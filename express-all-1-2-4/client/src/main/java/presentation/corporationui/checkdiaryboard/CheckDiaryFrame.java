
package presentation.corporationui.checkdiaryboard;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.corporationcontroller.LogController;
import presentation.inventoryui.boards.DateChooser;
import vo.LogVO;

public class CheckDiaryFrame extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DateChooser datechooserstart,datechooserend;
	private JLabel jlstart,jlend;
	private JTable table;
	private JButton jbreturn;
	private JButton jbsure;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	
	
	public CheckDiaryFrame(){
		this.setLayout(null);
		this.setTitle("查看日志");
		this.setBounds(560, 250, 520, 400);
		
		jlstart = new JLabel("开始时间：");
		jlstart.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlstart.setBounds(30, 25, 100, 30);
		this.add(jlstart);
		
		jlend = new JLabel("结束时间：");
		jlend.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlend.setBounds(250, 25, 100, 30);
		this.add(jlend);
		
		datechooserstart = new DateChooser(this,"yyyy/mm/dd",50);
		datechooserstart.setBounds(50, 14, datechooserstart.getdatechooserwidth(), datechooserstart.getdatechooserheight());
		datechooserstart.setOpaque(false);
		this.add(datechooserstart);
		
		datechooserend = new DateChooser(this,"yyyy/mm/dd",50);
		datechooserend.setBounds(270, 14, datechooserend.getdatechooserwidth(), datechooserstart.getdatechooserheight());
		datechooserend.setOpaque(false);
		this.add(datechooserend);
		
		jbsure = new JButton("确定");
		jbsure.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jbsure.setBounds(420, 26, 68, 25);
		jbsure.addActionListener(this);
		this.add(jbsure);
		
//		String[] columnNames = { "日期","人员","操作"};  
//        String[][] tableValues = { { "A1", "B1","C1"}, { "A2", "B2","C1"},  
//                { "A3", "B3","C3"}, { "A4", "B4","C4"}, 
//                { "A5", "B5","C5"}, { "A6", "B6","C6"}};
//		String[][] tableValues = null;
		columnNames = new Vector<String>();
		columnNames.add("日期");
		columnNames.add("人员");
		columnNames.add("操作");
		tableValues = new Vector<String>();
		
        model = new DefaultTableModel(tableValues,columnNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
			
			
        };
        table = new JTable();
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
		scrollPane.setBounds(3, 70, 500, 150);
		add(scrollPane);
		
		jbreturn = new JButton();
		jbreturn.setText("返回");
		jbreturn.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jbreturn.setBounds(220, 310, 75, 25);
		jbreturn.addActionListener(this);
		
		this.add(jbreturn);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if(e.getSource() == jbreturn){
			this.setVisible(false);
		}
		
		if(e.getSource() == jbsure){
			
			String start = datechooserstart.getDateField().getText();
			String[] s = start.split("/");
			int syear = Integer.valueOf(s[0]).intValue();
			int smonth = Integer.valueOf(s[1]).intValue()-1;
			int sday = Integer.valueOf(s[2]).intValue();
			
			String end = datechooserend.getDateField().getText();
			String[] ed = end.split("/");
			int eyear = Integer.valueOf(ed[0]).intValue();
			int emonth = Integer.valueOf(ed[1]).intValue()-1;
			int eday = Integer.valueOf(ed[2]).intValue();
			Calendar startDate = new GregorianCalendar(syear, smonth, sday);
			Calendar endDate = new GregorianCalendar(eyear, emonth, eday);
			//判断startDate是否小于等于endDate
			int comp = this.compare(startDate, endDate);
			if(comp > 0) {//开始日期晚于结束日期
				String error = "开始日期不能晚于结束日期";
				JOptionPane.showMessageDialog(this, error, "错误", JOptionPane.ERROR_MESSAGE);
			}
			LogController logController = new LogController();
			ArrayList<LogVO> findLogs = logController.findLog(startDate, endDate);
			if(findLogs == null) {
				System.out.println("日志记录为空");
			} else {
				System.out.println();
				for(int i = 0; i < findLogs.size(); i++) {
					row = new Vector<String>();
					String logtimestr = findLogs.get(i).timeToString();
					String logIDstr = findLogs.get(i).getOperatorRole().toString()+" "+findLogs.get(i).getOperatorID();
					String logOpstr = findLogs.get(i).getOperation()+" "+findLogs.get(i).getOperationObject();
					
					row.add(0, logtimestr);
					row.add(1, logIDstr);
					row.add(2, logOpstr);
					model.addRow(row);
					System.out.println(findLogs.get(i).toString());
				}
			}
		}
	}
	
	/**
	 * 比较日期day1和日期day2的大小
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public int compare(Calendar day1, Calendar day2) {
		int year1 = day1.get(Calendar.YEAR);
		int month1 = day1.get(Calendar.MONTH);
		int date1 = day1.get(Calendar.DATE);
		int year2 = day2.get(Calendar.YEAR);
		int month2 = day2.get(Calendar.MONTH);
		int date2 = day2.get(Calendar.DATE);

		if (year1 < year2) {
			return -1;
		}
		if (year1 == year2 && month1 < month2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 < date2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 == date2) {
			return 0;
		}
		return 1;
	}


	public static void main(String[] args) {
		new CheckDiaryFrame();
	}
}
