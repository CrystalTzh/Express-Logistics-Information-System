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
import controller.transitController.CarOfficeFormController;
import po.CarOfficeFormPO;
import presentation.mainui.MainFrame;
import presentation.transitui.CarInputBoard.CarInputFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class RelayCarInputFormNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏6个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始维护按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	static private JButton jbTransfer,jbCarInput,
					jbArrival;
	private ImageIcon imagelogo,imageTransfer,imageArrival,
					  imageCarInput;
	private ImageIcon imageStart,imageRecall;
	private JTable table;
	private JButton jbstart,jbrecall,jbexit,jbmodify;
	@SuppressWarnings("unused")
	private Box b,b1;
	private Vector<String> columnNames;
	private ArrayList<CarOfficeFormPO> allform;
	private DefaultTableModel model;
	private Vector<String> tableValues ;
	private Vector<String> row;
	
	
	public RelayCarInputFormNavigation(){
		
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
		
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
		
		setJbTransfer(new JButton());//中转单
		imageTransfer = new ImageIcon("image/transfer.jpg");
		getJbTransfer().setIcon(imageTransfer);
		getJbTransfer().setPreferredSize(new Dimension(imageTransfer.getIconWidth(),
				imageTransfer.getIconHeight()));
		getJbTransfer().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbTransfer()){
//					new MainFrame().setContentPane(new RelayFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		setJbArrival(new JButton());//中转中心到达单
		imageArrival = new ImageIcon("image/arrival.jpg");
		getJbArrival().setIcon(imageArrival);
		getJbArrival().setPreferredSize(new Dimension(imageArrival.getIconWidth(),
				imageArrival.getIconHeight()));
		getJbArrival().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbArrival()){
//					new MainFrame().setContentPane(new RelayArrivalFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		setJbCarInput(new JButton());//中转中心装车单
		imageCarInput = new ImageIcon("image/carInput.jpg");
		getJbCarInput().setIcon(imageCarInput);
		getJbCarInput().setPreferredSize(new Dimension(imageCarInput.getIconWidth(),
				imageCarInput.getIconHeight()));
		getJbCarInput().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == getJbCarInput()){
//					new MainFrame().setContentPane(new RelayCarInputFormNavigation());
//				}
				MainFrame.jumping(e);
			}
			
		});
		
		jpanel2.add(getJbTransfer());
		jpanel2.add(getJbArrival());
		jpanel2.add(getJbCarInput());
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：中转中心业务员  "+UserID.userid+" 当前任务： 装车单");
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
		columnNames.add("装车单编号");
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
				jbstart.setEnabled(true);
				jbrecall.setEnabled(true);
			}
        	
        });
        
        CarOfficeFormController carOfficeFormController = new CarOfficeFormController();
        allform = carOfficeFormController.findAll();
        if(allform == null){
        	System.out.println("中转中心装车单信息为空！");
        }else {
        	for(int i = 0;i<allform.size();i++){
            	row = new Vector<String>();
            	
            	String NO = allform.get(i).getNO();
            	String date = allform.get(i).getPutOnCarDate();
            	
            	row.add(0, NO);
            	row.add(1, date);
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
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbstart){
			new CarInputFrame();
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid);
		}
	}

	public static JButton getJbTransfer() {
		return jbTransfer;
	}

	public static void setJbTransfer(JButton jbTransfer) {
		RelayCarInputFormNavigation.jbTransfer = jbTransfer;
	}

	public static JButton getJbArrival() {
		return jbArrival;
	}

	public static void setJbArrival(JButton jbArrival) {
		RelayCarInputFormNavigation.jbArrival = jbArrival;
	}

	public static JButton getJbCarInput() {
		return jbCarInput;
	}

	public static void setJbCarInput(JButton jbCarInput) {
		RelayCarInputFormNavigation.jbCarInput = jbCarInput;
	}
	
}
