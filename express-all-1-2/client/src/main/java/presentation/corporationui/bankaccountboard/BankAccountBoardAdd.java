/**
 * 银行账户相关面板
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.corporationui.bankaccountboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.corporationcontroller.BankAccountController;
import vo.BankAccountInfoVO;

/**
 * 增加银行账户面板
 */
public class BankAccountBoardAdd extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField accountIDjtf, accountNamejtf, balancejtf;// 银行账号、账户名和余额文本框
	JButton addButton, resetButton;// 添加，重置按钮
	BankAccountController bankAccountController;

	public BankAccountBoardAdd() {
		accountIDjtf = new JTextField(20);
		accountNamejtf = new JTextField(20);
		balancejtf = new JTextField(20);
		addButton = new JButton("录入");
		resetButton = new JButton("重置");

		addButton.addActionListener(this);
		resetButton.addActionListener(this);

		// 将对应的标签和文本框水平排列
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("银行账号信息录入", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.BLUE);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("银行账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(Box.createHorizontalStrut(22));
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("账户名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(13));
		box2.add(accountNamejtf);
		box2.add(Box.createHorizontalStrut(22));
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("账户余额:", JLabel.CENTER));
		box3.add(balancejtf);
		box3.add(Box.createHorizontalStrut(10));
		box3.add(new JLabel("元"));

		// 将水平框垂直排列
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(40));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box3);

		// 将主要的信息添加到面板中间
		JPanel pCenter = new JPanel();
		pCenter.add(boxH);
		JScrollPane scrollPane = new JScrollPane(pCenter);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);

		// 将两个按钮添加到面板下面
		JPanel pSouth = new JPanel();
		pSouth.add(addButton);
		pSouth.add(resetButton);
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
		if (e.getSource() == addButton) {// 1 点击了录入按钮
			String number = "";
			number = accountIDjtf.getText();
			if (number.length() > 0) {// 1.1 输入了银行账号
				BankAccountInfoVO vo = null;
				bankAccountController = new BankAccountController();
				vo = bankAccountController.findBankAccount(number);
				if (vo != null) {//1.1.1 输入的银行账号存在
					String warning = "该银行账号基本信息已存在，请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输入的银行账号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if(ok == JOptionPane.YES_OPTION) {//确认录入
						//包装BankAccountInfoVO
						String accountID = accountIDjtf.getText();
						String accountName = accountNamejtf.getText();
						String balanceStr = balancejtf.getText();
						double balance = Double.parseDouble(balanceStr);
						BankAccountInfoVO voToAdd = new BankAccountInfoVO();
						voToAdd.setAccountId(accountID);
						voToAdd.setAccountName(accountName);
						voToAdd.setBalance(balance);
						bankAccountController.addBankAccount(voToAdd);//添加银行账户
					}//录入结束
				}
			} else {//1.2 未输入银行账号
				String warning = "必须要输入银行账户!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource() == resetButton) {//2 点击了重置按钮
			textClear();
		}
		System.out.println();
	}
	
	public void textClear() {
		accountIDjtf.setText(null);
		accountNamejtf.setText(null);
		balancejtf.setText(null);
	}
	
}
