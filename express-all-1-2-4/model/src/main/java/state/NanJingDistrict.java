/**
 * @author 谭琼
 * 2015年12月11日
 */
package state;

public enum NanJingDistrict {
	XuanWu("玄武区"), BaiXia("白下区"), QinHuai("秦淮区"), JianYe("建邺区"), GuLou("鼓楼区"),
	XiaGuan("下关区"), PuKou("浦口区"), LiuHe("六合区"), QiXia("栖霞区"), YuHuaTai("雨花台区"),
	JiangNing("江宁区"), LiShui("溧水区"), GaoChun("高淳区");
	
	private String district;
	
	private NanJingDistrict(String district) {
		this.district = district;
	}
	
	public String toString() {
		return district;
	}
	
	public static NanJingDistrict getByStr(String str) {
		if(str.equals(XuanWu.toString())) {
			return XuanWu;
		} else if(str.equals(BaiXia.toString())) {
			return BaiXia;
		} else if(str.equals(QinHuai.toString())) {
			return QinHuai;
		} else if(str.equals(JianYe.toString())) {
			return JianYe;
		} else if(str.equals(GuLou.toString())) {
			return GuLou;
		}
		
		else if(str.equals(XiaGuan.toString())) {
			return XiaGuan;
		} else if(str.equals(PuKou.toString())) {
			return PuKou;
		} else if(str.equals(LiuHe.toString())) {
			return LiuHe;
		} else if(str.equals(QiXia.toString())) {
			return QiXia;
		} else if(str.equals(YuHuaTai.toString())) {
			return YuHuaTai;
		}
		
		else if(str.equals(JiangNing.toString())) {
			return JiangNing;
		} else if(str.equals(LiShui.toString())) {
			return LiShui;
		} else if(str.equals(GaoChun.toString())) {
			return GaoChun;
		} 
		return null;
	}
}
