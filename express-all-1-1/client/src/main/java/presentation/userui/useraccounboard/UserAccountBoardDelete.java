/**
 * @author 谭琼
 * 2015年12月3日
 */
package presentation.userui.useraccounboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.userController.UserAccountController;
import state.UserRole;
import vo.UserAccountVO;

public class UserAccountBoardDelete extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 账号、用户名、初始密码
	JTextField accountIDjtf, userNamejtf, initialPasswordjtf;
	UserAccountController userAccountController;
	JButton deletebt;
	// 职位:快递员、营业厅业务员、中转中心业务员
	// 仓库管理人员、总经理、高级财务人员、普通财务人员
	JRadioButton expressManrbt, officeManrbt, transitCenterManrbt, 
		inventoryManrbt, managerrbt, adFinanceManrbt,geFinanceManrbt,administratorbt;
	ButtonGroup group = null;

	public UserAccountBoardDelete() {
		userAccountController = new UserAccountController();

		// 初始化文本框、按钮等组件
		accountIDjtf = new JTextField(10);
		deletebt = new JButton("删除");
		// 监听carNumber文本框和删除按钮
		accountIDjtf.addActionListener(this);
		deletebt.addActionListener(this);
		userNamejtf = new JTextField(10);
		userNamejtf.setEditable(false);
		initialPasswordjtf = new JTextField(10);
		initialPasswordjtf.setEditable(false);
		group = new ButtonGroup();
		expressManrbt = new JRadioButton("快递员", true);
		officeManrbt = new JRadioButton("营业厅业务员", false);
		transitCenterManrbt = new JRadioButton("中转中心业务员", false);
		inventoryManrbt = new JRadioButton("仓库管理人员", false);
		managerrbt = new JRadioButton("总经理", false);
		adFinanceManrbt = new JRadioButton("高级财务人员", false);
		geFinanceManrbt = new JRadioButton("普通财务人员", false);
		administratorbt = new JRadioButton("管理员",false);
		group.add(expressManrbt);
		group.add(officeManrbt);
		group.add(transitCenterManrbt);
		group.add(inventoryManrbt);
		group.add(managerrbt);
		group.add(adFinanceManrbt);
		group.add(geFinanceManrbt);
		group.add(administratorbt);

		// 水平显示组件
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("用户账号信息删除", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.DARK_GRAY);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要删除的账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(deletebt);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("用户名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(15));
		box2.add(userNamejtf);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("初始密码:", JLabel.CENTER));
		box3.add(initialPasswordjtf);
		// 职位分三排放置
		Box box4 = Box.createVerticalBox();
		// box41 放置快递员、营业厅业务员、中转中心业务员RadioButton
		Box box41 = Box.createHorizontalBox();
		box41.add(new JLabel("职位:", JLabel.CENTER));
		box41.add(Box.createHorizontalStrut(25));
		box41.add(expressManrbt);
		box41.add(officeManrbt);
		box41.add(transitCenterManrbt);
		// box42 放置仓库管理人员、普通财务人员
		Box box42 = Box.createHorizontalBox();
		box42.add(inventoryManrbt);
		box42.add(Box.createHorizontalStrut(28));
		box42.add(geFinanceManrbt);
		// box43 放置总经理、高级财务人员.管理员
		Box box43 = Box.createHorizontalBox();
		box43.add(managerrbt);
		box43.add(Box.createHorizontalStrut(1));
		box43.add(administratorbt);
		box43.add(Box.createHorizontalStrut(1));
		box43.add(adFinanceManrbt);
		box4.add(box41);
		box4.add(box42);
		box4.add(box43);

		// 垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(15));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(15));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(15));
		boxH.add(box4);

		JPanel pCenter;
		// JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		// 主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		validate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if(e.getSource() == deletebt
			|| e.getSource() == accountIDjtf) {//1 点击了删除按钮或Enter键确认输入用户账号完成
			String number = "";
			number = accountIDjtf.getText();
			
			if(number.length() > 0) {//1.1 输入了用户账号
				UserAccountVO vo = null;
				vo = userAccountController.findUserAccount(number);//查找用户账号
				if(vo != null) {//1.1.1 输入的用户账号存在
					//显示用户账号基本信息
					showText(vo);
					
					String m = "确定要删除该用户账号及全部信息吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION);
					if(ok == JOptionPane.YES_OPTION) {//1.1.1.1 确认删除
						userAccountController.deleteUserAccount(vo);//删除用户账号信息
						clearText();
					}
				} else {//1.1.2 输入的用户账号不存在
					String warning = "该用户账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {// 1.2 没有输入用户账号
				String warning = "必须要输入用户账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.out.println();

	}

	/**
	 * 清空面板
	 */
	public void clearText() {
		accountIDjtf.setText(null);
		userNamejtf.setText(null);
		initialPasswordjtf.setText(null);
		expressManrbt.setSelected(true);
	}
	
	/**
	 * 显示基本信息
	 * @param vo
	 */
	public void showText(UserAccountVO vo) {
		userNamejtf.setText(vo.getUserName());
		initialPasswordjtf.setText(vo.getInitialPassword());
		UserRole userRole = vo.getUserRole();
		switch(userRole) {
		case EXPRESSMAN:
			expressManrbt.setSelected(true);
			break;
		case OFFICEMAN:
			officeManrbt.setSelected(true);
			break;
		case TRANSITCENTERMAN:
			transitCenterManrbt.setSelected(true);
			break;
		case INVENTORYMAN:
			inventoryManrbt.setSelected(true);
			break;
		case MANAGER:
			managerrbt.setSelected(true);
			break;
		case ADFINANCEMAN:
			adFinanceManrbt.setSelected(true);
			break;
		default:
			geFinanceManrbt.setSelected(true);
			break;
		}
	}

}
