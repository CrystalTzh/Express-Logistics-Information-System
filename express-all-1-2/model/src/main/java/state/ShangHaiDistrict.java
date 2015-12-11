/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum ShangHaiDistrict {
	HuangPu("黄浦区"), LuWan("卢湾区"), XuHui("徐汇区"), ChangNing("长宁区"), JiangAn("静安区"),
	PuTuo("普陀区"), ZhaBei("闸北区"), HongKou("虹口区"), YangPu("杨浦区"), PuDong("浦东区"),
	SongJiang("松江区"), QingPu("青浦区"), JinShan("金山区"), NanHui("南汇区"), FengXian("奉贤区"),
	ChongMing("崇明区");
	
	private String district;
	
	private ShangHaiDistrict(String district) {
		this.district = district;
	}
	
	public String toString() {
		return district;
	}
	
	public ShangHaiDistrict districtByStr(String str) {
		if(str.equals(HuangPu.toString())) {
			return HuangPu;
		} else if(str.equals(LuWan.toString())) {
			return LuWan;
		} else if(str.equals(XuHui.toString())) {
			return XuHui;
		} else if(str.equals(ChangNing.toString())) {
			return ChangNing;
		} else if(str.equals(JiangAn.toString())) {
			return JiangAn;
		}
		
		else if(str.equals(PuTuo.toString())) {
			return PuTuo;
		} else if(str.equals(ZhaBei.toString())) {
			return ZhaBei;
		} else if(str.equals(HongKou.toString())) {
			return HongKou;
		} else if(str.equals(YangPu.toString())) {
			return YangPu;
		} else if(str.equals(PuDong.toString())) {
			return PuDong;
		}
		
		else if(str.equals(SongJiang.toString())) {
			return SongJiang;
		} else if(str.equals(QingPu.toString())) {
			return QingPu;
		} else if(str.equals(JinShan.toString())) {
			return JinShan;
		} else if(str.equals(NanHui.toString())) {
			return NanHui;
		} else if(str.equals(FengXian)) {
			return FengXian;
		}
		
		else if(str.equals(ChongMing.toString())) {
			return ChongMing;
		}
		return null;
	}
		
}
