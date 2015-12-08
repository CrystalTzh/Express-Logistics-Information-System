package datadriver.inventorydatadriver;

import java.rmi.RemoteException;


import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import po.InventoryInfoPO;
import state.Zone;

public class InventoryInfoInventorydataDriver {
	public void driver(InventoryInfoInventorydataService inventoryInfoInventorydataStub) throws RemoteException{
		InventoryInfoPO po=new InventoryInfoPO(null, 0, Zone.CAR);
		inventoryInfoInventorydataStub.find();
		
		inventoryInfoInventorydataStub.update(po);
	}
}
