package businesslogic.stub.inventoryblStub;

import java.util.ArrayList;

import state.FormState;
import state.Zone;
import vo.InventoryInfoVO;
import businesslogic.inventorybl.LocationNode;
import businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice;

public class InventoryInfoInventoryblStub implements InventoryInfoInventoryblSercice{

	public boolean invetoryInfoSetWarningLimit(double limit) {
		// TODO Auto-generated method stub
		System.out.println("call invetoryInfoSetWarningLimit...");
		return false;
	}

	public Zone inventoryAlarm(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call inventoryAlarm...");
		return null;
	}

	public boolean invetoryAdjustment(Zone zone) {
		// TODO Auto-generated method stub
		System.out.println("call invetoryAdjustment...");
		return false;
	}

	public InventoryInfoVO storageCheck(String startTime, String endTime) {
		// TODO Auto-generated method stub
		System.out.println("call storageCheck...");
		return null;
	}

	public InventoryInfoVO inventoryCounting(Zone zone) {
		// TODO Auto-generated method stub
		System.out.println("call inventoryCounting...");
		return null;
	}

	public InventoryInfoVO add(ArrayList<LocationNode> locationNode,
			double limit) {
		// TODO Auto-generated method stub
		InventoryInfoVO i = null;
		i = new InventoryInfoVO();
		return i;
	}

	public boolean setLimit(String inventoryID, double limit) {
		// TODO Auto-generated method stub
		return false;
	}

	public double findLimit(String inventoryID) {
		// TODO Auto-generated method stub
		return 0;
	}

	public InventoryInfoVO findInventoryInfo(String inventoryID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean addInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
