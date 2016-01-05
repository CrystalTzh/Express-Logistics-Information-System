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
import javax.swing.JTextField;

import controller.UserID;
import presentation.inventoryui.navigation.AdjustZoneNavigation;
import presentation.inventoryui.navigation.SetLimitNavigation;
import presentation.inventoryui.navigation.StorageCheckNavigation;
import presentation.inventoryui.navigation.StorageCountingNavigation;
import presentation.inventoryui.navigation.StorageInFormNavigation;
import presentation.inventoryui.navigation.StorageOutFormNavigation;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class InventoryManPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	@SuppressWarnings("unused")
	private JLabel jlcurrentID,jlLimit,jlWelcome;
	private JButton jbStorageInForm,jbStorageOutForm,jbZone,jbStorageCheck,jbStorageCounting,
					jbSetLimit;
	
	private ImageIcon imagelogo,imageStorageInForm,imageStorageOutForm,imageZone,
					  imageStorageCheck,imageStorageCounting,imageSetLimit;
	@SuppressWarnings("unused")
	private ImageIcon imageStart;
	@SuppressWarnings("unused")
	private JTable table;
	@SuppressWarnings("unused")
	private JButton jbstart,jbexit,jbmodify;
	private Box b,b1;
	@SuppressWarnings("unused")
	private JTextField jtLimit;
	
	public InventoryManPanel(){
		
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

		jbStorageInForm = new JButton();//入库单
		imageStorageInForm = new ImageIcon("image/storageinform.jpg");
		jbStorageInForm.setIcon(imageStorageInForm);
		jbStorageInForm.setPreferredSize(new Dimension(imageStorageInForm.getIconWidth(),
				imageStorageInForm.getIconHeight()));
		jbStorageInForm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbStorageInForm){
					new MainFrame().setContentPane(new StorageInFormNavigation());
				}
			}
			
		});
		
		jbZone = new JButton();//调整库存分区
		imageZone = new ImageIcon("image/zone.jpg");
		jbZone.setIcon(imageZone);
		jbZone.setPreferredSize(new Dimension(imageZone.getIconWidth(),
				imageZone.getIconHeight()));
		jbZone.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbZone){
					new MainFrame().setContentPane(new AdjustZoneNavigation());
				}
			}
			
		});
		
		jbStorageCheck = new JButton();//库存查看
		imageStorageCheck = new ImageIcon("image/storagecheck.jpg");
		jbStorageCheck.setIcon(imageStorageCheck);
		jbStorageCheck.setPreferredSize(new Dimension(imageStorageCheck.getIconWidth(),
				imageStorageCheck.getIconHeight()));
		jbStorageCheck.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbStorageCheck){
					new MainFrame().setContentPane(new StorageCheckNavigation());
				}
			}
			
		});
		
		jbStorageCounting = new JButton();//库存盘点
		imageStorageCounting = new ImageIcon("image/storagecounting.jpg");
		jbStorageCounting.setIcon(imageStorageCounting);
		jbStorageCounting.setPreferredSize(new Dimension(imageStorageCounting.getIconWidth(),
				imageStorageCounting.getIconHeight()));
		jbStorageCounting.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbStorageCounting){
					new MainFrame().setContentPane(new StorageCountingNavigation());
				}
			}
			
		});
		
		jbSetLimit = new JButton();//设置库存警戒值
		imageSetLimit = new ImageIcon("image/setlimit.jpg");
		jbSetLimit.setIcon(imageSetLimit);
		jbSetLimit.setPreferredSize(new Dimension(imageSetLimit.getIconWidth(),
				imageSetLimit.getIconHeight()));
		jbSetLimit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbSetLimit){
					new MainFrame().setContentPane(new SetLimitNavigation());
				}
			}
			
		});
		
		jbStorageOutForm = new JButton();//出库单
		imageStorageOutForm = new ImageIcon("image/storageoutform.jpg");
		jbStorageOutForm.setIcon(imageStorageOutForm);
		jbStorageOutForm.setPreferredSize(new Dimension(imageStorageOutForm.getIconWidth(),
				imageStorageOutForm.getIconHeight()));
		jbStorageOutForm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbStorageOutForm){
					new MainFrame().setContentPane(new StorageOutFormNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbStorageInForm);
		jpanel2.add(jbStorageOutForm);
		jpanel2.add(jbZone);
		jpanel2.add(jbStorageCheck);
		jpanel2.add(jbStorageCounting);
		jpanel2.add(jbSetLimit);
		
		

		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：中转中心仓库管理人员   "+UserID.userid);
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
