package po;

import java.io.Serializable;

import state.FormState;
import state.Transport;

public class StorageOutFormPO implements  Serializable{
	String NO;//出库单编号
	String date;//出库日期
	String expressNumber;//快递订单号
	String destination;//目的地
	Transport transport;//转运形式
	String transferNO;//中转单编号
	String sportNO;//汽运编号
	FormState formstate;//单据的状态
	
	
	public String getTransferNO() {
		return transferNO;
	}
	public void setTransferNO(String transferNO) {
		this.transferNO = transferNO;
	}
	public String getSportNO() {
		return sportNO;
	}
	public void setSportNO(String sportNO) {
		this.sportNO = sportNO;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		NO = nO;
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
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public Transport getTransport() {
		return transport;
	}
	public void setTransport(Transport transport) {
		this.transport = transport;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	public FormState getFormstate() {
		return formstate;
	}
	
	
}
