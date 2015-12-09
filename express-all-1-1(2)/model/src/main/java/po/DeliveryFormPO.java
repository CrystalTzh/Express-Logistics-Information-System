package po;

import java.io.Serializable;

import state.FormState;

public class DeliveryFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String arrivaeDate;//到达日期
	String ID;//订单条形码号
	String deliveryMan;//派送员
	FormState formstate;//单据的状态
	
	

	public FormState getFormstate() {
		return formstate;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}

	public String getArrivaeDate() {
		return arrivaeDate;
	}

	public String getID() {
		return ID;
	}

	public String getDeliveryMan() {
		return deliveryMan;
	}

	public void setArrivaeDate(String arrivaeDate) {
		this.arrivaeDate = arrivaeDate;
	}

	public void setID(String iD) {
		this.ID = iD;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
}
