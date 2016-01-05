package presentation.userui.navigation;

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
import javax.swing.table.DefaultTableModel;

import controller.UserID;
import controller.usercontroller.UserAccountController;
import presentation.mainui.MainFrame;
import presentation.userui.modifypasswordui.ModifyPasswordBoard;
import presentation.userui.useraccounboard.UserAccountManageDriver;
import state.UserRole;
import vo.UserAccountVO;

public class UserInfoNavigation extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel jpanel1,//logo
				   jpanel2,//任务栏7个
				   jpanel3,//加在CENTER的表格
				   jpanel4;//开始按钮
	private JLabel jlabellogo;
	private JLabel jlcurrentID;
	@SuppressWarnings("unused")
	static private JButton jbID,jbSalary,jbAccountID,jbJudge,
					jbCheckCostPayChart,jbCheckProfitChart,jbCheckDiary;
	
	@SuppressWarnings("unused")
	private ImageIcon imagelogo,imageID,imageSalary,
					  imageAccount,imageJudge,
					  imageCheckCostPayChart,imageCheckProfitChart,imageCheckDiary;
	private ImageIcon imageStart;
	private JTable table;
	private JButton jbstart,jbexit,jbmodify;
	private Box b;
//	private ScrollPane sp;
	MainFrame mainframe;
	Vector<String> tableValues ;
	Vector<String> columnNames ;
	Vector<String> row;
	DefaultTableModel model ;
	UserAccountController userAccountController;
	
	public UserInfoNavigation(){
		
//		mainframe = new MainFrame();
		
		this.setLayout(new BorderLayout());
		jpanel1 = new JPanel();
		jlabellogo = new JLabel();
		imagelogo = new ImageIcon("image/logo.jpg");
		jlabellogo.setIcon(imagelogo);
		jpanel1.add(jlabellogo);
		jpanel1.setBorder(BorderFactory.createEmptyBorder(0, 10, 10, 10));
		this.add(jpanel1,BorderLayout.NORTH);
		
		jpanel2 = new JPanel(new GridLayout(8, 1,5,10));
		jpanel2.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 5));

		setJbID(new JButton());//管理账号密码
		imageID = new ImageIcon("image/IDandPassword.jpg");
		getJbID().setIcon(imageID);
		getJbID().setPreferredSize(new Dimension(imageID.getIconWidth(),
				imageID.getIconHeight()));
		getJbID().addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if(e.getSource() == jbID){
//					new MainFrame().setContentPane(new UserInfoNavigation());
//				}
				MainFrame.jumping(e);
				JOptionPane.getRootFrame().dispose();
			}
			
		});
		
		
		
		jpanel2.add(getJbID());
		
		
		
		jpanel3 = new JPanel();
		jpanel3.setLayout(new BoxLayout(jpanel3,BoxLayout.Y_AXIS));
		jpanel3.setBorder(BorderFactory.createEmptyBorder(2, 5, 10, 10));
		
		jlcurrentID = new JLabel("当前身份：管理员   "+UserID.userid+" 当前任务：管理账号密码");
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
		columnNames.add("账号");
		columnNames.add("初始密码");
		columnNames.add("职位");
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
        model.setDataVector(tableValues, columnNames);
        table.setModel(model);
        
//        table = new JTable(tableValues, columnNames); 
//        table.setEnabled(false);
        JScrollPane scrollPane = new JScrollPane(table); 
        
        userAccountController = new UserAccountController();
        //快递员
        ArrayList<UserAccountVO> allExpressMan = userAccountController.findAll(UserRole.EXPRESSMAN);
        if(allExpressMan!=null){
        	for(int i = 0;i<allExpressMan.size();i++){
            	row = new Vector<String>();
            	
            	String accountID = allExpressMan.get(i).getAccountID();
            	String admin = allExpressMan.get(i).getInitialPassword();
            	String userrole = allExpressMan.get(i).getUserRole().toString();
            	
            	row.add(0, accountID);
            	row.add(1, admin);
            	row.add(2, userrole);
            	model.addRow(row);
            }
        }
        
        //营业厅业务员
        ArrayList<UserAccountVO> allOfficeMan = userAccountController.findAll(UserRole.OFFICEMAN);
        if(allOfficeMan!=null){
        	for(int i = 0;i<allOfficeMan.size();i++){
            	row = new Vector<String>();
            	
            	String accountID = allOfficeMan.get(i).getAccountID();
            	String admin = allOfficeMan.get(i).getInitialPassword();
            	String userrole = allOfficeMan.get(i).getUserRole().toString();
            	
            	row.add(0, accountID);
            	row.add(1, admin);
            	row.add(2, userrole);
            	model.addRow(row);
            }
        }
        
        //中转中心业务员
        ArrayList<UserAccountVO> allTransferMan = userAccountController.findAll(UserRole.TRANSITCENTERMAN);
        if(allTransferMan!=null){
        	for(int i = 0;i<allTransferMan.size();i++){
            	row = new Vector<String>();
            	
            	String accountID = allTransferMan.get(i).getAccountID();
            	String admin = allTransferMan.get(i).getInitialPassword();
            	String userrole = allTransferMan.get(i).getUserRole().toString();
            	
            	row.add(0, accountID);
            	row.add(1, admin);
            	row.add(2, userrole);
            	model.addRow(row);
            }
        }
        
        //仓库管理人员
        ArrayList<UserAccountVO> allInventoryMan = userAccountController.findAll(UserRole.INVENTORYMAN);
        if(allInventoryMan!=null){
        	for(int i = 0;i<allInventoryMan.size();i++){
            	row = new Vector<String>();
            	
            	String accountID = allInventoryMan.get(i).getAccountID();
            	String admin = allInventoryMan.get(i).getInitialPassword();
            	String userrole = allInventoryMan.get(i).getUserRole().toString();
            	
            	row.add(0, accountID);
            	row.add(1, admin);
            	row.add(2, userrole);
            	model.addRow(row);
            }
        }
        
        //高级财务人员
        ArrayList<UserAccountVO> allAdfinanceMan = userAccountController.findAll(UserRole.ADFINANCEMAN);
        if(allAdfinanceMan!=null){
        	for(int i = 0;i<allAdfinanceMan.size();i++){
            	row = new Vector<String>();
            	
            	String accountID = allAdfinanceMan.get(i).getAccountID();
            	String admin = allAdfinanceMan.get(i).getInitialPassword();
            	String userrole = allAdfinanceMan.get(i).getUserRole().toString();
            	
            	row.add(0, accountID);
            	row.add(1, admin);
            	row.add(2, userrole);
            	model.addRow(row);
            }
        }
        
        //普通财务人员
        ArrayList<UserAccountVO> allGefinanceMan = userAccountController.findAll(UserRole.GEFINACEMAN);
        if(allGefinanceMan!=null){
        	 for(int i = 0;i<allGefinanceMan.size();i++){
             	row = new Vector<String>();
             	
             	String accountID = allGefinanceMan.get(i).getAccountID();
             	String admin = allGefinanceMan.get(i).getInitialPassword();
             	String userrole = allGefinanceMan.get(i).getUserRole().toString();
             	
             	row.add(0, accountID);
             	row.add(1, admin);
             	row.add(2, userrole);
             	model.addRow(row);
             }
        }
       
        //总经理
        ArrayList<UserAccountVO> allManager = userAccountController.findAll(UserRole.MANAGER);
        if(allManager!=null){
        	 for(int i = 0;i<allManager.size();i++){
             	row = new Vector<String>();
             	
             	String accountID = allManager.get(i).getAccountID();
             	String admin = allManager.get(i).getInitialPassword();
             	String userrole = allManager.get(i).getUserRole().toString();
             	
             	row.add(0, accountID);
             	row.add(1, admin);
             	row.add(2, userrole);
             	model.addRow(row);
             }
        }
        //管理员
        ArrayList<UserAccountVO> administrator = userAccountController.findAll(UserRole.ADMINISTRATOR);
        if(administrator!=null){
        	 for(int i = 0;i<administrator.size();i++){
             	row = new Vector<String>();
             	
             	String accountID = administrator.get(i).getAccountID();
             	String admin = administrator.get(i).getInitialPassword();
             	String userrole = administrator.get(i).getUserRole().toString();
             	
             	row.add(0, accountID);
             	row.add(1, admin);
             	row.add(2, userrole);
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
		imageStart = new ImageIcon("image/start.jpg");
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
			new ModifyPasswordBoard(this, UserID.userid).setVisible(true);
		}
		if(e.getSource() == jbstart){
//			new UserAccountClientHelper();
			new UserAccountManageDriver().setVisible(true);;
		}
	}

	public static JButton getJbID() {
		return jbID;
	}

	public static void setJbID(JButton jbID) {
		UserInfoNavigation.jbID = jbID;
	}
	
	public static void main(String[] args) {
		MainFrame main = new MainFrame();
		main.setContentPane(new UserInfoNavigation());
		main.setVisible(true);
	}
}