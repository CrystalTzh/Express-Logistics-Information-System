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

import presentation.constui.navigation.PriceNavigation;
import presentation.constui.navigation.SalaryNavigation;
import presentation.formapprovalui.navigation.JudgeNavigation;
import presentation.mainui.MainFrame;

public class BossCheckProfitChartNavigation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbPrice,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imagePrice,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;

	
	public BossCheckProfitChartNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(7, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		jbPrice = new JButton();//制定价格常量
		imagePrice = new ImageIcon("image/price.jpg");
		jbPrice.setIcon(imagePrice);
		jbPrice.setPreferredSize(new Dimension(imagePrice.getIconWidth(),
				imagePrice.getIconHeight()));
		jbPrice.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbPrice){
					new MainFrame().setContentPane(new PriceNavigation());
				}
			}
			
		});
		
		jbSalary = new JButton();//制定薪资标准
		imageSalary = new ImageIcon("image/salary.jpg");
		jbSalary.setIcon(imageSalary);
		jbSalary.setPreferredSize(new Dimension(imageSalary.getIconWidth(),
				imageSalary.getIconHeight()));
		jbSalary.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbSalary){
					new MainFrame().setContentPane(new SalaryNavigation());
				}
			}
			
		});
		
		jbJudge = new JButton();//审批单据
		imageJudge = new ImageIcon("image/judge.jpg");
		jbJudge.setIcon(imageJudge);
		jbJudge.setPreferredSize(new Dimension(imageJudge.getIconWidth(),
				imageJudge.getIconHeight()));
		jbJudge.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbJudge){
					new MainFrame().setContentPane(new JudgeNavigation());
				}
			}
			
		});
		
		jbAccountID = new JButton();//查看账户
		imageAccount = new ImageIcon("image/checkaccount.jpg");
		jbAccountID.setIcon(imageAccount);
		jbAccountID.setPreferredSize(new Dimension(imageAccount.getIconWidth(),
				imageAccount.getIconHeight()));
		jbAccountID.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbAccountID){
					new MainFrame().setContentPane(new BossCheckAccountsNavigation());
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
					new MainFrame().setContentPane(new BossCheckCostPayChartNavigation());
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
					new MainFrame().setContentPane(new BossCheckProfitChartNavigation());
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
					new MainFrame().setContentPane(new BossCheckDiaryNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbPrice);
		jpanel2.add(jbSalary);
		jpanel2.add(jbJudge);
		jpanel2.add(jbAccountID);
		jpanel2.add(jbCheckCostPayChart);
		jpanel2.add(jbCheckProfitChart);
		jpanel2.add(jbCheckDiary);
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：总经理      当前任务：查看经营情况表");
		jlcurrentID.setFont(new Font("当前身份：总经理       当前任务：查看经营情况表",Font.PLAIN,15));

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
		
		String[] columnNames = { "经营情况表编号", "开始日期", "截止日期"};  
        String[][] tableValues = { { "A1", "B1","C1" }, { "A2", "B2", "C2"},  
                { "A3", "B3", "C3"}, { "A4", "B4", "C4"}, { "A5", "B5","C5" },
                { "A6", "B6", "C6" }};  
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames){

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
		
		jpanel4.add(Box.createHorizontalStrut(622));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);
		
	}
	
}
