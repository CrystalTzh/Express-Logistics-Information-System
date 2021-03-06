package presentation.transitui.navigation;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.transitController.DeliveryFormController;
import po.DeliveryFormPO;
import presentation.mainui.MainFrame;
import presentation.transitui.DeliveryBoard.DeliveryFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class DeliveryFormNavigation extends JPanel implements ActionListener{

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
	private ImageIcon imageStart,imageRecall,imageModifyForm;
	private JTable table;
	private JButton jbstart,jbrecall,jbexit,jbmodify,jbmodifyform;
	private Box b;
	private Vector<String> columnNames;
	private ArrayList<DeliveryFormPO> alldeliveryforms;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	public DeliveryFormNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(7, 1,5,8));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));

		setJbReceipt(new JButton());//收款单
		imageReceipt = new ImageIcon("image/receipt.jpg");
		getJbReceipt().setIcon(imageReceipt);
		getJbReceipt().setPreferredSize(new Dimension(imageReceipt.getIconWidth(),
				imageReceipt.getIconHeight()));
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
		
		jlcurrentID = new JLabel("当前身份：营业厅业务员 "+UserID.userid+" 当前任务： 派件单");
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
		columnNames.add("到达日期");
		columnNames.add("订单号");
		columnNames.add("派件员编号");
		tableValues = new Vector<String>();
		
        model = new DefaultTableModel(tableValues,columnNames){

			/**
			 * 
			 */
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
        
//        table = new JTable(tableValues, columnNames);  
//        table.setEnabled(false);
        
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				jbstart.setEnabled(false);
				jbrecall.setEnabled(true);
			}
        	
        });
        
        DeliveryFormController deliveryFormController = new DeliveryFormController();
        alldeliveryforms = deliveryFormController.findAll();
        if(alldeliveryforms == null){
        	System.out.println("派件单信息为空！");
        }else {
        	for(int i = 0;i<alldeliveryforms.size();i++){
            	row = new Vector<String>();
            	
            	String date = alldeliveryforms.get(i).getArrivaeDate();
            	String NO = alldeliveryforms.get(i).getID();
            	String name = alldeliveryforms.get(i).getDeliveryMan();
            	
            	row.add(0, date);
            	row.add(1, NO);
            	row.add(2, name);
            	model.addRow(row);
            	
            }
        }
        
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		
		jbstart = new JButton();
		jbstart.setContentAreaFilled(false);
		imageStart = new ImageIcon("image/startform.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		jbstart.addActionListener(this);
		
		jbrecall = new JButton();
		jbrecall.setContentAreaFilled(false);
		imageRecall = new ImageIcon("image/startrecall.jpg");
		jbrecall.setIcon(imageRecall);
		jbrecall.setPreferredSize(new Dimension(imageRecall.getIconWidth(),
				imageRecall.getIconHeight()));
		jbrecall.addActionListener(this);
//		jbrecall.setEnabled(false);
		
		jbmodifyform = new JButton();
		jbmodifyform.setContentAreaFilled(false);
		imageModifyForm = new ImageIcon("image/modifyform.jpg");
		jbmodifyform.setIcon(imageModifyForm);
		jbmodifyform.setPreferredSize(new Dimension(imageModifyForm.getIconWidth(),
				imageModifyForm.getIconWidth()));
		jbmodifyform.addActionListener(this);
		
		jpanel4.add(Box.createHorizontalStrut(420));
		jpanel4.add(jbstart);
		jpanel4.add(Box.createHorizontalStrut(10));
		jpanel4.add(jbmodifyform);
		jpanel4.add(Box.createHorizontalStrut(10));
		jpanel4.add(jbrecall);
		jpanel4.add(Box.createHorizontalGlue());
		
		this.add(jpanel4,BorderLayout.SOUTH);
		this.add(jpanel3,BorderLayout.CENTER);
		this.add(jpanel2,BorderLayout.WEST);

		
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == jbexit){
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbstart){
			new DeliveryFrame();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid);
		}
		if(e.getSource() == jbmodifyform){
			
		}
		MainFrame.jumping(e);
	}

	public static JButton getJbReceipt() {
		return jbReceipt;
	}

	public static void setJbReceipt(JButton jbReceipt) {
		DeliveryFormNavigation.jbReceipt = jbReceipt;
	}

	public static JButton getJbDelivery() {
		return jbDelivery;
	}

	public static void setJbDelivery(JButton jbDelivery) {
		DeliveryFormNavigation.jbDelivery = jbDelivery;
	}

	public static JButton getJbArrival() {
		return jbArrival;
	}

	public static void setJbArrival(JButton jbArrival) {
		DeliveryFormNavigation.jbArrival = jbArrival;
	}

	public static JButton getJbCarInput() {
		return jbCarInput;
	}

	public static void setJbCarInput(JButton jbCarInput) {
		DeliveryFormNavigation.jbCarInput = jbCarInput;
	}

	public static JButton getJbDriverInfo() {
		return jbDriverInfo;
	}

	public static void setJbDriverInfo(JButton jbDriverInfo) {
		DeliveryFormNavigation.jbDriverInfo = jbDriverInfo;
	}

	public static JButton getJbCarInfo() {
		return jbCarInfo;
	}

	public static void setJbCarInfo(JButton jbCarInfo) {
		DeliveryFormNavigation.jbCarInfo = jbCarInfo;
	}
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setContentPane(new DeliveryFormNavigation());
		main.setVisible(true);
	}
}
