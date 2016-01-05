/**
 * @author 谭琼
 * 2015年12月23日
 */
package presentation.handleexception.numberexceptionhandle;

import java.awt.Component;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exceptions.number.CheckValid;
import exceptions.number.DigitNumException;
import exceptions.number.IncludeCharacterException;

/**
 * 车辆代号异常处理类
 */
public class CarNumberHandle {
	
	/**
	 * 判断车辆代号是否合理并处理异常
	 * @param comp
	 * @param carNumberjtf
	 * @return 若没有抛出异常，则返回true，表示输入的车辆代号有效
	 */
	public boolean handle(Component comp, JTextField carNumberjtf) {
		
		// 城市编号（电话号码区号南京025）+营业厅编号（000三位数字）+000三位数字）
		String carNumber = carNumberjtf.getText();
		CheckValid checkValid = new CheckValid();
		try {
			checkValid.check(carNumber, 9);
			return true;
		} catch (DigitNumException e1) {
			// 显示错误信息面板：必须输入9位数字!
			String error = "车辆代号" + e1.getMessage();
			JOptionPane.showMessageDialog(comp, error, "错误", JOptionPane.ERROR_MESSAGE);
			// 将输入的编号选中
			carNumberjtf.requestFocus();
			carNumberjtf.selectAll();
			e1.printStackTrace();
		} catch (IncludeCharacterException e1) {
			// 显示错误信息面板：必须输入9位数字!
			// 将输入的编号选中
			String error = e1.getMessage();
			JOptionPane.showMessageDialog(comp, error, "错误", JOptionPane.ERROR_MESSAGE);
			carNumberjtf.requestFocus();
			carNumberjtf.selectAll();
			e1.printStackTrace();
		}
		return false;
	}
}
