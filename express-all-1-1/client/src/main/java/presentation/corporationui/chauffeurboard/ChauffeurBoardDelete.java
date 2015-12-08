package presentation.corporationui.chauffeurboard;

import java.awt.BorderLayout;
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

import controller.corporationController.DriverInfoController;
import state.SexList;
import vo.DriverInfoVO;

public class ChauffeurBoardDelete extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField driverNumber, name, idcard, cellphone, birthday;
	JTextField licensedate;
	JRadioButton manrbt, womanrbt;
	JButton deletebt;
	ButtonGroup group = null;
	DriverInfoController driverInfoController;

	public ChauffeurBoardDelete() {
		//初始化文本框、按钮等组件
		driverNumber = new JTextField(10);
		deletebt = new JButton("删除");
		//监听driverNumber文本框和删除按钮
		driverNumber.addActionListener(this);
		deletebt.addActionListener(this);
		name = new JTextField(10);
		name.setEditable(false);
		idcard = new JTextField(10);
		idcard.setEditable(false);
		cellphone = new JTextField(10);
		cellphone.setEditable(false);
		birthday = new JTextField(10);
		birthday.setEditable(false);
		licensedate = new JTextField(10);
		licensedate.setEditable(false);
		manrbt = new JRadioButton("男", false);
		womanrbt = new JRadioButton("女", false);
		group = new ButtonGroup();
		group.add(manrbt);
		group.add(womanrbt);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要删除的司机编号:", JLabel.CENTER));
		box1.add(driverNumber);
		box1.add(deletebt);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(37));
		box2.add(name);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("性别:", JLabel.LEFT));
		box3.add(manrbt);
		box3.add(womanrbt);
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("身份证号:", JLabel.CENTER));
		box4.add(Box.createHorizontalStrut(12));
		box4.add(idcard);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("手机号码:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(cellphone);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("出生日期:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(birthday);
		Box box7 = Box.createHorizontalBox();
		box7.add(new JLabel("行驶证期限:", JLabel.CENTER));
		box7.add(licensedate);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(20));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box4);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box6);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box7);
		
//		Box box8 = Box.createHorizontalBox();
//		box8.add(new JLabel("行驶证期限2:", JLabel.CENTER));
//		box8.add(new JTextField(10));
//		Box box9 = Box.createHorizontalBox();
//		box9.add(new JLabel("行驶证期限3:", JLabel.CENTER));
//		box9.add(new JTextField(10));
//		Box box10 = Box.createHorizontalBox();
//		box10.add(new JLabel("行驶证期限4:", JLabel.CENTER));
//		box10.add(new JTextField(10));
//		Box box11 = Box.createHorizontalBox();
//		box11.add(new JLabel("行驶证期限5:", JLabel.CENTER));
//		box11.add(new JTextField(10));
//		Box box12 = Box.createHorizontalBox();
//		box12.add(new JLabel("行驶证期限6:", JLabel.CENTER));
//		box12.add(new JTextField(10));
//		Box box13 = Box.createHorizontalBox();
//		box13.add(new JLabel("行驶证期限7:", JLabel.CENTER));
//		box13.add(new JTextField(10));
//		Box box14 = Box.createHorizontalBox();
//		box14.add(new JLabel("行驶证期限8:", JLabel.CENTER));
//		box14.add(new JTextField(10));
//		Box box15 = Box.createHorizontalBox();
//		box15.add(new JLabel("行驶证期限9:", JLabel.CENTER));
//		box15.add(new JTextField(10));
//		boxH.add(box8);
//		boxH.add(box9);
//		boxH.add(box10);
//		boxH.add(box11);
//		boxH.add(box12);
//		boxH.add(box13);
//		boxH.add(box14);
//		boxH.add(box15);
		
		JPanel pCenter;
		//JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		setLayout(new BorderLayout());
		//主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if (e.getSource() == deletebt 
				|| e.getSource() == driverNumber) {//1 点击了删除按钮或输入司机编号后按了enter
			String number = "";
			number = driverNumber.getText();

			if (number.length() > 0) {//1.1 输入了司机编号
				DriverInfoVO vo = null;
				driverInfoController = new DriverInfoController();
				vo = driverInfoController.findDriver(number);
				if(vo != null) {//1.1.1 输入的司机编号存在
					//显示基本信息
					name.setText(vo.getName());
					idcard.setText(vo.getIdcard());
					cellphone.setText(vo.getCellphone());
					birthday.setText(vo.getBirthday());
					licensedate.setText(vo.getLicensedate());
					if (vo.getSex() == SexList.MAN) {
						manrbt.setSelected(true);
					} else {
						womanrbt.setSelected(true);
					}
					
					String m = "确定要删除该司机编号及全部信息吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//1.1.1.1 点击了确认删除
						driverInfoController.deleteDriver(vo);//删除司机
						//清空面板
						clearText();
					}
					else if (ok == JOptionPane.NO_OPTION) {//1.1.1.2 取消删除，清空面板
						clearText();
					}
				}
				
			else {//1.1.2 输入的司机编号不存在
					String warning = "该司机编号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {//1.2 没有输入司机编号
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.out.println();
	}
	
	public void clearText() {
		driverNumber.setText(null);
		name.setText(null);
		idcard.setText(null);
		cellphone.setText(null);
		birthday.setText(null);
		licensedate.setText(null);
		manrbt.setSelected(true);
	}
}
