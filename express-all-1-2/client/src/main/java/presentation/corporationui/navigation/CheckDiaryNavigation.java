package presentation.corporationui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
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
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.corporationcontroller.LogController;
import presentation.corporationui.checkdiaryboard.CheckDiaryFrame;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import vo.LogVO;

public class CheckDiaryNavigation extends JPanel implements ActionListener{

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
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	
	public CheckDiaryNavigation(){
		
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
		getJbReceiptGather().addActionListener(this);
//		getJbReceiptGather().addActionListener(new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbReceiptGather()){
//					new MainFrame().setContentPane(new ReceiptGatherNavigation());
//				}
//			}
//			
//		});
		
		
		setJbCreatePaymentForm(new JButton());//生成付款单
		imageCreatePaymentForm = new ImageIcon("image/createpaymentform.jpg");
		getJbCreatePaymentForm().setIcon(imageCreatePaymentForm);
		getJbCreatePaymentForm().setPreferredSize(new Dimension(imageCreatePaymentForm.getIconWidth(),
				imageCreatePaymentForm.getIconHeight()));
		getJbCreatePaymentForm().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCreatePaymentForm()){
//					new MainFrame().setContentPane(new PaymentFormNavigation());
//				}
//			}
//			
//		});
		
		setJbCreateCostPayChart(new JButton());//创建成本收益表
		imageCreateCostPayChart = new ImageIcon("image/createcostpaychart.jpg");
		getJbCreateCostPayChart().setIcon(imageCreateCostPayChart);
		getJbCreateCostPayChart().setPreferredSize(new Dimension(imageCreateCostPayChart.getIconWidth(),
				imageCreateCostPayChart.getIconHeight()));
		getJbCreateCostPayChart().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCreateCostPayChart()){
//					new MainFrame().setContentPane(new CreateCostPayChartNavigation());
//				}
//			}
//			
//		});
		
		setJbCreateProfitChart(new JButton());//创建经营情况表
		imageCreateProfitChart = new ImageIcon("image/createprofitchart.jpg");
		getJbCreateProfitChart().setIcon(imageCreateProfitChart);
		getJbCreateProfitChart().setPreferredSize(new Dimension(imageCreateProfitChart.getIconWidth(),
				imageCreateProfitChart.getIconHeight()));
		getJbCreateProfitChart().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCreateProfitChart()){
//					new MainFrame().setContentPane(new CreateProfitChartNavigation());
//				}
//			}
//			
//		});
		
		setJbBeginningAccount(new JButton());//期初建账
		imageBeginningAccount = new ImageIcon("image/beginningaccount.jpg");
		getJbBeginningAccount().setIcon(imageBeginningAccount);
		getJbBeginningAccount().setPreferredSize(new Dimension(imageBeginningAccount.getIconWidth(),
				imageBeginningAccount.getIconHeight()));
		getJbBeginningAccount().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbBeginningAccount()){
//					new MainFrame().setContentPane(new BeginningAccountNavigation());
//				}
//			}
//			
//		});
		
		setJbAccountID(new JButton());//增删改查账户
		imageAccount = new ImageIcon("image/accountID.jpg");
		getJbAccountID().setIcon(imageAccount);
		getJbAccountID().setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		getJbAccountID().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbAccountID()){
//					new MainFrame().setContentPane(new AccountsNavigation());
//				}
//			}
//			
//		});
		
		setJbCheckCostPayChart(new JButton());//查看成本收益表
		imageCheckCostPayChart = new ImageIcon("image/checkcostpaychart.jpg");
		getJbCheckCostPayChart().setIcon(imageCheckCostPayChart);
		getJbCheckCostPayChart().setPreferredSize(new Dimension(imageCheckCostPayChart.getIconWidth(),
				imageCheckCostPayChart.getIconHeight()));
		getJbCheckCostPayChart().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckCostPayChart()){
//					new MainFrame().setContentPane(new CheckCostPayChartNavigation());
//				}
//			}
//			
//		});
		
		setJbCheckProfitChart(new JButton());//查看经营情况表
		imageCheckProfitChart = new ImageIcon("image/checkprofitchart.jpg");
		getJbCheckProfitChart().setIcon(imageCheckProfitChart);
		getJbCheckProfitChart().setPreferredSize(new Dimension(imageCheckProfitChart.getIconWidth(),
				imageCheckProfitChart.getIconHeight()));
		getJbCheckProfitChart().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckProfitChart()){
//					new MainFrame().setContentPane(new CheckProfitChartNavigation());
//				}
//			}
//			
//		});
		
		setJbCheckDiary(new JButton());//查看日志
		imageCheckDiary = new ImageIcon("image/checkdiary.jpg");
		getJbCheckDiary().setIcon(imageCheckDiary);
		getJbCheckDiary().setPreferredSize(new Dimension(imageCheckDiary.getIconWidth(),
				imageCheckDiary.getIconHeight()));
		getJbCheckDiary().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheckDiary()){
//					new MainFrame().setContentPane(new CheckDiaryNavigation());
//				}
//			}
//			
//		});
		
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
		
		jlcurrentID = new JLabel("当前身份：高级财务人员 "+UserID.userid+" 当前任务：查看日志");
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
		columnNames.add("日期");
		columnNames.add("人员");
		columnNames.add("操作");
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
        table = new JTable();
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        
        Calendar cal = Calendar.getInstance();
        
		int syear = cal.get(Calendar.YEAR);
		int smonth = cal.get(Calendar.MONTH);
		int sday = cal.get(Calendar.DATE);
		
		int eyear = cal.get(Calendar.YEAR);
		int emonth = cal.get(Calendar.MONTH);
		int eday = cal.get(Calendar.DATE);
		
		Calendar startDate = new GregorianCalendar(syear, smonth, sday);
		Calendar endDate = new GregorianCalendar(eyear, emonth, eday);
		System.out.println(startDate.toString() + " "+endDate.toString());
		LogController logController = new LogController();
		ArrayList<LogVO> findLogs = logController.findLog(startDate, endDate);
		if(findLogs == null) {
			System.out.println("日志记录为空");
		} else {
			System.out.println();
			for(int i = 0; i < findLogs.size(); i++) {
				row = new Vector<String>();
				String logtimestr = findLogs.get(i).timeToString();
				String logIDstr = findLogs.get(i).getOperatorRole().toString()+" "+findLogs.get(i).getOperatorID();
				String logOpstr = findLogs.get(i).getOperation()+" "+findLogs.get(i).getOperationObject();
				
				row.add(0, logtimestr);
				row.add(1, logIDstr);
				row.add(2, logOpstr);
				model.addRow(row);
				System.out.println(findLogs.get(i).toString());
			}
		}
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startcheck.jpg");
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
			new CheckDiaryFrame().setVisible(true);;
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this,UserID.userid).setVisible(true);
		}
		MainFrame.jumping(e);
	}

	public static JButton getJbReceiptGather() {
		return jbReceiptGather;
	}

	public static void setJbReceiptGather(JButton jbReceiptGather) {
		CheckDiaryNavigation.jbReceiptGather = jbReceiptGather;
	}

	public static JButton getJbCreatePaymentForm() {
		return jbCreatePaymentForm;
	}

	public static void setJbCreatePaymentForm(JButton jbCreatePaymentForm) {
		CheckDiaryNavigation.jbCreatePaymentForm = jbCreatePaymentForm;
	}

	public static JButton getJbCreateCostPayChart() {
		return jbCreateCostPayChart;
	}

	public static void setJbCreateCostPayChart(JButton jbCreateCostPayChart) {
		CheckDiaryNavigation.jbCreateCostPayChart = jbCreateCostPayChart;
	}

	public static JButton getJbCreateProfitChart() {
		return jbCreateProfitChart;
	}

	public static void setJbCreateProfitChart(JButton jbCreateProfitChart) {
		CheckDiaryNavigation.jbCreateProfitChart = jbCreateProfitChart;
	}

	public static JButton getJbBeginningAccount() {
		return jbBeginningAccount;
	}

	public static void setJbBeginningAccount(JButton jbBeginningAccount) {
		CheckDiaryNavigation.jbBeginningAccount = jbBeginningAccount;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		CheckDiaryNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		CheckDiaryNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		CheckDiaryNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		CheckDiaryNavigation.jbCheckDiary = jbCheckDiary;
	}
	
}
