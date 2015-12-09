package po;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class ReceiptFormPO implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;//收款日期
	double money;//收款金额
	String expressname;//收款快递员
	ArrayList<String> id;//所有快递单号
	String NO;//单号
	FormState formstate;//单据的状态

	public FormState getFormstate() {
		return formstate;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
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
	public String getExpressname() {
		return expressname;
	}
	public void setExpressname(String expressname) {
		this.expressname = expressname;
	}
	public ArrayList<String> getId() {
		return id;
	}
	public void setId(ArrayList<String> id) {
		this.id = id;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String NO) {
		this.NO = NO;
	}
	

	
}
