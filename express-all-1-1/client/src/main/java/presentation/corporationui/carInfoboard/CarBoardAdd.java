/**
 * @author 谭琼
 * 2015年12月1日
 */
package presentation.corporationui.carInfoboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.corporationController.CarInfoController;
import vo.CarInfoVO;

public class CarBoardAdd extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField carNumberjtf, plateNumberjtf, engineNumberjtf, chassisNumberjtf, buyTimejtf, activeTimejtf;
	JButton addButton, resetButton;
	CarInfoController carInfoController;

	public CarBoardAdd() {
		//初始化文本框、按钮等组件
		carNumberjtf = new JTextField(20);
		plateNumberjtf = new JTextField(20);
		engineNumberjtf = new JTextField(20);
		chassisNumberjtf = new JTextField(20);
		buyTimejtf = new JTextField(20);
		activeTimejtf = new JTextField(20);
		addButton = new JButton("录入");
		resetButton = new JButton("重置");
		//监听录入和重置按钮
		addButton.addActionListener(this);
		resetButton.addActionListener(this);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("车辆代号:", JLabel.CENTER));
		box1.add(Box.createHorizontalStrut(12));
		box1.add(carNumberjtf);
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
		/*
		 */
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
			number = carNumberjtf.getText();

			if (number.length() > 0) {//1.1 输入了车辆代号
				CarInfoVO vo = null;
				carInfoController = new CarInfoController();
				vo = carInfoController.findCar(number);
				if(vo != null) { //1.1.1 输入的车辆代号存在
					String warning = "该车辆基本信息已存在,请到修改页面修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				} else {//1.1.2 输出的车辆代号不存在
					String m = "基本信息将被录入!";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//确认录入
						//包装CarInfoVO
						String carNumber = carNumberjtf.getText();
						String plateNumber = plateNumberjtf.getText();
						String engineNumber = engineNumberjtf.getText();
						String chassisNumber = chassisNumberjtf.getText();
						String buyTime = buyTimejtf.getText();
						String activeTime = activeTimejtf.getText();
						CarInfoVO voToAdd = new CarInfoVO();
						voToAdd.setCarNumber(carNumber);
						voToAdd.setPlateNumber(plateNumber);
						voToAdd.setEngineNumber(engineNumber);
						voToAdd.setChassisNumber(chassisNumber);
						voToAdd.setBuyTime(buyTime);
						voToAdd.setActiveTime(activeTime);
						carInfoController.addCar(voToAdd);//添加车辆
					}//录入结束
				}
			} else {//1.2 未输入司机编号
				String warning = "必须要输入司机编号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		if (e.getSource() == resetButton) {//2 点击了重置按钮
			textClear();
		}
		System.out.println();
	}

	public void textClear() {
		carNumberjtf.setText(null);
		plateNumberjtf.setText(null);
		engineNumberjtf.setText(null);
		chassisNumberjtf.setText(null);
		buyTimejtf.setText(null);
		activeTimejtf.setText(null);
	}

}
