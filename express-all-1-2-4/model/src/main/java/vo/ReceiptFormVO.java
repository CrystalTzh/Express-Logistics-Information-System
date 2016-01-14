package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;
/**
 * 收款单持久化对象
 */
public class ReceiptFormVO implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String date;//收款日期
	double money;//收款金额
	String expressManNumber;//收款快递员
	ArrayList<String> ID;
	String NO;
	FormState formstate;//单据的状态
	boolean paystate = false;

	public boolean isPaystate() {
		return paystate;
	}

	public void setPaystate(boolean paystate) {
		this.paystate = paystate;
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

	public ArrayList<String> getID() {
		return ID;
	}

	public String getNO() {
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

	public void setID(ArrayList<String> ID) {
		this.ID = ID;
	}

	public void setNO(String NO) {
		this.NO = NO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
}