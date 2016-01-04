package presentation.financeui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
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
import presentation.corporationui.navigation.CheckDiaryNavigation;
import presentation.financeui.beginningaccountboard.BeginningAccountCarInfoPanel;
import presentation.mainui.MainFrame;
import presentation.transitui.navigation.PaymentFormNavigation;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import state.City;
import state.UserRole;
import vo.BankAccountInfoVO;
import vo.CarInfoVO;
import vo.DriverInfoVO;
import vo.OfficeVO;
import vo.TransferOfficeVO;
import vo.UserAccountVO;

public class BeginningAccountNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JLabel jlcarinfo,jldriverinfo,jlaccountinfo,jluserinfo,jlinsinfo;
	static private JButton jbReceiptGather,jbCreatePaymentForm,jbCreateCostPayChart,
					jbCreateProfitChart,jbAccountID,jbBeginningAccount,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageReceiptGather,imageCreatePaymentForm,imageCreateCostPayChart,
					  imageCreateProfitChart,imageAccount,imageBeginningAccount,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable tableaccount,tablecar,tabledriver,tableuser,tableins;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,tablebox;
	private ScrollPane sp;
	Vector<String> columnaccountNames,columncarNames,columndriverNames,columnuserNames,columninsNames;
	Vector<String> tableaccountValues,tablecarValues,tabledriverValues,tableuserValues,tableinsValues;
	Vector<String> rowaccount,rowcar,rowdriver,rowuser,rowins;
	DefaultTableModel modelaccount,modelcar,modeldriver,modeluser,modelins;
	BeginningAccountController beginningAccountController;
	
	public BeginningAccountNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(9, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));

		setJbReceiptGather(new JButton());//收款单汇总
		imageReceiptGather = new ImageIcon("image/receiptgather.jpg");
		getJbReceiptGather().setIcon(imageReceiptGather);
		getJbReceiptGather().setPreferredSize(new Dimension(imageReceiptGather.getIconWidth(),
				imageReceiptGather.getIconHeight()));
		getJbReceiptGather().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbReceiptGather()){
					new MainFrame().setContentPane(new ReceiptGatherNavigation());
				}
			}
			
		});
		
		
		setJbCreatePaymentForm(new JButton());//生成付款单
		imageCreatePaymentForm = new ImageIcon("image/createpaymentform.jpg");
		getJbCreatePaymentForm().setIcon(imageCreatePaymentForm);
		getJbCreatePaymentForm().setPreferredSize(new Dimension(imageCreatePaymentForm.getIconWidth(),
				imageCreatePaymentForm.getIconHeight()));
		getJbCreatePaymentForm().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCreatePaymentForm()){
					new MainFrame().setContentPane(new PaymentFormNavigation());
				}
			}
			
		});
		
		setJbCreateCostPayChart(new JButton());//创建成本收益表
		imageCreateCostPayChart = new ImageIcon("image/createcostpaychart.jpg");
		getJbCreateCostPayChart().setIcon(imageCreateCostPayChart);
		getJbCreateCostPayChart().setPreferredSize(new Dimension(imageCreateCostPayChart.getIconWidth(),
				imageCreateCostPayChart.getIconHeight()));
		getJbCreateCostPayChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCreateCostPayChart()){
					new MainFrame().setContentPane(new CreateCostPayChartNavigation());
				}
			}
			
		});
		
		setJbCreateProfitChart(new JButton());//创建经营情况表
		imageCreateProfitChart = new ImageIcon("image/createprofitchart.jpg");
		getJbCreateProfitChart().setIcon(imageCreateProfitChart);
		getJbCreateProfitChart().setPreferredSize(new Dimension(imageCreateProfitChart.getIconWidth(),
				imageCreateProfitChart.getIconHeight()));
		getJbCreateProfitChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCreateProfitChart()){
					new MainFrame().setContentPane(new CreateProfitChartNavigation());
				}
			}
			
		});
		
		setJbBeginningAccount(new JButton());//期初建账
		imageBeginningAccount = new ImageIcon("image/beginningaccount.jpg");
		getJbBeginningAccount().setIcon(imageBeginningAccount);
		getJbBeginningAccount().setPreferredSize(new Dimension(imageBeginningAccount.getIconWidth(),
				imageBeginningAccount.getIconHeight()));
		getJbBeginningAccount().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbBeginningAccount()){
					new MainFrame().setContentPane(new BeginningAccountNavigation());
				}
			}
			
		});
		
		setJbAccountID(new JButton());//增删改查账户
		imageAccount = new ImageIcon("image/accountID.jpg");
		getJbAccountID().setIcon(imageAccount);
		getJbAccountID().setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		getJbAccountID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbAccountID()){
					new MainFrame().setContentPane(new AccountsNavigation());
				}
			}
			
		});
		
		setJbCheckCostPayChart(new JButton());//查看成本收益表
		imageCheckCostPayChart = new ImageIcon("image/checkcostpaychart.jpg");
		getJbCheckCostPayChart().setIcon(imageCheckCostPayChart);
		getJbCheckCostPayChart().setPreferredSize(new Dimension(imageCheckCostPayChart.getIconWidth(),
				imageCheckCostPayChart.getIconHeight()));
		getJbCheckCostPayChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCheckCostPayChart()){
					new MainFrame().setContentPane(new CheckCostPayChartNavigation());
				}
			}
			
		});
		
		setJbCheckProfitChart(new JButton());//查看经营情况表
		imageCheckProfitChart = new ImageIcon("image/checkprofitchart.jpg");
		getJbCheckProfitChart().setIcon(imageCheckProfitChart);
		getJbCheckProfitChart().setPreferredSize(new Dimension(imageCheckProfitChart.getIconWidth(),
				imageCheckProfitChart.getIconHeight()));
		getJbCheckProfitChart().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCheckProfitChart()){
					new MainFrame().setContentPane(new CheckProfitChartNavigation());
				}
			}
			
		});
		
		setJbCheckDiary(new JButton());//查看日志
		imageCheckDiary = new ImageIcon("image/checkdiary.jpg");
		getJbCheckDiary().setIcon(imageCheckDiary);
		getJbCheckDiary().setPreferredSize(new Dimension(imageCheckDiary.getIconWidth(),
				imageCheckDiary.getIconHeight()));
		getJbCheckDiary().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == getJbCheckDiary()){
					new MainFrame().setContentPane(new CheckDiaryNavigation());
				}
			}
			
		});
		
		jpanel2.add(getJbReceiptGather());
		jpanel2.add(getJbCreatePaymentForm());
		jpanel2.add(getJbCreateProfitChart());
		jpanel2.add(getJbCreateCostPayChart());
		jpanel2.add(getJbBeginningAccount());
		jpanel2.add(getJbAccountID());
		jpanel2.add(getJbCheckCostPayChart());
		jpanel2.add(getJbCheckProfitChart());
		jpanel2.add(getJbCheckDiary());
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(7, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：高级财务人员    "+UserID.userid+" 当前任务：期初建账");
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
		
		beginningAccountController = new BeginningAccountController();
		
		jlaccountinfo = new JLabel("银行账户信息列表");
		jlaccountinfo.setFont(new Font("银行账户信息列表",Font.BOLD,15));
		
//		String[] columnaccountNames = { "卡号", "余额" };  
//        String[][] tableaccountValues = { { "A1", "B1" }, { "A2", "B2"},  
//                { "A3", "B3"}, { "A4", "B4"}, { "A5", "B5" },{ "A6", "B6" }}; 
        
		columnaccountNames = new Vector<String>();
		columnaccountNames.add("银行账号");
		columnaccountNames.add("账户名");
		columnaccountNames.add("余额");
		tableaccountValues = new Vector<String>();
		
		modelaccount = new DefaultTableModel(tableaccountValues,columnaccountNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
			
        };
        
        
        ArrayList<BankAccountInfoVO> accountlist = beginningAccountController.findAllBankAccountInfo();
		for(int i = 0; i < accountlist.size(); i++) {
			BankAccountInfoVO vo = accountlist.get(i);
			System.out.println(vo.getAccountName() + " " + vo.getAccountId() + " " + vo.getBalance());
			
			rowaccount = new Vector<String>();
			rowaccount.add(0, vo.getAccountId());
			rowaccount.add(1, vo.getAccountName());
			rowaccount.add(2, vo.getBalance()+"");
			modelaccount.addRow(rowaccount);
		}

        tableaccount = new JTable();
        modelaccount.setDataVector(tableaccountValues, columnaccountNames);
        tableaccount.setModel(modelaccount);
        JScrollPane scrollPaneaccount = new JScrollPane(tableaccount); 
        
        jlcarinfo = new JLabel("车辆信息列表");
        jlcarinfo.setFont(new Font("车辆信息列表",Font.BOLD,15));
        
//        String[] columncarNames = { "车辆代号", "车牌号","发动机号","底盘号","购买时间","服役时间" };  
//        String[][] tablecarValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
//                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
//                { "A6", "B6","C6","D6","E6","F6" }};  
        
        columncarNames = new Vector<String>();
        columncarNames.add("车辆代号");
        columncarNames.add("车牌号");
        columncarNames.add("服役时间");
        tablecarValues = new Vector<String>();
        
        modelcar = new DefaultTableModel(tablecarValues, columncarNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        
        ArrayList<CarInfoVO> carlist = beginningAccountController.findAlCarInfo();
		for(int i = 0; i < carlist.size(); i++) {
			CarInfoVO vo = carlist.get(i);
			System.out.println(vo.getCarNumber() + " " + vo.getPlateNumber() + " " + vo.getActiveTime());
			
			rowcar = new Vector<String>();
			rowcar.add(0, vo.getCarNumber());
			rowcar.add(1, vo.getPlateNumber());
			rowcar.add(2, vo.getActiveTime()+"");
			modelcar.addRow(rowcar);
		}
        
        tablecar = new JTable();
        modelcar.setDataVector(tablecarValues, columncarNames);
        tablecar.setModel(modelcar);
        JScrollPane scrollPanecar = new JScrollPane(tablecar);
        
        jldriverinfo = new JLabel("司机信息列表");
        jldriverinfo.setFont(new Font("司机信息列表",Font.BOLD,15));
        
//        String[] columndriverNames = { "姓名", "司机编号","性别","身份证号","手机","行驶证期限" };  
//        String[][] tabledriverValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
//                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
//                { "A6", "B6","C6","D6","E6","F6" }};  
        columndriverNames = new Vector<String>();
        columndriverNames.add("姓名");
        columndriverNames.add("司机编号");
        columndriverNames.add("性别");
        columndriverNames.add("身份证号");
        columndriverNames.add("手机号");
        columndriverNames.add("行驶证期限");
        tabledriverValues = new Vector<String>();
        
        modeldriver = new DefaultTableModel(tabledriverValues, columndriverNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
			
        };
        
        ArrayList<DriverInfoVO> driverlist = beginningAccountController.findAllDriverInfo();
		for(int i = 0; i < driverlist.size(); i++) {
			DriverInfoVO vo = driverlist.get(i);
			System.out.println(vo.getName() + " " + vo.getDriverNumber() + " " + vo.getSex()+" "+vo.getBirthday()
								+" "+ vo.getCellphone() + " "+ vo.getLicensedate());
			
			rowdriver = new Vector<String>();
			rowdriver.add(0, vo.getName());
			rowdriver.add(1, vo.getDriverNumber());
			rowdriver.add(2, vo.getSex().toString());
			rowdriver.add(3, vo.getBirthday());
			rowdriver.add(4, vo.getCellphone());
			rowdriver.add(5, vo.getLicensedate());
			modeldriver.addRow(rowdriver);
		}
        
        tabledriver = new JTable(); 
        modeldriver.setDataVector(tabledriverValues, columndriverNames);
        tabledriver.setModel(modeldriver);
        JScrollPane scrollPanedriver = new JScrollPane(tabledriver); 
        
        jluserinfo = new JLabel("用户信息列表");
        jluserinfo.setFont(new Font("用户信息列表",Font.BOLD,15));
        
//        String[] columnuserNames = { "用户名","用户类型"};  
//        String[][] tableuserValues = { { "A1", "B1"}, { "A2", "B2"},  
//                { "A3", "B3" }, { "A4", "B4" },{ "A5", "B5" },{ "A6", "B6" }};  
        columnuserNames = new Vector<String>();
        columnuserNames.add("账号");
        columnuserNames.add("初始密码");
        columnuserNames.add("职位");
        tableuserValues = new Vector<String>();
        
        modeluser = new DefaultTableModel(tableuserValues,columnuserNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
			
			
        };
        
        Hashtable<UserRole, ArrayList<UserAccountVO>> userlist = beginningAccountController.findAllUserAccountInfo();
		
        for(Iterator<UserRole> itr = userlist.keySet().iterator(); itr.hasNext();) {
			UserRole key = itr.next();
			ArrayList<UserAccountVO> list = userlist.get(key);
			for(int j = 0; j < list.size(); j++) {
				UserAccountVO vo = list.get(j);
				System.out.println(vo.getAccountID() + " " + vo.getUserRole().toString() + " " + vo.getUserName());
			
				rowuser = new Vector<String>();
				rowuser.add(0, vo.getAccountID());
				rowuser.add(1, vo.getUserName());
				rowuser.add(2, vo.getUserRole().toString());
				modeluser.addRow(rowuser);
			
			}
		}
        
        tableuser = new JTable();
        modeluser.setDataVector(tableuserValues, columnuserNames);
        tableuser.setModel(modeluser);
        JScrollPane scrollPaneuser = new JScrollPane(tableuser); 
        
        jlinsinfo = new JLabel("机构信息列表");
        jlinsinfo.setFont(new Font("机构信息列表",Font.BOLD,15));
        
        columninsNames = new Vector<String>();
        columninsNames.add("机构名称");
        columninsNames.add("机构编号");
        columninsNames.add("城市");
//        columnNames.add("区");
		tableinsValues = new Vector<String>();
		
		modelins = new DefaultTableModel(tableinsValues,columninsNames){
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
        Hashtable<City, ArrayList<TransferOfficeVO>> transferlist = beginningAccountController.findAllTransferOfficeInfo();
		
        for(Iterator<City> itr = transferlist.keySet().iterator(); itr.hasNext();) {
			City key = itr.next();
			ArrayList<TransferOfficeVO> list = transferlist.get(key);
			for(int i = 0; i < list.size(); i++) {
				TransferOfficeVO vo = list.get(i);
				System.out.println(vo.getTransferOfficeID() + " " + vo.getCity().toString());
				
				rowins = new Vector<String>();
				rowins.add(0, "中转中心");
				rowins.add(1, vo.getTransferOfficeID());
				rowins.add(2, vo.getCity().toString());
				
//				row.add(4, vo.getBeiJingDistrict().toString());
				modelins.addRow(rowins);
			}
		}
        Hashtable<City, ArrayList<OfficeVO>> officelist = beginningAccountController.findAllOfficeInfo();
        
        for(Iterator<City> itr = officelist.keySet().iterator(); itr.hasNext();) {
			City key = itr.next();
			ArrayList<OfficeVO> list = officelist.get(key);
			for(int i = 0; i < list.size(); i++) {
				OfficeVO vo = list.get(i);
				System.out.println(vo.getOfficeID() + " " + vo.getCity().toString());
				
				rowins = new Vector<String>();
				rowins.add(0, "营业厅");
				rowins.add(1, vo.getOfficeID());
				rowins.add(2, vo.getCity().toString());
//				row.add(4, vo.getBeiJingDistrict().toString());
				modelins.addRow(rowins);
			}
		}
        tableins = new JTable();
        modelins.setDataVector(tableinsValues, columninsNames);
        tableins.setModel(modelins);
        JScrollPane scrollPaneins = new JScrollPane(tableins); 
        
        tablebox = Box.createVerticalBox();
        
        tablebox.add(Box.createHorizontalStrut(130));
        tablebox.add(jlcarinfo);
        tablebox.add(Box.createVerticalStrut(2));
        tablebox.add(scrollPanecar);
        tablebox.add(Box.createVerticalStrut(2));
        
        tablebox.add(Box.createHorizontalStrut(130));
        tablebox.add(jldriverinfo);
        tablebox.add(Box.createVerticalStrut(2));
        tablebox.add(scrollPanedriver);
        tablebox.add(Box.createVerticalStrut(2));
        
        tablebox.add(Box.createHorizontalStrut(130));
        tablebox.add(jlaccountinfo);
        tablebox.add(Box.createVerticalStrut(2));
        tablebox.add(scrollPaneaccount);
        tablebox.add(Box.createVerticalStrut(2));
        
        tablebox.add(Box.createHorizontalStrut(130));
        tablebox.add(jluserinfo);
        tablebox.add(Box.createVerticalStrut(2));
        tablebox.add(scrollPaneuser);
        
        tablebox.add(Box.createHorizontalStrut(130));
        tablebox.add(jlinsinfo);
        tablebox.add(Box.createVerticalStrut(2));
        tablebox.add(scrollPaneins);
        
        
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(5));
        jpanel3.add(tablebox);
        
        sp = new ScrollPane();
		sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startsetup.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		jbstart.addActionListener(this);
		
		jpanel4.add(Box.createHorizontalStrut(622));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(sp,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
		
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbexit){
			new MainFrame().remove(this);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
		if(e.getSource() == jbstart){
			//TODO
			MainFrame main = new MainFrame();
			main.setContentPane(new BeginningAccountCarInfoPanel());
			main.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setContentPane(new BeginningAccountNavigation());
		main.setVisible(true);
	}

	public static JButton getJbReceiptGather() {
		return jbReceiptGather;
	}

	public static void setJbReceiptGather(JButton jbReceiptGather) {
		BeginningAccountNavigation.jbReceiptGather = jbReceiptGather;
	}

	public static JButton getJbCreatePaymentForm() {
		return jbCreatePaymentForm;
	}

	public static void setJbCreatePaymentForm(JButton jbCreatePaymentForm) {
		BeginningAccountNavigation.jbCreatePaymentForm = jbCreatePaymentForm;
	}

	public static JButton getJbCreateCostPayChart() {
		return jbCreateCostPayChart;
	}

	public static void setJbCreateCostPayChart(JButton jbCreateCostPayChart) {
		BeginningAccountNavigation.jbCreateCostPayChart = jbCreateCostPayChart;
	}

	public static JButton getJbCreateProfitChart() {
		return jbCreateProfitChart;
	}

	public static void setJbCreateProfitChart(JButton jbCreateProfitChart) {
		BeginningAccountNavigation.jbCreateProfitChart = jbCreateProfitChart;
	}

	public static JButton getJbBeginningAccount() {
		return jbBeginningAccount;
	}

	public static void setJbBeginningAccount(JButton jbBeginningAccount) {
		BeginningAccountNavigation.jbBeginningAccount = jbBeginningAccount;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		BeginningAccountNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		BeginningAccountNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		BeginningAccountNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		BeginningAccountNavigation.jbCheckDiary = jbCheckDiary;
	}
}
