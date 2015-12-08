package po;

import java.io.Serializable;

public class DeliveryFormPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String arrivaeDate;//到达日期
	String ID;//订单条形码号
	String deliveryMan;//派送员
	
	public DeliveryFormPO(String arrivaeDate,
			String i, String deliveryMan) {
		this.arrivaeDate = arrivaeDate;
		this.ID = i;
		this.deliveryMan = deliveryMan;
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
		ID = iD;
	}

	public void setDeliveryMan(String deliveryMan) {
		this.deliveryMan = deliveryMan;
	}
}
