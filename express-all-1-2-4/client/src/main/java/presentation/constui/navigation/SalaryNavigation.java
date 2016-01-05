package presentation.constui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.constcontroller.SalaryInfoController;
import presentation.constui.salaryboard.SalaryModifyBoard;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import vo.SalaryVO;

public class SalaryNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏8个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbPrice,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,
					jbCheckDiary,jbInstitutionsManage;
	
	private ImageIcon imagelogo,imagePrice,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,
					  imageCheckDiary,imageInstitutionsManage;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	private Vector<String> columnNames;
	private SalaryVO allsalary;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	public SalaryNavigation(){
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		setJbPrice(new JButton());//制定价格常量
		imagePrice = new ImageIcon("image/price.jpg");
		getJbPrice().setIcon(imagePrice);
		getJbPrice().setPreferredSize(new Dimension(imagePrice.getIconWidth(),
				imagePrice.getIconHeight()));
		getJbPrice().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbPrice()){
//					new MainFrame().setContentPane(new PriceNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbSalary(new JButton());//制定薪资标准
		imageSalary = new ImageIcon("image/salary.jpg");
		getJbSalary().setIcon(imageSalary);
		getJbSalary().setPreferredSize(new Dimension(imageSalary.getIconWidth(),
				imageSalary.getIconHeight()));
		
		
		setJbJudge(new JButton());//审批单据
		imageJudge = new ImageIcon("image/judge.jpg");
		getJbJudge().setIcon(imageJudge);
		getJbJudge().setPreferredSize(new Dimension(imageJudge.getIconWidth(),
				imageJudge.getIconHeight()));
		getJbJudge().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbJudge()){
//					new MainFrame().setContentPane(new JudgeNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbAccountID(new JButton());//查看账户
		imageAccount = new ImageIcon("image/checkaccount.jpg");
		getJbAccountID().setIcon(imageAccount);
		getJbAccountID().setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		getJbAccountID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbAccountID()){
//					new MainFrame().setContentPane(new BossCheckAccountsNavigation());
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
//					new MainFrame().setContentPane(new BossCheckCostPayChartNavigation());
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
//					new MainFrame().setContentPane(new BossCheckProfitChartNavigation());
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
//					new MainFrame().setContentPane(new BossCheckDiaryNavigation());
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
//					new MainFrame().setContentPane(new InstitutionsManageNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbPrice());
		jpanel2.add(getJbSalary());
		jpanel2.add(getJbJudge());
		jpanel2.add(getJbAccountID());
		jpanel2.add(getJbCheckCostPayChart());
		jpanel2.add(getJbCheckProfitChart());
		jpanel2.add(getJbCheckDiary());
		jpanel2.add(getJbInstitutionsManage());
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：总经理    "+UserID.userid+" 当前任务：制定薪资标准");
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
		columnNames.add("业务员基本工资");
		columnNames.add("快递员基本工资");
		columnNames.add("快递员揽件提成");
		columnNames.add("快递员派件提成");
		columnNames.add("司机市内计次");
		columnNames.add("司机跨市计次");
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
        
        JScrollPane scrollPane = new JScrollPane(table); 
        
        SalaryInfoController salaryInfoController =new SalaryInfoController();
        allsalary = salaryInfoController.findSalayInfo();
        if(allsalary == null){
        	System.out.println("工资信息为空！");
        }else {
        	row = new Vector<String>();
        	
        	String officeManSalary = allsalary.getOfficeManSalary();
        	String receiveOrderBonus = allsalary.getReceiveOrderBonus();
        	String sendOrderBonus = allsalary.getSendOrderBonus();
        	String driverInCityPay = allsalary.getDriverInCityPay();
        	String driverOutCityPay = allsalary.getDriverOutCityPay();
        	
        	row.add(0,officeManSalary);
        	row.add(1,officeManSalary);
        	row.add(2,receiveOrderBonus);
        	row.add(3,sendOrderBonus);
        	row.add(4,driverInCityPay);
        	row.add(5,driverOutCityPay);
        	
        	model.addRow(row);
        	
        }
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startdefine.jpg");
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
		if(e.getSource() ==jbstart){
			new SalaryModifyBoard();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this,UserID.userid).setVisible(true);
		}
	}

	public static JButton getJbPrice() {
		return jbPrice;
	}

	public static void setJbPrice(JButton jbPrice) {
		SalaryNavigation.jbPrice = jbPrice;
	}

	public static JButton getJbSalary() {
		return jbSalary;
	}

	public static void setJbSalary(JButton jbSalary) {
		SalaryNavigation.jbSalary = jbSalary;
	}

	public static JButton getJbJudge() {
		return jbJudge;
	}

	public static void setJbJudge(JButton jbJudge) {
		SalaryNavigation.jbJudge = jbJudge;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		SalaryNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		SalaryNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		SalaryNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		SalaryNavigation.jbCheckDiary = jbCheckDiary;
	}

	public static JButton getJbInstitutionsManage() {
		return jbInstitutionsManage;
	}

	public static void setJbInstitutionsManage(JButton jbInstitutionsManage) {
		SalaryNavigation.jbInstitutionsManage = jbInstitutionsManage;
	}
	
}
