/**
 * @author 谭琼
 * 2015年12月23日
 */
package exceptions.number;

/**
 * 包含字母异常
 */
public class IncludeCharacterException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public IncludeCharacterException(String m) {
		super(m);
	}
	
}
