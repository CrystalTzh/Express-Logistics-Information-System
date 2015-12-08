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

import controller.usercontroller.UserAccountController;
import state.UserRole;
import vo.UserAccountVO;

public class UserAccountBoardModify extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 账号、用户名、初始密码
	JTextField accountIDjtf, userNamejtf, initialPasswordjtf;
	UserAccountController userAccountController;
	JButton beginModifybt, confirmModifybt, resetbt;
	// 职位:快递员、营业厅业务员、中转中心业务员
	// 仓库管理人员、总经理、高级财务人员、普通财务人员
	JRadioButton expressManrbt, officeManrbt, transitCenterManrbt, inventoryManrbt, managerrbt, adFinanceManrbt,
			geFinanceManrbt;
	ButtonGroup group = null;

	public UserAccountBoardModify() {
		
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
		group.add(expressManrbt);
		group.add(officeManrbt);
		group.add(transitCenterManrbt);
		group.add(inventoryManrbt);
		group.add(managerrbt);
		group.add(adFinanceManrbt);
		group.add(geFinanceManrbt);

		beginModifybt = new JButton("开始修改");
		confirmModifybt = new JButton("录入修改");
		confirmModifybt.setEnabled(false);
		resetbt = new JButton("重置");
		// 监听账号文本框、开始修改按钮、确认修改按钮和重置按钮
		accountIDjtf.addActionListener(this);
		beginModifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);
		resetbt.addActionListener(this);
		// 水平显示组件
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("用户账号信息修改", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.BLUE);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要修改信息的账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(beginModifybt);
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
		// box43 放置总经理、高级财务人员
		Box box43 = Box.createHorizontalBox();
		box43.add(managerrbt);
		box43.add(Box.createHorizontalStrut(66));
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

		// 确认修改按钮和重置按钮显示在南边
		JPanel pSouth = new JPanel();
		pSouth.add(confirmModifybt);
		pSouth.add(resetbt);
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
		if(e.getSource() == beginModifybt
				|| e.getSource() == accountIDjtf) {//1 点击开始修改或按Enter键确认用户账号输入完成
			String number = "";
			number = accountIDjtf.getText();
			
			if(number.length() > 0) {//1.1 输入了用户账号，判断是否可以修改
				UserAccountVO vo = this.find(number);
				if(vo != null) {//1.1.1 输入的用户账号存在
					confirmModifybt.setEnabled(true);//可以修改
					//显示基本信息
					this.showText(vo);
				} else {//1.1.2 输入的用户账号不存在
					confirmModifybt.setEnabled(false);//不可修改
					String warning = "该用户账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					clearText();
				}
			} else {//1.2 没有输入用户账号
				confirmModifybt.setEnabled(false);//不可修改
				String warning = "必须要用户银行账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				clearText();
			}
		} else if(e.getSource() == confirmModifybt) {//2 点击了确认修改按钮
			String number = "";
			number = accountIDjtf.getText();
			if(number.length() > 0) {//2.1 输入了用户账号
				UserAccountVO vo = this.find(number);
				if(vo != null) {//2.1.1 输入的用户账号存在
					String question = "该用户账号基本信息已存在,您想修改它的基本信息吗?";
					JOptionPane.showMessageDialog(this, question, "警告", JOptionPane.QUESTION_MESSAGE);
					String m = "基本信息将被修改!";	
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//2.1.1.1 确认修改
						UserAccountVO voToModify = this.wrappVO();
						userAccountController.mofifyUserAccount(voToModify);//修改用户账号信息
						confirmModifybt.setEnabled(false);
					}
				} else {//2.1.2 输入的用户账号不存在
					String warning = "该用户账号没有基本信息,不能修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					confirmModifybt.setEnabled(false);
				}
			} else {//2.2 未输入用户账号
				String warning = "必须要输入用户账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				confirmModifybt.setEnabled(false);
			}
		}
		//3 点击了重置按钮
		if(e.getSource() == resetbt) {
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
		case OFFICEMAN:
			expressManrbt.setSelected(true);
		case TRANSITCENTERMAN:
			transitCenterManrbt.setSelected(true);
		case INVENTORYMAN:
			inventoryManrbt.setSelected(true);
		case MANAGER:
			managerrbt.setSelected(true);
		case ADFINANCEMAN:
			adFinanceManrbt.setSelected(true);
		case GEFINACEMAN:
			geFinanceManrbt.setSelected(true);
		}
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
	
	/**
	 * 根据用户账号查找账户信息
	 * @param number
	 * @return
	 */
	public UserAccountVO find(String number) {
		UserAccountVO vo = null;
		vo = userAccountController.findUserAccount(number);
		return vo;
	}
}
