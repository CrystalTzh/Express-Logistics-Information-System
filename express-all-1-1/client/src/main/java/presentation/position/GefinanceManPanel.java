package presentation.position;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import presentation.financeui.navigation.AccountsNavigation;
import presentation.financeui.navigation.BeginningAccountNavigation;
import presentation.financeui.navigation.CheckCostPayChartNavigation;
import presentation.financeui.navigation.CheckDiaryNavigation;
import presentation.financeui.navigation.CheckProfitChartNavigation;
import presentation.financeui.navigation.CreateCostPayChartNavigation;
import presentation.financeui.navigation.CreateProfitChartNavigation;
import presentation.financeui.navigation.ReceiptGatherNavigation;
import presentation.mainui.MainFrame;
import presentation.transitui.navigation.PaymentFormNavigation;

public class GefinanceManPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome;
	private JButton jbReceiptGather,jbCreatePaymentForm,jbCreateCostPayChart,
					jbCreateProfitChart,jbAccountID,jbBeginningAccount,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageReceiptGather,imageCreatePaymentForm,imageCreateCostPayChart,
					  imageCreateProfitChart,imageAccount,imageBeginningAccount,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,b1;
	
	public GefinanceManPanel(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(9, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));

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
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：普通财务人员      ");
		jlcurrentID.setFont(new Font("当前身份：普通财务人员       ",Font.PLAIN,15));

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
		
		
		jlWelcome = new JLabel("欢迎使用本快递物流信息系统！");
		jlWelcome.setFont(new Font("欢迎使用本快递物流信息系统！", Font.BOLD, 30));
		jlWelcome.setForeground(Color.GRAY);
		
		b1 = Box.createHorizontalBox();
		b1.add(jlWelcome);
		b1.add(Box.createHorizontalStrut(50));
		
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(50));
        jpanel3.add(b1);
        jpanel3.add(Box.createVerticalStrut(200));

        
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbmodify){
			
		}
		if(e.getSource() == jbexit){
//			new MainFrame().setVisible(true);
			new MainFrame().remove(this);
		}
	}
	
}
