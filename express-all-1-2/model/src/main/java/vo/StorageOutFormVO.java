package vo;

import java.io.Serializable;

import state.FormState;
import state.Transport;

public class StorageOutFormVO implements  Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String NO;//快递编号
	String date;//出库日期
	String expressNumber;
	String destination;//目的地
	Transport transport;//转运形式
	String transferNO;
	String sportNO;
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
		this.transport = transport;
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

	public void setNO(String NO) {
		this.NO = NO;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
