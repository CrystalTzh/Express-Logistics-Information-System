package presentation.corporationui.chauffeurboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.DriverInfoController;
import controller.corporationcontroller.LogController;
import presentation.handleexception.numberexceptionhandle.DriverNumberHandle;
import state.Operation;
import state.OperationObject;
import state.SexList;
import state.UserRole;
import vo.DriverInfoVO;
import vo.LogVO;

public class ChauffeurBoardAdd extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	//司机编号、姓名、身份证号、手机号码、出生日期、行驶证期限
	JTextField driverNumberjtf, namejtf, idcardjtf, cellphonejtf, birthdayjtf, licensedatejtf;
	//男、女
	JRadioButton manButton, womanButton;
	ButtonGroup group = null;
	JButton addButton, resetButton;
	DriverInfoController driverInfoController;
	LogController logController;
	
	public ChauffeurBoardAdd() {
		//初始化文本框、按钮等组件
		driverNumberjtf = new JTextField(10);
		namejtf = new JTextField(10);
		idcardjtf = new JTextField(10);
		cellphonejtf = new JTextField(10);
		birthdayjtf = new JTextField(10);
		licensedatejtf = new JTextField(10);
		group = new ButtonGroup();
		manButton = new JRadioButton("男", true);
		womanButton = new JRadioButton("女", false);
		group.add(manButton);
		group.add(womanButton);
		addButton = new JButton("录入");
		addButton.setContentAreaFilled(false);
		resetButton = new JButton("重置");
		resetButton.setContentAreaFilled(false);
		//监听录入和重置按钮
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("司机编号:", JLabel.CENTER));
		box1.add(Box.createHorizontalStrut(12));
		box1.add(driverNumberjtf);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(37));
		box2.add(namejtf);
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
		box4.add(idcardjtf);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("电话号码:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(cellphonejtf);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("出生日期:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(birthdayjtf);
		Box box7 = Box.createHorizontalBox();
		box7.add(new JLabel("行驶证期限:", JLabel.CENTER));
		box7.add(licensedatejtf);
		
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
			number = driverNumberjtf.getText();
			
			if (number.length() > 0) {//1.1 输入了司机编号
				//判断是否输入了合法的司机编号，若不合法处理异常
				DriverNumberHandle driverNumberHandle = new DriverNumberHandle();
				if(!driverNumberHandle.handle(this, driverNumberjtf)) {
					return;
				}
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
						String nameText = namejtf.getText();
						String idcardText = idcardjtf.getText();
						String cellphoneText = cellphonejtf.getText();
						String birthdayText = birthdayjtf.getText();
						String licensedateText = licensedatejtf.getText();
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
						
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.DriverInfo);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.OFFICEMAN);
						logController.addLog(logToAdd);//添加一条日志
						
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
		driverNumberjtf.setText(null);
		namejtf.setText(null);
		idcardjtf.setText(null);
		cellphonejtf.setText(null);
		birthdayjtf.setText(null);
		licensedatejtf.setText(null);

	}
}
