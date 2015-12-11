/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum Tag {
	OneTag("1位"), TwoTag("2位"), ThreeTag("3位"), FourTag("4位"), FiveTag("5位");

	private String tag;

	private Tag(String tag) {
		this.tag = tag;
	}

	public String toString() {
		return tag;
	}

	/**
	 * 通过字符串获取tag
	 * @param str
	 * @return
	 */
	public static Tag getbyStr(String str) {
		if (str.equals(OneTag.toString())) {
			return OneTag;
		} else if (str.equals(TwoTag.toString())) {
			return TwoTag;
		} else if (str.equals(ThreeTag.toString())) {
			return ThreeTag;
		} else if (str.equals(FourTag.toString())) {
			return FourTag;
		}else {
			return FiveTag;
		}
	}
	
	/**
	 * 通过数字获取tag
	 * @param index
	 * @return
	 */
	public static Tag getbyIndex(int index) {
		if(index == 0) {
			return OneTag;
		} else if(index == 1) {
			return TwoTag;
		} else if(index == 2) {
			return ThreeTag;
		} else if(index == 3) {
			return FourTag;
		} else if(index == 4) {
			return FiveTag;
		}
		return null;
	}

}
