package vo;

import java.io.Serializable;
import java.util.Hashtable;

import po.PositionPO;
import state.NodeState;
import state.Zone;

public class InventoryInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	double limit;//库存警戒值
	Zone emptyZone;//机动仓库的状态
	Hashtable<PositionPO, NodeState> planeZoneInfo;//航空区位置信息
	Hashtable<PositionPO, NodeState> carZoneInfo;//汽车区位置信息
	Hashtable<PositionPO, NodeState> trainZoneInfo;//火车区位置信息
	Hashtable<PositionPO, NodeState> emptyZoneInfo;//机动区位置信息
	String inventoryID;//仓库标识（是哪个中转中心的仓库）
	public static int capacity = 50;
	
	public InventoryInfoVO() {
		limit = 0.9;
		emptyZone = Zone.EMPTY;
		inventoryID = "01";
		planeZoneInfo = new Hashtable<PositionPO, NodeState>();
		for(int i = 0; i < capacity; i++) {
			PositionPO po = new PositionPO();
			po.setZone(Zone.PLANE);
			planeZoneInfo.put(po, po.getState());
		}
		carZoneInfo = new Hashtable<PositionPO, NodeState>();
		for(int i = 0; i < capacity; i++) {
			PositionPO po = new PositionPO();
			po.setZone(Zone.CAR);
			carZoneInfo.put(po, po.getState());
		}
		trainZoneInfo = new Hashtable<PositionPO, NodeState>();
		for(int i = 0; i < capacity; i++) {
			PositionPO po = new PositionPO();
			po.setZone(Zone.TRAIN);
			trainZoneInfo.put(po, po.getState());
		}
		emptyZoneInfo = new Hashtable<PositionPO, NodeState>();
		for(int i = 0; i < capacity; i++) {
			PositionPO po = new PositionPO();
			po.setZone(emptyZone);
			trainZoneInfo.put(po, po.getState());
		}
	}

	public double getLimit() {
		return limit;
	}

	public Zone getEmptyZone() {
		return emptyZone;
	}


	public String getInventoryID() {
		return inventoryID;
	}

	public void setLimit(double limit) {
		this.limit = limit;
	}

	public void setEmptyZone(Zone emptyZone) {
		this.emptyZone = emptyZone;
	}

	public void setInventoryID(String inventoryID) {
		this.inventoryID = inventoryID;
	}

	public Hashtable<PositionPO, NodeState> getPlaneZoneInfo() {
		return planeZoneInfo;
	}

	public Hashtable<PositionPO, NodeState> getCarZoneInfo() {
		return carZoneInfo;
	}

	public Hashtable<PositionPO, NodeState> getTrainZoneInfo() {
		return trainZoneInfo;
	}

	public void setPlaneZoneInfo(Hashtable<PositionPO, NodeState> planeZoneInfo) {
		this.planeZoneInfo = planeZoneInfo;
	}

	public void setCarZoneInfo(Hashtable<PositionPO, NodeState> carZoneInfo) {
		this.carZoneInfo = carZoneInfo;
	}

	public void setTrainZoneInfo(Hashtable<PositionPO, NodeState> trainZoneInfo) {
		this.trainZoneInfo = trainZoneInfo;
	}

	public Hashtable<PositionPO, NodeState> getEmptyZoneInfo() {
		return emptyZoneInfo;
	}

	public void setEmptyZoneInfo(Hashtable<PositionPO, NodeState> emptyZoneInfo) {
		this.emptyZoneInfo = emptyZoneInfo;
	}
	
	
}
