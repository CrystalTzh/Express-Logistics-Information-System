package po;

import java.io.Serializable;

import state.Transport;

public class StorageOutFormPO implements  Serializable{
	String NO;//出库单编号
	String date;//出库日期
	String expressNumber;//快递订单号
	String destination;//目的地
	Transport transport;//转运形式
	
	public StorageOutFormPO(){
		
	}
	
	public  StorageOutFormPO(String no, String da,String i,String de,Transport t){
		NO = no;
		date=da;
		expressNumber=i;
		destination=de;
		transport=t;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	public String getExpressNumber() {
		return expressNumber;
	}
	
	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}
	
	public Transport getTransport() {
		return transport;
	}

	public void setTransport(Transport transport) {
		this.transport=transport;
	}
}
