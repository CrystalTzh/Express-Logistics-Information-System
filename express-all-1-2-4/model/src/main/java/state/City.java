/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum City {
	BEIJING("北京", "010"), SHANGHAI("上海", "021"), GUANGZHOU("广州", "020"), NANJING("南京", "025");
	
	private String city;
	private String num;
	
	private City(String city, String num) {
		this.city = city;
		this.num = num;
	}
	public String toString() {
		return city;
	}
	public String toNum() {
		return num;
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
