package businesslogic.inventorybl;

import java.util.ArrayList;

import state.NodeState;
import state.Zone;
import vo.InventoryInfoVO;

public class MockInventoryInfo extends InventoryInfo {

	ArrayList<LocationNode> locationNode = new ArrayList<LocationNode>();
	LocationNode locationnode = new LocationNode();
	InventoryInfoVO ivo = new InventoryInfoVO();
	
	double limit;
	Zone emptyZone;
	NodeState state;
	
	public MockInventoryInfo(){
		
	}
	
	public NodeState getNodeState(Zone zone,int line,int shelf,int tag){
		state = locationnode.getState(zone,line,shelf,tag);
		return state;
	}
	
	public Zone getEmptyZone(){
		emptyZone = ivo.getEmptyZone();
		return emptyZone;
	}
	
	public double getLimit(){
		limit = ivo.getLimit();
		return limit;	
	}
	
	
}
