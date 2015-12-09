package businesslogic.inventorybl;

import java.util.ArrayList;

import state.NodeState;
import state.Zone;

public class PLANENode extends LocationNode {
	
	public PLANENode(){
		this.state = NodeState.VACANT;
	}

public PLANENode(Zone zone, int line, int shelf, int tag, long ID,
			NodeState state) {
		super(zone, line, shelf, tag, ID, state);
		// TODO Auto-generated constructor stub
		this.zone = zone;
		this.state = state;
		this.line = line;
		this.shelf = shelf;
		this.tag = tag;
		this.ID = ID;
	}

//	public NodeState getNodeState(Zone zone,int line,int shelf,int tag){
//		PLANENode planenode = new PLANENode();
//		
//		return vacantplanenode;
//		
//	}
	
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
	
}
