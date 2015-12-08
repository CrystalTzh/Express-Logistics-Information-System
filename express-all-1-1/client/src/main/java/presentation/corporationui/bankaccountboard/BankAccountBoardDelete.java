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

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.corporationController.BankAccountController;
import vo.BankAccountInfoVO;

/**
 *删除银行账户面板
 */
public class BankAccountBoardDelete extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JTextField accountIDjtf, accountNamejtf, balancejtf;//银行账号、账户名和余额文本框
	JButton deletebt;//删除按钮
	BankAccountController bankAccountController;

	public BankAccountBoardDelete() {
		accountNamejtf = new JTextField(10);
		accountNamejtf.setEditable(false);
		balancejtf = new JTextField(10);
		balancejtf.setEditable(false);
		accountIDjtf = new JTextField(10);
		deletebt = new JButton("删除");
		accountIDjtf.addActionListener(this);
		deletebt.addActionListener(this);
		
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("银行账号信息删除", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.BLUE);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要删除的银行账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(deletebt);
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
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box);
		boxH.add(Box.createVerticalStrut(40));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box3);
		
		JPanel pCenter = new JPanel();
		pCenter.add(boxH);
		JScrollPane scrollPane = new JScrollPane(pCenter);
		setLayout(new BorderLayout());
		add(scrollPane, BorderLayout.CENTER);
		validate();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if(e.getSource() == deletebt
			|| e.getSource() == accountIDjtf) {//1 点击了删除按钮或Enter键确认输入银行账号完成
			String number = "";
			number = accountIDjtf.getText();
			
			if(number.length() > 0) {//1.1 输入了银行账号
				BankAccountInfoVO vo = null;
				bankAccountController = new BankAccountController();
				vo = bankAccountController.findBankAccount(number);//查找银行账号信息
				if(vo != null) {//1.1.1 输入的银行账号存在
					//显示银行账号基本信息
					accountIDjtf.setText(vo.getAccountId());
					accountNamejtf.setText(vo.getAccountName());
					balancejtf.setText(String.valueOf(vo.getBalance()));
					
					String m = "确定要删除该银行账号及全部信息吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION);
					if(ok == JOptionPane.YES_OPTION) {//1.1.1.1 确认删除
						bankAccountController.deleteAccount(vo);//删除银行账号信息
						clearText();
					}
				} else {//1.1.2 输入的银行账号不存在
					String warning = "该银行账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {// 1.2 没有输入银行账号
				String warning = "必须要输入银行账号!";
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
		accountNamejtf.setText(null);
		balancejtf.setText(null);
	}

}
