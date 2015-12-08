package vo;

import java.io.Serializable;

public class ConstInfoVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double distancePrice;//距离价格常量
	double baseSalary;//快递员和营业厅业务员的基本工资
	double receiveExpressPrize;//快递员揽件提成
	double sendExpressPrize;//快递员派件提成
	double salaryEachInCity;//司机市内计次
	double salaryEachOutCity;//司机跨市计次
	
	public ConstInfoVO(double dp, double bs, double rep, double sep, 
			double sei, double seo) {
		distancePrice = dp;
		baseSalary	=bs;
		receiveExpressPrize = rep;
		sendExpressPrize = sep;
		salaryEachInCity = sei;
		salaryEachOutCity = seo;
	}
	public ConstInfoVO(){

		distancePrice = 2.0;//距离价格常量
		baseSalary = 2000.0;//快递员和营业厅业务员的基本工资
		receiveExpressPrize = 1.0;//快递员揽件提成
		sendExpressPrize = 0.5;//快递员派件提成
		salaryEachInCity = 50;//司机市内计次
		salaryEachOutCity = 200;//司机跨市计次
	}

	public double getDistancePrice() {
		return distancePrice;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getReceiveExpressPrize() {
		return receiveExpressPrize;
	}

	public double getSendExpressPrize() {
		return sendExpressPrize;
	}

	public double getSalaryEachInCity() {
		return salaryEachInCity;
	}

	public double getSalaryEachOutCity() {
		return salaryEachOutCity;
	}

	public void setDistancePrice(double distancePrice) {
		this.distancePrice = distancePrice;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setReceiveExpressPrize(double receiveExpressPrize) {
		this.receiveExpressPrize = receiveExpressPrize;
	}

	public void setSendExpressPrize(double sendExpressPrize) {
		this.sendExpressPrize = sendExpressPrize;
	}

	public void setSalaryEachInCity(double salaryEachInCity) {
		this.salaryEachInCity = salaryEachInCity;
	}

	public void setSalaryEachOutCity(double salaryEachOutCity) {
		this.salaryEachOutCity = salaryEachOutCity;
	}
	
}
