package presentation.financeui.PaymentBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
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

import controller.financeController.PaymentFormController;
import controller.financeController.ReceiptFormController;
import vo.PaymentFormVO;
import vo.ReceiptFormVO;

public class PaymentPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField date;
	private JTextField money;
	private JTextField name;
	private JTextField account;
	private JTextField type;
	private JTextField typedetail;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel basicInfo;
	private JLabel Ldate;
	private JLabel Lmoney;
	private JLabel Lname;
	private JLabel Laccount;
	private JLabel payInfo;
	private JComboBox typebox;
	private JComboBox typedetailbox;
	private JButton save;
	private JButton cancel;
	
	public PaymentPanel(){
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 484, 621);
		this.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 28, 414, 261);
		this.add(panel_1);
		
		basicInfo = new JLabel("\u57FA\u7840\u4FE1\u606F");
		basicInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		basicInfo.setBounds(10, 10, 67, 22);
		panel_1.add(basicInfo);
		
		Ldate = new JLabel("\u4ED8\u6B3E\u65E5\u671F \uFF1A");
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
		
		Lmoney = new JLabel("\u4ED8\u6B3E\u91D1\u989D \uFF1A");
		Lmoney.setForeground(Color.BLACK);
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(55, 95, 85, 28);
		panel_1.add(Lmoney);
		
		Lname = new JLabel("\u4ED8\u6B3E\u4EBA \uFF1A");
		Lname.setForeground(Color.BLACK);
		Lname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lname.setBackground(Color.GRAY);
		Lname.setBounds(63, 145, 67, 28);
		panel_1.add(Lname);
		
		Laccount = new JLabel("\u4ED8\u6B3E\u8D26\u6237 \uFF1A");
		Laccount.setForeground(Color.BLACK);
		Laccount.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Laccount.setBackground(Color.GRAY);
		Laccount.setBounds(55, 195, 85, 28);
		panel_1.add(Laccount);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(155, 95, 166, 28);
		panel_1.add(money);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(155, 145, 166, 28);
		panel_1.add(name);
		
		account = new JTextField();
		account.setColumns(10);
		account.setBounds(155, 195, 166, 28);
		panel_1.add(account);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(35, 326, 414, 200);
		this.add(panel_2);
		
		payInfo = new JLabel("\u4ED8\u6B3E\u4FE1\u606F");
		payInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		payInfo.setBounds(10, 10, 80, 22);
		panel_2.add(payInfo);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(155, 70, 166, 28);
		panel_2.add(type);
		
		typebox = new JComboBox();
		typebox.setModel(new DefaultComboBoxModel(new String[] {"     \u79DF\u91D1", "     \u8FD0\u8D39", "     \u5DE5\u8D44"}));
		typebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		typebox.setBackground(Color.WHITE);
		typebox.setBounds(41, 70, 89, 28);
		panel_2.add(typebox);
		typebox.addActionListener(this);
		
		typedetailbox = new JComboBox();
		typedetailbox.setModel(new DefaultComboBoxModel(new String[] {" \u79DF\u91D1\u5E74\u4EFD", " \u8FD0\u5355\u53F7", " \u5DE5\u8D44\u6708\u4EFD"}));
		typedetailbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		typedetailbox.setBackground(Color.WHITE);
		typedetailbox.setBounds(41, 120, 89, 28);
		panel_2.add(typedetailbox);
		typedetailbox.addActionListener(this);
		
		typedetail = new JTextField();
		typedetail.setColumns(10);
		typedetail.setBounds(155, 120, 166, 28);
		panel_2.add(typedetail);
		
		save = new JButton("\u4FDD\u5B58");
		save.setBounds(213, 555, 93, 36);
		this.add(save);
		save.addActionListener(this);
		
		cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(338, 555, 93, 36);
		this.add(cancel);
		cancel.addActionListener(this);
	}
	
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel){
			textClear();
			save.setText("\u4FDD\u5B58");
		}
		if(e.getSource()==save){
			
			PaymentFormController paymentFormController = new PaymentFormController();
			
			if(save.getText()=="\u63D0\u4EA4"){//提交
				
				String dates = date.getText(); //装车单编号
				double moneys = Double.parseDouble(money.getText());
				String names = name.getText();
				String accounts = account.getText();
				String types = (String)typebox.getSelectedItem();
				System.out.println(types);
				double rent=0;
				double freight=0;
				double salary=0;
				int year=0;
				String NO=null;
				int month=0;
				
				if(types=="     \u79DF\u91D1"){
					 rent = Double.parseDouble(type.getText());
				}
				if(types=="     \u8FD0\u8D39"){
					freight = Double.parseDouble(type.getText());
				}
				if(types=="     \u5DE5\u8D44"){
					salary = Double.parseDouble(type.getText());
				}
				
//				switch (types) {
//				case "     \u79DF\u91D1":
//					 rent = Double.parseDouble(type.getText());
//					break;
//				case "     \u8FD0\u8D39":
//					 freight = Double.parseDouble(type.getText());
//					break;
//				case "     \u5DE5\u8D44":
//					 salary = Double.parseDouble(type.getText());
//					break;
//				default:
//					break;
//				}
				
				String typedetails = (String)typedetailbox.getSelectedItem();
				
				if(typedetails==" \u79DF\u91D1\u5E74\u4EFD"){
					year = Integer.parseInt(type.getText());
				}
				if(typedetails==" \u8FD0\u5355\u53F7"){
					NO = type.getText();
				}
				if(typedetails==" \u5DE5\u8D44\u6708\u4EFD"){
					month = Integer.parseInt(type.getText());
				}
				
//				switch (typedetails) {
//				case " \u79DF\u91D1\u5E74\u4EFD":
//					 year = Integer.parseInt(type.getText());
//					break;
//				case " \u8FD0\u5355\u53F7":
//					 NO = type.getText();
//					break;
//				case " \u5DE5\u8D44\u6708\u4EFD":
//					 month = Integer.parseInt(type.getText());
//					break;
//				default:
//					break;
//				}
				
				
				PaymentFormVO voToAdd = new PaymentFormVO();
				voToAdd.setDate(dates);
				voToAdd.setName(names);
				voToAdd.setMoney(moneys);
				voToAdd.setAccount(accounts);
				voToAdd.setRent(rent);
				voToAdd.setYear(year);
				voToAdd.setFreight(freight);
				voToAdd.setSalary(salary);
				voToAdd.setFormNO(NO);
				voToAdd.setMonth(month);
				voToAdd.setNO("001");
				
				paymentFormController.submitDriver(voToAdd);
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
						double moneys = Double.parseDouble(money.getText());
						String names = name.getText();
						String accounts = account.getText();
						String types = (String)typebox.getSelectedItem();
						double rent=0;
						double freight=0;
						double salary=0;
						int year=0;
						String NO=null;
						int month=0;
						
						if(types=="     \u79DF\u91D1"){
							 rent = Double.parseDouble(type.getText());
						}
						if(types=="     \u8FD0\u8D39"){
							freight = Double.parseDouble(type.getText());
						}
						if(types=="     \u5DE5\u8D44"){
							salary = Double.parseDouble(type.getText());
						}
						
//						switch (types) {
//						case "     \u79DF\u91D1":
//							 rent = Double.parseDouble(type.getText());
//							break;
//						case "     \u8FD0\u8D39":
//							 freight = Double.parseDouble(type.getText());
//							break;
//						case "     \u5DE5\u8D44":
//							 salary = Double.parseDouble(type.getText());
//							break;
//						default:
//							break;
//						}
						String typedetails = (String)typedetailbox.getSelectedItem();
						
						if(typedetails==" \u79DF\u91D1\u5E74\u4EFD"){
							year = Integer.parseInt(type.getText());
						}
						if(typedetails==" \u8FD0\u5355\u53F7"){
							NO = type.getText();
						}
						if(typedetails==" \u5DE5\u8D44\u6708\u4EFD"){
							month = Integer.parseInt(type.getText());
						}
						
//						switch (typedetails) {
//						case " \u79DF\u91D1\u5E74\u4EFD":
//							 year = Integer.parseInt(type.getText());
//							break;
//						case " \u8FD0\u5355\u53F7":
//							 NO = type.getText();
//							break;
//						case " \u5DE5\u8D44\u6708\u4EFD":
//							 month = Integer.parseInt(type.getText());
//							break;
//						default:
//							break;
//						}
						
						PaymentFormVO voToAdd = new PaymentFormVO();
						voToAdd.setDate(dates);
						voToAdd.setName(names);
						voToAdd.setMoney(moneys);
						voToAdd.setAccount(accounts);
						voToAdd.setRent(rent);
						voToAdd.setYear(year);
						voToAdd.setSalary(salary);
						voToAdd.setFreight(freight);
						voToAdd.setFormNO(NO);
						voToAdd.setMonth(month);
						voToAdd.setNO("001");
						
						paymentFormController.saveDriver(voToAdd);
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
	
	private boolean isTextFull(){
		boolean flag = true;
		if(money.getText().length()==0){
			flag = false;
		}
		if(name.getText().length()==0){
			flag = false;
		}
		if(account.getText().length()==0){
			flag = false;
		}
		if(type.getText().length()==0){
			flag = false;
		}
		if(typedetail.getText().length()==0){
			flag = false;
		}
		return flag;
	}
	
	private void textClear(){
		money.setText(null);
		name.setText(null);
		account.setText(null);
		type.setText(null);
		typedetail.setText(null);
	}
	

}
