package presentation.corporationui.chauffeurboard;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.corporationController.DriverInfoController;
import state.SexList;
import vo.DriverInfoVO;

public class ChauffeurBoardInquire extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField driverNumber, name, idcard, cellphone, birthday, licensedate;
	JRadioButton manButton, womanButton;
	JButton findButton;
	ButtonGroup group = null;
	DriverInfoController driverInfoController;

	public ChauffeurBoardInquire(JFrame f) {
		//指定对话框的所有者、标题、模式,模式为false代表对话框与所属窗口可以互相切换，彼此之间在操作上没有顺序性
		super(f, "查询对话框", false);
		//初始化文本框、按钮等组件
		driverNumber = new JTextField(10);
		findButton = new JButton("查询");
		//监听司机编号文本框和查询按钮
		driverNumber.addActionListener(this);
		findButton.addActionListener(this);
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
		manButton = new JRadioButton("男", false);
		womanButton = new JRadioButton("女", false);
		group = new ButtonGroup();
		group.add(manButton);
		group.add(womanButton);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要查询的司机编号:", JLabel.CENTER));
		box1.add(driverNumber);
		box1.add(findButton);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("姓名:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(37));
		box2.add(name);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("性别:", JLabel.CENTER));
		box3.add(manButton);
		box3.add(womanButton);
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
		box7.add(new JLabel("行驶证期限", JLabel.CENTER));
		box7.add(licensedate);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(10));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box4);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box6);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box7);
		boxH.add(Box.createVerticalStrut(5));
		
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
		
		//添加主要的信息界面在中央
		Container con = getContentPane();
		con.add(scrollPane, BorderLayout.CENTER);
		con.validate();
		setVisible(false);
		setBounds(100, 200, 360, 270);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				setVisible(false);
			}
		});
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
		clearText();//清空text field

		if (e.getSource() == findButton || 
				e.getSource() == driverNumber) {//1 点击查询按钮或输入司机编号后按了enter
			String number = "";
			number = driverNumber.getText();

			if (number.length() > 0) {//1.1 输入了司机编号，go Find
				
				DriverInfoVO vo;//用来接收查询得来的司机信息
				driverInfoController = new DriverInfoController();
				vo = driverInfoController.findDriver(number);
				if(vo == null) { //1.1.1 输入的司机编号不存在
					String warning = "该司机编号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输入的司机编号存在
					name.setText(vo.getName());
					idcard.setText(vo.getIdcard());
					cellphone.setText(vo.getCellphone());
					birthday.setText(vo.getBirthday());
					licensedate.setText(vo.getLicensedate());
					if (vo.getSex() == SexList.MAN) {
						manButton.setSelected(true);
					} else {
						womanButton.setSelected(true);
					}
				}
			} else {//1.2 没有输入司机编号
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.out.println();
	}
	
	public void clearText() {
		name.setText(null);
		idcard.setText(null);
		cellphone.setText(null);
		birthday.setText(null);
		licensedate.setText(null);

	}
}
