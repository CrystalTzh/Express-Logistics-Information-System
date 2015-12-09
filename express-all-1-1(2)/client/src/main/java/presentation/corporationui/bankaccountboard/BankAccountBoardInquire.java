/**
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.corporationui.bankaccountboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.corporationcontroller.BankAccountController;
import vo.BankAccountInfoVO;

/**
 *查询银行账户属性面板
 */
public class BankAccountBoardInquire extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField accountIDjtf, accountNamejtf, balancejtf;//银行账号、账户名和余额文本框
	JButton findButton;//查询按钮
	BankAccountController bankAccountController;

	public BankAccountBoardInquire(JFrame f) {
		super(f, "查询对话框", false);
		accountNamejtf = new JTextField(10);
		accountNamejtf.setEditable(false);
		balancejtf = new JTextField(10);
		balancejtf.setEditable(false);
		accountIDjtf = new JTextField(10);
		findButton = new JButton("查询");
		accountIDjtf.addActionListener(this);
		findButton.addActionListener(this);
		
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("银行账号信息查询", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.BLUE);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要查询的银行账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(findButton);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("账户名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(28));
		box2.add(accountNamejtf);
		box2.add(Box.createHorizontalStrut(20));
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("余额:", JLabel.CENTER));
		box3.add(Box.createHorizontalStrut(40));
		box3.add(balancejtf);
		box3.add(Box.createHorizontalStrut(5));
		box3.add(new JLabel("元", JLabel.CENTER));
		
		Box boxH = Box.createVerticalBox();
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box3);
		
		JPanel pCenter = new JPanel();
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		add(pCenter, BorderLayout.CENTER);
		setVisible(false);
		setBounds(100, 200, 360, 270);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println();
		clearText();
		
		if(e.getSource() == findButton 
			|| e.getSource() == accountIDjtf) {//1 点击了查询按钮或按下Enter键确认输入银行账号结束
			String number = "";
			number = accountIDjtf.getText();
			
			if(number.length() > 0) {//1.1 输入了银行账号
				BankAccountInfoVO vo;//用来接收查询得来的银行账户信息
				bankAccountController = new BankAccountController();
				vo = bankAccountController.findBankAccount(number);
				if(vo == null) {//1.1.1 输入的银行账号不存在
					String warning = "该银行账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输入的银行账号存在
					accountIDjtf.setText(vo.getAccountId());
					accountNamejtf.setText(vo.getAccountName());
					balancejtf.setText(String.valueOf(vo.getBalance()));
				}
			}else {//1.2 没有输入银行账号
				String warning = "必须要输入银行账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.out.println();
		
	}
	
	public void clearText() {
		accountNamejtf.setText(null);
		balancejtf.setText(null);
	}

}
