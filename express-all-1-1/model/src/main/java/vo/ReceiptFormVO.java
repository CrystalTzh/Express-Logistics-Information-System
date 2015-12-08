package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class ReceiptFormVO implements  Serializable{
	String date;//收款日期
	double money;//收款金额
	String expressManNumber;//收款快递员
	ArrayList<Long> ID;
	long NO;
	FormState formstate;//单据的状态
	
	public ReceiptFormVO() {}
	
	public ReceiptFormVO(String d,double m,String e,ArrayList<Long> i,
			long NO, FormState formstate){
		date = d;
		money = m;
		expressManNumber = e;
		ID = i;
		this.NO = NO; 
		this.formstate = formstate;
	}

	public String getDate() {
		return date;
	}

	public double getMoney() {
		return money;
	}

	public String getExpressManNumber() {
		return expressManNumber;
	}

	public ArrayList<Long> getID() {
		return ID;
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

	public void setExpressManNumber(String expressManNumber) {
		this.expressManNumber = expressManNumber;
	}

	public void setID(ArrayList<Long> iD) {
		ID = iD;
	}

	public void setNO(long nO) {
		NO = nO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
}