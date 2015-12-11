/**
 * @author 谭琼
 * 2015年12月9日
 */
package vo;

import java.io.Serializable;

import state.NodeState;
import state.Zone;

/**
 * @author mac
 *
 */
public class PositionVO implements Serializable{

	private static final long serialVersionUID = 1L;
	Zone zone; //区号
	String line; //排号
	String shelf; //架号
	String tag; //位号
	String ID; //每个位置对应的订单号
	NodeState state; //每个位置的状态（被占据、空闲）
	//进仓库的时间
	//出仓库的时间
	
	public PositionVO() {
		state = NodeState.VACANT;
		zone = Zone.CAR;
		line = null;
		shelf = null;
		tag = null;
		ID = null;
	}
	
	public Zone getZone() {
		return zone;
	}
	public String getLine() {
		return line;
	}
	public String getShelf() {
		return shelf;
	}
	public String getTag() {
		return tag;
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
	public void setLine(String line) {
		this.line = line;
	}
	public void setShelf(String shelf) {
		this.shelf = shelf;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public void setState(NodeState state) {
		this.state = state;
	}
}
