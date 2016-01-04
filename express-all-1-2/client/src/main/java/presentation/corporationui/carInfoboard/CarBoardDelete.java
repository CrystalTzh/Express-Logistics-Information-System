/**
 * @author 谭琼
 * 2015年12月1日
 */
package presentation.corporationui.carInfoboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import controller.UserID;
import controller.corporationcontroller.CarInfoController;
import controller.corporationcontroller.LogController;
import presentation.handleexception.numberexceptionhandle.CarNumberHandle;
import state.Operation;
import state.OperationObject;
import state.UserRole;
import vo.CarInfoVO;
import vo.LogVO;

public class CarBoardDelete extends JPanel implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextField carNumberjtf, plateNumberjtf, engineNumberjtf, chassisNumberjtf, 
	buyTimejtf, activeTimejtf;
	JButton deletebt;
	CarInfoController carInfoController;
	LogController logController;
	
	public CarBoardDelete() {
		//初始化文本框、按钮等组件
		carNumberjtf = new JTextField(10);
		deletebt = new JButton("删除");
		//监听carNumber文本框和删除按钮
		carNumberjtf.addActionListener(this);
		deletebt.addActionListener(this);
		deletebt.setContentAreaFilled(false);
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
				CarNumberHandle carNumberHandle = new CarNumberHandle();
				if(!carNumberHandle.handle(this, carNumberjtf)){//判断输入的车辆代号是否有效，若无效进行相应处理
					return;
				}
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
						
						logController = new LogController();
						LogVO logToAdd = new LogVO();
						logToAdd.setOperation(Operation.ADD);
						logToAdd.setOperationObject(OperationObject.CarInfo);
						logToAdd.setOperationTime(new GregorianCalendar());
						logToAdd.setOperatorID(UserID.userid);
						logToAdd.setOperatorRole(UserRole.OFFICEMAN);
						logController.addLog(logToAdd);//添加一条日志
						
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
