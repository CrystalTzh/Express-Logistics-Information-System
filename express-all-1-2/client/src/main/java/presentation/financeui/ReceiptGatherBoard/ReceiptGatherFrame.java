package presentation.financeui.ReceiptGatherBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.corporationcontroller.BankAccountController;
import controller.financeController.ReceiptFormController;
import po.ReceiptFormPO;
import vo.BankAccountInfoVO;
import vo.ReceiptFormVO;

public class ReceiptGatherFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame;
	private JPanel panel_2;
	private JLabel Lmoney;
	private JLabel LexpressManNumber;
	private JLabel LID;
	private JLabel account;
	private JTextArea ID;
	private JScrollPane p;
	private JLabel Ldate;
	private JButton settle;
	private JButton cancel;
	@SuppressWarnings("rawtypes")
	private JList receiptlist;
	private JScrollPane pl;
	private JLabel Lreceiptlist;
	private JLabel receiptInfo;
	private JTextField date;
	private JTextField money;
	private JTextField expressManNumber;
	@SuppressWarnings("rawtypes")
	private JComboBox accountbox;
	private	ArrayList<ReceiptFormPO> all = findReceiptFormPO();
	private JPanel panel;
	
	public ReceiptGatherFrame(){
		initialize();
//		ReceiptGatherPanel panel = new ReceiptGatherPanel();
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("\u6536\u6B3E\u5355\u6C47\u603B");
//		frame.setBounds(100, 100, 490, 653);
//		frame.getContentPane().setLayout(null);
//		frame.setVisible(true);
//		frame.setResizable(false);
//		frame.getContentPane().add(panel);
		

	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("收款单汇总");
		frame.setSize(490, 653);
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
		panel.setBounds(0, 0, 484, 624);
		panel.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_2.setBounds(35, 207, 414, 280);
		panel.add(panel_2);
		
		Lmoney = new JLabel("收款金额 ：");
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(10, 67, 85, 28);
		panel_2.add(Lmoney);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(122, 67, 166, 28);
		panel_2.add(money);
		
		LexpressManNumber = new JLabel("快递员编号 ：");
		LexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressManNumber.setBackground(Color.GRAY);
		LexpressManNumber.setBounds(10, 117, 98, 27);
		panel_2.add(LexpressManNumber);
		
		expressManNumber = new JTextField();
		expressManNumber.setColumns(10);
		expressManNumber.setBounds(122, 117, 166, 28);
		panel_2.add(expressManNumber);
		
		LID = new JLabel("订单编号 ：");
		LID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LID.setBackground(Color.GRAY);
		LID.setBounds(10, 167, 85, 28);
		panel_2.add(LID);
		
		ID = new JTextArea();
		ID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ID.setColumns(1);
		ID.setBorder(new EtchedBorder());
		ID.setBackground(Color.WHITE);
		ID.setBounds(135, 184, 166, 80);
		
		p = new JScrollPane(ID);
		p.setBounds(122, 167, 166, 80);
		panel_2.add(p);
		
		Ldate = new JLabel("收款日期 ：");
		Ldate.setBounds(10, 17, 85, 28);
		panel_2.add(Ldate);
		Ldate.setForeground(Color.BLACK);
		Ldate.setBackground(Color.GRAY);
		Ldate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		date = new JTextField();
		date.setBounds(122, 17, 166, 28);
		panel_2.add(date);
		date.setColumns(10);
		
		settle = new JButton("结算");
		settle.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		settle.setBounds(205, 557, 93, 36);
		panel.add(settle);
		settle.setContentAreaFilled(false);
		settle.addActionListener(this);
		
		cancel = new JButton("取消");
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		cancel.setBounds(328, 557, 93, 36);
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
		receiptlist = new JList();
		receiptlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		receiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		DefaultListModel dlm = new DefaultListModel();
//		System.out.println(all.get(0).getNO());
		if(all.size()!=0){
			for(int i=all.size()-1;i>=0;i--){
				if(!all.get(i).isPaystate()){
					dlm.addElement((String)("收款单"+all.get(i).getNO()));
					all.get(i).setPaystate(true);
				}				
			}
		}else{
			dlm.addElement("无收款单信息！");
		}
		
		receiptlist.setModel(dlm);
		receiptlist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String str = (String)receiptlist.getSelectedValue();
				if(str!="无收款单信息！"){
					String  NO = str.substring(3);
					ReceiptFormController receiptFormController = new ReceiptFormController();
					ReceiptFormVO vo = new ReceiptFormVO();
					try {
						vo = receiptFormController.findDriver(NO);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<String> id = new ArrayList<String>();
					id = vo.getID();
					date.setText(vo.getDate());
					money.setText(Double.toString(vo.getMoney()));
					expressManNumber.setText(vo.getExpressManNumber());
					ID.setText("");
					for(int i= 0;i<id.size();i++){
						ID.append(id.get(i)+"\r\n");	
					}
				}
			}
		});
		
		pl = new JScrollPane(receiptlist);
		pl.setBounds(35, 45, 414, 120);
		panel.add(pl);

		
		
		receiptlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		receiptlist.setBounds(35, 25, 414, 120);
		
		Lreceiptlist = new JLabel("收款单列表");
		Lreceiptlist.setForeground(Color.BLACK);
		Lreceiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lreceiptlist.setBackground(Color.GRAY);
		Lreceiptlist.setBounds(35, 10, 85, 28);
		panel.add(Lreceiptlist);
		
		receiptInfo = new JLabel("收款单信息");
		receiptInfo.setForeground(Color.BLACK);
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		receiptInfo.setBackground(Color.GRAY);
		receiptInfo.setBounds(35, 175, 85, 28);
		panel.add(receiptInfo);
		
		account = new JLabel("收款账号：");
		account.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		account.setForeground(Color.BLACK);
		account.setBackground(Color.GRAY);
		account.setBounds(45, 506, 85, 28);
		panel.add(account);
		
		accountbox = new JComboBox();
		accountbox.setBackground(Color.WHITE);
		DefaultComboBoxModel dlm1 = new DefaultComboBoxModel();
		ArrayList<BankAccountInfoVO> allvo = findBankaccount();
		if(allvo!=null){
			for(int i = 0;i<allvo.size();i++){
				dlm1.addElement((String)(allvo.get(i).getAccountId()));
			}
		}else{
			dlm1.addElement("无银行账户信息！");
		}
		
		accountbox.setModel(dlm1);
		accountbox.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		accountbox.setBounds(166, 506, 166, 28);
		panel.add(accountbox);
	}
	
	private ArrayList<BankAccountInfoVO> findBankaccount() {
		// TODO Auto-generated method stub
		BankAccountController controller = new BankAccountController();
		return controller.findAllBankAccounts();
	}
	
	public ArrayList<ReceiptFormPO> findReceiptFormPO(){
		ReceiptFormController receiptFormController = new ReceiptFormController();
		return receiptFormController.findAll();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==settle){
			double money = 0;
			for(int i=0;i<all.size();i++){
				money += all.get(i).getMoney();
			}
			BankAccountController controller = new BankAccountController();
			BankAccountInfoVO vo = new BankAccountInfoVO();
			vo = controller.findBankAccount((String)accountbox.getSelectedItem());
			vo.setBalance(vo.getBalance()+money);
			controller.modifyBankAccount(vo);
			settle.setEnabled(false);
		}
	}
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReceiptGatherFrame window = new ReceiptGatherFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
