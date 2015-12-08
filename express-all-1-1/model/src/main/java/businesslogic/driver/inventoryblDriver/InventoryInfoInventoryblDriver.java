package businesslogic.driver.inventoryblDriver;

import state.Zone;
import vo.InventoryInfoVO;
import businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice;

public class InventoryInfoInventoryblDriver {
	public void driver(InventoryInfoInventoryblSercice inventoryInfoInventoryblStub){
		InventoryInfoVO inventoryInfoVO = inventoryInfoInventoryblStub.add(null, 0.9);
		Zone zone = inventoryInfoVO.getEmptyZone();
		System.out.println("The emptyZone is "+zone);
		inventoryInfoInventoryblStub.inventoryAlarm(inventoryInfoVO);
		inventoryInfoInventoryblStub.inventoryCounting(Zone.CAR);
		inventoryInfoInventoryblStub.invetoryAdjustment(Zone.CAR);
		inventoryInfoInventoryblStub.invetoryInfoSetWarningLimit(0.9);
		inventoryInfoInventoryblStub.storageCheck("20151023", "20151026");
	}
}
