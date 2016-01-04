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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.inventorycontroller.StorageOutFormController;
import po.StorageOutFormPO;
import presentation.inventoryui.StorageOutBoard.StorageOutFrame;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class StorageOutFormNavigation extends JPanel implements ActionListener{

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
	private ImageIcon imageStart,imageRecall;
	private JTable table;
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	private Box b;
	private Vector<String> columnNames;
	private ArrayList<StorageOutFormPO> allstorageoutform;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	public StorageOutFormNavigation(){
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
		
		jlcurrentID = new JLabel("当前身份：仓库管理员  "+UserID.userid+" 当前任务：出库单");
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
		columnNames.add("出库单编号");
		columnNames.add("创建日期");
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
        
        StorageOutFormController storageOutFormController = new StorageOutFormController();
        allstorageoutform = storageOutFormController.findAll();
        if(allstorageoutform == null){
        	System.out.println("司机信息为空！");
        }else {
        	for(int i = 0;i<allstorageoutform.size();i++){
            	row = new Vector<String>();
            	
            	String NO = allstorageoutform.get(i).getNO();
            	String date = allstorageoutform.get(i).getDate();
            	
            	row.add(0, NO);
            	row.add(1, date);
            	
            	model.addRow(row);
            	
            }
        }
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(10));
        jpanel3.add(scrollPane);
		
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/startform.jpg");
		jbstart.setIcon(imageStart);
		jbstart.setPreferredSize(new Dimension(imageStart.getIconWidth(),
				imageStart.getIconHeight()));
		jbstart.addActionListener(this);
		jbrecall = new JButton();
		imageRecall = new ImageIcon("image/startrecall.jpg");
		jbrecall.setIcon(imageRecall);
		jbrecall.setPreferredSize(new Dimension(imageRecall.getIconWidth(),
				imageRecall.getIconHeight()));
		jbrecall.setEnabled(false);
		
		
		jpanel4.add(Box.createHorizontalStrut(520));
		jpanel4.add(jbstart);
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
			new MainFrame().remove(this);
		}
		if(e.getSource() == jbstart){
			StorageOutFrame window = new StorageOutFrame();
			window.frame.setVisible(true);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
	}

	public static JButton getJbStorageInForm() {
		return jbStorageInForm;
	}

	public static void setJbStorageInForm(JButton jbStorageInForm) {
		StorageOutFormNavigation.jbStorageInForm = jbStorageInForm;
	}

	public static JButton getJbStorageOutForm() {
		return jbStorageOutForm;
	}

	public static void setJbStorageOutForm(JButton jbStorageOutForm) {
		StorageOutFormNavigation.jbStorageOutForm = jbStorageOutForm;
	}

	public static JButton getJbZone() {
		return jbZone;
	}

	public static void setJbZone(JButton jbZone) {
		StorageOutFormNavigation.jbZone = jbZone;
	}

	public static JButton getJbStorageCheck() {
		return jbStorageCheck;
	}

	public static void setJbStorageCheck(JButton jbStorageCheck) {
		StorageOutFormNavigation.jbStorageCheck = jbStorageCheck;
	}

	public static JButton getJbStorageCounting() {
		return jbStorageCounting;
	}

	public static void setJbStorageCounting(JButton jbStorageCounting) {
		StorageOutFormNavigation.jbStorageCounting = jbStorageCounting;
	}

	public static JButton getJbSetLimit() {
		return jbSetLimit;
	}

	public static void setJbSetLimit(JButton jbSetLimit) {
		StorageOutFormNavigation.jbSetLimit = jbSetLimit;
	}

	
}
