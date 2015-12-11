package presentation.corporationui.navigation;

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

import presentation.constui.navigation.PriceNavigation;
import presentation.constui.navigation.SalaryNavigation;
import presentation.financeui.navigation.BossCheckAccountsNavigation;
import presentation.financeui.navigation.BossCheckCostPayChartNavigation;
import presentation.financeui.navigation.BossCheckDiaryNavigation;
import presentation.financeui.navigation.BossCheckProfitChartNavigation;
import presentation.formapprovalui.institutionsmanageboard.InstitutionsManageDriver;
import presentation.mainui.MainFrame;

public class InstitutionsManageNavigation extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbPrice,jbSalary,jbAccountID,jbJudge,
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
	
	public InstitutionsManageNavigation(){
		
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
		
		jbInstitutionsManage = new JButton();//机构管理
		imageInstitutionsManage = new ImageIcon("image/institutionsmanage.jpg");
		jbInstitutionsManage.setIcon(imageInstitutionsManage);
		jbInstitutionsManage.setPreferredSize(new Dimension(imageInstitutionsManage.getIconWidth(),
				imageInstitutionsManage.getIconHeight()));
		jbInstitutionsManage.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbInstitutionsManage){
					new MainFrame().setContentPane(new InstitutionsManageNavigation());
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
		jpanel2.add(jbInstitutionsManage);
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：总经理      当前任务：审批单据");
		jlcurrentID.setFont(new Font("当前身份：总经理       当前任务：审批单据",Font.PLAIN,15));

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
		
		String[] columnNames = { "单据名称"};  
        String[][] tableValues = { { "A1"}, { "A2"},  
                { "A3"}, { "A4" }, 
                { "A5" },{ "A6"}}; 
        
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
		imageStart = new ImageIcon("image/startjudge.jpg");
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
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbstart){
			new InstitutionsManageDriver();
		}
		
	}

}
