package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ReceiptFormPO implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;
	double money;
	String expressname;
	ArrayList<Long> id;
	long NO;
	
	public ReceiptFormPO(String d,double m,String e,ArrayList<Long> i,long NO){
		date = d;
		money = m;
		expressname = e;
		id = i;
		this.NO = NO; 
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public String getExpressname() {
		return expressname;
	}

	public ArrayList<Long> getId() {
		return id;
	}
	
	public long getNO(){
		return NO;
	}
}
