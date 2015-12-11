package vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

import po.InventoryInfoPO;
import po.Position;
import state.Line;
import state.NodeState;
import state.Shelf;
import state.Tag;
import state.Zone;

public class InventoryInfoVO implements Serializable {

	private static final long serialVersionUID = 1L;
	double limit;//库存警戒值
	Zone emptyZone;//机动仓库的状态
	Hashtable<NodeState, ArrayList<Position>> planeZoneInfo;//航空区位置信息
	Hashtable<NodeState, ArrayList<Position>> carZoneInfo;//汽车区位置信息
	Hashtable<NodeState, ArrayList<Position>> trainZoneInfo;//火车区位置信息
	Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo;//机动区位置信息
	String inventoryID;//仓库标识（是哪个中转中心的仓库）
	static int zoneNum = 4;//区的数量
	static int lineNum = 4;//排的数量
	static int shelfNum = 4;//架的数量
	static int tagNum = 5;//位的数量
	public static int capacity = lineNum * shelfNum * tagNum;
	
	public InventoryInfoVO() {
		limit = 0.9;
		emptyZone = Zone.EMPTY;
		inventoryID = "01";
		planeZoneInfo = new Hashtable<NodeState, ArrayList<Position>>();
		initZone(planeZoneInfo);
		carZoneInfo = new Hashtable<NodeState, ArrayList<Position>>();
		initZone(carZoneInfo);
		trainZoneInfo = new Hashtable<NodeState, ArrayList<Position>>();
		initZone(trainZoneInfo);
		emptyZoneInfo = new Hashtable<NodeState, ArrayList<Position>>();
		initZone(emptyZoneInfo);
	}
	
	public InventoryInfoVO(int _zoneNum, int _lineNum, int _shelfNum, int _tagNum) {
		zoneNum = _zoneNum;
		lineNum = _lineNum;
		shelfNum = _shelfNum;
		tagNum = _tagNum;
		capacity = lineNum * shelfNum * tagNum;
		//TODO
		new InventoryInfoPO();
	}
	
	public void initZone(Hashtable<NodeState, ArrayList<Position>> zoneInfo) {
		ArrayList<Position> positions = new ArrayList<Position>();
		for(int i = 0; i < zoneNum; i++) {//区号
			for(int j = 0; j < lineNum; j++) {//排号
				for(int m = 0; m < shelfNum; m++) {//架号
					for(int n = 0; n < tagNum; n++) {//位号
						Position position = new Position();
						position.setZone(Zone.getbyIndex(i));
						position.setLine(Line.getbyIndex(j));
						position.setShelf(Shelf.getbyIndex(m));
						position.setTag(Tag.getbyIndex(n));
						positions.add(position);
					}
				}
			}
		}
		zoneInfo.put(NodeState.VACANT, positions);
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

	public int getZoneNum() {
		return zoneNum;
	}

	public int getLineNum() {
		return lineNum;
	}

	public int getShelfNum() {
		return shelfNum;
	}

	public int getTagNum() {
		return tagNum;
	}

	public Hashtable<NodeState, ArrayList<Position>> getPlaneZoneInfo() {
		return planeZoneInfo;
	}

	public Hashtable<NodeState, ArrayList<Position>> getCarZoneInfo() {
		return carZoneInfo;
	}

	public Hashtable<NodeState, ArrayList<Position>> getTrainZoneInfo() {
		return trainZoneInfo;
	}

	public Hashtable<NodeState, ArrayList<Position>> getEmptyZoneInfo() {
		return emptyZoneInfo;
	}

	public void setPlaneZoneInfo(Hashtable<NodeState, ArrayList<Position>> planeZoneInfo) {
		this.planeZoneInfo = planeZoneInfo;
	}

	public void setCarZoneInfo(Hashtable<NodeState, ArrayList<Position>> carZoneInfo) {
		this.carZoneInfo = carZoneInfo;
	}

	public void setTrainZoneInfo(Hashtable<NodeState, ArrayList<Position>> trainZoneInfo) {
		this.trainZoneInfo = trainZoneInfo;
	}

	public void setEmptyZoneInfo(Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo) {
		this.emptyZoneInfo = emptyZoneInfo;
	}

}
