package po;

import java.io.Serializable;
import java.util.ArrayList;

public class CarInputFormPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long NO; //装车单编号
	String destination; //目的地
	String motorNumber; //汽运编号
	String carNumber; //车辆代号
	String loadingMember; //监装员
	String supercargo; //押运员
	String putOnCarDate; //装车日期
	ArrayList<Long> allIDs; //本次装车所有订单号
	double transCharge; //运费
	
	
	public CarInputFormPO(long NO,String destination,String motorNumber,
			String carNumber,String loadingMember,
			String supercargo,String putOnCarDate,
			ArrayList<Long> allIDs,double transCharge) {
		super();
		// TODO Auto-generated constructor stub
		this.NO = NO;
		this.destination = destination;
		this.motorNumber = motorNumber;
		this.carNumber = carNumber;
		this.loadingMember = loadingMember;
		this.supercargo = supercargo;
		this.putOnCarDate = putOnCarDate;
		this.allIDs = allIDs;
		this.transCharge = transCharge;
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
	public ArrayList<Long> getAllIDs() {
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
	public void setAllIDs(ArrayList<Long> allIDs) {
		this.allIDs = allIDs;
	}
	public void setTransCharge(double transCharge) {
		this.transCharge = transCharge;
	}
	public long getNO() {
		return NO;
	}
	public void setNO(long nO) {
		NO = nO;
	}

}
