package presentation.inventoryui.navigation;

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
import javax.swing.JTable;
import javax.swing.JTextField;

import presentation.mainui.MainFrame;

public class SetLimitNavigation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlLimit;
	private JButton jbStorageInForm,jbStorageOutForm,jbZone,jbStorageCheck,jbStorageCounting,
					jbSetLimit;
	
	private ImageIcon imagelogo,imageStorageInForm,imageStorageOutForm,imageZone,
					  imageStorageCheck,imageStorageCounting,imageSetLimit;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b,b1;
	private JTextField jtLimit;
	
	public SetLimitNavigation(){
		
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
		
		jlcurrentID = new JLabel("当前身份：中转中心仓库管理员     当前任务：设置库存警戒值");
		jlcurrentID.setFont(new Font("当前身份：中转中心仓库管理员       当前任务：设置库存警戒值",Font.PLAIN,14));

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
		b.add(Box.createHorizontalStrut(8));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
//		String[] columnNames = { "开始日期","结束日期","出库数量","入库数量","出库金额","入库金额","库存总量"};  
//        String[][] tableValues = { { "A1", "B1","C1","D1","E1","F1","G1"}, { "A2", "B2","C1","D1","E1","F1","G1"},  
//                { "A3", "B3","C3","D3","E3","F3","G3"}, { "A4", "B4","C4","D4","E4","F4","G4"}, 
//                { "A5", "B5","C5","D5","E5","F5","G5"}, { "A6", "B6","C6","D6","E6","F6","G6"}};  
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
//        JScrollPane scrollPane = new JScrollPane(table); 
		
		jlLimit = new JLabel("当前库存警戒值：");
		jlLimit.setFont(new Font("当前库存警戒值：",Font.PLAIN,15));
		jtLimit = new JTextField();
		jtLimit.setEditable(false);
		
		b1 = Box.createHorizontalBox();
		b1.add(jlLimit);
		b1.add(jtLimit);
		
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(100));
        jpanel3.add(b1);
        jpanel3.add(Box.createVerticalStrut(300));
        
        
//        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startdefine.jpg");
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