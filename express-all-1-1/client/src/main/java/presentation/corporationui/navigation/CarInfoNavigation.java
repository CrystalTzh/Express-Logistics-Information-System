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

import presentation.mainui.MainFrame;
import presentation.transitui.navigation.DeliveryFormNavigation;
import presentation.transitui.navigation.OfficeArrivalFormNavigation;
import presentation.transitui.navigation.OfficeCarInputFormNavigation;
import presentation.transitui.navigation.ReceiptFormNavigation;
import vo.CarInfoVO;

public class CarInfoNavigation extends JPanel{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbReceipt,jbDelivery,jbCarInput,
					jbArrival,jbCarInfo,jbDriverInfo;
	private ImageIcon imagelogo,imageReceipt,imageDelivery,imageArrival,
					  imageCarInput,imageDriverInfo,imageCarInfo;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	CarInfoVO vo;
	
	public CarInfoNavigation(){
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(6, 1,5,25));
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
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：营业厅业务员      当前任务： 维护车辆信息");
		jlcurrentID.setFont(new Font("当前身份：营业厅业务员       当前任务：维护车辆信息",Font.PLAIN,15));

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
		
		String[] columnNames = { "车辆代号", "车牌号","发动机号","底盘号","购买时间","服役时间" };  
        String[][] tableValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
                { "A6", "B6","C6","D6","E6","F6" }};  
        table = new JTable(tableValues, columnNames);  
        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/start.jpg");
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
