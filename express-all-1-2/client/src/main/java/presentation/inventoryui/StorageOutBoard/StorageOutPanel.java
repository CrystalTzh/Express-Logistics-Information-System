package presentation.inventoryui.StorageOutBoard;

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

import controller.inventorycontroller.StorageOutFormController;
import state.Transport;
import vo.StorageOutFormVO;

public class StorageOutPanel extends JPanel implements ActionListener{

private static final long serialVersionUID = 1L;
	
	private JTextField date;
	private JTextField destination;
	private JTextField expressNumber;
	private JTextField formNO;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel OutInfo;
	private JLabel Ldate;
	private JLabel Ldestination;
	private JLabel OrderInfo;
	private JLabel LexpressNumber;
	private JLabel transport;
	private JComboBox transportbox;
	private JComboBox NObox;
	private JButton save;
	private JButton cancel;
	
	public StorageOutPanel(){
		
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 484, 517);
		this.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 28, 414, 158);
		this.add(panel_1);
		
		OutInfo = new JLabel("\u51FA\u5E93\u4FE1\u606F");
		OutInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		OutInfo.setBounds(10, 10, 64, 22);
		panel_1.add(OutInfo);
		
		Ldate = new JLabel("\u51FA\u5E93\u65E5\u671F \uFF1A");
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
		
		transport = new JLabel("\u8FD0\u9001\u65B9\u5F0F \uFF1A");
		transport.setForeground(Color.BLACK);
		transport.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		transport.setBackground(Color.GRAY);
		transport.setBounds(55, 95, 85, 28);
		panel_2.add(transport);
		
		transportbox = new JComboBox();
		transportbox.setModel(new DefaultComboBoxModel(new String[] {"     \u6C7D\u8FD0", "     \u94C1\u8DEF", "     \u7A7A\u8FD0"}));
		transportbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		transportbox.setBounds(155, 95, 93, 28);
		panel_2.add(transportbox);
		
		NObox = new JComboBox();
		NObox.setModel(new DefaultComboBoxModel(new String[] {" \u4E2D\u8F6C\u5355\u7F16\u53F7", "  \u6C7D\u8FD0\u7F16\u53F7"}));
		NObox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		NObox.setBackground(Color.WHITE);
		NObox.setBounds(34, 145, 106, 28);
		panel_2.add(NObox);
		
		formNO = new JTextField();
		formNO.setColumns(10);
		formNO.setBounds(155, 145, 166, 28);
		panel_2.add(formNO);
		
		save = new JButton("\u4FDD\u5B58");
		save.setBounds(216, 452, 93, 36);
		this.add(save);
		save.addActionListener(this);
		
		cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(337, 452, 93, 36);
		this.add(cancel);
		cancel.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel){
			textClear();
			save.setText("\u4FDD\u5B58");
		}
		if(e.getSource()==save){
			
			StorageOutFormController storageOutFormController = new StorageOutFormController();
			
			if(save.getText()=="\u63D0\u4EA4"){//提交
				
				String dates = date.getText(); //装车单编号
				String destinations = destination.getText();
				String expressNumbers = expressNumber.getText();
				String transportboxs = (String)transportbox.getSelectedItem();
				Transport transports = null;
				
				if(transportboxs=="     \u6C7D\u8FD0"){
					transports = Transport.CAR;
				}
				if(transportboxs=="     \u94C1\u8DEF"){
					transports = Transport.TRAIN;
				}
				if(transportboxs=="     \u7A7A\u8FD0"){
					transports = Transport.PLANE;
				}
				
//				switch (transportboxs) {
//				case "     \u6C7D\u8FD0":
//					transports = Transport.CAR;
//					break;
//				case "     \u94C1\u8DEF":
//					transports = Transport.TRAIN;
//					break;
//				case "     \u7A7A\u8FD0":
//					transports = Transport.PLANE;
//					break;
//				default:
//					break;
//				}
				
				String NOboxs = (String)NObox.getSelectedItem();
				String transferNO = "";
				String sportNO = "";
				
				if(NOboxs==" \u4E2D\u8F6C\u5355\u7F16\u53F7"){
					transferNO = formNO.getText();
				}
				if(NOboxs=="  \u6C7D\u8FD0\u7F16\u53F7"){
					sportNO = formNO.getText();
				}
				
//				switch (NOboxs) {
//				case " \u4E2D\u8F6C\u5355\u7F16\u53F7":
//					NOs = NO.getText();
//					break;
//				case "  \u6C7D\u8FD0\u7F16\u53F7":
//					NOs = NO.getText();
//					break;
//				default:
//					break;
//				}
				
				
				StorageOutFormVO voToAdd = new StorageOutFormVO();
				voToAdd.setDate(dates);
				voToAdd.setDestination(destinations);
				voToAdd.setExpressNumber(expressNumbers);
				voToAdd.setTransport(transports);
				voToAdd.setNO("001");
				voToAdd.setSportNO(sportNO);
				voToAdd.setTransferNO(transferNO);
				
	
				
				storageOutFormController.submitDriver(voToAdd);

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
						String destinations = destination.getText();
						String expressNumbers = expressNumber.getText();
						String transportboxs = (String)transportbox.getSelectedItem();
						Transport transports = null;
						
						if(transportboxs=="     \u6C7D\u8FD0"){
							transports = Transport.CAR;
						}
						if(transportboxs=="     \u94C1\u8DEF"){
							transports = Transport.TRAIN;
						}
						if(transportboxs=="     \u7A7A\u8FD0"){
							transports = Transport.PLANE;
						}
						
//						switch (transportboxs) {
//						case "     \u6C7D\u8FD0":
//							transports = Transport.CAR;
//							break;
//						case "     \u94C1\u8DEF":
//							transports = Transport.TRAIN;
//							break;
//						case "     \u7A7A\u8FD0":
//							transports = Transport.PLANE;
//							break;
//						default:
//							break;
//						}
						
						String NOboxs = (String)NObox.getSelectedItem();
						String transferNO = "";
						String sportNO = "";
						
						if(NOboxs==" \u4E2D\u8F6C\u5355\u7F16\u53F7"){
							transferNO = formNO.getText();
						}
						if(NOboxs=="  \u6C7D\u8FD0\u7F16\u53F7"){
							sportNO = formNO.getText();
						}
						
//						switch (NOboxs) {
//						case " \u4E2D\u8F6C\u5355\u7F16\u53F7":
//							NOs = NO.getText();
//							break;
//						case "  \u6C7D\u8FD0\u7F16\u53F7":
//							NOs = NO.getText();
//							break;
//						default:
//							break;
//						}
						
						
						StorageOutFormVO voToAdd = new StorageOutFormVO();
						voToAdd.setDate(dates);
						voToAdd.setDestination(destinations);
						voToAdd.setExpressNumber(expressNumbers);
						voToAdd.setTransport(transports);
						voToAdd.setNO("001");
						voToAdd.setSportNO(sportNO);
						voToAdd.setTransferNO(transferNO);
						
			
						
						storageOutFormController.saveDriver(voToAdd);
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
		if(formNO.getText().length()==0){
			flag = false;
		}
		return flag;
	}
	
	private void textClear() {
		destination.setText(null);
		expressNumber.setText(null);
		formNO.setText(null);
	}

}
