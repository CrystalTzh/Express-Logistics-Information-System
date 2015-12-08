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

public class ChauffeurBoardAdd extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//司机编号、姓名、身份证号、手机号码、出生日期、行驶证期限
	JTextField driverNumber, name, idcard, cellphone, birthday, licensedate;
	//男、女
	JRadioButton manButton, womanButton;
	ButtonGroup group = null;
	JButton addButton, resetButton;
	DriverInfoController driverInfoController;

	public ChauffeurBoardAdd() {
		//初始化文本框、按钮等组件
		driverNumber = new JTextField(10);
		name = new JTextField(10);
		idcard = new JTextField(10);
		cellphone = new JTextField(10);
		birthday = new JTextField(10);
		licensedate = new JTextField(10);
		group = new ButtonGroup();
		manButton = new JRadioButton("男", true);
		womanButton = new JRadioButton("女", false);
		group.add(manButton);
		group.add(womanButton);
		addButton = new JButton("录入");
		resetButton = new JButton("重置");
		//监听录入和重置按钮
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("司机编号:", JLabel.CENTER));
		box1.add(Box.createHorizontalStrut(12));
		box1.add(driverNumber);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(37));
		box2.add(name);
		Box box3 = Box.createHorizontalBox();
		box3.add(Box.createHorizontalStrut(0));
		box3.add(new JLabel("性别:", JLabel.CENTER));
		box3.add(Box.createHorizontalStrut(70));
		box3.add(manButton);
		box3.add(Box.createHorizontalStrut(20));
		box3.add(womanButton);
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("身份证号:", JLabel.CENTER));
		box4.add(Box.createHorizontalStrut(12));
		box4.add(idcard);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("电话号码:", JLabel.CENTER));
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
		boxH.add(Box.createVerticalStrut(10));
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
//		boxH.add(box8);
//		boxH.add(box9);
//		boxH.add(box10);
//		boxH.add(box11);
//		boxH.add(box12);
		
		JPanel pCenter;
		//JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		
		setLayout(new BorderLayout());
		//主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);
		JPanel pSouth = new JPanel();
		pSouth.add(addButton);
		pSouth.add(resetButton);
		//两个按钮显示在南边
		add(pSouth, BorderLayout.SOUTH);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if (e.getSource() == addButton) {//1 点击了录入按钮
			String number = "";
			number = driverNumber.getText();

			if (number.length() > 0) {//1.1 输入了司机编号
				DriverInfoVO vo = null;
				driverInfoController = new DriverInfoController();
				vo = driverInfoController.findDriver(number);
				if(vo != null) {//1.1.1 输入的司机编号存在
					String warning = "该司机基本信息已存在,请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);	
				} else {//1.1.2 输入的司机编号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//1.1.2.1 确认录入
						//包装DriverInfoVO
						String nameText = name.getText();
						String idcardText = idcard.getText();
						String cellphoneText = cellphone.getText();
						String birthdayText = birthday.getText();
						String licensedateText = licensedate.getText();
						SexList sex = null;
						if (manButton.isSelected()) {
							sex = SexList.MAN;
						} else {
							sex = SexList.WOMAN;
						}
						DriverInfoVO voToAdd = new DriverInfoVO();
						voToAdd.setDriverNumber(number);
						voToAdd.setName(nameText);
						voToAdd.setIdcard(idcardText);
						voToAdd.setCellphone(cellphoneText);
						voToAdd.setSex(sex);
						voToAdd.setBirthday(birthdayText);
						voToAdd.setLicensedate(licensedateText);
						driverInfoController.addDriver(voToAdd);//添加司机
					}//录入结束
				}//对输入的司机编号处理结束
			} else {//1.2 未输入司机编号
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource() == resetButton) {//点击了重置按钮
			textClear();
		}
		System.out.println();
	}
	
	public void textClear() {
		driverNumber.setText(null);
		name.setText(null);
		idcard.setText(null);
		cellphone.setText(null);
		birthday.setText(null);
		licensedate.setText(null);

	}
}
