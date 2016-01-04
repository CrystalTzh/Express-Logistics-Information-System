package vo;

import java.io.Serializable;
/**
 * 付款单持久化对象
 */
public class PaymentFormVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;//付款日期
	double money;//付款金额
	String name;//付款人
	String account;//付款账号
	double rent;//租金
	int year;//租金年份
	double freight;//运费
	String formNO;//运单号：中转单TransferForm、营业厅装车单CarOfficeForm、中转中心装车单CarInputForm
	double salary;//人员工资
	
	int month;//工资年月
	String NO;//编号
//	FormState formstate;//单据的状态
	

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public String getName() {
		return name;
	}

	public String getAccount() {
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

	public String getFormNO() {
		return formNO;
	}

	public double getSalary() {
		return salary;
	}

	

	public int getMonth() {
		return month;
	}

	public String getNO() {
		return NO;
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

	public void setAccount(String account) {
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

	public void setFormNO(String formNO) {
		this.formNO = formNO;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}



	public void setMonth(int month) {
		this.month = month;
	}

	public void setNO(String NO) {
		this.NO = NO;
	}

	
}