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

public class CarBoardDelete extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField carNumberjtf, plateNumberjtf, engineNumberjtf, chassisNumberjtf, 
	buyTimejtf, activeTimejtf;
	JButton deletebt;
	CarInfoController carInfoController;

	public CarBoardDelete() {
		//初始化文本框、按钮等组件
		carNumberjtf = new JTextField(10);
		deletebt = new JButton("删除");
		//监听carNumber文本框和删除按钮
		carNumberjtf.addActionListener(this);
		deletebt.addActionListener(this);
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
		box1.add(new JLabel("输入要删除的车辆代号:", JLabel.CENTER));
		box1.add(carNumberjtf);
		box1.add(deletebt);
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
				|| e.getSource() == carNumberjtf) {//1 点击课删除按钮或输入车辆代号后按了enter
			String number = "";
			number = carNumberjtf.getText();

			if (number.length() > 0) {//1.1 输入了车辆代号
				CarInfoVO vo = null;
				carInfoController = new CarInfoController();
				vo = carInfoController.findCar(number);
				if(vo != null) {//1.1.1 输入的车辆代号存在
					//显示基本信息
					plateNumberjtf.setText(vo.getPlateNumber());
					engineNumberjtf.setText(vo.getEngineNumber());
					chassisNumberjtf.setText(vo.getChassisNumber());
					buyTimejtf.setText(vo.getBuyTime());
					activeTimejtf.setText(vo.getActiveTime());
					
					String m = "确定要删除该车辆代号及全部信息吗?";
					int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);
					if (ok == JOptionPane.YES_OPTION) {//1.1.1.1 点击了确认删除
						carInfoController.deleteCar(vo);//删除车辆
						//清空面板
						clearText();
					}
				} else {//1.1.2 输入的车辆代号不存在
					String warning = "该车辆代号不存在!";
					JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				}
			} else {//1.2 没有输入车辆代号
				String warning = "必须要输入车辆代号!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
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
