package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class CarOfficeFormVO implements Serializable{
	long NO;//编号
	String putOnCarDate;//装车日期
	String officeNumber;//本营业厅编号
	String motorNumber; //汽运编号
	String destiantion;//到达地
	String carNumber; //车辆代号
	String loadingMember; //监装员
	String supercargo; //押运员
	ArrayList<Long> allIDs;//本次装箱所有条形码号
	long transitChange;//运费
	FormState formstate;//单据的状态
	
	public CarOfficeFormVO() {}
	
	public CarOfficeFormVO(long NO, String putOnCarDate, 
			String officeNumber, String motorNumber,
			String destiantion, String carNumber,
			String loadingMember, String supercargo,
			ArrayList<Long> allIDs, long transitChange, FormState formstate) {
		this.NO = NO;
		this.putOnCarDate = putOnCarDate;
		this.officeNumber = officeNumber;
		this.motorNumber = motorNumber;
		this.destiantion = destiantion;
		this.carNumber = carNumber;
		this.loadingMember = loadingMember;
		this.supercargo = supercargo;
		this.allIDs = allIDs;
		this.transitChange = transitChange;
		this.formstate = formstate;
	}
	
	public long getNO() {
		return NO;
	}
	public String getDestiantion() {
		return destiantion;
	}
	public void setNO(long nO) {
		NO = nO;
	}
	public void setDestiantion(String destiantion) {
		this.destiantion = destiantion;
	}
	public String getPutOnCarDate() {
		return putOnCarDate;
	}
	public String getOfficeNumber() {
		return officeNumber;
	}
	public String getMotorNumber() {
		return motorNumber;
	}
	public String getCarNumber() {
		return carNumber;
	}
	public String getLoadingMember() {
		return loadingMember;
	}
	public String getSupercargo() {
		return supercargo;
	}
	public ArrayList<Long> getAllIDs() {
		return allIDs;
	}
	public long getTransitChange() {
		return transitChange;
	}
	public void setPutOnCarDate(String putOnCarDate) {
		this.putOnCarDate = putOnCarDate;
	}
	public void setOfficeNumber(String officeNumber) {
		this.officeNumber = officeNumber;
	}
	public void setMotorNumber(String motorNumber) {
		this.motorNumber = motorNumber;
	}
	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}
	public void setLoadingMember(String loadingMember) {
		this.loadingMember = loadingMember;
	}
	public void setSupercargo(String supercargo) {
		this.supercargo = supercargo;
	}
	public void setAllIDs(ArrayList<Long> allIDs) {
		this.allIDs = allIDs;
	}
	public void setTransitChange(long transitChange) {
		this.transitChange = transitChange;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
