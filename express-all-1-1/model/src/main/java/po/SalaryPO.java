/**
 * @author 谭琼
 * 2015年12月4日
 */
package po;

import java.io.Serializable;

/**
 * 薪资标准持久化对象
 */
public class SalaryPO implements  Serializable{

	private static final long serialVersionUID = 1L;
	String receiveOrderBonus;//快递员揽件提成
	String sendOrderBonus;//快递员派件提成
	String driverInCityPay;//司机市内计次
	String driverOutCityPay;//司机跨市计次
	String officeManSalary;//业务员月薪
	
	public SalaryPO () {}
	
	public SalaryPO(String receiveOrderBonus, String sendOrderBonus,
			String driverInCityPay, String driverOutCityPay, String officeManSalary) {
		this.receiveOrderBonus = receiveOrderBonus;
		this.sendOrderBonus = sendOrderBonus;
		this.driverInCityPay = driverInCityPay;
		this.driverOutCityPay = driverOutCityPay;
		this.officeManSalary = officeManSalary;
	}

	public String getReceiveOrderBonus() {
		return receiveOrderBonus;
	}

	public String getSendOrderBonus() {
		return sendOrderBonus;
	}

	public String getOfficeManSalary() {
		return officeManSalary;
	}

	public void setReceiveOrderBonus(String receiveOrderBonus) {
		this.receiveOrderBonus = receiveOrderBonus;
	}

	public void setSendOrderBonus(String sendOrderBonus) {
		this.sendOrderBonus = sendOrderBonus;
	}

	public void setOfficeManSalary(String officeManSalary) {
		this.officeManSalary = officeManSalary;
	}

	public String getDriverInCityPay() {
		return driverInCityPay;
	}

	public String getDriverOutCityPay() {
		return driverOutCityPay;
	}

	public void setDriverInCityPay(String driverInCityPay) {
		this.driverInCityPay = driverInCityPay;
	}

	public void setDriverOutCityPay(String driverOutCityPay) {
		this.driverOutCityPay = driverOutCityPay;
	}
	
	
}
