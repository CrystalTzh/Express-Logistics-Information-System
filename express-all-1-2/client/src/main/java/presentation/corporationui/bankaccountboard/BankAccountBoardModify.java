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
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.BankAccountController;
import controller.corporationcontroller.LogController;
import presentation.handleexception.numberexceptionhandle.BankAccountIDHandle;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.BankAccountInfoVO;
import vo.LogVO;

/**
 *修改银行账户属性面板
 */
public class BankAccountBoardModify extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField accountIDjtf, balancejtf, newAccountNamejtf;//银行账号、余额、新账户名文本框
	JButton beginModifybt, confirmModifybt, resetbt;//开始修改、确认修改、重置按钮
	BankAccountController bankAccountController;
	LogController logController;
	
	public BankAccountBoardModify() {
		bankAccountController = new BankAccountController();
		
		accountIDjtf = new  JTextField(10);
		balancejtf = new JTextField(10);
		newAccountNamejtf = new JTextField(10);
		balancejtf.setEditable(false);
		
		beginModifybt = new JButton("开始修改");
		beginModifybt.setContentAreaFilled(false);
		confirmModifybt = new JButton("确认修改");	
		confirmModifybt.setContentAreaFilled(false);
		resetbt = new JButton("重置");
		resetbt.setContentAreaFilled(false);
		
		accountIDjtf.addActionListener(this);
		beginModifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);
		resetbt.addActionListener(this);
		
		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("银行账号信息修改", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.DARK_GRAY);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要修改的银行账号:", JLabel.CENTER));
		box1.add(accountIDjtf);
		box1.add(beginModifybt);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("(新)账户名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(35));
		box2.add(newAccountNamejtf);
		box2.add(Box.createHorizontalStrut(20));
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("余额:", JLabel.CENTER));
		box3.add(Box.createHorizontalStrut(70));
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
		JScrollPane scollPane = new JScrollPane(pCenter);
		setLayout(new BorderLayout());
		add(scollPane, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.add(confirmModifybt);
		pSouth.add(resetbt);
		add(pSouth, BorderLayout.SOUTH);
	}
	
	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if(e.getSource() == beginModifybt
				|| e.getSource() == accountIDjtf) {//1 点击开始修改或按Enter键确认银行账号输入完成
			String number = "";
			number = accountIDjtf.getText();
			
			if(number.length() > 0) {//1.1 输入了银行账号，判断是否可以修改
				BankAccountIDHandle bankAccountIDHandle = new BankAccountIDHandle();
				if(!bankAccountIDHandle.handle(this, accountIDjtf)) {//判断是否输入了合法的银行账号，如不合法处理异常
					return;
				}
				BankAccountInfoVO vo = this.find(number);
				if(vo != null) {//1.1.1 输入的银行账号存在
					confirmModifybt.setEnabled(true);//可以修改
					//显示基本信息
					this.showText(vo);
				} else {//1.1.2 输入的银行账号不存在
					confirmModifybt.setEnabled(false);//不可修改
					String warning = "该银行账号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					clearText();
				}
			} else {//1.2 没有输入银行账号
				confirmModifybt.setEnabled(false);//不可修改
				String warning = "必须要输入银行账号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				clearText();
			}
		} else if(e.getSource() == confirmModifybt) {//2 点击了确认修改按钮
			String number = "";
			number = accountIDjtf.getText();
			if(number.length() > 0) {//2.1 输入了银行账号
				BankAccountInfoVO vo = this.find(number);
				if(vo != null) {//2.1.1 输入的银行账号存在
					String question = "该银行账号基本信息已存在,您想修改它的基本信息吗?";
					JOptionPane.showMessageDialog(this, question, "警告", JOptionPane.QUESTION_MESSAGE);
					String m = "基本信息将被修改!";	
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//2.1.1.1 确认修改
						BankAccountInfoVO voToModify = this.wrappVO();
						bankAccountController.modifyBankAccount(voToModify);//修改银行账户信息
						//添加一条日志
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.MODIFY);
						logToAdd.setOperationObject(OperationObject.BankAccountInfo);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.ADFINANCEMAN);
						logController.addLog(logToAdd);// 添加一条日志
						confirmModifybt.setEnabled(false);
					}
				} else {//2.1.2 输入的银行账号不存在
					String warning = "该银行账号没有基本信息,不能修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					confirmModifybt.setEnabled(false);
				}
			} else {//2.2 未输入银行账号
				String warning = "必须要输入银行账号!";
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
		newAccountNamejtf.setText(null);
		balancejtf.setText(null);
	}
	
	/**
	 * 显示基本信息
	 * @param vo
	 */
	public void showText(BankAccountInfoVO vo) {
		newAccountNamejtf.setText(vo.getAccountName());
		balancejtf.setText(String.valueOf(vo.getBalance()));
	}
	
	/**
	 * 从面板获取基本信息包装为BankAccountInfoVO
	 * @param number
	 * @return
	 */
	public BankAccountInfoVO wrappVO() {
		BankAccountInfoVO voToModify = new BankAccountInfoVO();
		voToModify.setAccountId(accountIDjtf.getText());
		voToModify.setAccountName(newAccountNamejtf.getText());
		voToModify.setBalance(Double.parseDouble(balancejtf.getText()));
		return voToModify;
	}
	
	/**
	 * 根据银行账号查找银行账户信息
	 * @param accountID
	 * @return
	 */
	public BankAccountInfoVO find(String number) {
		BankAccountInfoVO vo = null;
		vo = bankAccountController.findBankAccount(number);//查找银行账号
		return vo;
	}

}
