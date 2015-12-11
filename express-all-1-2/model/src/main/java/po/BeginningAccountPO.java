package po;

import java.io.Serializable;
import java.util.ArrayList;

public class BeginningAccountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int year;//建立年份
	ArrayList<UserAccountPO> userInfo;//当前机构人员账户信息
	ArrayList<CarInfoPO> carInfo;//车辆信息
	ArrayList<InventoryInfoPO> inventoryInfo;//库存信息
	BankAccountInfoPO bankAccountInfoPO;//银行账户信息
	
	public BeginningAccountPO(int year,
			ArrayList<UserAccountPO> userInfo,
			ArrayList<CarInfoPO> carInfo,
			ArrayList<InventoryInfoPO> inventoryInfo,
			BankAccountInfoPO accountInfo) {
		this.userInfo = userInfo;
		this.carInfo = carInfo;
		this.inventoryInfo = inventoryInfo;
		this.bankAccountInfoPO = bankAccountInfoPO;
	}

	
	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		this.year = year;
	}


	public ArrayList<UserAccountPO> getUserInfo() {
		return userInfo;
	}

	public ArrayList<CarInfoPO> getCarInfo() {
		return carInfo;
	}

	public ArrayList<InventoryInfoPO> getInventoryInfo() {
		return inventoryInfo;
	}

	public BankAccountInfoPO getAccountInfo() {
		return bankAccountInfoPO;
	}

	public void setUserInfo(ArrayList<UserAccountPO> userInfo) {
		this.userInfo = userInfo;
	}

	public void setCarInfo(ArrayList<CarInfoPO> carInfo) {
		this.carInfo = carInfo;
	}

	public void setInventoryInfo(ArrayList<InventoryInfoPO> inventoryInfo) {
		this.inventoryInfo = inventoryInfo;
	}

	public void setAccountInfo(BankAccountInfoPO accountInfo) {
		this.bankAccountInfoPO = accountInfo;
	}
	
}
