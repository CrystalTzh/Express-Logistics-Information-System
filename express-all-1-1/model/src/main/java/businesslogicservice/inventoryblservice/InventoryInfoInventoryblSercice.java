package businesslogicservice.inventoryblservice;

import java.util.ArrayList;

import businesslogic.inventorybl.LocationNode;
import state.Zone;
import vo.InventoryInfoVO;

public interface InventoryInfoInventoryblSercice {
	
	public boolean invetoryInfoSetWarningLimit (double limit);
	
	public Zone inventoryAlarm(InventoryInfoVO vo);
	
	public boolean invetoryAdjustment (Zone zone);
	
	public InventoryInfoVO storageCheck(String startTime, String endTime);
	
	public InventoryInfoVO inventoryCounting(Zone zone);
	
	public InventoryInfoVO add(ArrayList<LocationNode> locationNode,double limit);
	
}
