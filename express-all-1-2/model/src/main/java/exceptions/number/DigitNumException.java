/**
 * @author 谭琼
 * 2015年12月23日
 */
package exceptions.number;

/**
 * 数字位数异常
 */
public class DigitNumException extends Exception{

	private static final long serialVersionUID = 1L;

	public DigitNumException(String m) {
		super(m);
	}
}
