/**
 * @author 谭琼
 * 2015年12月6日
 */
package presentation.userui.modifypasswordui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import controller.userController.UserAccountController;
import vo.UserAccountVO;

/**
 * 修改密码面板
 */
public class ModifyPasswordBoard extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	// 原始密码、新密码、确认新密码密码框
	JPasswordField oldPasswordjpf, newPasswordjpf, confirmPasswordjpf;
	UserAccountController userAccountController;
	JButton savebt, resetbt;// 确认、重置按钮
	String accountID;

	public ModifyPasswordBoard(JFrame f, String accountID) {
		// 指定对话框的所有者、标题、模式,模式为false代表对话框与所属窗口可以互相切换，彼此之间在操作上没有顺序性
		super(f, false);

		userAccountController = new UserAccountController();
		
		this.accountID = accountID;

		Font font1 = new Font("Comic Sans MS", Font.BOLD, 16);
		Font font2 = new Font("TimesRoman", Font.BOLD, 28);
		Font font3 = new Font("TimesRoman", Font.PLAIN, 14);

		oldPasswordjpf = new JPasswordField(15);
		newPasswordjpf = new JPasswordField(15);
		confirmPasswordjpf = new JPasswordField(15);

		savebt = new JButton("保存");
		savebt.setFont(font3);
		resetbt = new JButton("重置");
		resetbt.setFont(font3);
		savebt.addActionListener(this);
		resetbt.addActionListener(this);

		Box box = Box.createHorizontalBox();

		JLabel modifyjl = new JLabel("修改密码");
		modifyjl.setFont(font2);
		modifyjl.setForeground(Color.GRAY);
		box.add(modifyjl);
		Box box1 = Box.createHorizontalBox();
		JLabel oldpasswordjl = new JLabel("原始密码:", JLabel.CENTER);
		oldpasswordjl.setFont(font1);
		box1.add(oldpasswordjl);
		box1.add(Box.createHorizontalStrut(15));
		box1.add(oldPasswordjpf);
		Box box2 = Box.createHorizontalBox();
		JLabel newPasswordjl = new JLabel("新密码:", JLabel.CENTER);
		newPasswordjl.setFont(font1);
		box2.add(newPasswordjl);
		box2.add(Box.createHorizontalStrut(31));
		box2.add(newPasswordjpf);
		Box box3 = Box.createHorizontalBox();
		JLabel confirmPasswordjl = new JLabel("确认新密码:", JLabel.CENTER);
		confirmPasswordjl.setFont(font1);
		box3.add(confirmPasswordjl);
		box3.add(confirmPasswordjpf);
		Box box4 = Box.createHorizontalBox();
		box4.add(savebt);
		box4.add(resetbt);

		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box4);

		JPanel pCenter = new JPanel();
		pCenter.add(boxH);

		// 添加主要的信息界面在中央
		this.add(pCenter, BorderLayout.CENTER);
		this.validate();
		setVisible(false);
		setBounds(100, 200, 387, 270);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == savebt) {// 1. 点击了保存按钮
			String oldPassword = "";
			oldPassword = this.passwordTextToString(oldPasswordjpf.getPassword());
			if (oldPassword.length() > 0) {// 1.1 输入了原始密码
				String newPassword = "";
				newPassword = this.passwordTextToString(newPasswordjpf.getPassword());
				String confirmPassword = "";
				confirmPassword = this.passwordTextToString(confirmPasswordjpf.getPassword());
				boolean enteredNewPassword = newPassword.length() > 0;
				boolean enteredConfirmPassword = confirmPassword.length() > 0;
				if (enteredNewPassword && enteredConfirmPassword) {// 1.1.1.1
																	// 输入了新密码和确认新密码
					handleCompleInput(oldPassword, newPassword, confirmPassword);
				} else if (enteredNewPassword && !enteredConfirmPassword) {// 1.1.1.2
																			// 输入新密码，未输入确认新密码
					String warning = "您两次输入的密码不一致, 请重新输入!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					clearText2();
				} else {// 1.1.2 未输入新密码【提示输入新密码】
					String warning = "未输入新密码!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {// 1.2 未输入原始密码
				String warning = "未输入原始密码!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == resetbt) {// 2. 点击了重置按钮
			clearText1();
		}
	}

	/**
	 * 比对输入的原始密码、新密码和确认新密码并进行相应处理
	 * @param oldPassword
	 * @param newPassword
	 * @param confirmPassword
	 */
	public void handleCompleInput(String oldPassword, String newPassword, String confirmPassword) {
		// 比对原始密码
		UserAccountVO vo = userAccountController.findUserAccount(accountID);
		boolean oldPasswordIsValid = oldPassword.equals(vo.getPassword());
			
		if(oldPasswordIsValid) {//1 原始密码正确
			if(newPassword.equals(confirmPassword)) {//1.1 新密码和确认新密码一致
				//修改密码并写入数据层
				vo.setPassword(newPassword);
				userAccountController.mofifyUserAccount(vo);
				String m = "修改密码成功!";
				JOptionPane.showMessageDialog(this, m, "提示", JOptionPane.INFORMATION_MESSAGE);
				clearText1();
			} else {//1.2 不一致
				String warning = "您两次输入的密码不一致, 请重新输入!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				clearText2();
			}
		} else {//2 原始密码不正确
			String error = "旧密码错误, 修改失败!";
			JOptionPane.showMessageDialog(this, error, "错误", JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * 清空整个面板
	 */
	public void clearText1() {
		oldPasswordjpf.setText(null);
		newPasswordjpf.setText(null);
		confirmPasswordjpf.setText(null);
	}

	/**
	 * 清空面板但不清空输入的原始密码
	 */
	public void clearText2() {
		newPasswordjpf.setText(null);
		confirmPasswordjpf.setText(null);
	}
	
	/**
	 * 将密码的char数组转换为String
	 * 
	 * @param password
	 * @return
	 */
	public String passwordTextToString(char[] password) {
		int len = password.length;
		String pass = "";
		for (int i = 0; i < len; i++) {
			pass += password[i];
		}
		return pass;
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		Font font = new Font("Comic Sans MS", Font.BOLD, 16);
		JLabel label = new JLabel("Modify Password", JLabel.CENTER);
		label.setFont(font);
		final ModifyPasswordBoard modifyPasswordBoard = new ModifyPasswordBoard(frame, "141250122");

		frame.add(label, BorderLayout.CENTER);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		label.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				modifyPasswordBoard.setVisible(true);
			}

			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

		});
	}
}
