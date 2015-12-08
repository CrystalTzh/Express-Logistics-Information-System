package businesslogic.inventorybl;

import java.util.ArrayList;

import businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice;
import state.NodeState;
import state.Zone;
import vo.InventoryInfoVO;

public class InventoryInfo implements InventoryInfoInventoryblSercice{
	
	NodeState state;
	Zone zone;
	double limit;

	public NodeState getNodeState(Zone zone,int line,int shelf,int tag){
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		state = inventoryInfo.getNodeState(zone, line, shelf, tag);
		return state;
	}
	
	public Zone getEmptyZone(){
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		zone = inventoryInfo.getEmptyZone();
		return zone;
	}
	
	public double getLimit(){
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		limit = inventoryInfo.getLimit();
		return limit;
	}
	


	public boolean invetoryInfoSetWarningLimit(double limit) {
		// TODO Auto-generated method stub
		return false;
	}

	public Zone inventoryAlarm(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean invetoryAdjustment(Zone zone) {
		// TODO Auto-generated method stub
		return false;
	}

	public InventoryInfoVO storageCheck(String startTime, String endTime) {
		// TODO Auto-generated method stub
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		InventoryInfoVO ivo = new InventoryInfoVO();
		
		return null;
	}

	public InventoryInfoVO inventoryCounting(Zone zone) {
		// TODO Auto-generated method stub
		return null;
	}

	public InventoryInfoVO add(ArrayList<LocationNode> locationNode, double limit) {
		// TODO Auto-generated method stub
		return null;
	}

}
