package po;

import java.io.Serializable;

public class CarInfoPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String carNumber;//车辆代号
	String plateNumber;//车牌号
	String engineNumber;//发动机编号
	String chassisNumber;//底盘号
	String buyTime;//购买时间
	String activeTime;//服役时间
	
	public CarInfoPO(String c,String p,String e,String ch,String b,String a){
		carNumber = c;
		plateNumber = p;
		engineNumber = e;
		chassisNumber = ch;
		buyTime = b;
		activeTime = a;
	}

	/**
	 * 
	 */
	public CarInfoPO() {
		// TODO Auto-generated constructor stub
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public String getEngineNumber() {
		return engineNumber;
	}
	
	public String getChassisNumber() {
		return chassisNumber;
	}

	public String getBuyTime() {
		return buyTime;
	}

	public String getActiveTime() {
		return activeTime;
	}

	public void setCarNumber(String carNumber) {
		this.carNumber = carNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public void setEngineNumber(String engineNumber) {
		this.engineNumber = engineNumber;
	}

	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}

	public void setBuyTime(String buyTime) {
		this.buyTime = buyTime;
	}

	public void setActiveTime(String activeTime) {
		this.activeTime = activeTime;
	}
	
}
