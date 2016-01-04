/**
 * 
 * @author 谭琼
 * 2015年11月25日
 */
package presentation.userui.loginui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controller.UserID;
import controller.usercontroller.UserAccountController;
import presentation.mainui.MainFrame;
import state.UserRole;
import vo.UserAccountVO;

/**
 * 登录面板
 */
public class LoginBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField accountIdjtf;// 用户账号文本框
	JPasswordField passwordjpf;// 密码框
	JLabel accountIDjl, passwordjl, logojl;
	JButton loginbt, cancelbt;// 登录、取消按钮
	UserAccountController userAccountController;

	public LoginBoard() {
		userAccountController = new UserAccountController();

		accountIdjtf = new JTextField(15);
		passwordjpf = new JPasswordField(15);
		Font font = new Font("微软雅黑", Font.BOLD, 16);
		accountIDjl = new JLabel("账号：", JLabel.CENTER);
		accountIDjl.setFont(font);
		passwordjl = new JLabel("密码：", JLabel.CENTER);
		passwordjl.setFont(font);
		logojl = new JLabel("快递物流系统登录", JLabel.CENTER);
		logojl.setFont(new Font("微软雅黑", Font.BOLD, 32));
		logojl.setForeground(Color.DARK_GRAY);

		Font font2 = new Font("微软雅黑", Font.PLAIN, 14);
		loginbt = new JButton("登录");
		cancelbt = new JButton("取消");
		loginbt.setFont(font2);
		cancelbt.setFont(font2);
		loginbt.setForeground(Color.BLACK);
		cancelbt.setForeground(Color.BLACK);
		loginbt.addActionListener(this);
		cancelbt.addActionListener(this);
		passwordjpf.addActionListener(this);
		loginbt.setContentAreaFilled(false);
		cancelbt.setContentAreaFilled(false);

		Box box = Box.createHorizontalBox();
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(accountIDjl);
		box1.add(Box.createHorizontalStrut(10));
		box1.add(accountIdjtf);
		Box box2 = Box.createHorizontalBox();
		box2.add(passwordjl);
		box2.add(Box.createHorizontalStrut(10));
		box2.add(passwordjpf);
		Box box3 = Box.createHorizontalBox();
		box3.add(loginbt);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(cancelbt);

		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(50));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(50));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(30));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(40));
		boxH.add(box3);

		JPanel pCenter = new JPanel();
		pCenter.add(boxH);
		add(pCenter);

//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBounds(560, 250, 420, 380);
		validate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == loginbt || e.getSource() == passwordjpf) {// 1
																		// 点击了登录按钮按下Enter键确认输入用户密码结束
			String number = "";
			number = accountIdjtf.getText();

			if (number.length() > 0) {// 1.1 输入了用户账号
				UserAccountVO vo;// 用来接收查询得来的用户账号信息
				vo = userAccountController.findUserAccount(number);// 查找用户账号信息
				if (vo == null) {// 1.1.1 输入的用户账号不存在
					String warning = "该用户账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {// 1.1.2 输入的用户账号存在, 判断输入的密码是否正确
					String passwordStr = passwordTextToString(passwordjpf.getPassword());
					System.out.println("输入的密码: " + passwordStr);
					String passwordServer = vo.getPassword();
					System.out.println("数据库中的密码: " + passwordServer);
					if (passwordStr.equals(passwordServer)) {// 1.1.2.1 输入的密码正确
						String m = "Login successfully!";
						JOptionPane.showMessageDialog(this, m, "提示", JOptionPane.INFORMATION_MESSAGE);
					
						UserRole userrole =  vo.getUserRole();
						
						UserID.userid = number;
						
						this.setVisible(false);
						MainFrame.repainting(userrole);
						
					} else {// 1.1.2.2 输入的密码错误
						String error = "密码错误!";
						JOptionPane.showMessageDialog(this, error, "错误", JOptionPane.ERROR_MESSAGE);
					}
				}
			} else {// 1.2 没有输入的用户账号
				String warning = "必须要输入用户账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}

		if (e.getSource() == cancelbt) {// 2 点击了取消按钮
			System.exit(0);
		}
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
		new LoginBoard();
	}
}
