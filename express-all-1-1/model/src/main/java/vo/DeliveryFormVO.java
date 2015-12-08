package vo;

import java.io.Serializable;

import state.FormState;
import state.State;

public class DeliveryFormVO implements Serializable{
	String arrivaeDate;//到达日期
	long ID;//订单条形码号
	String deliveryMan;//派送员
	FormState formstate;//单据的状态
	
	public DeliveryFormVO() {}
	
	public DeliveryFormVO(String arrivaeDate,
			long ID, String deliveryMan, FormState formstate) {
		this.arrivaeDate = arrivaeDate;
		this.ID = ID;
		this.deliveryMan = deliveryMan;
		this.formstate = formstate;
	}

	public String getArrivaeDate() {
		return arrivaeDate;
	}

	public long getID() {
		return ID;
	}

	public String getDeliveryMan() {
		return deliveryMan;
	}

	public void setArrivaeDate(String arrivaeDate) {
		this.arrivaeDate = arrivaeDate;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
