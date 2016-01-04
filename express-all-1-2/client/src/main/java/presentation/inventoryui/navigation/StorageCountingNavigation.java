package presentation.inventoryui.navigation;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.inventorycontroller.StorageInFormController;
import po.StorageInFormPO;
import presentation.inventoryui.boards.StorageCountingBoard;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class StorageCountingNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbStorageInForm,jbStorageOutForm,jbZone,jbStorageCheck,jbStorageCounting,
					jbSetLimit;
	
	private ImageIcon imagelogo,imageStorageInForm,imageStorageOutForm,imageZone,
					  imageStorageCheck,imageStorageCounting,imageSetLimit;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	private Vector<String> columnNames;
	private ArrayList<StorageInFormPO> allstorageinform;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	public StorageCountingNavigation(){
		
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
		
		jlcurrentID = new JLabel("当前身份：仓库管理员  "+UserID.userid+" 当前任务：库存盘点");
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
		columnNames.add("订单号");
		columnNames.add("入库日期");
		columnNames.add("目的地");
		columnNames.add("区号");
		columnNames.add("排号");
		columnNames.add("架号");
		columnNames.add("位号");
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
        table.getTableHeader().setReorderingAllowed(false);
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        
        StorageInFormController storageInFormController = new StorageInFormController();
        allstorageinform = storageInFormController.findAll();
        if(allstorageinform == null){
        	System.out.println("库存信息为空！");
        }else {
        	for(int i = 0;i<allstorageinform.size();i++){
            	row = new Vector<String>();
            	
            	String NO = allstorageinform.get(i).getExpressNumber();
            	String date = allstorageinform.get(i).getDate();
            	String destination = allstorageinform.get(i).getDestination();
            	String zone = allstorageinform.get(i).getZone().toString();
            	String line = allstorageinform.get(i).getLine().toString();
            	String shelf = allstorageinform.get(i).getShelf().toString();
            	String tag = allstorageinform.get(i).getTag().toString();
            	
            	row.add(0, NO);
            	row.add(1, date);
            	row.add(2, destination);
            	row.add(3, zone);
            	row.add(4, line);
            	row.add(5, shelf);
            	row.add(6, tag);
            	
            	model.addRow(row);
            	
            }
        }
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startcheck.jpg");
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
			new StorageCountingBoard();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
	}

	public static JButton getJbStorageInForm() {
		return jbStorageInForm;
	}

	public static void setJbStorageInForm(JButton jbStorageInForm) {
		StorageCountingNavigation.jbStorageInForm = jbStorageInForm;
	}

	public static JButton getJbStorageOutForm() {
		return jbStorageOutForm;
	}

	public static void setJbStorageOutForm(JButton jbStorageOutForm) {
		StorageCountingNavigation.jbStorageOutForm = jbStorageOutForm;
	}

	public static JButton getJbZone() {
		return jbZone;
	}

	public static void setJbZone(JButton jbZone) {
		StorageCountingNavigation.jbZone = jbZone;
	}

	public static JButton getJbStorageCheck() {
		return jbStorageCheck;
	}

	public static void setJbStorageCheck(JButton jbStorageCheck) {
		StorageCountingNavigation.jbStorageCheck = jbStorageCheck;
	}

	public static JButton getJbStorageCounting() {
		return jbStorageCounting;
	}

	public static void setJbStorageCounting(JButton jbStorageCounting) {
		StorageCountingNavigation.jbStorageCounting = jbStorageCounting;
	}

	public static JButton getJbSetLimit() {
		return jbSetLimit;
	}

	public static void setJbSetLimit(JButton jbSetLimit) {
		StorageCountingNavigation.jbSetLimit = jbSetLimit;
	}
	
}
