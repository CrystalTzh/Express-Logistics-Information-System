/**
 * 公司常量相关面板
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.constui.salaryboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 更新薪资标准面板
 */
public class SalaryModifyBoard extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField receiveOrderBonusjtf, sendOrderBonusjtf, driverInCityPay, 
	driverOutCityPay, officeManSalary;//快递员揽件提成、快递员派件提成、司机市内计次、司机跨市计次和业务员月薪文本框
	JButton modifybt, confirmModifybt;// 修改、确认修改按钮
	
	public SalaryModifyBoard() {
		receiveOrderBonusjtf = new JTextField(10);
		receiveOrderBonusjtf.setEditable(false);
		sendOrderBonusjtf = new JTextField(10);
		sendOrderBonusjtf.setEditable(false);
		driverInCityPay = new JTextField(10);
		driverInCityPay.setEditable(false);
		driverOutCityPay = new JTextField(10);
		driverOutCityPay.setEditable(false);
		officeManSalary = new JTextField(10);
		officeManSalary.setEditable(false);
		
		modifybt = new JButton("修改");
		confirmModifybt = new JButton("确认修改");
		confirmModifybt.setEnabled(false);
		modifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);
		
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("快递员揽件提成:"));
		box1.add(receiveOrderBonusjtf);
		box1.add(new JLabel("元/件", JLabel.CENTER));
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("快递员派件提成:"));
		box2.add(sendOrderBonusjtf);
		box2.add(new JLabel("元/件", JLabel.CENTER));
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("司机市内计次:"));
		box3.add(Box.createHorizontalStrut(10));
		box3.add(driverInCityPay);
		box3.add(new JLabel("元/次", JLabel.CENTER));
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("司机跨市计次:"));
		box4.add(Box.createHorizontalStrut(10));
		box4.add(driverOutCityPay);
		box4.add(new JLabel("元/次", JLabel.CENTER));
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("业务员月薪:"));
		box5.add(Box.createHorizontalStrut(20));
		box5.add(officeManSalary);
		box5.add(new JLabel("元/月", JLabel.CENTER));
		
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(30));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(30));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box4);
		boxH.add(Box.createVerticalStrut(30));
		boxH.add(box5);
		
		JPanel pCenter = new JPanel();
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		add(pCenter, BorderLayout.CENTER);
		
		JPanel pSouth = new JPanel();
		pSouth.add(modifybt);
		pSouth.add(confirmModifybt);
		add(pSouth, BorderLayout.SOUTH);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
		setBounds(560, 250, 420, 380);
		validate();
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		new SalaryModifyBoard();
	}

}
