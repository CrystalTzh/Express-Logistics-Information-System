package businesslogic.inventorybl;

import java.io.Serializable;
import java.util.ArrayList;

import state.NodeState;
import state.Zone;

public class LocationNode implements Serializable{
	Zone zone; //区号
	int line; //排号
	int shelf; //架号
	int tag; //位号
	long ID; //每个位置对应的订单号
	NodeState state = NodeState.VACANT; //每个位置的状态（被占据、空闲）
	
	ArrayList<PLANENode> takenplanenode;
	ArrayList<PLANENode> vacantplanenode;
	
//	PLANENode pn;
	public LocationNode(){
//		pn.initNode(zone, line, line, line);
	}
	
	public LocationNode(Zone zone, int line, int shelf, int tag, long ID, NodeState state) {
		super();
		// TODO Auto-generated constructor stub
		this.zone = zone;
		this.line = line;
		this.shelf = shelf;
		this.tag = tag;
		this.ID = ID;
		this.state = state;
		
	}

	public Zone getZone() {
		return zone;
	}

	public int getLine() {
		return line;
	}

	public int getShelf() {
		return shelf;
	}

	public int getTag() {
		return tag;
	}

	public NodeState getState(Zone zone,int line,int shelf,int tag) {
		return state;
	}

	public void setZone(Zone zone) {
		this.zone = zone;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public void setShelf(int shelf) {
		this.shelf = shelf;
	}

	public void setTag(int tag) {
		this.tag = tag;
	}
	//当把机动仓库调整为相应的区时，就把tag*2
	
	public void setState(NodeState state,Zone zone,int line,int shelf,int tag) {
		this.state = state;
	}
	
	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public NodeState add(long ID,Zone zone,int line,int shelf,int tag){
		NodeState currentState = getState(zone, line, shelf, tag);
		currentState = opposite(currentState);
		return currentState;	
	}
	
	public NodeState remove(long ID,Zone zone,int line,int shelf,int tag){
		NodeState currentState = getState(zone, line, shelf, tag);
		currentState = opposite(currentState);
		return currentState;	
	}
	public NodeState opposite(NodeState state){
		
		if(state == NodeState.TAKEN){
			state = NodeState.VACANT;
		}else if(state == NodeState.VACANT){
			state = NodeState.TAKEN;
		}
		return state;
		
	}
	
}
