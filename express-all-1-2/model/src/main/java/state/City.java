/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum City {
	BEIJING("北京"), SHANGHAI("上海"), GUANGZHOU("广州"), NANJING("南京");
	private String city;
	private City(String city) {
		this.city = city;
	}
	public String toString() {
		return city;
	}
	

	/**
	 * 通过字符串获取city
	 * @param str
	 * @return
	 */
	public static City getbyStr(String str) {
		if(str.equals(BEIJING.toString())) {
			return BEIJING;
		} else if(str.equals(SHANGHAI.toString())) {
			return SHANGHAI;
		} else if(str.equals(GUANGZHOU.toString())) {
			return GUANGZHOU;
		} else {
			return NANJING;
		}
	}
}
