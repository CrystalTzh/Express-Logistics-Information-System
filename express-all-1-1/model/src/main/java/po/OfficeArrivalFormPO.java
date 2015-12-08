package po;

import java.io.Serializable;

import state.State;

public class OfficeArrivalFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long NO;//编号
	String arriveDate;//到达日期
	long relayformnumber; //中转单编号
	String startingpoint; //出发地
	String destination; //目的地
	State state; //货物到达状态

	public OfficeArrivalFormPO(long NO, String arriveDate,
			long relayformnumber, String startingpoint,
			String destination, State state) {
		this.NO = NO;
		this.arriveDate = arriveDate;
		this.relayformnumber = relayformnumber;
		this.startingpoint = startingpoint;
		this.destination = destination;
		this.state = state;
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

	public void setNO(long NO) {
		this.NO = NO;
	}
	
}

