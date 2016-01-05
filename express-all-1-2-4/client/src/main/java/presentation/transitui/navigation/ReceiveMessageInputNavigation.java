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
import controller.transitController.OrderFormController;
import po.OrderFormPO;
import presentation.mainui.MainFrame;
import presentation.transitui.ReceiveInfoBoard.ReceiveInfoFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class ReceiveMessageInputNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏3个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbOrderForm,jbCheck,jbReceiveInfo;
	
	private ImageIcon imagelogo,imageOrderForm,imageCheck,
					  imageReceiveInfo;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	
	private Vector<String> columnNames;
	private ArrayList<OrderFormPO> allform;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	
	/**
	 * 
	 */
	public ReceiveMessageInputNavigation(){
		
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
		
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		setJbOrderForm(new JButton());//寄件单
		imageOrderForm = new ImageIcon("image/orderform.jpg");
		getJbOrderForm().setIcon(imageOrderForm);
		getJbOrderForm().setPreferredSize(new Dimension(imageOrderForm.getIconWidth(),
				imageOrderForm.getIconHeight()));
		getJbOrderForm().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbOrderForm()){
//					new MainFrame().setContentPane(new OrderFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbCheck(new JButton());//订单信息查询
		imageCheck = new ImageIcon("image/orderformcheck.jpg");
		getJbCheck().setIcon(imageCheck);
		getJbCheck().setPreferredSize(new Dimension(imageCheck.getIconWidth(),
				imageCheck.getIconHeight()));
		getJbCheck().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCheck()){
//					new MainFrame().setContentPane(new OrderInfoCheckNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		setJbReceiveInfo(new JButton());//收件信息输入
		imageReceiveInfo = new ImageIcon("image/receiveinfoinput.jpg");
		getJbReceiveInfo().setIcon(imageReceiveInfo);
		getJbReceiveInfo().setPreferredSize(new Dimension(imageReceiveInfo.getIconWidth(),
				imageReceiveInfo.getIconHeight()));
		getJbReceiveInfo().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbReceiveInfo()){
//					new MainFrame().setContentPane(new ReceiveMessageInputNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbOrderForm());
		jpanel2.add(getJbCheck());
		jpanel2.add(getJbReceiveInfo());
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：快递员  "+UserID.userid+" 当前任务：收件信息输入");
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
		columnNames.add("寄件单编号");
		columnNames.add("创建日期");
		tableValues = new Vector<String>();
		model = new DefaultTableModel(tableValues, columnNames){

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
		model.setDataVector(tableValues, columnNames);
		table.setModel(model);
		DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(JLabel.CENTER);
        table.setDefaultRenderer(Object.class, tcr);
        JScrollPane scrollPane = new JScrollPane(table);
        
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){

			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				jbstart.setEnabled(true);
				
			}
        	
        });
        
        OrderFormController orderFormController = new OrderFormController();
        allform = orderFormController.findAll();
        if(allform == null){
        	System.out.println("寄件单信息为空！");
        }else {
        	for(int i = 0;i<allform.size();i++){
            	row = new Vector<String>();
            	
            	String NO = allform.get(i).getID();
            	String date = allform.get(i).getDate();
            	
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
		jbstart.setEnabled(false);
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
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbstart){
			new ReceiveInfoFrame().setVisible(true);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid);
		}
	}

	public static JButton getJbOrderForm() {
		return jbOrderForm;
	}

	public static void setJbOrderForm(JButton jbOrderForm) {
		ReceiveMessageInputNavigation.jbOrderForm = jbOrderForm;
	}

	public static JButton getJbCheck() {
		return jbCheck;
	}

	public static void setJbCheck(JButton jbCheck) {
		ReceiveMessageInputNavigation.jbCheck = jbCheck;
	}

	public static JButton getJbReceiveInfo() {
		return jbReceiveInfo;
	}

	public static void setJbReceiveInfo(JButton jbReceiveInfo) {
		ReceiveMessageInputNavigation.jbReceiveInfo = jbReceiveInfo;
	}
	
}
