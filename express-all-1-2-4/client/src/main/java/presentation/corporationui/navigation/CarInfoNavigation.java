package presentation.corporationui.navigation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.corporationcontroller.CarInfoController;
import presentation.corporationui.carInfoboard.CarInfoManageDriver;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import vo.CarInfoVO;

public class CarInfoNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbReceipt,jbDelivery,jbCarInput,
					jbArrival,jbCarInfo,jbDriverInfo;
	private ImageIcon imagelogo,imageReceipt,imageDelivery,imageArrival,
					  imageCarInput,imageDriverInfo,imageCarInfo;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	
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

		setJbReceipt(new JButton());//收款单
		imageReceipt = new ImageIcon("image/receipt.jpg");
		getJbReceipt().setIcon(imageReceipt);
		getJbReceipt().setPreferredSize(new Dimension(imageReceipt.getIconWidth(),
				imageReceipt.getIconHeight()));
//		jbReceipt.setEnabled(false);
		getJbReceipt().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbReceipt()){
//					new MainFrame().setContentPane(new ReceiptFormNavigation());
//				}
//			}
//			
//		});
		
		setJbDelivery(new JButton());//派件单
		imageDelivery = new ImageIcon("image/Delivery.jpg");
		getJbDelivery().setIcon(imageDelivery);
		getJbDelivery().setPreferredSize(new Dimension(imageDelivery.getIconWidth(),
				imageDelivery.getIconHeight()));
//		jbDelivery.setEnabled(false);
		getJbDelivery().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbDelivery()){
//					new MainFrame().setContentPane(new DeliveryFormNavigation());
//				}
//			}
//			
//		});
		
		setJbArrival(new JButton());//到达单
		imageArrival = new ImageIcon("image/arrival.jpg");
		getJbArrival().setIcon(imageArrival);
		getJbArrival().setPreferredSize(new Dimension(imageArrival.getIconWidth(),
				imageArrival.getIconHeight()));
//		jbArrival.setEnabled(false);
		getJbArrival().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbArrival()){
//					new MainFrame().setContentPane(new OfficeArrivalFormNavigation());
//				}
//			}
//			
//		});
		
		setJbCarInput(new JButton());//装车单
		imageCarInput = new ImageIcon("image/carInput.jpg");
		getJbCarInput().setIcon(imageCarInput);
		getJbCarInput().setPreferredSize(new Dimension(imageCarInput.getIconWidth(),
				imageCarInput.getIconHeight()));
//		jbCarInput.setEnabled(false);
		getJbCarInput().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCarInput()){
//					new MainFrame().setContentPane(new OfficeCarInputFormNavigation());
//				}
//			}
//			
//		});
		
		setJbDriverInfo(new JButton());//维护司机信息
		imageDriverInfo = new ImageIcon("image/driver.jpg");
		getJbDriverInfo().setIcon(imageDriverInfo);
		getJbDriverInfo().setPreferredSize(new Dimension(imageDriverInfo.getIconWidth(),
				imageDriverInfo.getIconHeight()));
//		jbDriverInfo.setEnabled(false);
		getJbDriverInfo().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbDriverInfo()){
//					new MainFrame().setContentPane(new DriverInfoNavigation());
//				}
//			}
//			
//		});
		
		setJbCarInfo(new JButton());//维护车辆信息
		imageCarInfo = new ImageIcon("image/carInfo.jpg");
		getJbCarInfo().setIcon(imageCarInfo);
		getJbCarInfo().setPreferredSize(new Dimension(imageCarInfo.getIconWidth(),
				imageCarInfo.getIconHeight()));
//		jbCarInfo.setEnabled(false);
		getJbCarInfo().addActionListener(this);
//				new ActionListener(){
//
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCarInfo()){
//					new MainFrame().setContentPane(new CarInfoNavigation());
//				}
//			}
//			
//		});
		
		jpanel2.add(getJbReceipt());
		jpanel2.add(getJbDelivery());
		jpanel2.add(getJbArrival());
		jpanel2.add(getJbCarInput());
		jpanel2.add(getJbDriverInfo());
		jpanel2.add(getJbCarInfo());
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：营业厅业务员    "+UserID.userid+" 当前任务： 维护车辆信息");
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
		
//		String[] columnNames = { "车辆代号", "车牌号","发动机号","底盘号","购买时间","服役时间" };  
//        String[][] tableValues = { { "A1", "B1","C1","D1","E1","F1" }, { "A2", "B2","C2","D2","E2","F2" },  
//                { "A3", "B3" ,"C3","D3","E3","F3"}, { "A4", "B4" ,"C4","D4","E4","F4"}, { "A5", "B5","C5","D5","E5","F5" },
//                { "A6", "B6","C6","D6","E6","F6" }};  
		columnNames = new Vector<String>();
		columnNames.add("车辆代号");
		columnNames.add("车牌号");
		columnNames.add("服役时间");
		tableValues = new Vector<String>();
		
        model = new DefaultTableModel(tableValues,columnNames){
        	/**
			 * 重写isCellEditable方法使得表格行可选但不可编辑
			 */
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
			
			
        };
        table = new JTable();
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        JScrollPane scrollPane = new JScrollPane(table); 
        
        CarInfoController carinfocontroller = new CarInfoController();
        ArrayList<CarInfoVO> allCarInfo = carinfocontroller.findAll();
        if(allCarInfo == null){
        	System.out.println("车辆信息为空！");
        }else {
        	for(int i = 0;i<allCarInfo.size();i++){
            	row = new Vector<String>();
            	
            	String carnumber = allCarInfo.get(i).getCarNumber();
            	String platenumber = allCarInfo.get(i).getPlateNumber();
            	String activeyear = allCarInfo.get(i).getActiveTime();
            	
            	row.add(0, carnumber);
            	row.add(1, platenumber);
            	row.add(2, activeyear);
            	model.addRow(row);
            	
            }
        }
        
        
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
		if(e.getSource() == jbstart){
			new CarInfoManageDriver().setVisible(true);
		}
		if(e.getSource() == jbexit){
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this,UserID.userid).setVisible(true);
		}
		MainFrame.jumping(e);
	}

	public static JButton getJbReceipt() {
		return jbReceipt;
	}

	public static void setJbReceipt(JButton jbReceipt) {
		CarInfoNavigation.jbReceipt = jbReceipt;
	}

	public static JButton getJbDelivery() {
		return jbDelivery;
	}

	public static void setJbDelivery(JButton jbDelivery) {
		CarInfoNavigation.jbDelivery = jbDelivery;
	}

	public static JButton getJbArrival() {
		return jbArrival;
	}

	public static void setJbArrival(JButton jbArrival) {
		CarInfoNavigation.jbArrival = jbArrival;
	}

	public static JButton getJbCarInput() {
		return jbCarInput;
	}

	public static void setJbCarInput(JButton jbCarInput) {
		CarInfoNavigation.jbCarInput = jbCarInput;
	}

	public static JButton getJbDriverInfo() {
		return jbDriverInfo;
	}

	public static void setJbDriverInfo(JButton jbDriverInfo) {
		CarInfoNavigation.jbDriverInfo = jbDriverInfo;
	}

	public static JButton getJbCarInfo() {
		return jbCarInfo;
	}

	public static void setJbCarInfo(JButton jbCarInfo) {
		CarInfoNavigation.jbCarInfo = jbCarInfo;
	}

	
}
