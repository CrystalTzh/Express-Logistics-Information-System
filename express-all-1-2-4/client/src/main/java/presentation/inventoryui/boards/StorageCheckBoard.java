package presentation.inventoryui.boards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class StorageCheckBoard extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private DateChooser datechooserstart,datechooserend;
	private JLabel jlstart,jlend,
				   jlinputstorage,jloutputstorage,jlcurrentstorage,//出入库总数，当前总数
				   jlinputamount,jloutputamount,jlcurrentamount;//出入库金额，当前金额
	 private JTextField jtinputstorage,jtoutputstorage,jtcurrentstorage,//出入库总数，当前总数
	   				   jtinputamount,jtoutputamount,jtcurrentamount;//出入库金额，当前金额
	private JTable table;
	private JButton jbreturn;
	
	public StorageCheckBoard(){
		this.setLayout(null);
		this.setTitle("库存查看");
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
		datechooserstart.setBounds(60, 14, datechooserstart.getdatechooserwidth(), datechooserstart.getdatechooserheight());
		datechooserstart.setOpaque(false);
		this.add(datechooserstart);
		
		datechooserend = new DateChooser(this,"yyyy/mm/dd",50);
		datechooserend.setBounds(280, 14, datechooserend.getdatechooserwidth(), datechooserstart.getdatechooserheight());
		datechooserend.setOpaque(false);
		this.add(datechooserend);
		
		String[] columnNames = { "订单号","入库日期","出库日期","区号","排号","架号","位号","金额"};  
        String[][] tableValues = { { "A1", "B1","C1","D1","E1","F1","G1","H1"}, { "A2", "B2","C1","D1","E1","F1","G1","H2"},  
                { "A3", "B3","C3","D3","E3","F3","G3","H3"}, { "A4", "B4","C4","D4","E4","F4","G4","H4"}, 
                { "A5", "B5","C5","D5","E5","F5","G5","H5"}, { "A6", "B6","C6","D6","E6","F6","G6","H6"}};  
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames){
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
        table.setModel(model);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
		scrollPane.setBounds(3, 70, 500, 150);
		add(scrollPane);
		
		jlinputstorage = new JLabel("入库数量：");
		jlinputstorage.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlinputstorage.setBounds(10, 230, 100, 30);
		this.add(jlinputstorage);
		
		jloutputstorage = new JLabel("出库数量：");
		jloutputstorage.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jloutputstorage.setBounds(150, 230, 100, 30);
		this.add(jloutputstorage);
		
		jlcurrentstorage = new JLabel("当前库存数量：");
		jlcurrentstorage.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlcurrentstorage.setBounds(290, 230, 120, 30);
		this.add(jlcurrentstorage);
		
		jlinputamount = new JLabel("入库金额：");
		jlinputamount.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlinputamount.setBounds(10, 280, 100, 30);
		this.add(jlinputamount);
		
		jloutputamount = new JLabel("出库金额：");
		jloutputamount.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jloutputamount.setBounds(150, 280, 100, 30);
		this.add(jloutputamount);
		
		jlcurrentamount = new JLabel("当前库存金额：");
		jlcurrentamount.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jlcurrentamount.setBounds(290, 280, 120, 30);
		this.add(jlcurrentamount);
		
		jtinputstorage = new JTextField();
		jtinputstorage.setBounds(87, 237, 55, 20);
		this.add(jtinputstorage);
		
		jtoutputstorage = new JTextField();
		jtoutputstorage.setBounds(227, 237, 55, 20);
		this.add(jtoutputstorage);
		
		jtcurrentstorage = new JTextField();
		jtcurrentstorage.setBounds(397, 237, 55, 20);
		this.add(jtcurrentstorage);
		
		jtinputamount = new JTextField();
		jtinputamount.setBounds(87, 287, 55, 20);
		this.add(jtinputamount);
		
		jtoutputamount = new JTextField();
		jtoutputamount.setBounds(227, 287, 55, 20);
		this.add(jtoutputamount);
		
		jtcurrentamount = new JTextField();
		jtcurrentamount.setBounds(397, 287, 55, 20);
		this.add(jtcurrentamount);
		
		jbreturn = new JButton();
		jbreturn.setText("返回");
		jbreturn.addActionListener(this);
		jbreturn.setBounds(397, 330, 60, 25);
		jbreturn.setContentAreaFilled(false);
		this.add(jbreturn);
		
		this.setVisible(true);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbreturn){
			this.setVisible(false);
		}
		
	}

	public static void main(String[] args) {
		new StorageCheckBoard();
	}
}
