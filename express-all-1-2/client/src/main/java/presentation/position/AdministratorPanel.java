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

import presentation.mainui.MainFrame;
import presentation.userui.navigation.UserInfoNavigation;

public class AdministratorPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome;
	private JButton jbID,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	private ImageIcon imagelogo,imageID,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,b1;
//	private ScrollPane sp;
	MainFrame mainframe;
	
	public AdministratorPanel(){
		
//		mainframe = new MainFrame();
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(15, 5, 10, 5));

		jbID = new JButton();//管理账号密码
		imageID = new ImageIcon("image/IDandPassword.jpg");
		jbID.setIcon(imageID);
		jbID.setPreferredSize(new Dimension(imageID.getIconWidth(),
				imageID.getIconHeight()));
		jbID.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbID){
					new MainFrame().setContentPane(new UserInfoNavigation());
				}
			}
			
		});
		
		
		
		jpanel2.add(jbID);
		
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：管理员     ");
		jlcurrentID.setFont(new Font("当前身份：管理员       ",Font.PLAIN,15));

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
