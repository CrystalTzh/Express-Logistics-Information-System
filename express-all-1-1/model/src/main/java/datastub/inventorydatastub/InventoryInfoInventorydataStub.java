package datastub.inventorydatastub;

import java.rmi.RemoteException;

import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import po.InventoryInfoPO;
import state.Zone;

public class InventoryInfoInventorydataStub implements InventoryInfoInventorydataService{

	public InventoryInfoPO find() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
//		InventoryInfoPO po=new InventoryInfoPO(null, 0, Zone.CAR);
		return null;
	}

	public void update(InventoryInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

}
