package po;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;
/**
 * 中转中心装车单持久化对象
 */
public class CarInputFormPO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	String NO; //中转中心装车单编号
	String destination; //目的地
	String motorNumber; //汽运编号
	String carNumber; //车辆代号
	String loadingMember; //监装员
	String supercargo; //押运员
	String putOnCarDate; //装车日期
	ArrayList<String> allIDs; //本次装车所有订单号
	double transCharge; //运费
	FormState formstate;//单据的状态
	
	
	public FormState getFormstate() {
		return formstate;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	public String getDestination() {
		return destination;
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
	public String getPutOnCarDate() {
		return putOnCarDate;
	}
	public ArrayList<String> getAllIDs() {
		return allIDs;
	}
	public double getTransCharge() {
		return transCharge;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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
	public void setPutOnCarDate(String putOnCarDate) {
		this.putOnCarDate = putOnCarDate;
	}
	public void setAllIDs(ArrayList<String> allIDs) {
		this.allIDs = allIDs;
	}
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String NO) {
		this.NO = NO;
	}

}
