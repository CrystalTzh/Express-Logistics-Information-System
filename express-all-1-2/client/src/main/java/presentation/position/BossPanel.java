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

import presentation.constui.navigation.PriceNavigation;
import presentation.constui.navigation.SalaryNavigation;
import presentation.financeui.navigation.BossCheckAccountsNavigation;
import presentation.financeui.navigation.BossCheckCostPayChartNavigation;
import presentation.financeui.navigation.BossCheckDiaryNavigation;
import presentation.financeui.navigation.BossCheckProfitChartNavigation;
import presentation.formapprovalui.navigation.JudgeNavigation;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class BossPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome,jlHello;
	private JButton jbPrice,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imagePrice,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,b1;
	
	public BossPanel(){
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
					new MainFrame().setContentPane(new BossCheckAccountsNavigation(null));
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
		
		jlcurrentID = new JLabel("当前身份：总经理      ");
		jlcurrentID.setFont(new Font("当前身份：总经理       ",Font.PLAIN,15));

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
//			new ModifyPasswordBoard(new MainFrame(), ).setVisible(true);
		}
		
		if(e.getSource() == jbexit){
//			new MainFrame().setVisible(true);
			new MainFrame().remove(this);
		}
	}
	
}
