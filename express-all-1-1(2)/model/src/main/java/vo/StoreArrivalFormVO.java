package vo;

import java.io.Serializable;

import state.FormState;
import state.State;

public class StoreArrivalFormVO implements Serializable {

	String NO; //营业厅到达单编号
	String relaynumber; //中转中心编号
	String arriveDate; // 到达日期
	String relayformnumber; //中转单编号
	String startingPoint; //出发地
	State state; //货物到达状态
	FormState formstate;//单据的状态
	
	public String getNO() {
		return NO;
	}
	public void setNO(String NO) {
		this.NO = NO;
	}
	public String getRelaynumber() {
		return relaynumber;
	}
	public void setRelaynumber(String relaynumber) {
		this.relaynumber = relaynumber;
	}
	public String getArriveDate() {
		return arriveDate;
	}
	public void setArriveDate(String arriveDate) {
		this.arriveDate = arriveDate;
	}
	public String getRelayformnumber() {
		return relayformnumber;
	}
	public void setRelayformnumber(String relayformnumber) {
		this.relayformnumber = relayformnumber;
	}
	public String getStartingPoint() {
		return startingPoint;
	}
	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	public FormState getFormstate() {
		return formstate;
	}
	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
	
}
