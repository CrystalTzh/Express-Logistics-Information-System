/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum GuangZhouDistrict {
	YueXiu("越秀区"), LiWan("荔湾区"), TianHe("天河区"), BaiYun("白云区"), HaiZhu("海珠区"),
	FanYu("番禹区"), HuaDu("花都区"), NanSha("南沙区"), HuangPu(""), LuoGang(""),
	CongHua(""), ZengCheng("");
	
	private String district;
	
	private GuangZhouDistrict(String district) {
		this.district = district;
	}
	
	public String toString() {
		return district;
	}
}
