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
import javax.swing.JTextField;

import clienthelper.useraccountclienthelper.UserAccountClientHelper;
import presentation.constui.navigation.PriceNavigation;
import presentation.constui.navigation.SalaryNavigation;
import presentation.corporationui.navigation.CarInfoNavigation;
import presentation.corporationui.navigation.DriverInfoNavigation;
import presentation.financeui.navigation.AccountsNavigation;
import presentation.financeui.navigation.BeginningAccountNavigation;
import presentation.financeui.navigation.BossCheckAccountsNavigation;
import presentation.financeui.navigation.BossCheckCostPayChartNavigation;
import presentation.financeui.navigation.BossCheckDiaryNavigation;
import presentation.financeui.navigation.BossCheckProfitChartNavigation;
import presentation.financeui.navigation.CheckCostPayChartNavigation;
import presentation.financeui.navigation.CheckDiaryNavigation;
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

public class MainFrame extends JFrame implements ActionListener {

		
	public static final int MAINFRAME_WIDTH = 731;
	public static final int MAINFRAME_HEIGHT = 650;
	public JLabel jlLogo,jlinput;
	public JButton jbCheck,jbLogin;
	public ImageIcon imagelogo,imageCheck,imageLogin;
	public JTextField jtExpressNumber;
	
	static MainFrame mainframe;
	
	@SuppressWarnings("deprecation")
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

		
		this.add(jtExpressNumber);
		
//		jlinput = new JLabel("");
		
		jbCheck = new JButton();
		imageCheck = new ImageIcon("image/OrderFormCheck.jpg");
		jbCheck.setIcon(imageCheck);
		jbCheck.setPreferredSize(new Dimension(imageCheck.getIconWidth(),
				imageCheck.getIconHeight()));
		jbCheck.setBounds(575, 329, imageCheck.getIconWidth(), imageCheck.getIconHeight());
		this.add(jbCheck);
		
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
	
		DriverInfoNavigation driverinfonavigation = new DriverInfoNavigation();
		CarInfoNavigation carinfonavigation = new CarInfoNavigation();
		AccountsNavigation accountsnavigation = new AccountsNavigation();
		ReceiptGatherNavigation receiptgathernavigation = new ReceiptGatherNavigation();
		PaymentFormNavigation paymentformnavigation = new PaymentFormNavigation();
		CreateProfitChartNavigation createprofitchartnavigation = new CreateProfitChartNavigation();
		CreateCostPayChartNavigation createcostpaychartnavigation = new CreateCostPayChartNavigation();
		BeginningAccountNavigation beginningaccountnavigation = new BeginningAccountNavigation();
		CheckCostPayChartNavigation checkcostpaychartnavigation = new CheckCostPayChartNavigation();
		CheckProfitChartNavigation checkprofitchartnavigation = new CheckProfitChartNavigation();
		CheckDiaryNavigation checkdiarynavigation = new CheckDiaryNavigation();
		PriceNavigation pricenavigation = new PriceNavigation();
		SalaryNavigation salarynavigation = new SalaryNavigation();
		JudgeNavigation judgenavigation = new JudgeNavigation();
		BossCheckCostPayChartNavigation bosscheckcostpaychartnavigation =  new BossCheckCostPayChartNavigation();
		BossCheckProfitChartNavigation bosscheckprofitchartnavigation = new BossCheckProfitChartNavigation();
		BossCheckDiaryNavigation bosscheckdiarynavigation = new BossCheckDiaryNavigation();
		BossCheckAccountsNavigation bosscheckaccounts = new BossCheckAccountsNavigation();
		ReceiptFormNavigation receiptformnavigation = new ReceiptFormNavigation();
		DeliveryFormNavigation deliveryformnavigation = new DeliveryFormNavigation();
		OfficeArrivalFormNavigation officearrivalformnavigation = new OfficeArrivalFormNavigation();
		OfficeCarInputFormNavigation officecarinputformnavigation =  new OfficeCarInputFormNavigation();
		RelayArrivalFormNavigation relayarrivalformnavigation = new RelayArrivalFormNavigation();
		RelayFormNavigation relayformnavigation = new RelayFormNavigation();
		RelayCarInputFormNavigation relaycarinputformnavigation = new RelayCarInputFormNavigation();
		OrderFormNavigation orderformnavigation = new OrderFormNavigation();
		OrderInfoCheckNavigation orderinfochecknavigation = new OrderInfoCheckNavigation();
		ReceiveMessageInputNavigation receivemessageinputnavigation = new ReceiveMessageInputNavigation();
		StorageInFormNavigation storageinformnavigation = new StorageInFormNavigation();
		StorageOutFormNavigation storageoutformnavigation = new StorageOutFormNavigation();
		StorageCheckNavigation storagechecknavigation = new StorageCheckNavigation();
		StorageCountingNavigation storagecountingnavigation = new StorageCountingNavigation();
		AdjustZoneNavigation adjustzonenavigation = new AdjustZoneNavigation();
	//	SetLimitNavigation setlimitnavigation = new SetLimitNavigation();
		UserInfoNavigation userinfonavigation = new UserInfoNavigation();
		
		BossPanel bosspanel = new BossPanel();
		ExpressManPanel expressmanpanel = new ExpressManPanel();
		OfficeManPanel officemanpanel = new OfficeManPanel();
		TransitCenterManPanel transitcentermanpanel = new TransitCenterManPanel();
		InventoryManPanel inventorymanpanel = new InventoryManPanel();
		AdfinanceManPanel adfinancemanpanel = new AdfinanceManPanel();
		GefinanceManPanel gefinancemanpanel = new GefinanceManPanel();
		AdministratorPanel administrator = new AdministratorPanel();
		
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
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	
//	}
	
}
