package vo;

import java.io.Serializable;

import state.FormState;
import state.State;
/**
 * 营业厅到达单持久化对象
 */
public class OfficeArrivalFormVO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String NO;//编号
	String arriveDate;//到达日期
	String relayformnumber; //中转单编号
	String destination; //目的地
	State state; //货物到达状态
	FormState formstate;//单据的状态
	
	public String getNO() {
		return NO;
	}
	public void setNO(String NO) {
		this.NO = NO;
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
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
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

