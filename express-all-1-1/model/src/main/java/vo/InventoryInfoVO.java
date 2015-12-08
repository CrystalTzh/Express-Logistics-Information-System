package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;
import state.Zone;
import businesslogic.inventorybl.LocationNode;

public class InventoryInfoVO implements Serializable {

	ArrayList<LocationNode> locationNode;
	double limit;
	Zone emptyZone;
	
	public InventoryInfoVO() {
		limit = 0.8;
		emptyZone = Zone.EMPTY;
	}
	
	public InventoryInfoVO(ArrayList<LocationNode> locationNode,double limit,
			Zone emptyZone) {
		super();
		// TODO Auto-generated constructor stub
		this.locationNode = locationNode;
		this.limit = limit;
		this.emptyZone = emptyZone;
	}
	
	public ArrayList<LocationNode> getLocationNode() {
		return locationNode;
	}
	public double getLimit() {
		return limit;
	}
	public Zone getEmptyZone() {
		return emptyZone;
	}
	public void setLocationNode(ArrayList<LocationNode> locationNode) {
		this.locationNode = locationNode;
	}
	public void setLimit(double limit) {
		this.limit = limit;
	}
	public void setEmptyZone(Zone emptyZone) {
		this.emptyZone = emptyZone;
	}

	
	
}