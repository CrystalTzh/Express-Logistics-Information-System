package presentation.financeui.navigation;

import java.awt.BorderLayout;
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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.corporationui.bankaccountboard.BankAccountManageDriver;
import presentation.mainui.MainFrame;
import presentation.transitui.navigation.PaymentFormNavigation;

public class AccountsNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏9个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbReceiptGather,jbCreatePaymentForm,jbCreateCostPayChart,
					jbCreateProfitChart,jbAccountID,jbBeginningAccount,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageReceiptGather,imageCreatePaymentForm,imageCreateCostPayChart,
					  imageCreateProfitChart,imageAccount,imageBeginningAccount,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
//	AccountInfoVO vo;
	
	public AccountsNavigation(){
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
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：高级财务人员      当前任务： 增删改查账户");
		jlcurrentID.setFont(new Font("当前身份：高级财务人员       当前任务：增删改查账户",Font.PLAIN,15));

		jbmodify = new JButton("修改密码");
		jbmodify.setFont(new Font("修改密码",Font.PLAIN,12));
		jbmodify.setContentAreaFilled(false);
		
		jbexit = new JButton("退出登录");
		jbexit.setFont(new Font("退出登录",Font.PLAIN,12));
		jbexit.setContentAreaFilled(false);
		
		b = Box.createHorizontalBox();
		b.add(jlcurrentID);
		b.add(Box.createHorizontalGlue());
		b.add(jbmodify);
		b.add(Box.createHorizontalStrut(13));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
		String[] columnNames = { "卡号", "余额" };  
        String[][] tableValues = { { "A1", "B1" }, { "A2", "B2"},  
                { "A3", "B3"}, { "A4", "B4"}, { "A5", "B5" },{ "A6", "B6" }};  
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        table = new JTable();
        table.setModel(model);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/start.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		jbstart.addActionListener(this);
		
		jpanel4.add(Box.createHorizontalStrut(622));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbstart){
			new BankAccountManageDriver().setVisible(true);
		}
		

	}
}
