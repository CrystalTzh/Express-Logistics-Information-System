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
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.corporationcontroller.DriverInfoController;
import presentation.corporationui.chauffeurboard.DriverInfoManageDriver;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import vo.DriverInfoVO;

public class DriverInfoNavigation extends JPanel implements ActionListener{

	/**
	 * 
	 */
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
//	private JButton jbadd,jbdelete,jbupdate,jbfind;
//	private ImageIcon imageAdd,imageDelete,imageUpdate,imageFind;
//	private CardLayout card;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	DriverInfoVO driverInfovo = null;
	private Vector<String> columnNames;
	private ArrayList<DriverInfoVO> alldriver;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	
	public DriverInfoNavigation(){
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
//		getJbReceipt().setEnabled(false);
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
//		getJbDelivery().setEnabled(false);
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
//		getJbArrival().setEnabled(false);
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
//		getJbCarInput().setEnabled(false);
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
//		getJbCarInfo().setEnabled(false);
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
		
		jlcurrentID = new JLabel("当前身份：营业厅业务员   "+UserID.userid+" 当前任务： 维护司机信息");
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
		
		columnNames = new Vector<String>();
		columnNames.add("姓名");
		columnNames.add("司机编号");
		columnNames.add("性别");
		columnNames.add("身份证号");
		columnNames.add("手机");
		columnNames.add("行驶证期限");
		tableValues = new Vector<String>();
		
		model = new DefaultTableModel(tableValues, columnNames){
			private static final long serialVersionUID = 1L;

			
			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
		};
		
        table = new JTable();
        table.getTableHeader().setReorderingAllowed(false);
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        
        JScrollPane scrollPane = new JScrollPane(table); 
        
        DriverInfoController driverInfoController = new DriverInfoController();
        alldriver = driverInfoController.findAll();
        if(alldriver == null){
        	System.out.println("司机信息为空！");
        }else {
        	for(int i = 0;i<alldriver.size();i++){
            	row = new Vector<String>();
            	
            	String driverNumber = alldriver.get(i).getDriverNumber();
            	String name = alldriver.get(i).getName();
            	String sex = alldriver.get(i).getSex().toString();
            	String idcard = alldriver.get(i).getIdcard();
            	String cellphone = alldriver.get(i).getCellphone();
            	String licensedate = alldriver.get(i).getLicensedate();
            	
            	row.add(0, name);
            	row.add(1, driverNumber);
            	row.add(2, sex);
            	row.add(3,idcard);
            	row.add(4,cellphone);
            	row.add(5,licensedate);
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
			new DriverInfoManageDriver().setVisible(true);
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
		DriverInfoNavigation.jbReceipt = jbReceipt;
	}

	public static JButton getJbDelivery() {
		return jbDelivery;
	}

	public static void setJbDelivery(JButton jbDelivery) {
		DriverInfoNavigation.jbDelivery = jbDelivery;
	}

	public static JButton getJbArrival() {
		return jbArrival;
	}

	public static void setJbArrival(JButton jbArrival) {
		DriverInfoNavigation.jbArrival = jbArrival;
	}

	public static JButton getJbCarInput() {
		return jbCarInput;
	}

	public static void setJbCarInput(JButton jbCarInput) {
		DriverInfoNavigation.jbCarInput = jbCarInput;
	}

	public static JButton getJbDriverInfo() {
		return jbDriverInfo;
	}

	public static void setJbDriverInfo(JButton jbDriverInfo) {
		DriverInfoNavigation.jbDriverInfo = jbDriverInfo;
	}

	public static JButton getJbCarInfo() {
		return jbCarInfo;
	}

	public static void setJbCarInfo(JButton jbCarInfo) {
		DriverInfoNavigation.jbCarInfo = jbCarInfo;
	}
	

}
