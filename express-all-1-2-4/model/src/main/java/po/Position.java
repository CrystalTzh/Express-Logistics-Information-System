/**
 * @author 谭琼
 * 2015年12月8日
 */
package po;

import java.io.Serializable;

import state.Line;
import state.NodeState;
import state.Shelf;
import state.Tag;
import state.Zone;

/**
 * 仓库位置信息的持久化对象
 */
public class Position implements Serializable{

	private static final long serialVersionUID = 1L;
	Zone zone; //区号
	Line line; //排号
	Shelf shelf; //架号
	Tag tag; //位号
	String ID; //每个位置对应的订单号
	NodeState state; //每个位置的状态（被占据、空闲）
	
	public Position() {
		state = NodeState.VACANT;
		zone = Zone.CAR;
		line = null;
		shelf = null;
		tag = null;
		ID = null;
	}
	
	
	public Line getLine() {
		return line;
	}


	public Shelf getShelf() {
		return shelf;
	}


	public Tag getTag() {
		return tag;
	}


	public void setLine(Line line) {
		this.line = line;
	}


	public void setShelf(Shelf shelf) {
		this.shelf = shelf;
	}


	public void setTag(Tag tag) {
		this.tag = tag;
	}


	public Zone getZone() {
		return zone;
	}
	public String getID() {
		return ID;
	}
	public NodeState getState() {
		return state;
	}
	public void setZone(Zone zone) {
		this.zone = zone;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setState(NodeState state) {
		this.state = state;
	}
	
}
