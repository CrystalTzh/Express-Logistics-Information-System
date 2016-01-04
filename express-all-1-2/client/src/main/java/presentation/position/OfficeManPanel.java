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
import presentation.corporationui.navigation.CarInfoNavigation;
import presentation.corporationui.navigation.DriverInfoNavigation;
import presentation.mainui.MainFrame;
import presentation.transitui.navigation.DeliveryFormNavigation;
import presentation.transitui.navigation.OfficeArrivalFormNavigation;
import presentation.transitui.navigation.OfficeCarInputFormNavigation;
import presentation.transitui.navigation.ReceiptFormNavigation;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class OfficeManPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlWelcome;
	private JButton jbReceipt,jbDelivery,jbCarInput,
					jbArrival,jbCarInfo,jbDriverInfo;
	private ImageIcon imagelogo,imageReceipt,imageDelivery,imageArrival,
					  imageCarInput,imageDriverInfo,imageCarInfo;
	@SuppressWarnings("unused")
	private ImageIcon imageStart,imageRecall;
	@SuppressWarnings("unused")
	private JTable table;
	@SuppressWarnings("unused")
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	private Box b,b1;
	
	public OfficeManPanel(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,15));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));

		jbReceipt = new JButton();//收款单
		imageReceipt = new ImageIcon("image/receipt.jpg");
		jbReceipt.setIcon(imageReceipt);
		jbReceipt.setPreferredSize(new Dimension(imageReceipt.getIconWidth(),
				imageReceipt.getIconHeight()));
		jbReceipt.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbReceipt){
					new MainFrame().setContentPane(new ReceiptFormNavigation());
				}
			}
			
		});
		
		jbDelivery = new JButton();//派件单
		imageDelivery = new ImageIcon("image/Delivery.jpg");
		jbDelivery.setIcon(imageDelivery);
		jbDelivery.setPreferredSize(new Dimension(imageDelivery.getIconWidth(),
				imageDelivery.getIconHeight()));
		jbDelivery.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbDelivery){
					new MainFrame().setContentPane(new DeliveryFormNavigation());
				}
			}
			
		});
		
		jbArrival = new JButton();//到达单
		imageArrival = new ImageIcon("image/arrival.jpg");
		jbArrival.setIcon(imageArrival);
		jbArrival.setPreferredSize(new Dimension(imageArrival.getIconWidth(),
				imageArrival.getIconHeight()));
		jbArrival.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbArrival){
					new MainFrame().setContentPane(new OfficeArrivalFormNavigation());
				}
			}
			
		});
		
		jbCarInput = new JButton();//装车单
		imageCarInput = new ImageIcon("image/carInput.jpg");
		jbCarInput.setIcon(imageCarInput);
		jbCarInput.setPreferredSize(new Dimension(imageCarInput.getIconWidth(),
				imageCarInput.getIconHeight()));
		jbCarInput.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCarInput){
					new MainFrame().setContentPane(new OfficeCarInputFormNavigation());
				}
			}
			
		});
		
		jbDriverInfo = new JButton();//维护司机信息
		imageDriverInfo = new ImageIcon("image/driver.jpg");
		jbDriverInfo.setIcon(imageDriverInfo);
		jbDriverInfo.setPreferredSize(new Dimension(imageDriverInfo.getIconWidth(),
				imageDriverInfo.getIconHeight()));
		jbDriverInfo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbDriverInfo){
					new MainFrame().setContentPane(new DriverInfoNavigation());
				}
			}
			
		});
		
		jbCarInfo = new JButton();//维护车辆信息
		imageCarInfo = new ImageIcon("image/carInfo.jpg");
		jbCarInfo.setIcon(imageCarInfo);
		jbCarInfo.setPreferredSize(new Dimension(imageCarInfo.getIconWidth(),
				imageCarInfo.getIconHeight()));
		jbCarInfo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCarInfo){
					new MainFrame().setContentPane(new CarInfoNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbReceipt);
		jpanel2.add(jbDelivery);
		jpanel2.add(jbArrival);
		jpanel2.add(jbCarInput);
		jpanel2.add(jbDriverInfo);
		jpanel2.add(jbCarInfo);
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：营业厅业务员      "+UserID.userid);
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
