package datadriver.inventorydatadriver;

import java.rmi.RemoteException;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.StorageOutFormPO;
import state.Transport;

public class StorageOutFormInventorydataDriver {
	public void driver(StorageOutFromInventorydataService storageOutFormInventorydataStub) throws RemoteException{
		StorageOutFormPO po=new StorageOutFormPO("001","A", "10086", "b", Transport.CAR);
		storageOutFormInventorydataStub.delete(po);
		storageOutFormInventorydataStub.find("001");
		storageOutFormInventorydataStub.insert(po);
		storageOutFormInventorydataStub.update(po);
	}
}
