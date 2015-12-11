package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class CarOfficeFormVO implements Serializable{
	String NO;//编号
	String putOnCarDate;//装车日期
	String motorNumber; //汽运编号
	String destination;//到达地
	String carNumber; //车辆代号
	String loadingMember; //监装员
	String supercargo; //押运员
	ArrayList<String> allIDs;//本次装箱所有条形码号
	double transitCharge;//运费
	FormState formstate;//单据的状态
	
	public String getNO() {
		return NO;
	}
	public String getDestination() {
		return destination;
	}
	public void setNO(String NO) {
		this.NO = NO;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getPutOnCarDate() {
		return putOnCarDate;
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
	public double getTransitCharge() {
		return transitCharge;
	}
	public void setPutOnCarDate(String putOnCarDate) {
		this.putOnCarDate = putOnCarDate;
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
	public void setTransitCharge(double transitCharge) {
		this.transitCharge = transitCharge;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
