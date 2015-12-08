/**
 * @author 谭琼
 * 2015年12月3日
 */
package presentation.userui.useraccounboard;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class UserAccountManageDriver extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	UserAccountBoardAdd userAccountBoardAdd = null;
	UserAccountBoardDelete userAccountBoardDelete = null;
	UserAccountBoardModify userAccountBoardModify = null;
	UserAccountBoardInquire userAccountBoardInquire = null;
	JMenuBar bar;
	JMenu fileMenu;
	JMenuItem addmi, modifymi, inquiremi, deletemi;
	Container con = null;
	CardLayout card = null;
	JLabel label = null;
	JPanel pCenter;
	
	public UserAccountManageDriver() {
			//建立菜单栏
			addmi = new JMenuItem("录入用户账户基本信息");
			modifymi = new JMenuItem("修改用户账户基本信息");
			inquiremi = new JMenuItem("查询用户账户基本信息");
			deletemi = new JMenuItem("删除用户账户基本信息");
			bar = new JMenuBar();
			fileMenu = new JMenu("菜单选项");
			fileMenu.add(addmi);
			fileMenu.add(modifymi);
			fileMenu.add(inquiremi);
			fileMenu.add(deletemi);
			bar.add(fileMenu);
			setJMenuBar(bar);
			label = new JLabel("维护用户账户信息", JLabel.CENTER);
			label.setFont(new Font("TimesRoman", Font.BOLD, 24));
			label.setForeground(Color.BLUE);
			//对菜单项进行监听
			addmi.addActionListener(this);
			modifymi.addActionListener(this);
			inquiremi.addActionListener(this);
			deletemi.addActionListener(this);
			card = new CardLayout();
			con = getContentPane();
			pCenter = new JPanel();
			pCenter.setLayout(card);
			userAccountBoardAdd = new UserAccountBoardAdd();
			userAccountBoardModify = new UserAccountBoardModify();
			userAccountBoardInquire = new UserAccountBoardInquire(this);
			userAccountBoardDelete = new UserAccountBoardDelete();
			pCenter.add("欢迎语界面", label);
			pCenter.add("录入界面", userAccountBoardAdd);
			pCenter.add("修改界面", userAccountBoardModify);
			pCenter.add("删除界面", userAccountBoardDelete);
			con.add(pCenter, BorderLayout.CENTER);
			con.validate();
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			});
			setVisible(true);
			setBounds(560, 250, 420, 380);
			validate();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//卡片布局能够让多个组件共享同一个显示空间
		if (e.getSource() == addmi) {
			card.show(pCenter, "录入界面");
		} else if(e.getSource() == deletemi) {
			card.show(pCenter, "删除界面");
		}  else if (e.getSource() == modifymi) {
			card.show(pCenter, "修改界面");
		} else if (e.getSource() == inquiremi) {
			userAccountBoardInquire.setVisible(true);
		}
	}
	
	public static void main(String[] args) {
		new UserAccountManageDriver();
	}
}
