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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.constcontroller.SalaryInfoController;
import vo.SalaryVO;

/**
 * 更新薪资标准面板
 */
public class SalaryModifyBoard extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JTextField receiveOrderBonusjtf, sendOrderBonusjtf, driverInCityPayjtf, 
	driverOutCityPayjtf, officeManSalaryjtf;//快递员揽件提成、快递员派件提成、司机市内计次、司机跨市计次和业务员月薪文本框
	JButton savebt, cancelbt;// 保存、取消按钮
	SalaryInfoController salaryInfoController = new SalaryInfoController();;
	
	public SalaryModifyBoard() {
		
		receiveOrderBonusjtf = new JTextField(10);
		sendOrderBonusjtf = new JTextField(10);
		driverInCityPayjtf = new JTextField(10);
		driverOutCityPayjtf = new JTextField(10);
		officeManSalaryjtf = new JTextField(10);
		
		savebt = new JButton("保存");
		cancelbt = new JButton("取消");
		savebt.setContentAreaFilled(false);
		cancelbt.setContentAreaFilled(false);
		savebt.addActionListener(this);
		cancelbt.addActionListener(this);
		
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
		box3.add(driverInCityPayjtf);
		box3.add(new JLabel("元/次", JLabel.CENTER));
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("司机跨市计次:"));
		box4.add(Box.createHorizontalStrut(10));
		box4.add(driverOutCityPayjtf);
		box4.add(new JLabel("元/次", JLabel.CENTER));
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("业务员月薪:"));
		box5.add(Box.createHorizontalStrut(20));
		box5.add(officeManSalaryjtf);
		box5.add(new JLabel("元/月", JLabel.CENTER));
		
		showBasicInfo();
		
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
		pSouth.add(savebt);
		pSouth.add(cancelbt);
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
		if(e.getSource() == savebt) {//1 点击了保存按钮
			SalaryVO voToModify = this.wrappVO();
			salaryInfoController.modifySalaryInfo(voToModify);//修改薪资标准
			String m = "修改成功!";
			JOptionPane.showMessageDialog(this, m, "提示", JOptionPane.INFORMATION_MESSAGE);
			System.exit(0);
		}
		
		if(e.getSource() == cancelbt) {//2 点击了取消按钮
			//关闭窗口
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new SalaryModifyBoard();
	}
	
	/**
	 * 在面板上显示薪资标准的基本信息
	 */
	public void showBasicInfo() {
		//获取薪资标准信息
		SalaryVO vo = salaryInfoController.findSalayInfo();
		receiveOrderBonusjtf.setText(vo.getReceiveOrderBonus());
		sendOrderBonusjtf.setText(vo.getSendOrderBonus());
		driverInCityPayjtf.setText(vo.getDriverInCityPay());
		driverOutCityPayjtf.setText(vo.getDriverOutCityPay());
		officeManSalaryjtf.setText(vo.getOfficeManSalary());
	}

	/**
	 * 将面板基本信息包装为VO
	 * @return
	 */
	public SalaryVO wrappVO() {
		//获取面板基本信息
		String receiveOrderBonus = receiveOrderBonusjtf.getText();
		String sendOrderBonus = sendOrderBonusjtf.getText();
		String driverInCityPay = driverInCityPayjtf.getText();
		String driverOutCityPay = driverOutCityPayjtf.getText();
		String officeManSalary = officeManSalaryjtf.getText();
		
		SalaryVO vo = new SalaryVO();
		vo.setSendOrderBonus(sendOrderBonus);
		vo.setReceiveOrderBonus(receiveOrderBonus);
		vo.setDriverInCityPay(driverInCityPay);
		vo.setDriverOutCityPay(driverOutCityPay);
		vo.setOfficeManSalary(officeManSalary);
		
		return vo;
	}

}
