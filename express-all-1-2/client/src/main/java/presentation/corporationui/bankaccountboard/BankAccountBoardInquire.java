/**
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.corporationui.bankaccountboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.BankAccountController;
import controller.corporationcontroller.LogController;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.BankAccountInfoVO;
import vo.LogVO;

/**
 * 查询银行账户属性面板
 */
public class BankAccountBoardInquire extends JDialog implements ItemListener {

	private static final long serialVersionUID = 1L;
	JTextField accountNamejtf, balancejtf;// 账户名和余额文本框
	@SuppressWarnings("rawtypes")
	JComboBox accountIDjcb;// 银行账号组合框
	BankAccountController bankAccountController;
	LogController logController;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BankAccountBoardInquire(JFrame f) {
		super(f, "查询对话框", false);
		bankAccountController = new BankAccountController();
		accountNamejtf = new JTextField(10);
		accountNamejtf.setEditable(false);
		balancejtf = new JTextField(10);
		balancejtf.setEditable(false);

		ArrayList<BankAccountInfoVO> allBankAccounts = bankAccountController.findAllBankAccounts();
		final String[] allBankAccountIDs = new String[allBankAccounts.size()+1];
		for (int i = 1; i <= allBankAccounts.size(); i++) {
			allBankAccountIDs[i] = allBankAccounts.get(i-1).getAccountId();
		}
		accountIDjcb = new JComboBox(allBankAccountIDs);
		accountIDjcb.addItemListener(this);

		Box box = Box.createHorizontalBox();
		JLabel logojl = new JLabel("银行账号信息查询", JLabel.CENTER);
		logojl.setFont(new Font("TimesRoman", Font.BOLD, 24));
		logojl.setForeground(Color.DARK_GRAY);
		box.add(logojl);
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("选择要查询的银行账号:", JLabel.CENTER));
		box1.add(accountIDjcb);
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

	public void clearText() {
		accountNamejtf.setText(null);
		balancejtf.setText(null);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent e) {
		clearText();
		if(e.getSource() == accountIDjcb.getItemAt(0)) {
			System.out.println("选择为空");
			accountNamejtf.setText(null);
			balancejtf.setText(null);
			return;
		}
		String number = (String) accountIDjcb.getSelectedItem();
		BankAccountInfoVO vo = bankAccountController.findBankAccount(number);
		//添加一条日志
		logController = new LogController();
		LogVO logToAdd = new LogVO();
		logToAdd.setOperation(Operation.FIND);
		logToAdd.setOperationObject(OperationObject.BankAccountInfo);
		logToAdd.setOperationTime(new GregorianCalendar());
		logToAdd.setOperatorID(UserID.userid);
		logToAdd.setOperatorRole(UserRole.ADFINANCEMAN);
		logController.addLog(logToAdd);// 添加一条日志
		accountNamejtf.setText(vo.getAccountName());
		balancejtf.setText(String.valueOf(vo.getBalance()));
	}

}
