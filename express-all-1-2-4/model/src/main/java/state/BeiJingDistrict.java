/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum BeiJingDistrict {
	DongCheng("东城区"), XiCheng("西城区"), Xuanwu("宣武区"), ChongWen("崇文区"), ChaoYang("朝阳区"),
	HaiDian("海淀区"), FengTai("丰台区"), ShiJingShan("石景山区"), TongZhou("通州区"), DaXing("大兴区"),
	FangShan("房山区"), MenTouGou("门头沟区"), ChangPing("昌平区"), YanQing("延庆区"), HuaiRou("怀柔区"),
	ShunYi("顺义区"), PingGu("平谷区"), MiYun("密云县");
	
	private String district;
	
	private BeiJingDistrict(String district) {
		this.district = district;
	}
	
	public String toString() {
		return district;
	}
	
	public static BeiJingDistrict districtByStr(String str) {
		if(str.equals(DongCheng.toString())) {
			return DongCheng;
		} else if(str.equals(XiCheng.toString())) {
			return XiCheng;
		} else if(str.equals(Xuanwu.toString())) {
			return Xuanwu;
		} else if(str.equals(ChongWen.toString())) {
			return ChongWen;
		} else if(str.equals(ChaoYang.toString())) {
			return ChaoYang;
		}
		
		else if(str.equals(HaiDian.toString())) {
			return HaiDian;
		} else if(str.equals(FengTai.toString())) {
			return FengTai;
		} else if(str.equals(ShiJingShan.toString())) {
			return ShiJingShan;
		} else if(str.equals(TongZhou.toString())) {
			return TongZhou;
		} else if(str.equals(DaXing.toString())) {
			return DaXing;
		}
		
		else if(str.equals(FangShan.toString())) {
			return FangShan;
		} else if(str.equals(MenTouGou.toString())) {
			return MenTouGou;
		} else if(str.equals(ChangPing.toString())) {
			return ChangPing;
		} else if(str.equals(YanQing.toString())) {
			return YanQing;
		} else if(str.equals(HuaiRou)) {
			return HuaiRou;
		}
		
		else if(str.equals(ShunYi.toString())) {
			return ShunYi;
		} else if(str.equals(PingGu.toString())) {
			return PingGu;
		} else if(str.equals(MiYun.toString())) {
			return MiYun;
		}
		
		return null;
	}
	
}
