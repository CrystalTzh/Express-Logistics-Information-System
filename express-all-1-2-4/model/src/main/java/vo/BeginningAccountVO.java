package vo;

import java.io.Serializable;
import java.util.ArrayList;

import po.BankAccountInfoPO;
import po.UserAccountPO;
import state.FormState;

public class BeginningAccountVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int year;//建立年份
	ArrayList<UserAccountPO> userAccountPO;//当前机构人员账户信息
	ArrayList<CarInfoVO> carInfo;//车辆信息
	ArrayList<InventoryInfoVO> inventoryInfo;//库存信息
	BankAccountInfoPO bankAccountInfoPO;//银行账户信息
	FormState formstate;//单据的状态
	
	public BeginningAccountVO() {}
	
	public BeginningAccountVO(int year,
			ArrayList<UserAccountPO> userInfo,
			ArrayList<CarInfoVO> carInfo,
			ArrayList<InventoryInfoVO> inventoryInfo,
			BankAccountInfoPO accountInfo, FormState formstate) {
		this.userAccountPO = userInfo;
		this.carInfo = carInfo;
		this.inventoryInfo = inventoryInfo;
		this.bankAccountInfoPO = accountInfo;
		this.formstate = formstate;
	}

	
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public ArrayList<UserAccountPO> getUserInfo() {
		return userAccountPO;
	}

	public ArrayList<CarInfoVO> getCarInfo() {
		return carInfo;
	}

	public ArrayList<InventoryInfoVO> getInventoryInfo() {
		return inventoryInfo;
	}

	public BankAccountInfoPO getAccountInfo() {
		return bankAccountInfoPO;
	}

	public void setUserInfo(ArrayList<UserAccountPO> userInfo) {
		this.userAccountPO = userInfo;
	}

	public void setCarInfo(ArrayList<CarInfoVO> carInfo) {
		this.carInfo = carInfo;
	}

	public void setInventoryInfo(ArrayList<InventoryInfoVO> inventoryInfo) {
		this.inventoryInfo = inventoryInfo;
	}

	public void setAccountInfo(BankAccountInfoPO bankAccountInfoPO) {
		this.bankAccountInfoPO = bankAccountInfoPO;
	}


	public FormState getFormstate() {
		return formstate;
	}


	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
	
	
}
