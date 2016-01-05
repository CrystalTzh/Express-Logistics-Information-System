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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import controller.UserID;
import presentation.mainui.MainFrame;
import presentation.outfindui.OutfindFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;

public class OrderInfoCheckNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏3个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID,jlexpressnumber;
	static private JButton jbOrderForm,jbCheck,jbReceiveInfo,jbCheckDetail;
	
	private ImageIcon imagelogo,imageOrderForm,imageCheck,
					  imageReceiveInfo,imageCheckDetail;
	private ImageIcon imageStart;
	@SuppressWarnings("unused")
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	@SuppressWarnings("unused")
	private Box b,b1,b2,b3;
	private JTextField jtExpressNumber;
	
	public OrderInfoCheckNavigation(){
		
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
		
		jlcurrentID = new JLabel("当前身份：快递员 "+UserID.userid+" 当前任务：订单信息查询");
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
		
		jlexpressnumber = new JLabel("订单号输入：");
		jlexpressnumber.setFont(new Font("订单号输入：",Font.PLAIN,15));
		jtExpressNumber = new JTextField(20);
		jbCheckDetail = new JButton();
		imageCheckDetail = new ImageIcon("image/checkdetail.jpg");
		jbCheckDetail.setIcon(imageCheckDetail);
		jbCheckDetail.setPreferredSize(new Dimension(imageCheckDetail.getIconWidth(),
				imageCheckDetail.getIconHeight()));
		
		b2 = Box.createHorizontalBox();
		b2.add(jlexpressnumber);
		b2.add(Box.createHorizontalGlue());
		
		b3 = Box.createHorizontalBox();
		b3.add(jtExpressNumber);
		b3.add(Box.createHorizontalStrut(5));
		
		
		
        jpanel3.add(b);
        jpanel3.add(Box.createVerticalStrut(90));
//        jpanel3.add(b2);
        jpanel3.add(Box.createVerticalStrut(10));
//        jpanel3.add(b3);
        jpanel3.add(Box.createVerticalStrut(180));
        
        
//        sp = new ScrollPane();
//        sp.add(jpanel3);
        
        jpanel4 = new JPanel();
        jpanel4.setLayout(new BoxLayout(jpanel4,BoxLayout.X_AXIS));
		jpanel4.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		jbstart = new JButton();
		imageStart = new ImageIcon("image/checkdetail.jpg");
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
			JOptionPane.getFrameForComponent(this).dispose();
			new MainFrame().setVisible(true);
		}
		if(e.getSource() == jbmodify){
			new ModifyPasswordBoard(this, UserID.userid);
		}
		if(e.getSource() == jbstart){
			new OutfindFrame().setVisible(true);
		}
	}

	public static JButton getJbOrderForm() {
		return jbOrderForm;
	}

	public static void setJbOrderForm(JButton jbOrderForm) {
		OrderInfoCheckNavigation.jbOrderForm = jbOrderForm;
	}

	public static JButton getJbCheck() {
		return jbCheck;
	}

	public static void setJbCheck(JButton jbCheck) {
		OrderInfoCheckNavigation.jbCheck = jbCheck;
	}

	public static JButton getJbReceiveInfo() {
		return jbReceiveInfo;
	}

	public static void setJbReceiveInfo(JButton jbReceiveInfo) {
		OrderInfoCheckNavigation.jbReceiveInfo = jbReceiveInfo;
	}
	
}
