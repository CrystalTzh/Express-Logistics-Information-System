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
 * 订单编号异常处理类
 */
public class OrderIDHandle {

	/**
	 * 判断订单编号是否合理并处理异常
	 * @param comp
	 * @param orderIDjtf
	 * @return 若没有抛出异常，则返回true，表示输入的司机编号有效
	 */
	public boolean handle(Component comp, JTextField orderIDjtf) {
		
		// 订单编号10位数字
		String orderID = orderIDjtf.getText();
		CheckValid checkValid = new CheckValid();
		try {
			checkValid.check(orderID, 10);
			return true;
		} catch (DigitNumException e1) {
			// 显示错误信息面板：必须输入10位数字!
			String error = "订单编号" + e1.getMessage();
			JOptionPane.showMessageDialog(comp, error, "错误", JOptionPane.ERROR_MESSAGE);
			// 将输入的编号选中
			orderIDjtf.requestFocus();
			orderIDjtf.selectAll();
			e1.printStackTrace();
		} catch (IncludeCharacterException e1) {
			// 显示错误信息面板：必须输入10位数字!
			// 将输入的编号选中
			String error = e1.getMessage();
			JOptionPane.showMessageDialog(comp, error, "错误", JOptionPane.ERROR_MESSAGE);
			orderIDjtf.requestFocus();
			orderIDjtf.selectAll();
			e1.printStackTrace();
		}
		return false;
	}
}
