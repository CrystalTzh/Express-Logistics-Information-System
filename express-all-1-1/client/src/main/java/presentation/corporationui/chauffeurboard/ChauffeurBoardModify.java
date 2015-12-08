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

import controller.corporationcontroller.DriverInfoController;
import state.SexList;
import vo.DriverInfoVO;

public class ChauffeurBoardModify extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField driverNumberjtf, namejtf, idcardjtf, cellphonejtf, birthdayjtf, licensedatejtf;
	JRadioButton manrbt, womanrbt;
	ButtonGroup group = null;
	JButton beginModifybt, confirmModifybt, resetbt;
	DriverInfoController driverInfoController;

	public ChauffeurBoardModify() {
		// 初始化文本框、按钮等组件
		driverNumberjtf = new JTextField(10);
		namejtf = new JTextField(10);
		idcardjtf = new JTextField(10);
		cellphonejtf = new JTextField(10);
		birthdayjtf = new JTextField(10);
		licensedatejtf = new JTextField(10);
		group = new ButtonGroup();
		manrbt = new JRadioButton("男", true);
		womanrbt = new JRadioButton("女", false);
		group.add(manrbt);
		group.add(womanrbt);
		beginModifybt = new JButton("开始修改");
		confirmModifybt = new JButton("录入修改");
		confirmModifybt.setEnabled(false);
		resetbt = new JButton("重置");
		// 监听司机编号文本框、开始修改按钮、确认修改按钮和重置按钮
		driverNumberjtf.addActionListener(this);
		beginModifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);
		resetbt.addActionListener(this);
		// 水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要修改信息的司机编号:", JLabel.CENTER));
		box1.add(driverNumberjtf);
		box1.add(beginModifybt);// 开始修改按钮
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("(新)姓名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(37));
		box2.add(namejtf);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("(新)性别:", JLabel.CENTER));
		box3.add(manrbt);
		box3.add(womanrbt);
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("(新)身份证号:", JLabel.CENTER));
		box4.add(Box.createHorizontalStrut(12));
		box4.add(idcardjtf);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("(新)手机号码:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(cellphonejtf);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("(新)出生日期:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(birthdayjtf);
		Box box7 = Box.createHorizontalBox();
		box7.add(new JLabel("(新)行驶证期限:", JLabel.CENTER));
		box7.add(licensedatejtf);

		// 垂直显示组件
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

		// Box box8 = Box.createHorizontalBox();
		// box8.add(new JLabel("行驶证期限2:", JLabel.CENTER));
		// box8.add(new JTextField(10));
		// Box box9 = Box.createHorizontalBox();
		// box9.add(new JLabel("行驶证期限3:", JLabel.CENTER));
		// box9.add(new JTextField(10));
		// Box box10 = Box.createHorizontalBox();
		// box10.add(new JLabel("行驶证期限4:", JLabel.CENTER));
		// box10.add(new JTextField(10));
		// Box box11 = Box.createHorizontalBox();
		// box11.add(new JLabel("行驶证期限5:", JLabel.CENTER));
		// box11.add(new JTextField(10));
		// Box box12 = Box.createHorizontalBox();
		// box12.add(new JLabel("行驶证期限6:", JLabel.CENTER));
		// box12.add(new JTextField(10));
		// boxH.add(box8);
		// boxH.add(box9);
		// boxH.add(box10);
		// boxH.add(box11);
		// boxH.add(box12);

		JPanel pCenter;
		// JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);

		setLayout(new BorderLayout());
		// 主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);

		// 确认修改按钮和重置按钮显示在南边
		JPanel pSouth = new JPanel();
		pSouth.add(confirmModifybt);
		pSouth.add(resetbt);
		add(pSouth, BorderLayout.SOUTH);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if (e.getSource() == beginModifybt || 
				e.getSource() == driverNumberjtf) {//1 点击开始修改按钮或输入司机编号后按了enter
			String number = "";
			number = driverNumberjtf.getText();

			if (number.length() > 0) {// 1.1 输入了司机编号，判断是否可以修改
				DriverInfoVO vo = null;
				driverInfoController = new DriverInfoController();
				vo = driverInfoController.findDriver(number);
				if (vo != null) {// 1.1.1 输入的司机编号存在
					confirmModifybt.setEnabled(true);// 可以修改
					// 显示基本信息
					namejtf.setText(vo.getName());
					idcardjtf.setText(vo.getIdcard());
					cellphonejtf.setText(vo.getCellphone());
					birthdayjtf.setText(vo.getBirthday());
					licensedatejtf.setText(vo.getLicensedate());
					if (vo.getSex() == SexList.MAN) {
						manrbt.setSelected(true);
					} else {
						womanrbt.setSelected(true);
					}
				} else {// 1.1.2 输入的司机编号不存在
					confirmModifybt.setEnabled(false);// 不可修改
					String warning = "该司机编号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					clearText();
				}
			} else {// 1.2 没有输入司机编号
				confirmModifybt.setEnabled(false);// 不可修改
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				clearText();
			}
		} else if (e.getSource() == confirmModifybt) {// 2 点击了确认修改按钮
			String number = "";
			number = driverNumberjtf.getText();
			if (number.length() > 0) {// 2.1 输入了司机编号
				DriverInfoVO vo = null;
				driverInfoController = new DriverInfoController();
				vo = driverInfoController.findDriver(number);
				if (vo != null) {// 2.1.1 输入的司机编号存在
					String question = "该司机基本信息已存在,您想修改他(她)的基本信息吗?";
					JOptionPane.showMessageDialog(this, question, "警告", JOptionPane.QUESTION_MESSAGE);
					String m = "基本信息将被修改!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);

					if (ok == JOptionPane.YES_OPTION) {//2.1.1.1 点击确认按钮，确认修改
						// 获取基本信息，包装为vo
						String name = namejtf.getText();
						String discipling = idcardjtf.getText();
						String grade = cellphonejtf.getText();
						String birthday = birthdayjtf.getText();
						String licensedateText = licensedatejtf.getText();
						SexList sex = null;
						if (manrbt.isSelected()) {
							sex = SexList.MAN;
						} else {
							sex = SexList.WOMAN;
						}
						DriverInfoVO voToModify = new DriverInfoVO();
						voToModify.setDriverNumber(number);
						voToModify.setName(name);
						voToModify.setIdcard(discipling);
						voToModify.setCellphone(grade);
						voToModify.setSex(sex);
						voToModify.setBirthday(birthday);
						voToModify.setLicensedate(licensedateText);
						driverInfoController.modifyDriver(voToModify);
						confirmModifybt.setEnabled(false);
					} else if (ok == JOptionPane.NO_OPTION) {// 2.1.2.2 取消修改
						confirmModifybt.setEnabled(true);
					}
				}

				else {//2.1.2 输入的司机编号不存在
					String warning = "该司机编号没有基本信息,不能修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					confirmModifybt.setEnabled(false);
				}
			} else {//2.2 未输入司机编号
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				confirmModifybt.setEnabled(false);
			}
		}
		//3 点击了重置按钮
		if (e.getSource() == resetbt) {
			clearText();
		}
		System.out.println();
	}

	public void clearText() {
		driverNumberjtf.setText(null);
		namejtf.setText(null);
		idcardjtf.setText(null);
		cellphonejtf.setText(null);
		birthdayjtf.setText(null);
		licensedatejtf.setText(null);
	}
}
