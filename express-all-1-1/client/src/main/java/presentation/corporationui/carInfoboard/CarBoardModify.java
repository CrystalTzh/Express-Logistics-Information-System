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

import controller.corporationcontroller.CarInfoController;
import vo.CarInfoVO;

public class CarBoardModify extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField carNumberjtf, plateNumberjtf, engineNumberjtf, chassisNumberjtf, buyTimejtf, activeTimejtf;
	JButton beginModifybt, confirmModifybt, resetbt;
	CarInfoController carInfoController;

	public CarBoardModify() {
		//初始化文本框、按钮等组件
		carNumberjtf = new JTextField(10);
		plateNumberjtf = new JTextField(10);
		engineNumberjtf = new JTextField(10);
		chassisNumberjtf = new JTextField(10);
		buyTimejtf = new JTextField(10);
		activeTimejtf = new JTextField(10);
		
		beginModifybt = new JButton("开始修改");
		confirmModifybt = new JButton("录入修改");
		confirmModifybt.setEnabled(false);
		resetbt = new JButton("重置");
		//监听车辆代号文本框、开始修改按钮、确认修改按钮和重置按钮
		carNumberjtf.addActionListener(this);
		beginModifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);
		resetbt.addActionListener(this);
		//水平显示组件
		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("输入要修改信息的车辆代号:", JLabel.CENTER));
		box1.add(carNumberjtf);
		box1.add(beginModifybt);//开始修改按钮
		Box box2 = Box.createHorizontalBox();
		box2.add(new JLabel("(新)车牌号:", JLabel.CENTER));
		box2.add(Box.createHorizontalStrut(25));
		box2.add(plateNumberjtf);
		Box box3 = Box.createHorizontalBox();
		box3.add(new JLabel("(新)发动机编号:", JLabel.CENTER));
		box3.add(engineNumberjtf);
		Box box4 = Box.createHorizontalBox();
		box4.add(new JLabel("(新)底盘号:", JLabel.CENTER));
		box4.add(Box.createHorizontalStrut(25));
		box4.add(chassisNumberjtf);
		Box box5 = Box.createHorizontalBox();
		box5.add(new JLabel("(新)购买时间:", JLabel.CENTER));
		box5.add(Box.createHorizontalStrut(12));
		box5.add(buyTimejtf);
		Box box6 = Box.createHorizontalBox();
		box6.add(new JLabel("(新)服役时间:", JLabel.CENTER));
		box6.add(Box.createHorizontalStrut(12));
		box6.add(activeTimejtf);
		
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
		
		//组件之间的距离自动扩充平均分配
		boxH.add(Box.createVerticalGlue());
		JPanel pCenter;
		//JScrollPane处理滚动
		JScrollPane scrollPane = new JScrollPane(pCenter = new JPanel());
		pCenter.add(boxH);
		
		setLayout(new BorderLayout());
		//主要的信息界面显示在中央
		add(scrollPane, BorderLayout.CENTER);

		//确认修改按钮和重置按钮显示在南边
		JPanel pSouth = new JPanel();
		pSouth.add(confirmModifybt);
		pSouth.add(resetbt);
		add(pSouth, BorderLayout.SOUTH);
		validate();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
		if (e.getSource() == beginModifybt 
				|| e.getSource() == carNumberjtf) {//1 点击开始修改按钮或输入车辆代号后按了enter
			String number = "";
			number = carNumberjtf.getText();

			if (number.length() > 0) {//1.1 输入了车辆代号，判断是否可以修改
				CarInfoVO vo = null;
				carInfoController = new CarInfoController();
				vo = carInfoController.findCar(number);
				if(vo != null) {//1.1.1 输入的车辆代号存在
					confirmModifybt.setEnabled(true);// 可以修改
					// 显示基本信息
					plateNumberjtf.setText(vo.getPlateNumber());
					engineNumberjtf.setText(vo.getEngineNumber());
					chassisNumberjtf.setText(vo.getChassisNumber());
					buyTimejtf.setText(vo.getBuyTime());
					activeTimejtf.setText(vo.getActiveTime());
				} else {//1.1.2 输入的车辆代号不存在
					confirmModifybt.setEnabled(false);// 不可修改
					String warning = "该车辆代号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					clearText();
				}
			} else {//1.2 没有输入车辆代号
				confirmModifybt.setEnabled(false);// 不可修改
				String warning = "必须要输入车辆代号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				clearText();
			}
		} else if (e.getSource() == confirmModifybt) {//2 点击了确认修改按钮
			String number = "";
			number = carNumberjtf.getText();
			if (number.length() > 0) {//2.1 输入了车辆代号
				CarInfoVO vo = null;
				carInfoController = new CarInfoController();
				vo = carInfoController.findCar(number);
				if(vo != null) {//2.1.1 输入的车辆代号存在
					String question = "该车辆基本信息已存在,您想修改它的基本信息吗?";
					JOptionPane.showMessageDialog(this, question, "警告", JOptionPane.QUESTION_MESSAGE);
					String m = "基本信息将被修改!";	
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//2.1.1.1 点击确认按钮，确认修改
						//获取基本信息，包装为vo
						String plateNumber = plateNumberjtf.getText();
						String engineNumber = engineNumberjtf.getText();
						String chassisNumber = chassisNumberjtf.getText();
						String buyTime = buyTimejtf.getText();
						String activeTime = activeTimejtf.getText();
						
						CarInfoVO voToModify = new CarInfoVO();
						voToModify.setCarNumber(number);
						voToModify.setPlateNumber(plateNumber);
						voToModify.setEngineNumber(engineNumber);
						voToModify.setChassisNumber(chassisNumber);
						voToModify.setBuyTime(buyTime);
						voToModify.setActiveTime(activeTime);
						carInfoController.modifyCar(voToModify);//修改车辆信息
						confirmModifybt.setEnabled(false);
					}
				} else {//2.1.2 输入的车辆代号不存在
					String warning = "该车辆代号没有基本信息,不能修改!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
					confirmModifybt.setEnabled(false);
				}
			} else {//2.2 未输入车辆代号
				String warning = "必须要输入车辆代号!";
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
		carNumberjtf.setText(null);
		plateNumberjtf.setText(null);
		engineNumberjtf.setText(null);
		chassisNumberjtf.setText(null);
		buyTimejtf.setText(null);
		activeTimejtf.setText(null);
	}
}
