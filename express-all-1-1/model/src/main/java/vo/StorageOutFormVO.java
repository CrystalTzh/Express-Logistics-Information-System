package vo;

import java.io.Serializable;

import state.FormState;

public class StorageOutFormVO implements  Serializable{
	String NO;
	String date;
	long expressNumber;
	String destination;
	String position;
	FormState formstate;//单据的状态
	
	public StorageOutFormVO() {
		
	}
	
	public  StorageOutFormVO(String da,long i,String de,String p, FormState formstate){
		date=da;
		expressNumber=i;
		destination=de;
		position=p;
		this.formstate = formstate;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public long getExpressNumber() {
		return expressNumber;
	}
	
	public void setExpressNumber(long expressNumber) {
		this.expressNumber = expressNumber;
	}
	
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position=position;
	}

	public String getNO() {
		return NO;
	}

	public String getDestination() {
		return destination;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setNO(String nO) {
		NO = nO;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
