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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import controller.UserID;
import presentation.mainui.MainFrame;
import presentation.transitui.navigation.RelayArrivalFormNavigation;
import presentation.transitui.navigation.RelayCarInputFormNavigation;
import presentation.transitui.navigation.RelayFormNavigation;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class TransitCenterManPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome;
	private JButton jbTransfer,jbCarInput,
					jbArrival;
	private ImageIcon imagelogo,imageTransfer,imageArrival,
					  imageCarInput;
	@SuppressWarnings("unused")
	private ImageIcon imageStart,imageRecall;
	@SuppressWarnings("unused")
	private JTable table;
	@SuppressWarnings("unused")
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	private Box b,b1;
	
	public TransitCenterManPanel(){
		
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
		
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
		
		jbTransfer = new JButton();//中转单
		imageTransfer = new ImageIcon("image/transfer.jpg");
		jbTransfer.setIcon(imageTransfer);
		jbTransfer.setPreferredSize(new Dimension(imageTransfer.getIconWidth(),
				imageTransfer.getIconHeight()));
		jbTransfer.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbTransfer){
					new MainFrame().setContentPane(new RelayFormNavigation());
				}
			}
			
		});
		jbArrival = new JButton();//中转中心到达单
		imageArrival = new ImageIcon("image/arrival.jpg");
		jbArrival.setIcon(imageArrival);
		jbArrival.setPreferredSize(new Dimension(imageArrival.getIconWidth(),
				imageArrival.getIconHeight()));
		jbArrival.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbArrival){
					new MainFrame().setContentPane(new RelayArrivalFormNavigation());
				}
			}
			
		});
		jbCarInput = new JButton();//中转中心装车单
		imageCarInput = new ImageIcon("image/carInput.jpg");
		jbCarInput.setIcon(imageCarInput);
		jbCarInput.setPreferredSize(new Dimension(imageCarInput.getIconWidth(),
				imageCarInput.getIconHeight()));
		jbCarInput.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCarInput){
					new MainFrame().setContentPane(new RelayCarInputFormNavigation());
				}
			}
			
		});
		
		
		jpanel2.add(jbTransfer);
		jpanel2.add(jbArrival);
		jpanel2.add(jbCarInput);
	

		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：中转中心业务员      "+UserID.userid);
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
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
		if(e.getSource() == jbexit){
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
	}
	
}
