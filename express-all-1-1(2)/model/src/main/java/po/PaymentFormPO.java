package po;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class PaymentFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;//付款单日期
	double money;//付款金额
	String name;//付款人姓名
	String account;//付款账户
	double rent;//租金
	int year;//租金年份
	double freight;//运费
	String formNO;//运单号：中转单TransferForm、营业厅装车单CarOfficeForm、中转中心装车单CarInputForm
	double salary;//人员工资

	int month;//工资月份
	String NO;//单号
	FormState formstate;//单据的状态
	
	public FormState getFormState(){
		return formstate;
	}
	
	public void setFormState(FormState formstate){
		this.formstate=formstate;
	}
	
	public String getFormNO() {
		return formNO;
	}
	public void setFormNO(String formNO) {
		this.formNO = formNO;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public double getRent() {
		return rent;
	}
	public void setRent(double rent) {
		this.rent = rent;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public double getFreight() {
		return freight;
	}
	public void setFreight(double freight) {
		this.freight = freight;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		this.NO = nO;
	}
	
	
	
	
	

	
}
