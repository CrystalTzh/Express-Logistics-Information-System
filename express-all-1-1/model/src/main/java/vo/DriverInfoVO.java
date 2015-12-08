package vo;

import java.io.Serializable;

import state.FormState;
import state.SexList;

public class DriverInfoVO implements Serializable{
	
	String driverNumber;
	String name;
	String birthday;
	String idcard;
	String cellphone;
	String licensedate;
	SexList sex;
//	FormState formstate;//单据的状态
	
	public DriverInfoVO() {}
	
	public DriverInfoVO(String d, String n,String b,String i,String c,String l,SexList s){
		driverNumber = d;
		name = n;
		birthday = b;
		idcard = i;
		cellphone = c;
		licensedate = l;
		sex = s;
//		this.formstate = formstate;
	}

	public void setDriverNumber(String driverNumber) {
		this.driverNumber = driverNumber;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	

	public void setLicensedate(String licensedate) {
		this.licensedate = licensedate;
	}

	public void setSex(SexList sex) {
		this.sex = sex;
	}

	public String getDriverNumber() {
		return driverNumber;
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getIdcard() {
		return idcard;
	}


	public String getLicensedate() {
		return licensedate;
	}

	public SexList getSex() {
		return sex;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	

//	public FormState getFormstate() {
//		return formstate;
//	}

//	public void setFormstate(FormState formstate) {
//		this.formstate = formstate;
//	}
	
}
