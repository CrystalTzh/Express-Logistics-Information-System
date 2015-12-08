package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class PaymentFormVO implements Serializable{
	String date;//付款日期
	double money;//付款金额
	String name;//付款人
	long account;//付款账号
	double rent;//租金
	int year;//租金年份
	double freight;//运费
	ArrayList<Long> allNO;//运单号：中转单TransferForm、营业厅装车单CarOfficeForm、中转中心装车单CarInputForm
	double salary;//人员工资
	double bonus;//奖励
	String payDate;//工资年月
	long NO;//编号
	FormState formstate;//单据的状态
	
	public PaymentFormVO() {
		
	}
	
	public PaymentFormVO(String date, double money, String name, long account, 
			double rent, int year, ArrayList<Long> allNO, double salary,
			double bonus, String payDate, long NO,double freight, FormState formstate){
		this.date = date;
		this.money = money;
		this.account = account;
		this.rent = rent;
		this.year = year;
		this.freight = freight;
		this.allNO = allNO;
		this.salary = salary;
		this.bonus = bonus;
		this.payDate = payDate;
		this.NO = NO;
		this.formstate = formstate;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public long getAccount() {
		return account;
	}

	public double getRent() {
		return rent;
	}

	public int getYear() {
		return year;
	}

	public double getFreight() {
		return freight;
	}

	public ArrayList<Long> getAllNO() {
		return allNO;
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public String getPayDate() {
		return payDate;
	}

	public long getNO() {
		return NO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAccount(long account) {
		this.account = account;
	}

	public void setRent(double rent) {
		this.rent = rent;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void setFreight(double freight) {
		this.freight = freight;
	}

	public void setAllNO(ArrayList<Long> allNO) {
		this.allNO = allNO;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public void setNO(long NO) {
		this.NO = NO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
}