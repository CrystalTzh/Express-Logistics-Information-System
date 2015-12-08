package presentation.transitui.navigation;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import presentation.mainui.MainFrame;

public class ReceiveMessageInputNavigation extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏3个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	private JButton jbOrderForm,jbCheck,jbReceiveInfo;
	
	private ImageIcon imagelogo,imageOrderForm,imageCheck,
					  imageReceiveInfo;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
	
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

		jbOrderForm = new JButton();//寄件单
		imageOrderForm = new ImageIcon("image/orderform.jpg");
		jbOrderForm.setIcon(imageOrderForm);
		jbOrderForm.setPreferredSize(new Dimension(imageOrderForm.getIconWidth(),
				imageOrderForm.getIconHeight()));
		jbOrderForm.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbOrderForm){
					new MainFrame().setContentPane(new OrderFormNavigation());
				}
			}
			
		});
		
		jbCheck = new JButton();//订单信息查询
		imageCheck = new ImageIcon("image/orderformcheck.jpg");
		jbCheck.setIcon(imageCheck);
		jbCheck.setPreferredSize(new Dimension(imageCheck.getIconWidth(),
				imageCheck.getIconHeight()));
		jbCheck.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbCheck){
					new MainFrame().setContentPane(new OrderInfoCheckNavigation());
				}
			}
			
		});
		
		jbReceiveInfo = new JButton();//收件信息输入
		imageReceiveInfo = new ImageIcon("image/receiveinfoinput.jpg");
		jbReceiveInfo.setIcon(imageReceiveInfo);
		jbReceiveInfo.setPreferredSize(new Dimension(imageReceiveInfo.getIconWidth(),
				imageReceiveInfo.getIconHeight()));
		jbReceiveInfo.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource() == jbReceiveInfo){
					new MainFrame().setContentPane(new ReceiveMessageInputNavigation());
				}
			}
			
		});
		
		jpanel2.add(jbOrderForm);
		jpanel2.add(jbCheck);
		jpanel2.add(jbReceiveInfo);
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：快递员     当前任务：收件信息输入");
		jlcurrentID.setFont(new Font("当前身份：快递员       当前任务：收件信息输入",Font.PLAIN,15));

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
		b.add(Box.createHorizontalStrut(13));
		b.add(jbexit);
		b.add(Box.createHorizontalStrut(3));
		
		String[] columnNames = { "寄件单编号","创建日期"};  
        String[][] tableValues = { { "A1", "B1"}, { "A2", "B2"},  
                { "A3", "B3"}, { "A4", "B4"}, { "A5", "B5"},
                { "A6", "B6"}};  
        DefaultTableModel model = new DefaultTableModel(tableValues,columnNames){

			@Override
        	public boolean isCellEditable(int row,int column){
        		return false;
        	}
        };
        table = new JTable();
        table.setModel(model);
        
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
		imageStart = new ImageIcon("image/startform.jpg");
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
