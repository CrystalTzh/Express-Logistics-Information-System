package presentation.financeui.ReceiptBoard;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import controller.UserID;
import controller.corporationcontroller.LogController;
import controller.financeController.ReceiptFormController;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.LogVO;
import vo.ReceiptFormVO;

public class ReceiptFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JFrame frame;
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
	private JPanel panel;
	
	public ReceiptFrame(){
		initialize();
	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("收款单");
		frame.setSize(490, 613);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - frame.getWidth())/2;
		int y = (screen.height - frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBounds(0, 0, 484, 584);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBounds(35, 28, 414, 138);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		basicInfo = new JLabel("基础信息");
		basicInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		basicInfo.setBounds(10, 10, 67, 22);
		panel_1.add(basicInfo);
		
		Ldate = new JLabel("收款日期 ：");
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
		panel_2.setBounds(35, 192, 414, 303);
		panel.add(panel_2);
		
		receiptInfo = new JLabel("收款信息");
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		receiptInfo.setBounds(10, 10, 67, 22);
		panel_2.add(receiptInfo);
		
		Lmoney= new JLabel("收款金额 ：");
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(35, 57, 85, 28);
		panel_2.add(Lmoney);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(135, 57, 166, 28);
		panel_2.add(money);
		
		LexpressManNumber = new JLabel("快递员编号 ：");
		LexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressManNumber.setBackground(Color.GRAY);
		LexpressManNumber.setBounds(27, 120, 98, 27);
		panel_2.add(LexpressManNumber);
		
		expressManNumber = new JTextField();
		expressManNumber.setColumns(10);
		expressManNumber.setBounds(135, 119, 166, 28);
		panel_2.add(expressManNumber);
		
		LID = new JLabel("订单编号 ：");
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
		
		save = new JButton("保存");
		save.setBounds(197, 527, 93, 36);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setBounds(331, 527, 93, 36);
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==cancel){
			frame.dispose();
		}
		if(e.getSource()==save){
			
			ReceiptFormController receiptFormController = new ReceiptFormController();
			
			if(save.getText()=="提交"){
				String m = "确认提交";
				int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (ok == JOptionPane.YES_OPTION) {
					String dates = date.getText(); 
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
					voToAdd.setNO("01");
					
					receiptFormController.submitDriver(voToAdd);
					
					LogController log= new LogController();
					LogVO logToAdd = new LogVO();
					logToAdd.setOperation(Operation.ADD);
					logToAdd.setOperationObject(OperationObject.ReceiptForm);
					logToAdd.setOperationTime(new GregorianCalendar());
					logToAdd.setOperatorID(UserID.userid);
					logToAdd.setOperatorRole(UserRole.OFFICEMAN);
					log.addLog(logToAdd);
					
					frame.dispose();
					
					
				}
				

			}
			
			if(save.getText()=="保存"){
				
				if(isTextFull()){
					
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {
						
							
						String dates = date.getText(); 
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
						voToAdd.setNO("01");
						
						receiptFormController.saveDriver(voToAdd);
					}
					save.setText("提交");
				}
					
				else {
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
	
	public String getCurrenTime() {
		int year, month, day;
		
		Calendar calendar = new GregorianCalendar();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH)+1;
		day = calendar.get(Calendar.DATE);
		
		return year+"-"+month+"-"+day;
	}

	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptFrame window = new ReceiptFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
