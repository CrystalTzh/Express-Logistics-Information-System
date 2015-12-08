package businesslogic.financebl;

import java.util.ArrayList;

import state.FormState;

public class MockPaymentForm {
	String date = null;
	int money = 0;
	String name = null;
	long account = 0;
	double rent = 0;
	int year = 0;
	double freight = 0;
	ArrayList<Long> allNO = new ArrayList<Long>();
	double salary = 0;
	double bonus = 0;
	String payDate = null;
	long NO = 0;
	FormState formstate = null;
	
	public MockPaymentForm(long NO)
	{
		date = "2015-01-01";
		money = 10086;
		name = "hello";
		account = 141250162;
		rent = 1000;
		year = 2014;
		freight = 2000;
		allNO.add((long) 1234556789);
		salary = 5000;
		bonus = 500;
		payDate = "2015-12";
		this.NO = NO;
		formstate = FormState.DRAFT;
	}
	public String getName()
	{
		return this.name;
	}
	public String getPayDate()
	{
		return this.payDate;
	}
	public int getMoney()
	{
		return money;
	}
}
