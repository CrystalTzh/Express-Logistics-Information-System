package po;

import java.io.Serializable;

import state.State;

public class StoreArrivalFormPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	long NO; //营业厅到达单编号
	String relaynumber; //中转中心编号
	String arriveDate; // 到达日期
	long relayformnumber; //中转单编号
	String startingPoint; //出发地
	State state; //货物到达状态
	
	public String getRelayNumber() {
		return relaynumber;
	}
	public String getArriveDate() {
		return arriveDate;
	}
	public long getRelayFormNumber() {
		return relayformnumber;
	}
	public String getStartingPoint() {
		return startingPoint;
	}
	public State getState() {
		return state;
	}
	public void setRelayNumber(String relaynumber) {
		this.relaynumber = relaynumber;
	}
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	public void setRelayFormNumber(long relayformnumber) {
		this.relayformnumber = relayformnumber;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public void setState(State state) {
		this.state = state;
	}
	public long getNO() {
		return NO;
	}
	public String getRelaynumber() {
		return relaynumber;
	}
	public long getRelayformnumber() {
		return relayformnumber;
	}
	public void setNO(long NO) {
		this.NO = NO;
	}
	public void setRelaynumber(String relaynumber) {
		this.relaynumber = relaynumber;
	}
	public void setRelayformnumber(long relayformnumber) {
		this.relayformnumber = relayformnumber;
	}

	
}
