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

public class UserAccountBoardAdd extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 账号、用户名、初始密码
	JTextField accountIDjtf, userNamejtf, initialPasswordjtf;
	// 职位:快递员、营业厅业务员、中转中心业务员
	// 仓库管理人员、总经理、高级财务人员、普通财务人员
	JRadioButton expressManrbt, officeManrbt, transitCenterManrbt, inventoryManrbt, managerrbt, adFinanceManrbt,
			geFinanceManrbt,administratorbt;
	ButtonGroup group = null;
	JButton addButton, resetButton;
	UserAccountController userAccountController;

	public UserAccountBoardAdd() {
		userAccountController = new UserAccountController();
		
		// 初始化文本框、按钮等组件
		accountIDjtf = new JTextField(10);
		userNamejtf = new JTextField(10);
		initialPasswordjtf = new JTextField(10);
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
		addButton = new JButton("录入");
		resetButton = new JButton("重置");
		// 监听录入和重置按钮
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		// 水平显示组件
		// 将对应的标签和文本框水平排列
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("用户账号信息录入", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.DARK_GRAY);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("账号:", JLabel.CENTER));
		box1.add(Box.createHorizontalStrut(25));
		box1.add(accountIDjtf);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("用户名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(12));
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
		
		// box43 放置总经理、高级财务人员，管理员
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
		boxH.add(Box.createVerticalStrut(15));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(15));
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
		JPanel pSouth = new JPanel();
		pSouth.add(addButton);
		pSouth.add(resetButton);
		// 两个按钮显示在南边
		add(pSouth, BorderLayout.SOUTH);
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
		if(e.getSource() == addButton) {//1 点击了录入按钮
			String number = "";
			number = accountIDjtf.getText();
			if(number.length() > 0) {//1.1 输入了用户账号
				UserAccountVO vo = null;
				userAccountController = new UserAccountController();
				vo = userAccountController.findUserAccount(number);
				if(vo != null) {//1.1.1 输入的用户账号已存在
					String warning = "该用户账号基本已存在，请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输入的用户账号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION);
					if(ok == JOptionPane.YES_OPTION) {//确认录入
						UserAccountVO voToAdd = this.wrappVO();
						userAccountController.addUserAccount(voToAdd);//添加用户账户信息
					}
				}
			} else {//1.2 未输入用户账号
				String warning = "必须要输入用户账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource() == resetButton) {//2 点击了重置按钮
			clearText();
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
	 * 从面板获取基本信息包装为UserAccountVO
	 * @return
	 */
	public UserAccountVO wrappVO() {
		UserAccountVO voToAdd = new UserAccountVO();
		String accountID = accountIDjtf.getText();
		String initialPassword = initialPasswordjtf.getText();
		String userName = userNamejtf.getText();
		UserRole userRole = null;
		//读入userRole的值
		if(expressManrbt.isSelected()) {
			userRole = UserRole.EXPRESSMAN;
		} else if(officeManrbt.isSelected()) {
			userRole = UserRole.OFFICEMAN;
		} else if(transitCenterManrbt.isSelected()) {
			userRole = UserRole.TRANSITCENTERMAN;
		} else if(inventoryManrbt.isSelected()) {
			userRole = UserRole.INVENTORYMAN;
		} else if(managerrbt.isSelected()) {
			userRole = UserRole.MANAGER;
		} else if(adFinanceManrbt.isSelected()) {
			userRole = UserRole.ADFINANCEMAN;
		} else if(geFinanceManrbt.isSelected()) {
			userRole = UserRole.GEFINACEMAN;
		}
		voToAdd.setAccountID(accountID);
		voToAdd.setInitialPassword(initialPassword);
		voToAdd.setPassword(initialPassword);
		voToAdd.setUserName(userName);
		voToAdd.setUserRole(userRole);
		
		return voToAdd;
		
	}
}
