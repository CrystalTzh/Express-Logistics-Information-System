package presentation.inventoryui.navigation;

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
import javax.swing.JTextField;

import controller.UserID;
import controller.inventorycontroller.InventoryController;
import presentation.inventoryui.boards.AdjustZoneBoard;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import state.Zone;
import vo.InventoryInfoVO;

public class AdjustZoneNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlCar,jlPlane,jlTrain,jlEmpty,jlLabel,jlcangku;
	static private JButton jbStorageInForm,jbStorageOutForm,jbZone,jbStorageCheck,jbStorageCounting,
					jbSetLimit;
	
	private ImageIcon imagelogo,imageStorageInForm,imageStorageOutForm,imageZone,
					  imageStorageCheck,imageStorageCounting,imageSetLimit;
	private ImageIcon imageStart;
	private JButton jbstart,jbexit,jbmodify, jbcangku;
	private Box b,b1,b2,b3, bb;
	private JTextField jtCar,jtPlane,jtTrain,jtEmpty,jtfcangku;
	private String id;
	
	public AdjustZoneNavigation(){
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel();
		jpanel2 = new JPanel(new GridLayout(7, 1,5,10));
		
//		jpanel2.setLayout(new BoxLayout(jpanel2,BoxLayout.Y_AXIS));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		setJbStorageInForm(new JButton());//入库单
		imageStorageInForm = new ImageIcon("image/storageinform.jpg");
		getJbStorageInForm().setIcon(imageStorageInForm);
		getJbStorageInForm().setPreferredSize(new Dimension(imageStorageInForm.getIconWidth(),
				imageStorageInForm.getIconHeight()));
		getJbStorageInForm().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbStorageInForm()){
//					new MainFrame().setContentPane(new StorageInFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbZone(new JButton());//调整库存分区
		imageZone = new ImageIcon("image/zone.jpg");
		getJbZone().setIcon(imageZone);
		getJbZone().setPreferredSize(new Dimension(imageZone.getIconWidth(),
				imageZone.getIconHeight()));
		getJbZone().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbZone()){
//					new MainFrame().setContentPane(new AdjustZoneNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbStorageCheck(new JButton());//库存查看
		imageStorageCheck = new ImageIcon("image/storagecheck.jpg");
		getJbStorageCheck().setIcon(imageStorageCheck);
		getJbStorageCheck().setPreferredSize(new Dimension(imageStorageCheck.getIconWidth(),
				imageStorageCheck.getIconHeight()));
		getJbStorageCheck().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbStorageCheck()){
//					new MainFrame().setContentPane(new StorageCheckNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbStorageCounting(new JButton());//库存盘点
		imageStorageCounting = new ImageIcon("image/storagecounting.jpg");
		getJbStorageCounting().setIcon(imageStorageCounting);
		getJbStorageCounting().setPreferredSize(new Dimension(imageStorageCounting.getIconWidth(),
				imageStorageCounting.getIconHeight()));
		getJbStorageCounting().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbStorageCounting()){
//					new MainFrame().setContentPane(new StorageCountingNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbSetLimit(new JButton());//设置库存警戒值
		imageSetLimit = new ImageIcon("image/setlimit.jpg");
		getJbSetLimit().setIcon(imageSetLimit);
		getJbSetLimit().setPreferredSize(new Dimension(imageSetLimit.getIconWidth(),
				imageSetLimit.getIconHeight()));
		getJbSetLimit().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbSetLimit()){
//					new MainFrame().setContentPane(new SetLimitNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbStorageOutForm(new JButton());//出库单
		imageStorageOutForm = new ImageIcon("image/storageoutform.jpg");
		getJbStorageOutForm().setIcon(imageStorageOutForm);
		getJbStorageOutForm().setPreferredSize(new Dimension(imageStorageOutForm.getIconWidth(),
				imageStorageOutForm.getIconHeight()));
		getJbStorageOutForm().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbStorageOutForm()){
//					new MainFrame().setContentPane(new StorageOutFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbStorageInForm());
		jpanel2.add(getJbStorageOutForm());
		jpanel2.add(getJbZone());
		jpanel2.add(getJbStorageCheck());
		jpanel2.add(getJbStorageCounting());
		jpanel2.add(getJbSetLimit());
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：仓库管理员   "+UserID.userid+" 当前任务：调整库存分区");
		jlcurrentID.setFont(new Font("微软雅黑",Font.PLAIN,14));

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
		b.add(Box.createHorizontalStrut(10));
		b.add(jbmodify);
		b.add(Box.createHorizontalStrut(10));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
		jlcangku = new JLabel("请输入仓库编号：");
		jlcangku.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jtfcangku = new JTextField(13);
		jbcangku = new JButton("确认");
		jbcangku.addActionListener(this);
		jbcangku.setContentAreaFilled(false);
		
		bb = Box.createHorizontalBox();
		bb.add(jlcangku);
		bb.add(jtfcangku);
		bb.add(jbcangku);
		
		
		jlLabel = new JLabel("各分区被占用位置数目 / 可容纳总数：");
		jlLabel.setFont(new Font("微软雅黑",Font.PLAIN,15));
		
		jlCar = new JLabel("汽车区：");
		jlCar.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jtCar = new JTextField(13);
		jtCar.setEnabled(false);
		jlTrain = new JLabel("火车区：");
		jlTrain.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jtTrain = new JTextField(15);
		jtTrain.setEnabled(false);
		jlPlane = new JLabel("飞机区：");
		jlPlane.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jtPlane = new JTextField(13);
		jtPlane.setEnabled(false);
		jlEmpty = new JLabel("机动仓库区：");
		jlEmpty.setFont(new Font("微软雅黑",Font.PLAIN,15));
		jtEmpty = new JTextField(15);
		jtEmpty.setEnabled(false);
		
		
		
		b1 = Box.createHorizontalBox();
		b1.add(jlCar);
//		b1.add(Box.createHorizontalStrut(10));
		b1.add(jtCar);
		b1.add(Box.createHorizontalStrut(25));
		b1.add(jlTrain);
		b1.add(Box.createHorizontalStrut(15));
		b1.add(jtTrain);
		b1.add(Box.createHorizontalStrut(10));
		
		b2 = Box.createHorizontalBox();
		b2.add(jlPlane);
//		b2.add(Box.createHorizontalStrut(10));
		b2.add(jtPlane);
		b2.add(Box.createHorizontalStrut(16));
		b2.add(jlEmpty);
//		b2.add(Box.createHorizontalStrut(3));
		b2.add(jtEmpty);
		b2.add(Box.createHorizontalStrut(10));
		
		b3 = Box.createHorizontalBox();
		b3.add(jlLabel);
		b3.add(Box.createHorizontalStrut(305));
		
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(80));
        jpanel3.add(bb);
        jpanel3.add(Box.createVerticalStrut(20));
        jpanel3.add(b3);
        jpanel3.add(Box.createVerticalStrut(20));
        jpanel3.add(b1);
        jpanel3.add(Box.createVerticalStrut(20));
        jpanel3.add(b2);
        jpanel3.add(Box.createVerticalStrut(300));
//        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startadjust.jpg");
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
		if(e.getSource() == jbexit){
			new MainFrame().remove(this);
		}
		if(e.getSource() == jbstart){
//			String id = JOptionPane.showInputDialog("请输入仓库编号");
			String inventoryID = jtfcangku.getText();
			new AdjustZoneBoard(inventoryID).setVisible(true);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
		if(e.getSource() == jbcangku) {
			String inventoryID = jtfcangku.getText();
			if(inventoryID.length() == 0) {//输入了仓库编号
				JOptionPane.showMessageDialog(this, "请输入仓库编号!", "警告", JOptionPane.WARNING_MESSAGE);
			} else {//没有输入仓库编号
				InventoryController inventoryController = new InventoryController();
				//查找此仓库是否存在
				InventoryInfoVO inventoryInfoVO = inventoryController.findInventory(inventoryID);
				if(inventoryInfoVO == null) {//没有找到仓库，提示错误并返回
					JOptionPane.showMessageDialog(this, "没有找到对应仓库，请重新输入编号!", "警告", JOptionPane.WARNING_MESSAGE);
					return;
				}
				//找到了仓库，显示相应信息
				jtCar.setText((inventoryController.getInventoryPercentage(inventoryID, Zone.CAR)).toString());
				boolean carIsAlam = inventoryController.inventoryAlarm(inventoryID, Zone.CAR);
				if(carIsAlam) {
//					jtCar.setForeground(Color.RED);
					JOptionPane.showMessageDialog(this, "汽车区报警！");
				}
				jtPlane.setText((inventoryController.getInventoryPercentage(inventoryID, Zone.PLANE)).toString());
				boolean planeIsAlam = inventoryController.inventoryAlarm(inventoryID, Zone.PLANE);
				System.out.println(planeIsAlam);
				if(planeIsAlam) {
					JOptionPane.showMessageDialog(this, "航空区报警！");
				}
				jtTrain.setText((inventoryController.getInventoryPercentage(inventoryID, Zone.TRAIN)).toString());
				boolean trainIsAlam = inventoryController.inventoryAlarm(inventoryID, Zone.TRAIN);
				if(trainIsAlam) {
					JOptionPane.showMessageDialog(this, "火车区报警！");
				}
				jtEmpty.setText((inventoryController.getInventoryPercentage(inventoryID, Zone.EMPTY)).toString());
			}
		}
	}

	public static JButton getJbStorageInForm() {
		return jbStorageInForm;
	}

	public static void setJbStorageInForm(JButton jbStorageInForm) {
		AdjustZoneNavigation.jbStorageInForm = jbStorageInForm;
	}

	public static JButton getJbStorageOutForm() {
		return jbStorageOutForm;
	}

	public static void setJbStorageOutForm(JButton jbStorageOutForm) {
		AdjustZoneNavigation.jbStorageOutForm = jbStorageOutForm;
	}

	public static JButton getJbZone() {
		return jbZone;
	}

	public static void setJbZone(JButton jbZone) {
		AdjustZoneNavigation.jbZone = jbZone;
	}

	public static JButton getJbStorageCheck() {
		return jbStorageCheck;
	}

	public static void setJbStorageCheck(JButton jbStorageCheck) {
		AdjustZoneNavigation.jbStorageCheck = jbStorageCheck;
	}

	public static JButton getJbStorageCounting() {
		return jbStorageCounting;
	}

	public static void setJbStorageCounting(JButton jbStorageCounting) {
		AdjustZoneNavigation.jbStorageCounting = jbStorageCounting;
	}

	public static JButton getJbSetLimit() {
		return jbSetLimit;
	}

	public static void setJbSetLimit(JButton jbSetLimit) {
		AdjustZoneNavigation.jbSetLimit = jbSetLimit;
	}
	
}
