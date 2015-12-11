package po;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class CarOfficeFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String NO;//编号
	String putOnCarDate;//装车日期
	String officeNumber;//本营业厅编号
	String motorNumber; //汽运编号
	String destiantion;//到达地
	String carNumber; //车辆代号
	String loadingMember; //监装员
	String supercargo; //押运员
	ArrayList<String> allIDs;//本次装箱所有条形码号
	double transitChange;//运费
	FormState formstate;//单据的状态
	
	public String getNO() {
		return NO;
	}
	public String getDestiantion() {
		return destiantion;
	}
	public void setNO(String NO) {
		this.NO = NO;
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
	public ArrayList<String> getAllIDs() {
		return allIDs;
	}
	public double getTransitChange() {
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
	public void setAllIDs(ArrayList<String> allIDs) {
		this.allIDs = allIDs;
	}
	public void setTransitChange(double transitChange) {
		this.transitChange = transitChange;
	}
	public FormState getFormstate() {
		return formstate;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
