package vo;

import java.io.Serializable;

import state.FormState;
import state.State;

public class OfficeArrivalFormVO implements Serializable{
	long NO;//编号
	String arriveDate;//到达日期
	long relayformnumber; //中转单编号
	String startingpoint; //出发地
	String destination; //目的地
	State state; //货物到达状态
	FormState formstate;//单据的状态

	public OfficeArrivalFormVO() {}
	
	public OfficeArrivalFormVO(long NO, String arriveDate,
			long relayformnumber, String startingpoint,
			String destination, State state, FormState formstate) {
		this.NO = NO;
		this.arriveDate = arriveDate;
		this.relayformnumber = relayformnumber;
		this.startingpoint = startingpoint;
		this.destination = destination;
		this.state = state;
		this.formstate = formstate;
	}
	
	public String getArriveDate() {
		return arriveDate;
	}
	public long getRelayformnumber() {
		return relayformnumber;
	}
	public String getStartingpoint() {
		return startingpoint;
	}
	public String getDestination() {
		return destination;
	}
	public State getState() {
		return state;
	}
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	public void setRelayformnumber(long relayformnumber) {
		this.relayformnumber = relayformnumber;
	}
	public void setStartingpoint(String startingpoint) {
		this.startingpoint = startingpoint;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public void setState(State state) {
		this.state = state;
	}

	public long getNO() {
		return NO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setNO(long nO) {
		NO = nO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}

