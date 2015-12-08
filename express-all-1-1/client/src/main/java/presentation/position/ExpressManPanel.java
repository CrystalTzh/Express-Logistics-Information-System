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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.MainFrame;
import presentation.transitui.navigation.OrderFormNavigation;
import presentation.transitui.navigation.OrderInfoCheckNavigation;
import presentation.transitui.navigation.ReceiveMessageInputNavigation;

public class ExpressManPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏3个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome;
	private JButton jbOrderForm,jbCheck,jbReceiveInfo;
	
	private ImageIcon imagelogo,imageOrderForm,imageCheck,
					  imageReceiveInfo;
	private ImageIcon imageStart,imageRecall;
	private JTable table;
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	private Box b,b1;
	
	public ExpressManPanel(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel();
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		
//		jpanel2.setLayout(new BoxLayout(jpanel2,BoxLayout.Y_AXIS));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		jbOrderForm = new JButton();//寄件单
		imageOrderForm = new ImageIcon("image/orderform.jpg");
		jbOrderForm.setIcon(imageOrderForm);
		jbOrderForm.setPreferredSize(new Dimension(imageOrderForm.getIconWidth(),
				imageOrderForm.getIconHeight()));
		jbOrderForm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbOrderForm){
					new MainFrame().setContentPane(new OrderFormNavigation());
//					MainFrame.mainframe.setContentPane(new OrderFormNavigation());
				}
			}
			
		});
		
		jbCheck = new JButton();//订单信息查询
		imageCheck = new ImageIcon("image/orderformcheck.jpg");
		jbCheck.setIcon(imageCheck);
		jbCheck.setPreferredSize(new Dimension(imageCheck.getIconWidth(),
				imageCheck.getIconHeight()));
		jbCheck.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCheck){
					new MainFrame().setContentPane(new OrderInfoCheckNavigation());
//					MainFrame.mainframe.setContentPane(new OrderInfoCheckNavigation());
				}
			}
			
		});
		
		jbReceiveInfo = new JButton();//收件信息输入
		imageReceiveInfo = new ImageIcon("image/receiveinfoinput.jpg");
		jbReceiveInfo.setIcon(imageReceiveInfo);
		jbReceiveInfo.setPreferredSize(new Dimension(imageReceiveInfo.getIconWidth(),
				imageReceiveInfo.getIconHeight()));
		jbReceiveInfo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbReceiveInfo){
					new MainFrame().setContentPane(new ReceiveMessageInputNavigation());
				}
			}
			
		});
		
//		b1 = Box.createVerticalBox();
//		b1.add(Box.createVerticalStrut(35));
//		b1.add(jbOrderForm);
//		b1.add(Box.createVerticalStrut(20));
//		b1.add(jbCheck);
//		b1.add(Box.createVerticalStrut(20));
//		b1.add(jbReceiveInfo);
//		
//		jpanel2.add(b1);
		
		jpanel2.add(jbOrderForm);
		jpanel2.add(jbCheck);
		jpanel2.add(jbReceiveInfo);
		
		

		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：快递员      ");
		jlcurrentID.setFont(new Font("当前身份：快递员       ",Font.PLAIN,15));

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
