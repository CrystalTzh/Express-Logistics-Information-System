package presentation.financeui.beginningaccountboard;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.financeController.BeginningAccountController;
import presentation.corporationui.bankaccountboard.BankAccountManageDriver;
import presentation.mainui.MainFrame;
import vo.BankAccountInfoVO;

public class BeginningAccountBankAccountInfoPanel extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,jpanel2,jpanel3,jpanel4;
	private JLabel jlabellogo,jlcurrentID;
	private ImageIcon imagelogo,imageDriverInfo,imageCarInfo,imageAccount,
					  imageID,imageInstitutionsManage,imageReturn,imageRefresh,imageCheckcurrent;
	static private JButton jbDriverInfo,jbCarInfo,jbAccountID,
					jbID,jbInstitutionsManage,jbstop,jbrefresh,jbcheckcurrent,jbmodify,jbexit;
	private Box b;
	private JTable table;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	BeginningAccountController beginningAccountController;
	
	public BeginningAccountBankAccountInfoPanel(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
		
		setJbDriverInfo(new JButton());//维护司机信息
		imageDriverInfo = new ImageIcon("image/driver.jpg");
		getJbDriverInfo().setIcon(imageDriverInfo);
		getJbDriverInfo().setPreferredSize(new Dimension(imageDriverInfo.getIconWidth(),
				imageDriverInfo.getIconHeight()));
		getJbDriverInfo().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbDriverInfo()){
////					new MainFrame().setContentPane(new DriverInfoNavigation());
//					new DriverInfoManageDriver().setVisible(true);
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbCarInfo(new JButton());//维护车辆信息
		imageCarInfo = new ImageIcon("image/carInfo.jpg");
		getJbCarInfo().setIcon(imageCarInfo);
		getJbCarInfo().setPreferredSize(new Dimension(imageCarInfo.getIconWidth(),
				imageCarInfo.getIconHeight()));
		getJbCarInfo().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCarInfo()){
////					new MainFrame().setContentPane(new CarInfoNavigation());
//					new CarInfoManageDriver().setVisible(true);
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbAccountID(new JButton());//增删改查银行账户
		imageAccount = new ImageIcon("image/accountID.jpg");
		getJbAccountID().setIcon(imageAccount);
		getJbAccountID().setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		getJbAccountID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbAccountID()){
////					new MainFrame().setContentPane(new AccountsNavigation());
//					new BankAccountManageDriver().setVisible(true);
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbID(new JButton());//管理账号密码
		imageID = new ImageIcon("image/IDandPassword.jpg");
		getJbID().setIcon(imageID);
		getJbID().setPreferredSize(new Dimension(imageID.getIconWidth(),
				imageID.getIconHeight()));
		getJbID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbID()){
////					new MainFrame().setContentPane(new UserInfoNavigation());
//					new UserAccountManageDriver().setVisible(true);
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbInstitutionsManage(new JButton());//机构管理
		imageInstitutionsManage = new ImageIcon("image/institutionsmanage.jpg");
		getJbInstitutionsManage().setIcon(imageInstitutionsManage);
		getJbInstitutionsManage().setPreferredSize(new Dimension(imageInstitutionsManage.getIconWidth(),
				imageInstitutionsManage.getIconHeight()));
		getJbInstitutionsManage().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbInstitutionsManage()){
////					new MainFrame().setContentPane(new InstitutionsManageNavigation());
//					new InstitutionsManageDriver().setVisible(true);
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbDriverInfo());
		jpanel2.add(getJbCarInfo());
		jpanel2.add(getJbAccountID());
		jpanel2.add(getJbID());
		jpanel2.add(getJbInstitutionsManage());
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：高级财务人员 "+UserID.userid+" 期初建账:银行");
		jlcurrentID.setFont(new Font("微软雅黑",Font.PLAIN,15));

		jbmodify = new JButton("修改密码");
		jbmodify.setFont(new Font("修改密码",Font.PLAIN,12));
		jbmodify.setContentAreaFilled(false);
		jbmodify.addActionListener(this);
		
		jbexit = new JButton("退出登录");
		jbexit.setFont(new Font("退出登录",Font.PLAIN,12));
		jbexit.setContentAreaFilled(false);
		jbexit.addActionListener(this);
		
		b = Box.createHorizontalBox();
		b.add(jlcurrentID);
		b.add(Box.createHorizontalGlue());
		b.add(jbmodify);
		b.add(Box.createHorizontalStrut(13));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
		columnNames = new Vector<String>();
		columnNames.add("银行账号");
		columnNames.add("账户名");
		columnNames.add("余额");
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
        
        beginningAccountController = new BeginningAccountController();
        ArrayList<BankAccountInfoVO> accountlist = beginningAccountController.findAllBankAccountInfo();
		for(int i = 0; i < accountlist.size(); i++) {
			BankAccountInfoVO vo = accountlist.get(i);
			System.out.println(vo.getAccountName() + " " + vo.getAccountId() + " " + vo.getBalance());
			
			row = new Vector<String>();
			row.add(0, vo.getAccountId());
			row.add(1, vo.getAccountName());
			row.add(2, vo.getBalance()+"");
			model.addRow(row);
		}
        
        table = new JTable();
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table); 
		
		jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
		jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		
		jbstop = new JButton();
		imageReturn = new ImageIcon("image/stop.jpg");
		jbstop.setIcon(imageReturn);
		jbstop.setPreferredSize(new Dimension(imageReturn.getIconWidth(),
				imageReturn.getIconHeight()));
		jbstop.addActionListener(this);
		
		jbrefresh = new JButton();
		imageRefresh = new ImageIcon("image/startbeginaccount.jpg");
		jbrefresh.setIcon(imageRefresh);
		jbrefresh.setPreferredSize(new Dimension(imageRefresh.getIconWidth(),
				imageRefresh.getIconHeight()));
		jbrefresh.addActionListener(this);
		
		jbcheckcurrent = new JButton();
		imageCheckcurrent = new ImageIcon("image/checkcurrent.jpg");
		jbcheckcurrent.setIcon(imageCheckcurrent);
		jbcheckcurrent.setPreferredSize(new Dimension(imageCheckcurrent.getIconWidth(),
				imageCheckcurrent.getIconHeight()));
		jbcheckcurrent.addActionListener(this);
		
		jpanel4.add(Box.createHorizontalStrut(422));
		jpanel4.add(jbcheckcurrent);
		jpanel4.add(Box.createHorizontalStrut(10));
		jpanel4.add(jbrefresh);
		jpanel4.add(Box.createHorizontalStrut(10));
		jpanel4.add(jbstop);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3, BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
		
		this.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbstop){
			//结束建账
			jbstop.setEnabled(false);
			beginningAccountController = new BeginningAccountController();
			
			boolean isNew = beginningAccountController.syncBankAccount();
			if(isNew){
				model.setRowCount(0);
				ArrayList<BankAccountInfoVO> accountlist = beginningAccountController.findAllBankAccountInfo();
				for(int i = 0; i < accountlist.size(); i++) {
					BankAccountInfoVO vo = accountlist.get(i);
					System.out.println(vo.getAccountName() + " " + vo.getAccountId() + " " + vo.getBalance());
					
					row = new Vector<String>();
					row.add(0, vo.getAccountId());
					row.add(1, vo.getAccountName());
					row.add(2, vo.getBalance()+"");
					model.addRow(row);
				}
			}
		}
		if(e.getSource() == jbcheckcurrent){
			//刷新当前列表信息
			
			beginningAccountController = new BeginningAccountController();
			boolean isNew = beginningAccountController.syncBankAccount();
			if(isNew){
				model.setRowCount(0);
				ArrayList<BankAccountInfoVO> accountlist = beginningAccountController.findAllBankAccountInfo();
				for(int i = 0; i < accountlist.size(); i++) {
					BankAccountInfoVO vo = accountlist.get(i);
					System.out.println(vo.getAccountName() + " " + vo.getAccountId() + " " + vo.getBalance());
					
					row = new Vector<String>();
					row.add(0, vo.getAccountId());
					row.add(1, vo.getAccountName());
					row.add(2, vo.getBalance()+"");
					model.addRow(row);
				}
			}
		}
		if(e.getSource() == jbrefresh){
			//开始建账
			jbstop.setEnabled(true);
			new BankAccountManageDriver().setVisible(true);
		}
		
	}

	public static JButton getJbCarInfo() {
		return jbCarInfo;
	}

	public static void setJbCarInfo(JButton jbCarInfo) {
		BeginningAccountBankAccountInfoPanel.jbCarInfo = jbCarInfo;
	}

	public static JButton getJbDriverInfo() {
		return jbDriverInfo;
	}

	public static void setJbDriverInfo(JButton jbDriverInfo) {
		BeginningAccountBankAccountInfoPanel.jbDriverInfo = jbDriverInfo;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		BeginningAccountBankAccountInfoPanel.jbAccountID = jbAccountID;
	}

	public static JButton getJbID() {
		return jbID;
	}

	public static void setJbID(JButton jbID) {
		BeginningAccountBankAccountInfoPanel.jbID = jbID;
	}

	public static JButton getJbInstitutionsManage() {
		return jbInstitutionsManage;
	}

	public static void setJbInstitutionsManage(JButton jbInstitutionsManage) {
		BeginningAccountBankAccountInfoPanel.jbInstitutionsManage = jbInstitutionsManage;
	}
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setContentPane(new BeginningAccountBankAccountInfoPanel());
		main.setVisible(true);
	}


}
