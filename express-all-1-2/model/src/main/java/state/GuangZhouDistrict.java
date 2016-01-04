/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum GuangZhouDistrict {
	YueXiu("越秀区"), LiWan("荔湾区"), TianHe("天河区"), BaiYun("白云区"), HaiZhu("海珠区"),
	FanYu("番禹区"), HuaDu("花都区"), NanSha("南沙区"), HuangPu("黄浦区"), LuoGang("萝岗区"),
	CongHua("从化市"), ZengCheng("增城市");
	
	private String district;
	
	private GuangZhouDistrict(String district) {
		this.district = district;
	}
	
	public String toString() {
		return district;
	}
	
	public static GuangZhouDistrict getByStr(String str) {
		if(str.equals(YueXiu.toString())) {
			return YueXiu;
		} else if(str.equals(LiWan.toString())) {
			return LiWan;
		} else if(str.equals(TianHe.toString())) {
			return TianHe;
		} else if(str.equals(BaiYun.toString())) {
			return BaiYun;
		} else if(str.equals(HaiZhu.toString())) {
			return HaiZhu;
		}
		
		else if(str.equals(FanYu.toString())) {
			return FanYu;
		} else if(str.equals(HuaDu.toString())) {
			return HuaDu;
		} else if(str.equals(NanSha.toString())) {
			return NanSha;
		} else if(str.equals(HuangPu.toString())) {
			return HuangPu;
		} else if(str.equals(LuoGang.toString())) {
			return LuoGang;
		}
		
		else if(str.equals(CongHua.toString())) {
			return CongHua;
		} else if(str.equals(ZengCheng.toString())) {
			return ZengCheng;
		}
		return null;
	}

}
