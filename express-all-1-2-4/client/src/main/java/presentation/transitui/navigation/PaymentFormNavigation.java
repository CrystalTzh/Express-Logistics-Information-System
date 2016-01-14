package presentation.transitui.navigation;

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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.financeController.PaymentFormController;
import po.PaymentFormPO;
import presentation.financeui.PaymentBoard.PaymentFrame;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class PaymentFormNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbReceiptGather,jbCreatePaymentForm,jbCreateCostPayChart,
					jbCreateProfitChart,jbAccountID,jbBeginningAccount,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageReceiptGather,imageCreatePaymentForm,imageCreateCostPayChart,
					  imageCreateProfitChart,imageAccount,imageBeginningAccount,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	private Vector<String> columnNames;
	private ArrayList<PaymentFormPO> allform;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	
	public PaymentFormNavigation(){
		
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

		setJbReceiptGather(new JButton());//收款单汇总
		imageReceiptGather = new ImageIcon("image/receiptgather.jpg");
		getJbReceiptGather().setIcon(imageReceiptGather);
		getJbReceiptGather().setPreferredSize(new Dimension(imageReceiptGather.getIconWidth(),
				imageReceiptGather.getIconHeight()));
		getJbReceiptGather().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbReceiptGather()){
//					new MainFrame().setContentPane(new ReceiptGatherNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCreatePaymentForm()){
//					new MainFrame().setContentPane(new PaymentFormNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCreateCostPayChart()){
//					new MainFrame().setContentPane(new CreateCostPayChartNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCreateProfitChart()){
//					new MainFrame().setContentPane(new CreateProfitChartNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbBeginningAccount()){
//					new MainFrame().setContentPane(new BeginningAccountNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbAccountID()){
//					new MainFrame().setContentPane(new AccountsNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCheckCostPayChart()){
//					new MainFrame().setContentPane(new CheckCostPayChartNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCheckProfitChart()){
//					new MainFrame().setContentPane(new CheckProfitChartNavigation());
//				}
				MainFrame.jumping(e);
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
//				if(e.getSource() == getJbCheckDiary()){
//					new MainFrame().setContentPane(new CheckDiaryNavigation());
//				}
				MainFrame.jumping(e);
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
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：高级财务人员  "+UserID.userid+" 当前任务：生成付款单");
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
		columnNames.add("付款单编号");
		columnNames.add("付款日期");
		columnNames.add("付款账号");
		columnNames.add("付款金额");
		tableValues = new Vector<String>();
		
        model = new DefaultTableModel(tableValues,columnNames){

			/**
			 * 重写isCellEditable方法使得列表每一行可以选中但是不能修改
			 */
			private static final long serialVersionUID = 1L;

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        table = new JTable();
        table.getTableHeader().setReorderingAllowed(false);
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				jbstart.setEnabled(true);
				
			}
        	
        });
        
        PaymentFormController paymentFormController = new PaymentFormController(); 
        allform = paymentFormController.findAll();
        if(allform == null){
        	System.out.println("付款单信息为空！");
        }else {
        	for(int i = 0;i<allform.size();i++){
            	row = new Vector<String>();
            	
            	String NO = allform.get(i).getNO();
            	String date = allform.get(i).getDate();
            	String account = allform.get(i).getAccount();
            	String money = Double.toString(allform.get(i).getMoney());
            	
            	row.add(0, NO);
            	row.add(1, date);
            	row.add(2, account);
            	row.add(3, money);
            	model.addRow(row);
            	
            }
        }
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startcreate.jpg");
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
		if(e.getSource() == jbexit){
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbstart){
			new PaymentFrame();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid);
		}
	}

	public static JButton getJbReceiptGather() {
		return jbReceiptGather;
	}

	public static void setJbReceiptGather(JButton jbReceiptGather) {
		PaymentFormNavigation.jbReceiptGather = jbReceiptGather;
	}

	public static JButton getJbCreatePaymentForm() {
		return jbCreatePaymentForm;
	}

	public static void setJbCreatePaymentForm(JButton jbCreatePaymentForm) {
		PaymentFormNavigation.jbCreatePaymentForm = jbCreatePaymentForm;
	}

	public static JButton getJbCreateCostPayChart() {
		return jbCreateCostPayChart;
	}

	public static void setJbCreateCostPayChart(JButton jbCreateCostPayChart) {
		PaymentFormNavigation.jbCreateCostPayChart = jbCreateCostPayChart;
	}

	public static JButton getJbCreateProfitChart() {
		return jbCreateProfitChart;
	}

	public static void setJbCreateProfitChart(JButton jbCreateProfitChart) {
		PaymentFormNavigation.jbCreateProfitChart = jbCreateProfitChart;
	}

	public static JButton getJbBeginningAccount() {
		return jbBeginningAccount;
	}

	public static void setJbBeginningAccount(JButton jbBeginningAccount) {
		PaymentFormNavigation.jbBeginningAccount = jbBeginningAccount;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		PaymentFormNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		PaymentFormNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		PaymentFormNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		PaymentFormNavigation.jbCheckDiary = jbCheckDiary;
	}
	
}