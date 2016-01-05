/**
 * @author 谭琼
 * 2015年12月23日
 */
package exceptions.number;

/**
 * 检查数字的有效性
 */
public class CheckValid {

	/**
	 * 检查输入的数字是否有效
	 * @param number 输入的数字
	 * @param validLen 有效数字的长度
	 * @throws DigitNumException 数字位数异常
	 * @throws IncludeCharacterException 数字含有字母异常
	 */
	public void check(String number, int validLen) throws DigitNumException, IncludeCharacterException {
		// 数字中含有字母
		if (hasCharacter(number.toLowerCase())) {
			String m = "数字中含有字母!";
			throw new IncludeCharacterException(m);
		}
		// 数字位数错误
		if (number.length() != validLen) {
			String m = "请输入" + String.valueOf(validLen) + "位数字!";
			throw new DigitNumException(m);
		}
	}

	/**
	 * 判断字符串中是否含有字母
	 * 
	 * @param number
	 *            不含大写
	 * @return
	 */
	public boolean hasCharacter(String number) {
		int len = number.length();
		for (int i = 0; i < len; i++) {
			char c = number.charAt(i);
			if (c >= 'a' && c <= 'z') {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		CheckValid checkValid = new CheckValid();
		try {
			checkValid.check("12344", 9);
		} catch (DigitNumException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} catch (IncludeCharacterException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
}
