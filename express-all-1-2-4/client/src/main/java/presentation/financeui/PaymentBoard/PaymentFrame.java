package presentation.financeui.PaymentBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import controller.UserID;
import controller.corporationcontroller.BankAccountController;
import controller.corporationcontroller.LogController;
import controller.financeController.PaymentFormController;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.BankAccountInfoVO;
import vo.LogVO;
import vo.PaymentFormVO;

public class PaymentFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame;
	private JTextField date;
	private JTextField money;
	private JTextField name;
	@SuppressWarnings("rawtypes")
	private JComboBox account;
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
	@SuppressWarnings("rawtypes")
	private JComboBox typebox;
	@SuppressWarnings("rawtypes")
	private JComboBox typedetailbox;
	private JButton save;
	private JButton cancel;
	private JPanel panel;
	
	public PaymentFrame(){
		initialize();

	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("付款单");
		frame.setSize(490, 649);
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
		panel.setBounds(0, 0, 484, 621);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_1.setBounds(35, 28, 414, 261);
		panel.add(panel_1);
		
		basicInfo = new JLabel("基础信息");
		basicInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		basicInfo.setBounds(10, 10, 67, 22);
		panel_1.add(basicInfo);
		
		Ldate = new JLabel("付款日期 ：");
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
		
		Lmoney = new JLabel("付款金额 ：");
		Lmoney.setForeground(Color.BLACK);
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(55, 95, 85, 28);
		panel_1.add(Lmoney);
		
		Lname = new JLabel("付款人 ：");
		Lname.setForeground(Color.BLACK);
		Lname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lname.setBackground(Color.GRAY);
		Lname.setBounds(63, 145, 67, 28);
		panel_1.add(Lname);
		
		Laccount = new JLabel("付款账户 ：");
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
		
		account = new JComboBox();
		account.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		account.setBackground(Color.WHITE);
		DefaultComboBoxModel dlm = new DefaultComboBoxModel();
		ArrayList<BankAccountInfoVO> allvo = findBankaccount();
		if(allvo!=null){
			for(int i = 0;i<allvo.size();i++){
				dlm.addElement((String)(allvo.get(i).getAccountId()));
			}
		}else{
			dlm.addElement("无银行账户信息");
		}
		account.setModel(dlm);
		account.setBounds(155, 195, 166, 28);
		panel_1.add(account);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		panel_2.setBounds(35, 326, 414, 200);
		panel.add(panel_2);
		
		payInfo = new JLabel("付款信息");
		payInfo.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		payInfo.setBounds(10, 10, 80, 22);
		panel_2.add(payInfo);
		
		type = new JTextField();
		type.setColumns(10);
		type.setBounds(155, 70, 166, 28);
		panel_2.add(type);
		
		typebox = new JComboBox();
		typebox.setModel(new DefaultComboBoxModel(new String[] {"租金", "运费", "工资"}));
		typebox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		typebox.setBackground(Color.WHITE);
		typebox.setBounds(41, 70, 89, 28);
		panel_2.add(typebox);
		typebox.addActionListener(this);
		
		typedetailbox = new JComboBox();
		typedetailbox.setModel(new DefaultComboBoxModel(new String[] {"租金年份", "运单号", "工资月份"}));
		typedetailbox.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		typedetailbox.setBackground(Color.WHITE);
		typedetailbox.setBounds(41, 120, 89, 28);
		panel_2.add(typedetailbox);
		typedetailbox.addActionListener(this);
		
		typedetail = new JTextField();
		typedetail.setColumns(10);
		typedetail.setBounds(155, 120, 166, 28);
		panel_2.add(typedetail);
		
		save = new JButton("保存");
		save.setBounds(213, 555, 93, 36);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setBounds(338, 555, 93, 36);
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
	}
	
	private ArrayList<BankAccountInfoVO> findBankaccount() {
		// TODO Auto-generated method stub
		BankAccountController controller = new BankAccountController();
		return controller.findAllBankAccounts();
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
			frame.dispose();
		}
		if(e.getSource()==save){
			
			PaymentFormController paymentFormController = new PaymentFormController();
			
			if(save.getText()=="提交"){
				String m = "确认提交";
				int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (ok == JOptionPane.YES_OPTION) {
					String dates = date.getText(); 
					double moneys = Double.parseDouble(money.getText());
					String names = name.getText();
					String accounts = (String)account.getSelectedItem();
					String types = (String)typebox.getSelectedItem();
					System.out.println(types);
					double rent=0;
					double freight=0;
					double salary=0;
					int year=0;
					String NO=null;
					int month=0;
					
					BankAccountController controller = new BankAccountController();
					BankAccountInfoVO vo = new BankAccountInfoVO();
					vo = controller.findBankAccount(accounts);
					vo.setBalance(vo.getBalance()-moneys);
					controller.modifyBankAccount(vo);
					
					if(types=="租金"){
						 rent = Double.parseDouble(type.getText());
					}
					if(types=="运费"){
						freight = Double.parseDouble(type.getText());
					}
					if(types=="工资"){
						salary = Double.parseDouble(type.getText());
					}
					
					String typedetails = (String)typedetailbox.getSelectedItem();
					
					if(typedetails=="租金年份"){
						year = Integer.parseInt(type.getText());
					}
					if(typedetails=="运单号"){
						NO = type.getText();
					}
					if(typedetails=="工资月份"){
						month = Integer.parseInt(type.getText());
					}
					
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
					
					paymentFormController.submitDriver(voToAdd);
					
					LogController log= new LogController();
					LogVO logToAdd = new LogVO();
					logToAdd.setOperation(Operation.ADD);
					logToAdd.setOperationObject(OperationObject.PaymentForm);
					logToAdd.setOperationTime(new GregorianCalendar());
					logToAdd.setOperatorID(UserID.userid);
					logToAdd.setOperatorRole(UserRole.ADFINANCEMAN);
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
						String names = name.getText();
						String accounts = (String)account.getSelectedItem();
						String types = (String)typebox.getSelectedItem();
						double rent=0;
						double freight=0;
						double salary=0;
						int year=0;
						String NO=null;
						int month=0;
						
						if(types=="租金"){
							 rent = Double.parseDouble(type.getText());
						}
						if(types=="运费"){
							freight = Double.parseDouble(type.getText());
						}
						if(types=="工资"){
							salary = Double.parseDouble(type.getText());
						}
						
						String typedetails = (String)typedetailbox.getSelectedItem();
						
						if(typedetails=="租金年份"){
							year = Integer.parseInt(type.getText());
						}
						if(typedetails=="运单号"){
							NO = type.getText();
						}
						if(typedetails=="工资月份"){
							month = Integer.parseInt(type.getText());
						}				
						
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
						
						paymentFormController.saveDriver(voToAdd);
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
		if(name.getText().length()==0){
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

	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentFrame window = new PaymentFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
