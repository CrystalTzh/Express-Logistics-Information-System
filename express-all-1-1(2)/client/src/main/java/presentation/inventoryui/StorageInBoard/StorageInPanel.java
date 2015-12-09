package presentation.inventoryui.StorageInBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controller.inventorycontroller.StorageInFormController;
import vo.StorageInFormVO;

public class StorageInPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField date;
	private JTextField destination;
	private JTextField expressNumber;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel InInfo;
	private JLabel Ldate;
	private JLabel Ldestination;
	private JLabel OrderInfo;
	private JLabel LexpressNumber;
	private JLabel Lzone;
	private JLabel Lline;
	private JLabel Lshelf;
	private JLabel Ltag;
	private JComboBox zonebox;
	private JComboBox linebox;
	private JComboBox shelfbox;
	private JComboBox tagbox;
	private JButton save;
	private JButton cancel;
	
	public StorageInPanel(){
		
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 484, 517);
		this.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 28, 414, 158);
		this.add(panel_1);
		
		InInfo = new JLabel("\u5165\u5E93\u4FE1\u606F");
		InInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		InInfo.setBounds(10, 10, 64, 22);
		panel_1.add(InInfo);
		
		Ldate = new JLabel("\u5165\u5E93\u65E5\u671F \uFF1A");
		Ldate.setForeground(Color.BLACK);
		Ldate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ldate.setBackground(Color.GRAY);
		Ldate.setBounds(55, 45, 85, 28);
		panel_1.add(Ldate);
		
		date = new JTextField();
		date.setColumns(10);
		date.setBounds(155, 45, 166, 28);
		date.setText(getCurrenTime());
		panel_1.add(date);
		
		Ldestination = new JLabel("\u76EE\u7684\u5730 \uFF1A");
		Ldestination.setForeground(Color.BLACK);
		Ldestination.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ldestination.setBackground(Color.GRAY);
		Ldestination.setBounds(63, 95, 67, 28);
		panel_1.add(Ldestination);
		
		destination = new JTextField();
		destination.setColumns(10);
		destination.setBounds(155, 95, 166, 28);
		panel_1.add(destination);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(35, 214, 414, 212);
		this.add(panel_2);
		
		OrderInfo = new JLabel("\u8BA2\u5355\u4FE1\u606F");
		OrderInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		OrderInfo.setBounds(10, 10, 64, 22);
		panel_2.add(OrderInfo);
		
		LexpressNumber = new JLabel("\u8BA2\u5355\u7F16\u53F7 \uFF1A");
		LexpressNumber.setForeground(Color.BLACK);
		LexpressNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressNumber.setBackground(Color.GRAY);
		LexpressNumber.setBounds(55, 45, 85, 28);
		panel_2.add(LexpressNumber);
		
		expressNumber = new JTextField();
		expressNumber.setColumns(10);
		expressNumber.setBounds(155, 45, 166, 28);
		panel_2.add(expressNumber);
		
		Lzone = new JLabel("\u533A\u53F7 \uFF1A");
		Lzone.setForeground(Color.BLACK);
		Lzone.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lzone.setBackground(Color.GRAY);
		Lzone.setBounds(29, 95, 64, 28);
		panel_2.add(Lzone);
		
		Lline = new JLabel("\u6392\u53F7 \uFF1A");
		Lline.setForeground(Color.BLACK);
		Lline.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lline.setBackground(Color.GRAY);
		Lline.setBounds(218, 95, 64, 28);
		panel_2.add(Lline);
		
		Lshelf = new JLabel("\u67B6\u53F7 \uFF1A");
		Lshelf.setForeground(Color.BLACK);
		Lshelf.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lshelf.setBackground(Color.GRAY);
		Lshelf.setBounds(29, 145, 64, 28);
		panel_2.add(Lshelf);
		
		Ltag = new JLabel("\u4F4D\u53F7 \uFF1A");
		Ltag.setForeground(Color.BLACK);
		Ltag.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltag.setBackground(Color.GRAY);
		Ltag.setBounds(218, 145, 64, 28);
		panel_2.add(Ltag);
		
		zonebox = new JComboBox();
		zonebox.setModel(new DefaultComboBoxModel(new String[] {"  \u98DE\u673A\u533A", "  \u706B\u8F66\u533A", "  \u6C7D\u8F66\u533A"}));
		zonebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		zonebox.setBounds(103, 95, 85, 28);
		panel_2.add(zonebox);
		
		linebox = new JComboBox();
		linebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		linebox.setBounds(292, 95, 85, 28);
		panel_2.add(linebox);
		
		shelfbox = new JComboBox();
		shelfbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		shelfbox.setBounds(103, 145, 85, 28);
		panel_2.add(shelfbox);
		
		tagbox = new JComboBox();
		tagbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		tagbox.setBounds(292, 145, 85, 28);
		panel_2.add(tagbox);
		
		save = new JButton("\u63D0\u4EA4");
		save.setBounds(216, 451, 93, 36);
		this.add(save);
		
		cancel = new JButton("\u63D0\u4EA4");
		cancel.setBounds(337, 451, 93, 36);
		this.add(cancel);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel){
			textClear();
			save.setText("\u4FDD\u5B58");
		}
		if(e.getSource()==save){
			
			StorageInFormController storageInFormController = new StorageInFormController();
			
			if(save.getText()=="\u63D0\u4EA4"){//提交
				
				String dates = date.getText(); //装车单编号
				String destinations= destination.getText();
				String expressNumbers=expressNumber.getText() ;
				
				StorageInFormVO voToAdd= new StorageInFormVO();
				voToAdd.setDate(dates);
				voToAdd.setDestination(destinations);
				voToAdd.setExpressNumber(expressNumbers);
				storageInFormController.saveDriver(voToAdd);//添加车辆

			}
			
			if(save.getText()=="\u4FDD\u5B58"){//保存
				
				if(isTextFull()){
					//1.1.2 输出的车辆代号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
							//包装CarInputFormVO
							
						String dates = date.getText(); //装车单编号
						String destinations= destination.getText();
						String expressNumbers=expressNumber.getText() ;
						
						StorageInFormVO voToAdd= new StorageInFormVO();
						voToAdd.setDate(dates);
						voToAdd.setDestination(destinations);
						voToAdd.setExpressNumber(expressNumbers);
						storageInFormController.saveDriver(voToAdd);//添加车辆
					}//录入结束
					save.setText("\u63D0\u4EA4");
				}
					
				else {//1.2 未输入司机编号
					String warning = "必须要输入信息!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
				
			}
			
			
			
		}
		
	}
	
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
	}
	
	private boolean isTextFull(){
		boolean flag = true;
		if(destination.getText().length()==0){
			flag = false;
		}
		if(expressNumber.getText().length()==0){
			flag = false;
		}
		return flag;
	}
	
	private void textClear() {
		destination.setText(null);
		expressNumber.setText(null);
	}

}
