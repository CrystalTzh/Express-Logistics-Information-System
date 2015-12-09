package businesslogic.financebl;

import java.util.ArrayList;

import state.FormState;

public class MockReceiptForm extends ReceiptForm{
	String date = null;
	int money = 0;
	String expressManNumber = null;
	ArrayList<Long> id = new ArrayList<Long>();
	long NO = 0;
	FormState formstate;
	
	public MockReceiptForm(long NO)
	{
		this.NO = NO;
		date = "2015-01-01";
		money = 20086;
		expressManNumber = "025110C";
		id.add((long) 2501011);
		formstate = FormState.DRAFT;
	}
	public String getDate()
	{
		return this.date;
	}
	public int getMoney()
	{
		return money;
	}
}
