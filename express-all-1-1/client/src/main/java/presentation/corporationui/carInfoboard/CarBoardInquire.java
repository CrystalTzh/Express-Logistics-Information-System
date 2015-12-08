/**
 * @author 谭琼
 * 2015年12月1日
 */
package presentation.corporationui.carInfoboard;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.corporationController.CarInfoController;
import vo.CarInfoVO;

public class CarBoardInquire extends JDialog implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField carNumberjtf, plateNumberjtf, engineNumberjtf, chassisNumberjtf, buyTimejtf, activeTimejtf;
	JButton findButton;
	CarInfoController carInfoController;

	public CarBoardInquire(JFrame f) {
		//指定对话框的所有者、标题、模式,模式为false代表对话框与所属窗口可以互相切换，彼此之间在操作上没有顺序性
		super(f, "查询对话框", false);
		//初始化文本框、按钮等组件
		carNumberjtf = new JTextField(10);
		findButton = new JButton("查询");
		//监听车辆代号文本框和查询按钮
		carNumberjtf.addActionListener(this);
		findButton.addActionListener(this);
		plateNumberjtf = new JTextField(10);
		plateNumberjtf.setEditable(false);
		engineNumberjtf = new JTextField(10);
		engineNumberjtf.setEditable(false);
		chassisNumberjtf = new JTextField(10);
		chassisNumberjtf.setEditable(false);
		buyTimejtf = new JTextField(10);
		buyTimejtf.setEditable(false);
		activeTimejtf = new JTextField(10);
		activeTimejtf.setEditable(false);
		
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要查询的车辆代号:", JLabel.CENTER));
		box1.add(carNumberjtf);
		box1.add(findButton);
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("车牌号:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(25));
		box2.add(plateNumberjtf);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("发动机编号:", JLabel.CENTER));
		box3.add(engineNumberjtf);
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("底盘号:", JLabel.CENTER));
		box4.add(Box.createHorizontalStrut(25));
		box4.add(chassisNumberjtf);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("购买时间:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(buyTimejtf);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("服役时间:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(activeTimejtf);
		//垂直显示组件
		Box boxH = Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box2);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box3);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box4);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box5);
		boxH.add(Box.createVerticalStrut(5));
		boxH.add(box6);
		
		/*
		 */
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
		cleartext();// 清空text field

		if (e.getSource() == findButton 
				|| e.getSource() == carNumberjtf) {//1 点击查询按钮或输入车辆代号后按了enter
			String number = "";
			number = carNumberjtf.getText();

			if (number.length() > 0) {//1.1 输入了车辆代号，go Find

				CarInfoVO vo;// 用来接收查询得来的车辆信息
				CarInfoController carInfoController = new CarInfoController();
				vo = carInfoController.findCar(number);
				if (vo == null) { //1.1.1 输入的司机编号不存在
					String warning = "该车辆代号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输入的车辆代号存在
					plateNumberjtf.setText(vo.getPlateNumber());
					engineNumberjtf.setText(vo.getEngineNumber());
					chassisNumberjtf.setText(vo.getChassisNumber());
					buyTimejtf.setText(vo.getBuyTime());
					activeTimejtf.setText(vo.getActiveTime());
				}

			} else {//1.2 没有输入车辆代号
				String warning = "必须要输入车辆代号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		System.out.println();
	}

	public void cleartext() {
		plateNumberjtf.setText(null);
		engineNumberjtf.setText(null);
		chassisNumberjtf.setText(null);
		buyTimejtf.setText(null);
		activeTimejtf.setText(null);

	}
}
