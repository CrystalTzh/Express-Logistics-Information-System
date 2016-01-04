package presentation.mainui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import RMIHelper.URL;
import clienthelper.useraccountclienthelper.UserAccountClientHelper;
import presentation.constui.navigation.PriceNavigation;
import presentation.constui.navigation.SalaryNavigation;
import presentation.corporationui.navigation.BossCheckDiaryNavigation;
import presentation.corporationui.navigation.CarInfoNavigation;
import presentation.corporationui.navigation.CheckDiaryNavigation;
import presentation.corporationui.navigation.DriverInfoNavigation;
import presentation.corporationui.navigation.InstitutionsManageNavigation;
import presentation.financeui.beginningaccountboard.BeginningAccountBankAccountInfoPanel;
import presentation.financeui.beginningaccountboard.BeginningAccountCarInfoPanel;
import presentation.financeui.beginningaccountboard.BeginningAccountDriverInfoPanel;
import presentation.financeui.beginningaccountboard.BeginningAccountInstitutionsInfoPanel;
import presentation.financeui.beginningaccountboard.BeginningAccountUserAccountInfoPanel;
import presentation.financeui.navigation.AccountsNavigation;
import presentation.financeui.navigation.BeginningAccountNavigation;
import presentation.financeui.navigation.BossCheckAccountsNavigation;
import presentation.financeui.navigation.BossCheckCostPayChartNavigation;
import presentation.financeui.navigation.BossCheckProfitChartNavigation;
import presentation.financeui.navigation.CheckCostPayChartNavigation;
import presentation.financeui.navigation.CheckProfitChartNavigation;
import presentation.financeui.navigation.CreateCostPayChartNavigation;
import presentation.financeui.navigation.CreateProfitChartNavigation;
import presentation.financeui.navigation.ReceiptGatherNavigation;
import presentation.formapprovalui.navigation.JudgeNavigation;
import presentation.inventoryui.navigation.AdjustZoneNavigation;
import presentation.inventoryui.navigation.SetLimitNavigation;
import presentation.inventoryui.navigation.StorageCheckNavigation;
import presentation.inventoryui.navigation.StorageCountingNavigation;
import presentation.inventoryui.navigation.StorageInFormNavigation;
import presentation.inventoryui.navigation.StorageOutFormNavigation;
import presentation.outfindui.OutfindFrame;
import presentation.position.AdfinanceManPanel;
import presentation.position.AdministratorPanel;
import presentation.position.BossPanel;
import presentation.position.ExpressManPanel;
import presentation.position.GefinanceManPanel;
import presentation.position.InventoryManPanel;
import presentation.position.OfficeManPanel;
import presentation.position.TransitCenterManPanel;
import presentation.transitui.navigation.DeliveryFormNavigation;
import presentation.transitui.navigation.OfficeArrivalFormNavigation;
import presentation.transitui.navigation.OfficeCarInputFormNavigation;
import presentation.transitui.navigation.OrderFormNavigation;
import presentation.transitui.navigation.OrderInfoCheckNavigation;
import presentation.transitui.navigation.PaymentFormNavigation;
import presentation.transitui.navigation.ReceiptFormNavigation;
import presentation.transitui.navigation.ReceiveMessageInputNavigation;
import presentation.transitui.navigation.RelayArrivalFormNavigation;
import presentation.transitui.navigation.RelayCarInputFormNavigation;
import presentation.transitui.navigation.RelayFormNavigation;
import presentation.userui.loginui.LoginBoard;
import presentation.userui.navigation.UserInfoNavigation;
import state.UserRole;

public class MainFrame extends JFrame implements ActionListener {

		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final int MAINFRAME_WIDTH = 731;
	public static final int MAINFRAME_HEIGHT = 650;
	public JLabel jlLogo,jlinput;
	public JButton jbCheck,jbLogin;
	public ImageIcon imagelogo,imageCheck,imageLogin;
	public JTextField jtExpressNumber;
	
	public static MainFrame mainframe;
	
	public MainFrame(){
//		this.setLayout(new BorderLayout());
		this.setLayout(null);
		jlLogo = new JLabel();
		imagelogo = new ImageIcon("image/mainlogo.jpg");
		jlLogo.setIcon(imagelogo);
//		this.add(jlLogo,BorderLayout.NORTH);
		jlLogo.setBounds(0, 0, imagelogo.getIconWidth(), imagelogo.getIconHeight());
		this.add(jlLogo);
		
		jtExpressNumber = new JTextField("--请输入订单号--");
		jtExpressNumber.setFont(new Font("--请输入订单号--",Font.PLAIN,15));
		jtExpressNumber.setSize(200,35);
		jtExpressNumber.setBounds(340, 333, jtExpressNumber.getWidth(), 
				jtExpressNumber.getHeight());
//		jtExpressNumber.setEnabled(false);
		jtExpressNumber.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jtExpressNumber){
					jtExpressNumber.setEnabled(true);
//					jtExpressNumber.setEditable(true);
				}
			}
		});

		
//		this.add(jtExpressNumber);
		
//		jlinput = new JLabel("");
		
		jbCheck = new JButton();
		imageCheck = new ImageIcon("image/OrderFormCheck.jpg");
		jbCheck.setIcon(imageCheck);
		jbCheck.setPreferredSize(new Dimension(imageCheck.getIconWidth(),
				imageCheck.getIconHeight()));
		jbCheck.setBounds(575, 329, imageCheck.getIconWidth(), imageCheck.getIconHeight());
		this.add(jbCheck);
		jbCheck.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new OutfindFrame().setVisible(true);
			}
			
		});
		
		jbLogin = new JButton();
		imageLogin = new ImageIcon("image/login.jpg");
		jbLogin.setIcon(imageLogin);
		jbLogin.setPreferredSize(new Dimension(imageLogin.getIconWidth(),
				imageLogin.getIconHeight()));
		jbLogin.setBounds(575, 400, imageLogin.getIconWidth(), imageLogin.getIconHeight());
		this.add(jbLogin);
		jbLogin.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbLogin){
					new UserAccountClientHelper();
					new LoginBoard().setVisible(true);;
				}
			}
			
		});
		
		
		this.setTitle("快递物流信息系统");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setSize(MAINFRAME_WIDTH,MAINFRAME_HEIGHT);
		this.setResizable(false);
//		this.dispose();
//		this.setUndecorated(true);
//		this.show();
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - this.getWidth())/2;
		int y = (screen.height - this.getHeight())/2 - 32;
		this.setLocation(x, y);
		

//		validate();
		
	}
	
	
	
	public static void main(String[] args) {
	
//		DriverInfoNavigation driverinfonavigation = new DriverInfoNavigation();
//		CarInfoNavigation carinfonavigation = new CarInfoNavigation();
//		AccountsNavigation accountsnavigation = new AccountsNavigation();
//		ReceiptGatherNavigation receiptgathernavigation = new ReceiptGatherNavigation();
//		PaymentFormNavigation paymentformnavigation = new PaymentFormNavigation();
//		CreateProfitChartNavigation createprofitchartnavigation = new CreateProfitChartNavigation();
//		CreateCostPayChartNavigation createcostpaychartnavigation = new CreateCostPayChartNavigation();
//		BeginningAccountNavigation beginningaccountnavigation = new BeginningAccountNavigation();
//		CheckCostPayChartNavigation checkcostpaychartnavigation = new CheckCostPayChartNavigation();
//		CheckProfitChartNavigation checkprofitchartnavigation = new CheckProfitChartNavigation();
//		CheckDiaryNavigation checkdiarynavigation = new CheckDiaryNavigation();
//		PriceNavigation pricenavigation = new PriceNavigation();
//		SalaryNavigation salarynavigation = new SalaryNavigation();
//		JudgeNavigation judgenavigation = new JudgeNavigation();
//		BossCheckCostPayChartNavigation bosscheckcostpaychartnavigation =  new BossCheckCostPayChartNavigation();
//		BossCheckProfitChartNavigation bosscheckprofitchartnavigation = new BossCheckProfitChartNavigation();
//		BossCheckDiaryNavigation bosscheckdiarynavigation = new BossCheckDiaryNavigation();
//		BossCheckAccountsNavigation bosscheckaccounts = new BossCheckAccountsNavigation();
//		ReceiptFormNavigation receiptformnavigation = new ReceiptFormNavigation();
//		DeliveryFormNavigation deliveryformnavigation = new DeliveryFormNavigation();
//		OfficeArrivalFormNavigation officearrivalformnavigation = new OfficeArrivalFormNavigation();
//		OfficeCarInputFormNavigation officecarinputformnavigation =  new OfficeCarInputFormNavigation();
//		RelayArrivalFormNavigation relayarrivalformnavigation = new RelayArrivalFormNavigation();
//		RelayFormNavigation relayformnavigation = new RelayFormNavigation();
//		RelayCarInputFormNavigation relaycarinputformnavigation = new RelayCarInputFormNavigation();
//		OrderFormNavigation orderformnavigation = new OrderFormNavigation();
//		OrderInfoCheckNavigation orderinfochecknavigation = new OrderInfoCheckNavigation();
//		ReceiveMessageInputNavigation receivemessageinputnavigation = new ReceiveMessageInputNavigation();
//		StorageInFormNavigation storageinformnavigation = new StorageInFormNavigation();
//		StorageOutFormNavigation storageoutformnavigation = new StorageOutFormNavigation();
//		StorageCheckNavigation storagechecknavigation = new StorageCheckNavigation();
//		StorageCountingNavigation storagecountingnavigation = new StorageCountingNavigation();
//		AdjustZoneNavigation adjustzonenavigation = new AdjustZoneNavigation();
//	//	SetLimitNavigation setlimitnavigation = new SetLimitNavigation();
//		UserInfoNavigation userinfonavigation = new UserInfoNavigation();
//		BeginningAccountCarInfoPanel beginningaccountpanel = new BeginningAccountCarInfoPanel();
		
//		BossPanel bosspanel = new BossPanel();
//		ExpressManPanel expressmanpanel = new ExpressManPanel();
//		OfficeManPanel officemanpanel = new OfficeManPanel();
//		TransitCenterManPanel transitcentermanpanel = new TransitCenterManPanel();
//		InventoryManPanel inventorymanpanel = new InventoryManPanel();
//		AdfinanceManPanel adfinancemanpanel = new AdfinanceManPanel();
//		GefinanceManPanel gefinancemanpanel = new GefinanceManPanel();
//		AdministratorPanel administrator = new AdministratorPanel();
		
		String ip = JOptionPane.showInputDialog("请输入服务器的IP地址:");
		URL.setServerIP(ip);
		mainframe = new MainFrame();
//		new MainFrame();
//		mainframe.setContentPane(bosspanel);
//		mainframe.setContentPane(expressmanpanel);
//		mainframe.setContentPane(officemanpanel);
//		mainframe.setContentPane(transitcentermanpanel);
//		mainframe.setContentPane(inventorymanpanel);
//		mainframe.setContentPane(adfinancemanpanel);
//		mainframe.setContentPane(gefinancemanpanel);
//		mainframe.setContentPane(administrator);

//		mainframe.setContentPane(driverinfonavigation);
//		mainframe.setContentPane(carinfonavigation);
//		mainframe.setContentPane(accountsnavigation);
//		mainframe.setContentPane(receiptgathernavigation);
//		mainframe.setContentPane(paymentformnavigation);
//		mainframe.setContentPane(createprofitchartnavigation);
//		mainframe.setContentPane(createcostpaychartnavigation);
//		mainframe.setContentPane(beginningaccountnavigation);
//		mainframe.setContentPane(checkcostpaychartnavigation);
//		mainframe.setContentPane(checkprofitchartnavigation);
//		mainframe.setContentPane(checkdiarynavigation);
//		mainframe.setContentPane(pricenavigation);
//		mainframe.setContentPane(salarynavigation);
//		mainframe.setContentPane(judgenavigation);
//		mainframe.setContentPane(bosscheckcostpaychartnavigation);
//		mainframe.setContentPane(bosscheckprofitchartnavigation);
//		mainframe.setContentPane(bosscheckdiarynavigation);
//		mainframe.setContentPane(bosscheckaccounts);
//		mainframe.setContentPane(receiptformnavigation);
//		mainframe.setContentPane(deliveryformnavigation);
//		mainframe.setContentPane(officearrivalformnavigation);
//		mainframe.setContentPane(officecarinputformnavigation);
//		mainframe.setContentPane(relayarrivalformnavigation);
//		mainframe.setContentPane(relayformnavigation);
//		mainframe.setContentPane(relaycarinputformnavigation);
//		mainframe.setContentPane(orderformnavigation);
//		mainframe.setContentPane(orderinfochecknavigation);
//		mainframe.setContentPane(receivemessageinputnavigation);
//		mainframe.setContentPane(storageinformnavigation);
//		mainframe.setContentPane(storageoutformnavigation);
//		mainframe.setContentPane(storagechecknavigation);
//		mainframe.setContentPane(storagecountingnavigation);
//		mainframe.setContentPane(adjustzonenavigation);
//		mainframe.setContentPane(setlimitnavigation);
//		mainframe.setContentPane(userinfonavigation);
//		mainframe.setContentPane(beginningaccountpanel);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	
//	}
	
	
	public static void repainting(UserRole userrole){
		if(userrole.equals(UserRole.ADMINISTRATOR)){//管理员导航界面
			mainframe.setContentPane(new AdministratorPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.MANAGER)){//总经理导航界面
			mainframe.setContentPane(new BossPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.ADFINANCEMAN)){//高级财务人员导航界面
			mainframe.setContentPane(new AdfinanceManPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.GEFINACEMAN)){//普通财务人员导航界面
			mainframe.setContentPane(new GefinanceManPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.EXPRESSMAN)){//快递员导航界面
			mainframe.setContentPane(new ExpressManPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.INVENTORYMAN)){//仓库管理人员导航界面
			mainframe.setContentPane(new InventoryManPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.OFFICEMAN)){//营业厅业务员导航界面
			mainframe.setContentPane(new OfficeManPanel());
			mainframe.setVisible(true);
		}else if(userrole.equals(UserRole.TRANSITCENTERMAN)){//中转中心业务员导航界面
			mainframe.setContentPane(new TransitCenterManPanel());
			mainframe.setVisible(true);
		}
		
	}
	
	public static void jumping(ActionEvent e){
//总经理所有导航界面
		//机构管理界面
		if(e.getSource() == InstitutionsManageNavigation.getJbPrice()){
			//机构管理界面跳转制定价格常量界面
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbSalary()){
			//机构管理界面跳转制定薪资标准界面
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbJudge()){
			//机构管理界面跳转审批单据界面
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbAccountID()){
			//机构管理界面跳转查看银行账户界面
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbCheckCostPayChart()){
			//机构管理界面跳转总经理查看成本收益表界面
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbCheckProfitChart()){
			//机构管理界面跳转总经理查看经营情况表界面
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbCheckDiary()){
			//机构管理界面跳转总经理查看日志界面
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == InstitutionsManageNavigation.getJbInstitutionsManage()){
			//机构管理界面刷新
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//制定价格常量界面
		else if(e.getSource() == PriceNavigation.getJbPrice()){
			//制定价格常量界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbSalary()){
			//制定价格常量界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbJudge()){
			//制定价格常量界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbAccountID()){
			//制定价格常量界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbCheckCostPayChart()){
			//制定价格常量界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbCheckProfitChart()){
			//制定价格常量界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbCheckDiary()){
			//制定价格常量界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PriceNavigation.getJbInstitutionsManage()){
			//制定价格常量界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//制定薪资标准界面
		else if(e.getSource() == SalaryNavigation.getJbPrice()){
			//制定薪资标准界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbSalary()){
			//制定薪资标准界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbJudge()){
			//制定薪资标准界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbAccountID()){
			//制定薪资标准界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbCheckCostPayChart()){
			//制定薪资标准界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbCheckProfitChart()){
			//制定薪资标准界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbCheckDiary()){
			//制定薪资标准界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SalaryNavigation.getJbInstitutionsManage()){
			//制定薪资标准界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//审批单据
		else if(e.getSource() == JudgeNavigation.getJbPrice()){
			//审批单据界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbSalary()){
			//审批单据界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbJudge()){
			//审批单据界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbAccountID()){
			//审批单据界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbCheckCostPayChart()){
			//审批单据界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbCheckProfitChart()){
			//审批单据界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbCheckDiary()){
			//审批单据界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == JudgeNavigation.getJbInstitutionsManage()){
			//审批单据界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//总经理查看银行账户
		else if(e.getSource() == BossCheckAccountsNavigation.getJbPrice()){
			//总经理查看银行账户界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbSalary()){
			//总经理查看银行账户界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbJudge()){
			//总经理查看银行账户界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbAccountID()){
			//总经理查看银行账户界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbCheckCostPayChart()){
			//总经理查看银行账户界面跳转总经理查看成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbCheckProfitChart()){
			//总经理查看银行账户界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbCheckDiary()){
			//总经理查看银行账户界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckAccountsNavigation.getJbInstitutionsManage()){
			//总经理查看银行账户界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//总经理查看成本收益表
		else if(e.getSource() == BossCheckCostPayChartNavigation.getJbPrice()){
			//总经理查看成本收益表界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbSalary()){
			//总经理查看成本收益表界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbJudge()){
			//总经理查看成本收益表界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbAccountID()){
			//总经理查看成本收益表界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbCheckCostPayChart()){
			//总经理查看成本收益表界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbCheckProfitChart()){
			//总经理查看成本收益表界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbCheckDiary()){
			//总经理查看成本收益表界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckCostPayChartNavigation.getJbInstitutionsManage()){
			//总经理查看成本收益表界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//总经理查看经营情况表
		else if(e.getSource() == BossCheckProfitChartNavigation.getJbPrice()){
			//总经理查看经营情况表界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbSalary()){
			//总经理查看经营情况表界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbJudge()){
			//总经理查看经营情况表界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbAccountID()){
			//总经理查看经营情况表界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbCheckCostPayChart()){
			//总经理查看经营情况表界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbCheckProfitChart()){
			//总经理查看经营情况表界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbCheckDiary()){
			//总经理查看经营情况表界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckProfitChartNavigation.getJbInstitutionsManage()){
			//总经理查看经营情况表界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
		//总经理查看日志
		else if(e.getSource() == BossCheckDiaryNavigation.getJbPrice()){
			//总经理查看日志界面刷新
			mainframe.setContentPane(new PriceNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbSalary()){
			//总经理查看日志界面跳转制定薪资标准
			mainframe.setContentPane(new SalaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbJudge()){
			//总经理查看日志界面跳转审批单据
			mainframe.setContentPane(new JudgeNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbAccountID()){
			//总经理查看日志界面跳转总经理查看银行账户
			mainframe.setContentPane(new BossCheckAccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbCheckCostPayChart()){
			//总经理查看日志界面跳转成本收益表
			mainframe.setContentPane(new BossCheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbCheckProfitChart()){
			//总经理查看日志界面跳转总经理查看经营情况表
			mainframe.setContentPane(new BossCheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbCheckDiary()){
			//总经理查看日志界面跳转总经理查看日志
			mainframe.setContentPane(new BossCheckDiaryNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BossCheckDiaryNavigation.getJbInstitutionsManage()){
			//总经理查看日志界面跳转机构管理
			mainframe.setContentPane(new InstitutionsManageNavigation());
			mainframe.setVisible(true);
		}
//管理员导航界面
		if(e.getSource() == UserInfoNavigation.getJbID()){
			mainframe.setContentPane(new UserInfoNavigation());
			mainframe.setVisible(true);
		}
//高级财务人员所有导航界面
		//增删改查银行账户界面
		if(e.getSource() == AccountsNavigation.getJbReceiptGather()){
			//增删改查银行账户界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCreatePaymentForm()){
			//增删改查银行账户界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCreateCostPayChart()){
			//增删改查银行账户界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCreateProfitChart()){
			//增删改查银行账户界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbBeginningAccount()){
			//增删改查银行账户界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbAccountID()){
			//增删改查银行账户界面刷新
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCheckCostPayChart()){
			//增删改查银行账户界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCheckProfitChart()){
			//增删改查银行账户界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AccountsNavigation.getJbCheckDiary()){
			//增删改查银行账户界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//收款单汇总界面
		if(e.getSource() == ReceiptGatherNavigation.getJbReceiptGather()){
			//收款单汇总界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCreatePaymentForm()){
			//收款单汇总界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCreateCostPayChart()){
			//收款单汇总界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCreateProfitChart()){
			//收款单汇总界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbBeginningAccount()){
			//收款单汇总界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbAccountID()){
			//收款单汇总界面跳转银行账户界面
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCheckCostPayChart()){
			//收款单汇总界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCheckProfitChart()){
			//收款单汇总界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptGatherNavigation.getJbCheckDiary()){
			//收款单汇总界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//创建付款单界面
		if(e.getSource() == PaymentFormNavigation.getJbReceiptGather()){
			//创建付款单界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCreatePaymentForm()){
			//创建付款单界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCreateCostPayChart()){
			//创建付款单界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCreateProfitChart()){
			//创建付款单界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbBeginningAccount()){
			//创建付款单界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbAccountID()){
			//创建付款单界面跳转银行账户界面
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCheckCostPayChart()){
			//创建付款单界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCheckProfitChart()){
			//创建付款单界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == PaymentFormNavigation.getJbCheckDiary()){
			//创建付款单界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//创建成本收益表
		if(e.getSource() == CreateCostPayChartNavigation.getJbReceiptGather()){
			//创建成本收益表跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCreatePaymentForm()){
			//创建成本收益表跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCreateCostPayChart()){
			//创建成本收益表跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCreateProfitChart()){
			//创建成本收益表跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbBeginningAccount()){
			//创建成本收益表跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbAccountID()){
			//创建成本收益表跳转银行账户界面
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCheckCostPayChart()){
			//创建成本收益表跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCheckProfitChart()){
			//创建成本收益表跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateCostPayChartNavigation.getJbCheckDiary()){
			//创建成本收益表跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//创建经营情况表
		if(e.getSource() == CreateProfitChartNavigation.getJbReceiptGather()){
			//创建经营情况表跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCreatePaymentForm()){
			//创建经营情况表跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCreateCostPayChart()){
			//创建经营情况表跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCreateProfitChart()){
			//创建经营情况表跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbBeginningAccount()){
			//创建经营情况表跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbAccountID()){
			//创建经营情况表跳转银行账户界面
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCheckCostPayChart()){
			//创建经营情况表跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCheckProfitChart()){
			//创建经营情况表跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CreateProfitChartNavigation.getJbCheckDiary()){
			//创建经营情况表跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//期初建账
		if(e.getSource() == BeginningAccountNavigation.getJbReceiptGather()){
			//期初建账界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCreatePaymentForm()){
			//期初建账界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCreateCostPayChart()){
			//期初建账界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCreateProfitChart()){
			//期初建账界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbBeginningAccount()){
			//期初建账界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbAccountID()){
			//期初建账界面跳转银行账户界面
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCheckCostPayChart()){
			//期初建账界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCheckProfitChart()){
			//期初建账界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountNavigation.getJbCheckDiary()){
			//期初建账界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//查看成本收益表
		if(e.getSource() == CheckCostPayChartNavigation.getJbReceiptGather()){
			//查看成本收益表界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCreatePaymentForm()){
			//查看成本收益表界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCreateCostPayChart()){
			//查看成本收益表界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCreateProfitChart()){
			//查看成本收益表界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbBeginningAccount()){
			//查看成本收益表界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbAccountID()){
			//查看成本收益表界面刷新
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCheckCostPayChart()){
			//查看成本收益表界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCheckProfitChart()){
			//查看成本收益表界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckCostPayChartNavigation.getJbCheckDiary()){
			//查看成本收益表界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//查看经营情况表
		if(e.getSource() == CheckProfitChartNavigation.getJbReceiptGather()){
			//查看经营情况表界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCreatePaymentForm()){
			//查看经营情况表界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCreateCostPayChart()){
			//查看经营情况表界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCreateProfitChart()){
			//查看经营情况表界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbBeginningAccount()){
			//查看经营情况表界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbAccountID()){
			//查看经营情况表界面刷新
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCheckCostPayChart()){
			//查看经营情况表界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCheckProfitChart()){
			//查看经营情况表界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckProfitChartNavigation.getJbCheckDiary()){
			//查看经营情况表界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
		//查看日志
		if(e.getSource() == CheckDiaryNavigation.getJbReceiptGather()){
			//查看日志界面跳转收款单汇总界面
			mainframe.setContentPane(new ReceiptGatherNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCreatePaymentForm()){
			//查看日志界面跳转跳转创建付款单界面
			mainframe.setContentPane(new PaymentFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCreateCostPayChart()){
			//查看日志界面跳转跳转创建成本收益表
			mainframe.setContentPane(new CreateCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCreateProfitChart()){
			//查看日志界面跳转创建经营情况表
			mainframe.setContentPane(new CreateProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbBeginningAccount()){
			//查看日志界面跳转期初建账
			mainframe.setContentPane(new BeginningAccountNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbAccountID()){
			//查看日志界面刷新
			mainframe.setContentPane(new AccountsNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCheckCostPayChart()){
			//查看日志界面跳转查看成本收益表
			mainframe.setContentPane(new CheckCostPayChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCheckProfitChart()){
			//查看日志界面跳转查看经营情况表
			mainframe.setContentPane(new CheckProfitChartNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CheckDiaryNavigation.getJbCheckDiary()){
			//查看日志界面跳转查看日志
			mainframe.setContentPane(new CheckDiaryNavigation());
			mainframe.setVisible(true);
		}
			
//营业厅业务员所有导航界面
		//营业厅到达单界面
		if(e.getSource() == OfficeArrivalFormNavigation.getJbReceipt()){
			//营业厅到达单界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeArrivalFormNavigation.getJbDelivery()){
			//营业厅到达单界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeArrivalFormNavigation.getJbArrival()){
			//营业厅到达单界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeArrivalFormNavigation.getJbCarInput()){
			//营业厅到达单界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeArrivalFormNavigation.getJbDriverInfo()){
			//营业厅到达单界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeArrivalFormNavigation.getJbCarInfo()){
			//营业厅到达单界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
		//收款单界面
		if(e.getSource() == ReceiptFormNavigation.getJbReceipt()){
			//收款单界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptFormNavigation.getJbDelivery()){
			//收款单界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptFormNavigation.getJbArrival()){
			//收款单界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptFormNavigation.getJbCarInput()){
			//收款单界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptFormNavigation.getJbDriverInfo()){
			//收款单界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiptFormNavigation.getJbCarInfo()){
			//收款单界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
		//派件单界面
		if(e.getSource() == DeliveryFormNavigation.getJbReceipt()){
			//派件单界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DeliveryFormNavigation.getJbDelivery()){
			//派件单界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DeliveryFormNavigation.getJbArrival()){
			//派件单界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DeliveryFormNavigation.getJbCarInput()){
			//派件单界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DeliveryFormNavigation.getJbDriverInfo()){
			//派件单界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DeliveryFormNavigation.getJbCarInfo()){
			//派件单界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
		//营业厅装车单界面
		if(e.getSource() == OfficeCarInputFormNavigation.getJbReceipt()){
			//营业厅装车单界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeCarInputFormNavigation.getJbDelivery()){
			//营业厅装车单界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeCarInputFormNavigation.getJbArrival()){
			//营业厅装车单界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeCarInputFormNavigation.getJbCarInput()){
			//营业厅装车单界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeCarInputFormNavigation.getJbDriverInfo()){
			//营业厅装车单界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OfficeCarInputFormNavigation.getJbCarInfo()){
			//营业厅装车单界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
		//维护司机信息界面
		if(e.getSource() == DriverInfoNavigation.getJbReceipt()){
			//维护司机信息界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DriverInfoNavigation.getJbDelivery()){
			//维护司机信息界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DriverInfoNavigation.getJbArrival()){
			//维护司机信息界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DriverInfoNavigation.getJbCarInput()){
			//维护司机信息界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DriverInfoNavigation.getJbDriverInfo()){
			//维护司机信息界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == DriverInfoNavigation.getJbCarInfo()){
			//维护司机信息界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
		//维护车辆信息界面
		if(e.getSource() == CarInfoNavigation.getJbReceipt()){
			//维护车辆信息界面跳转收款单界面
			mainframe.setContentPane(new ReceiptFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CarInfoNavigation.getJbDelivery()){
			//维护车辆信息界面跳转派件单界面
			mainframe.setContentPane(new DeliveryFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CarInfoNavigation.getJbArrival()){
			//维护车辆信息界面跳转营业厅到达单界面
			mainframe.setContentPane(new OfficeArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CarInfoNavigation.getJbCarInput()){
			//维护车辆信息界面跳转营业厅装车单
			mainframe.setContentPane(new OfficeCarInputFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CarInfoNavigation.getJbDriverInfo()){
			//维护车辆信息界面跳转维护司机信息界面
			mainframe.setContentPane(new DriverInfoNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == CarInfoNavigation.getJbCarInfo()){
			//维护车辆信息界面跳转维护车辆信息界面
			mainframe.setContentPane(new CarInfoNavigation());
			mainframe.setVisible(true);
		}
//中转中心仓库管理人员所有导航界面
		//入库单界面跳转
		if(e.getSource() == StorageInFormNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageInFormNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageInFormNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageInFormNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageInFormNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageInFormNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		//出库单界面
		if(e.getSource() == StorageOutFormNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageOutFormNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageOutFormNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageOutFormNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageOutFormNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageOutFormNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		//调整库存分区界面
		if(e.getSource() == AdjustZoneNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AdjustZoneNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AdjustZoneNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AdjustZoneNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AdjustZoneNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == AdjustZoneNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		//库存查看界面
		if(e.getSource() == StorageCheckNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCheckNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCheckNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCheckNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCheckNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCheckNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		//库存盘点界面
		if(e.getSource() == StorageCountingNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCountingNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCountingNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCountingNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCountingNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == StorageCountingNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		//设置库存警戒值界面
		if(e.getSource() == SetLimitNavigation.getJbStorageInForm()){
			mainframe.setContentPane(new StorageInFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SetLimitNavigation.getJbStorageOutForm()){
			mainframe.setContentPane(new StorageOutFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SetLimitNavigation.getJbZone()){
			mainframe.setContentPane(new AdjustZoneNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SetLimitNavigation.getJbStorageCheck()){
			mainframe.setContentPane(new StorageCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SetLimitNavigation.getJbStorageCounting()){
			mainframe.setContentPane(new StorageCountingNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == SetLimitNavigation.getJbSetLimit()){
			mainframe.setContentPane(new SetLimitNavigation());
			mainframe.setVisible(true);
		}
		
//中转中心业务员所有导航界面
		//中转中心到达单
		if(e.getSource() == RelayArrivalFormNavigation.getJbTransfer()){
			mainframe.setContentPane(new RelayFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayArrivalFormNavigation.getJbArrival()){
			mainframe.setContentPane(new RelayArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayArrivalFormNavigation.getJbCarInput()){
			mainframe.setContentPane(new RelayCarInputFormNavigation());
			mainframe.setVisible(true);
		}
		//中转单
		if(e.getSource() == RelayFormNavigation.getJbTransfer()){
			mainframe.setContentPane(new RelayFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayFormNavigation.getJbArrival()){
			mainframe.setContentPane(new RelayArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayFormNavigation.getJbCarInput()){
			mainframe.setContentPane(new RelayCarInputFormNavigation());
			mainframe.setVisible(true);
		}
		//中转中心装车单
		if(e.getSource() == RelayCarInputFormNavigation.getJbTransfer()){
			mainframe.setContentPane(new RelayFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayCarInputFormNavigation.getJbArrival()){
			mainframe.setContentPane(new RelayArrivalFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == RelayCarInputFormNavigation.getJbCarInput()){
			mainframe.setContentPane(new RelayCarInputFormNavigation());
			mainframe.setVisible(true);
		}
		
//快递员所有导航界面
		//寄件单
		if(e.getSource() == OrderFormNavigation.getJbOrderForm()){
			mainframe.setContentPane(new OrderFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OrderFormNavigation.getJbCheck()){
			mainframe.setContentPane(new OrderInfoCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OrderFormNavigation.getJbReceiveInfo()){
			mainframe.setContentPane(new ReceiveMessageInputNavigation());
			mainframe.setVisible(true);
		}
		//订单信息查询
		if(e.getSource() == OrderInfoCheckNavigation.getJbOrderForm()){
			mainframe.setContentPane(new OrderFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OrderInfoCheckNavigation.getJbCheck()){
			mainframe.setContentPane(new OrderInfoCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == OrderInfoCheckNavigation.getJbReceiveInfo()){
			mainframe.setContentPane(new ReceiveMessageInputNavigation());
			mainframe.setVisible(true);
		}
		//收件信息录入
		if(e.getSource() == ReceiveMessageInputNavigation.getJbOrderForm()){
			mainframe.setContentPane(new OrderFormNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiveMessageInputNavigation.getJbCheck()){
			mainframe.setContentPane(new OrderInfoCheckNavigation());
			mainframe.setVisible(true);
		}else if(e.getSource() == ReceiveMessageInputNavigation.getJbReceiveInfo()){
			mainframe.setContentPane(new ReceiveMessageInputNavigation());
			mainframe.setVisible(true);
		}
		
		//期初建账具体页面跳转
		if(e.getSource() == BeginningAccountCarInfoPanel.getJbCarInfo()){
			//期初建账 车辆信息跳转车辆信息面板
			mainframe.setContentPane(new BeginningAccountCarInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountCarInfoPanel.getJbDriverInfo()){
			System.out.println("!");
			//期初建账 车辆信息面板跳转司机信息面板
			mainframe.setContentPane(new BeginningAccountDriverInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountCarInfoPanel.getJbAccountID()){
			//期初建账 车辆信息面板跳转银行账户信息面板
			mainframe.setContentPane(new BeginningAccountBankAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountCarInfoPanel.getJbID()){
			//期初建账 车辆信息面板跳转用户信息面板
			mainframe.setContentPane(new BeginningAccountUserAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountCarInfoPanel.getJbInstitutionsManage()){
			//期初建账 车辆信息面板跳转机构信息面板
			mainframe.setContentPane(new BeginningAccountInstitutionsInfoPanel());
			mainframe.setVisible(true);
		}
		
		if(e.getSource() == BeginningAccountDriverInfoPanel.getJbCarInfo()){
			//期初建账 司机信息跳转车辆信息面板
			mainframe.setContentPane(new BeginningAccountCarInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountDriverInfoPanel.getJbDriverInfo()){
			//期初建账 司机信息面板跳转司机信息面板
			mainframe.setContentPane(new BeginningAccountDriverInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountDriverInfoPanel.getJbAccountID()){
			//期初建账 司机信息面板跳转银行账户信息面板
			mainframe.setContentPane(new BeginningAccountBankAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountDriverInfoPanel.getJbID()){
			//期初建账 司机信息面板跳转用户信息面板
			mainframe.setContentPane(new BeginningAccountUserAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountDriverInfoPanel.getJbInstitutionsManage()){
			//期初建账 司机信息面板跳转机构信息面板
			mainframe.setContentPane(new BeginningAccountInstitutionsInfoPanel());
			mainframe.setVisible(true);
		}
		
		if(e.getSource() == BeginningAccountBankAccountInfoPanel.getJbCarInfo()){
			//期初建账 银行信息跳转车辆信息面板
			mainframe.setContentPane(new BeginningAccountCarInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountBankAccountInfoPanel.getJbDriverInfo()){
			//期初建账 银行信息面板跳转司机信息面板
			mainframe.setContentPane(new BeginningAccountDriverInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountBankAccountInfoPanel.getJbAccountID()){
			//期初建账 银行信息面板跳转银行账户信息面板
			mainframe.setContentPane(new BeginningAccountBankAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountBankAccountInfoPanel.getJbID()){
			//期初建账 银行信息面板跳转用户信息面板
			mainframe.setContentPane(new BeginningAccountUserAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountBankAccountInfoPanel.getJbInstitutionsManage()){
			//期初建账 银行信息面板跳转机构信息面板
			mainframe.setContentPane(new BeginningAccountInstitutionsInfoPanel());
			mainframe.setVisible(true);
		}
		
		if(e.getSource() == BeginningAccountUserAccountInfoPanel.getJbCarInfo()){
			//期初建账 用户信息跳转车辆信息面板
			mainframe.setContentPane(new BeginningAccountCarInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountUserAccountInfoPanel.getJbDriverInfo()){
			//期初建账 用户信息面板跳转司机信息面板
			mainframe.setContentPane(new BeginningAccountDriverInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountUserAccountInfoPanel.getJbAccountID()){
			//期初建账 用户信息面板跳转银行账户信息面板
			mainframe.setContentPane(new BeginningAccountBankAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountUserAccountInfoPanel.getJbID()){
			//期初建账 用户信息面板跳转用户信息面板
			mainframe.setContentPane(new BeginningAccountUserAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountUserAccountInfoPanel.getJbInstitutionsManage()){
			//期初建账 用户信息面板跳转机构信息面板
			mainframe.setContentPane(new BeginningAccountInstitutionsInfoPanel());
			mainframe.setVisible(true);
		}
		
		if(e.getSource() == BeginningAccountInstitutionsInfoPanel.getJbCarInfo()){
			//期初建账 机构信息跳转车辆信息面板
			mainframe.setContentPane(new BeginningAccountCarInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountInstitutionsInfoPanel.getJbDriverInfo()){
			//期初建账 机构信息面板跳转司机信息面板
			mainframe.setContentPane(new BeginningAccountDriverInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountInstitutionsInfoPanel.getJbAccountID()){
			//期初建账 机构信息面板跳转银行账户信息面板
			mainframe.setContentPane(new BeginningAccountBankAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountInstitutionsInfoPanel.getJbID()){
			//期初建账 机构信息面板跳转用户信息面板
			mainframe.setContentPane(new BeginningAccountUserAccountInfoPanel());
			mainframe.setVisible(true);
		}else if(e.getSource() == BeginningAccountInstitutionsInfoPanel.getJbInstitutionsManage()){
			//期初建账 机构信息面板跳转机构信息面板
			mainframe.setContentPane(new BeginningAccountInstitutionsInfoPanel());
			mainframe.setVisible(true);
		}
		
		
	}
}
