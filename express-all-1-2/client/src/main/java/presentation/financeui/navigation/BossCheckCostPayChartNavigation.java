package presentation.financeui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import controller.UserID;
import presentation.financeui.CheckCostPayChartBoard.CheckCostPayChartFrame;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class BossCheckCostPayChartNavigation extends JPanel implements ActionListener{

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
	
	public BossCheckCostPayChartNavigation(){
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
		getJbSalary().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbSalary()){
//					new MainFrame().setContentPane(new SalaryNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
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
		
		jlcurrentID = new JLabel("当前身份：总经理    "+UserID.userid+" 当前任务：查看成本收益表");
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
		
		String[] columnNames = { "成本收益表编号", "开始日期", "截止日期"};  
        String[][] tableValues = { { "A1", "B1","C1" }, { "A2", "B2", "C2"},  
                { "A3", "B3", "C3"}, { "A4", "B4", "C4"}, { "A5", "B5","C5" },
                { "A6", "B6", "C6" }};  
        table = new JTable(tableValues, columnNames); 
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
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
			new MainFrame().remove(this);
		}
		if(e.getSource() == jbstart){
			
			try {
				CheckCostPayChartFrame window = new CheckCostPayChartFrame();
				window.frame.setVisible(true);
			} catch (RemoteException | IllegalArgumentException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
	}

	public static JButton getJbPrice() {
		return jbPrice;
	}

	public static void setJbPrice(JButton jbPrice) {
		BossCheckCostPayChartNavigation.jbPrice = jbPrice;
	}

	public static JButton getJbSalary() {
		return jbSalary;
	}

	public static void setJbSalary(JButton jbSalary) {
		BossCheckCostPayChartNavigation.jbSalary = jbSalary;
	}

	public static JButton getJbJudge() {
		return jbJudge;
	}

	public static void setJbJudge(JButton jbJudge) {
		BossCheckCostPayChartNavigation.jbJudge = jbJudge;
	}

	public static JButton getJbAccountID() {
		return jbAccountID;
	}

	public static void setJbAccountID(JButton jbAccountID) {
		BossCheckCostPayChartNavigation.jbAccountID = jbAccountID;
	}

	public static JButton getJbCheckCostPayChart() {
		return jbCheckCostPayChart;
	}

	public static void setJbCheckCostPayChart(JButton jbCheckCostPayChart) {
		BossCheckCostPayChartNavigation.jbCheckCostPayChart = jbCheckCostPayChart;
	}

	public static JButton getJbCheckProfitChart() {
		return jbCheckProfitChart;
	}

	public static void setJbCheckProfitChart(JButton jbCheckProfitChart) {
		BossCheckCostPayChartNavigation.jbCheckProfitChart = jbCheckProfitChart;
	}

	public static JButton getJbCheckDiary() {
		return jbCheckDiary;
	}

	public static void setJbCheckDiary(JButton jbCheckDiary) {
		BossCheckCostPayChartNavigation.jbCheckDiary = jbCheckDiary;
	}

	public static JButton getJbInstitutionsManage() {
		return jbInstitutionsManage;
	}

	public static void setJbInstitutionsManage(JButton jbInstitutionsManage) {
		BossCheckCostPayChartNavigation.jbInstitutionsManage = jbInstitutionsManage;
	}
	
}
