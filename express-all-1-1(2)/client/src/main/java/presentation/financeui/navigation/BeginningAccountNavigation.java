package presentation.financeui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.mainui.MainFrame;
import presentation.transitui.navigation.PaymentFormNavigation;

public class BeginningAccountNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JLabel jlcarinfo,jldriverinfo,jlaccountinfo,jluserinfo;
	private JButton jbReceiptGather,jbCreatePaymentForm,jbCreateCostPayChart,
					jbCreateProfitChart,jbAccountID,jbBeginningAccount,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageReceiptGather,imageCreatePaymentForm,imageCreateCostPayChart,
					  imageCreateProfitChart,imageAccount,imageBeginningAccount,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable tableaccount,tablecar,tabledriver,tableuser;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,tablebox;
	private ScrollPane sp;
	
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

		jbReceiptGather = new JButton();//收款单汇总
		imageReceiptGather = new ImageIcon("image/receiptgather.jpg");
		jbReceiptGather.setIcon(imageReceiptGather);
		jbReceiptGather.setPreferredSize(new Dimension(imageReceiptGather.getIconWidth(),
				imageReceiptGather.getIconHeight()));
		jbReceiptGather.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbReceiptGather){
					new MainFrame().setContentPane(new ReceiptGatherNavigation());
				}
			}
			
		});
		
		
		jbCreatePaymentForm = new JButton();//生成付款单
		imageCreatePaymentForm = new ImageIcon("image/createpaymentform.jpg");
		jbCreatePaymentForm.setIcon(imageCreatePaymentForm);
		jbCreatePaymentForm.setPreferredSize(new Dimension(imageCreatePaymentForm.getIconWidth(),
				imageCreatePaymentForm.getIconHeight()));
		jbCreatePaymentForm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCreatePaymentForm){
					new MainFrame().setContentPane(new PaymentFormNavigation());
				}
			}
			
		});
		
		jbCreateCostPayChart = new JButton();//创建成本收益表
		imageCreateCostPayChart = new ImageIcon("image/createcostpaychart.jpg");
		jbCreateCostPayChart.setIcon(imageCreateCostPayChart);
		jbCreateCostPayChart.setPreferredSize(new Dimension(imageCreateCostPayChart.getIconWidth(),
				imageCreateCostPayChart.getIconHeight()));
		jbCreateCostPayChart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCreateCostPayChart){
					new MainFrame().setContentPane(new CreateCostPayChartNavigation());
				}
			}
			
		});
		
		jbCreateProfitChart = new JButton();//创建经营情况表
		imageCreateProfitChart = new ImageIcon("image/createprofitchart.jpg");
		jbCreateProfitChart.setIcon(imageCreateProfitChart);
		jbCreateProfitChart.setPreferredSize(new Dimension(imageCreateProfitChart.getIconWidth(),
				imageCreateProfitChart.getIconHeight()));
		jbCreateProfitChart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCreateProfitChart){
					new MainFrame().setContentPane(new CreateProfitChartNavigation());
				}
			}
			
		});
		
		jbBeginningAccount = new JButton();//期初建账
		imageBeginningAccount = new ImageIcon("image/beginningaccount.jpg");
		jbBeginningAccount.setIcon(imageBeginningAccount);
		jbBeginningAccount.setPreferredSize(new Dimension(imageBeginningAccount.getIconWidth(),
				imageBeginningAccount.getIconHeight()));
		jbBeginningAccount.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbBeginningAccount){
					new MainFrame().setContentPane(new BeginningAccountNavigation());
				}
			}
			
		});
		
		jbAccountID = new JButton();//增删改查账户
		imageAccount = new ImageIcon("image/accountID.jpg");
		jbAccountID.setIcon(imageAccount);
		jbAccountID.setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		jbAccountID.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbAccountID){
					new MainFrame().setContentPane(new AccountsNavigation());
				}
			}
			
		});
		
		jbCheckCostPayChart = new JButton();//查看成本收益表
		imageCheckCostPayChart = new ImageIcon("image/checkcostpaychart.jpg");
		jbCheckCostPayChart.setIcon(imageCheckCostPayChart);
		jbCheckCostPayChart.setPreferredSize(new Dimension(imageCheckCostPayChart.getIconWidth(),
				imageCheckCostPayChart.getIconHeight()));
		jbCheckCostPayChart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCheckCostPayChart){
					new MainFrame().setContentPane(new CheckCostPayChartNavigation());
				}
			}
			
		});
		
		jbCheckProfitChart = new JButton();//查看经营情况表
		imageCheckProfitChart = new ImageIcon("image/checkprofitchart.jpg");
		jbCheckProfitChart.setIcon(imageCheckProfitChart);
		jbCheckProfitChart.setPreferredSize(new Dimension(imageCheckProfitChart.getIconWidth(),
				imageCheckProfitChart.getIconHeight()));
		jbCheckProfitChart.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCheckProfitChart){
					new MainFrame().setContentPane(new CheckProfitChartNavigation());
				}
			}
			
		});
		
		jbCheckDiary = new JButton();//查看日志
		imageCheckDiary = new ImageIcon("image/checkdiary.jpg");
		jbCheckDiary.setIcon(imageCheckDiary);
		jbCheckDiary.setPreferredSize(new Dimension(imageCheckDiary.getIconWidth(),
				imageCheckDiary.getIconHeight()));
		jbCheckDiary.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCheckDiary){
					new MainFrame().setContentPane(new CheckDiaryNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbReceiptGather);
		jpanel2.add(jbCreatePaymentForm);
		jpanel2.add(jbCreateProfitChart);
		jpanel2.add(jbCreateCostPayChart);
		jpanel2.add(jbBeginningAccount);
		jpanel2.add(jbAccountID);
		jpanel2.add(jbCheckCostPayChart);
		jpanel2.add(jbCheckProfitChart);
		jpanel2.add(jbCheckDiary);
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(7, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：高级财务人员      当前任务：期初建账");
		jlcurrentID.setFont(new Font("当前身份：高级财务人员       当前任务：期初建账",Font.PLAIN,15));

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
		
		jlaccountinfo = new JLabel("银行账户信息列表");
		jlaccountinfo.setFont(new Font("银行账户信息列表",Font.BOLD,15));
		
		String[] columnaccountNames = { "卡号", "余额" };  
        String[][] tableaccountValues = { { "A1", "B1" }, { "A2", "B2"},  
                { "A3", "B3"}, { "A4", "B4"}, { "A5", "B5" },{ "A6", "B6" }};  
        tableaccount = new JTable(tableaccountValues, columnaccountNames);  
        tableaccount.setEnabled(false);
        JScrollPane scrollPaneaccount = new JScrollPane(tableaccount); 
        
        jlcarinfo = new JLabel("车辆信息列表");
        jlcarinfo.setFont(new Font("车辆信息列表",Font.BOLD,15));
        
        String[] columncarNames = { "车辆代号", "车牌号","发动机号","底盘号","购买时间","服役时间" };  
        String[][] tablecarValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
                { "A6", "B6","C6","D6","E6","F6" }};  
        tablecar = new JTable(tablecarValues, columncarNames);  
        tablecar.setEnabled(false);
        JScrollPane scrollPanecar = new JScrollPane(tablecar);
        
        jldriverinfo = new JLabel("司机信息列表");
        jldriverinfo.setFont(new Font("司机信息列表",Font.BOLD,15));
        
        String[] columndriverNames = { "姓名", "司机编号","性别","身份证号","手机","行驶证期限" };  
        String[][] tabledriverValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
                { "A6", "B6","C6","D6","E6","F6" }};  
        tabledriver = new JTable(tabledriverValues, columndriverNames); 
        tabledriver.setEnabled(false);
        JScrollPane scrollPanedriver = new JScrollPane(tabledriver); 
        
        jluserinfo = new JLabel("用户信息列表");
        jluserinfo.setFont(new Font("用户信息列表",Font.BOLD,15));
        
        String[] columnuserNames = { "用户名","用户类型"};  
        String[][] tableuserValues = { { "A1", "B1"}, { "A2", "B2"},  
                { "A3", "B3" }, { "A4", "B4" },{ "A5", "B5" },{ "A6", "B6" }};  
        tableuser = new JTable(tableuserValues, columnuserNames);  
        tableuser.setEnabled(false);
        JScrollPane scrollPaneuser = new JScrollPane(tableuser); 
        
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
		
		jpanel4.add(Box.createHorizontalStrut(622));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(sp,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbexit){
			new MainFrame().remove(this);
		}
	}
	
}
