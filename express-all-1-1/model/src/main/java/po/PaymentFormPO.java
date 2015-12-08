package po;

import java.io.Serializable;

public class PaymentFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	double money;
	String name;
	long account;
	double rent;
	int year;
	double freight;
	long id;
	double salary;
	double bonus;
	int month;
	String NO;
	
	public PaymentFormPO(String d,double m,String n,long a,String N){
		date = d;
		money = m;
		name = n;
		account = a;
		NO = N;
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
	
	public String getNO(){
		return NO;
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

	public long getId() {
		return id;
	}

	public double getSalary() {
		return salary;
	}

	public double getBonus() {
		return bonus;
	}

	public int getMonth() {
		return month;
	}
}
