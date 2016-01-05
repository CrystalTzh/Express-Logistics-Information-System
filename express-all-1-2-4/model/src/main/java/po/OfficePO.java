/**
 * @author 谭琼
 * 2015年12月11日
 */
package po;

import java.io.Serializable;

import state.BeiJingDistrict;
import state.City;
import state.GuangZhouDistrict;
import state.NanJingDistrict;
import state.ShangHaiDistrict;

/**
 * 营业厅类
 */
public class OfficePO implements Serializable{
	//无无参构造方法
	private static final long serialVersionUID = 1L;
	String officeID;
	City city;
	BeiJingDistrict beiJingDistrict;
	ShangHaiDistrict shangHaiDistrict;
	GuangZhouDistrict guangZhouDistrict;
	NanJingDistrict nanJingDistrict;

	/**
	 * 北京市营业厅的构造方法
	 * @param city
	 * @param district
	 */
	public OfficePO(City city, BeiJingDistrict district) {
		this.city = city;
		beiJingDistrict = district;
		shangHaiDistrict = null;
		guangZhouDistrict = null;
		nanJingDistrict = null;
	}

	/**
	 * 上海市营业厅的构造方法
	 * @param city
	 * @param district
	 */
	public OfficePO(City city, ShangHaiDistrict district) {
		this.city = city;
		beiJingDistrict = null;
		shangHaiDistrict = district;
		guangZhouDistrict = null;
		nanJingDistrict = null;
	}

	/**
	 * 广州市营业厅的构造方法
	 * @param city
	 * @param district
	 */
	public OfficePO(City city, GuangZhouDistrict district) {
		this.city = city;
		beiJingDistrict = null;
		shangHaiDistrict = null;
		guangZhouDistrict = district;
		nanJingDistrict = null;
	}

	/**
	 * 南京市营业厅的构造方法
	 * @param city
	 * @param district
	 */
	public OfficePO(City city, NanJingDistrict district) {
		this.city = city;
		beiJingDistrict = null;
		shangHaiDistrict = null;
		guangZhouDistrict = null;
		nanJingDistrict = district;
	}


	public String getOfficeID() {
		return officeID;
	}

	public City getCity() {
		return city;
	}

	public BeiJingDistrict getBeiJingDistrict() {
		return beiJingDistrict;
	}

	public ShangHaiDistrict getShangHaiDistrict() {
		return shangHaiDistrict;
	}

	public GuangZhouDistrict getGuangZhouDistrict() {
		return guangZhouDistrict;
	}

	public NanJingDistrict getNanJingDistrict() {
		return nanJingDistrict;
	}

	public void setOfficeID(String officeID) {
		this.officeID = officeID;
	}

}
