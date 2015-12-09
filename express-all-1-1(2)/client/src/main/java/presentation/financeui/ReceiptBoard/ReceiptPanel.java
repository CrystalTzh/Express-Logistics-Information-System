package presentation.financeui.ReceiptBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import controller.financeController.ReceiptFormController;
import controller.transitController.CarInputFormController;
import vo.CarInputFormVO;
import vo.ReceiptFormVO;

public class ReceiptPanel extends JPanel implements ActionListener{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField date;
	private JTextField money;
	private JTextField expressManNumber;
	private JTextArea ID;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton save;
	private JButton cancel;
	private JLabel basicInfo;
	private JLabel Ldate;
	private JLabel receiptInfo;
	private JLabel Lmoney;
	private JLabel LexpressManNumber;
	private JLabel LID;
	private JScrollPane Spanel;
	
	public ReceiptPanel(){
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 484, 584);
		this.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 28, 414, 138);
		this.add(panel_1);
		panel_1.setLayout(null);
		
		basicInfo = new JLabel("\u57FA\u7840\u4FE1\u606F");
		basicInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		basicInfo.setBounds(10, 10, 67, 22);
		panel_1.add(basicInfo);
		
		Ldate = new JLabel("\u6536\u6B3E\u65E5\u671F \uFF1A");
		Ldate.setForeground(Color.BLACK);
		Ldate.setBounds(35, 58, 85, 28);
		panel_1.add(Ldate);
		Ldate.setBackground(Color.GRAY);
		Ldate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		date = new JTextField();
		date.setBounds(135, 57, 166, 28);
		panel_1.add(date);
		date.setText(getCurrenTime());
		date.setColumns(10);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(35, 192, 414, 303);
		this.add(panel_2);
		
		receiptInfo = new JLabel("\u6536\u6B3E\u4FE1\u606F");
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		receiptInfo.setBounds(10, 10, 67, 22);
		panel_2.add(receiptInfo);
		
		Lmoney= new JLabel("\u6536\u6B3E\u91D1\u989D \uFF1A");
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(35, 57, 85, 28);
		panel_2.add(Lmoney);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(135, 57, 166, 28);
		panel_2.add(money);
		
		LexpressManNumber = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7 \uFF1A");
		LexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressManNumber.setBackground(Color.GRAY);
		LexpressManNumber.setBounds(27, 120, 98, 27);
		panel_2.add(LexpressManNumber);
		
		expressManNumber = new JTextField();
		expressManNumber.setColumns(10);
		expressManNumber.setBounds(135, 119, 166, 28);
		panel_2.add(expressManNumber);
		
		LID = new JLabel("\u8BA2\u5355\u7F16\u53F7 \uFF1A");
		LID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LID.setBackground(Color.GRAY);
		LID.setBounds(35, 181, 85, 28);
		panel_2.add(LID);
		
		ID = new JTextArea();
		ID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ID.setColumns(1);
		ID.setBorder(new EtchedBorder());
		ID.setBackground(Color.WHITE);
		ID.setBounds(135, 184, 166, 96);
		
		Spanel = new JScrollPane(ID);
		Spanel.setBounds(135, 184, 166, 96);
		panel_2.add(Spanel);
		
		save = new JButton("\u4FDD\u5B58");
		save.setBounds(197, 527, 93, 36);
		this.add(save);
		save.addActionListener(this);
		
		cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(331, 527, 93, 36);
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
			
			ReceiptFormController receiptFormController = new ReceiptFormController();
			
			if(save.getText()=="\u63D0\u4EA4"){//提交
				
				String dates = date.getText(); //装车单编号
				double moneys = Double.parseDouble(money.getText());
				String expressManNumbers = expressManNumber.getText();
				ArrayList<String> IDs = new ArrayList<String>();
				BufferedReader br = new BufferedReader(new StringReader(ID.getText()));
				String line = ""; 
				try{
					while((line = br.readLine()) != null){
							IDs.add(line);
					}
				} 
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
					
				ReceiptFormVO voToAdd = new ReceiptFormVO();
				voToAdd.setDate(dates);
				voToAdd.setExpressManNumber(expressManNumbers);
				voToAdd.setID(IDs);
				voToAdd.setMoney(moneys);
				voToAdd.setNO("001");
				
				receiptFormController.submitDriver(voToAdd);

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
						String expressManNumbers = expressManNumber.getText();
						ArrayList<String> IDs = new ArrayList<String>();
						BufferedReader br = new BufferedReader(new StringReader(ID.getText()));
						try {
							System.out.println(br.readLine());
						} catch (IOException e2) {
							// TODO Auto-generated catch block
							e2.printStackTrace();
						}
						String line = ""; 
						try{
							while((line = br.readLine()) != null){
									IDs.add(line);
							}
						} 
						catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						System.out.println("IDs get!");	
						ReceiptFormVO voToAdd = new ReceiptFormVO();
						voToAdd.setDate(dates);
						voToAdd.setExpressManNumber(expressManNumbers);
						voToAdd.setID(IDs);
						voToAdd.setMoney(moneys);
						voToAdd.setNO("001");
						
						receiptFormController.saveDriver(voToAdd);//添加车辆
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
		if(expressManNumber.getText().length()==0){
			flag = false;
		}
		if(ID.getText().length()==0){
			flag = false;
		}
		return flag;
	}
	
	private void textClear() {
		money.setText(null);
		expressManNumber.setText(null);
		ID.setText(null);
	}

}
