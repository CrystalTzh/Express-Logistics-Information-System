/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum Line {
	OneLine("一排"), TwoLine("二排"), ThreeLine("三排"), FourLine("四排");
	
	private String line;
	
	private Line (String line) {
		this.line = line;
	}
	
	public String toString() {
		return line;
	}
	
	/**
	 * 通过字符串获取line
	 * @param str
	 * @return
	 */
	public static Line getbyStr(String str) {
		if(str.equals(OneLine.toString())) {
			return OneLine;
		} else if(str.equals(TwoLine.toString())) {
			return TwoLine;
		} else if(str.equals(ThreeLine.toString())) {
			return ThreeLine;
		} else {
			return FourLine;
		}
	}
	
	/**
	 * 通过数字获取line
	 * @param index
	 * @return
	 */
	public static Line getbyIndex(int index) {
		if(index == 0) {
			return OneLine;
		} else if(index == 1) {
			return TwoLine;
		} else if(index == 2) {
			return ThreeLine;
		} else if(index == 3) {
			return FourLine;
		}
		return null;
	}
}
