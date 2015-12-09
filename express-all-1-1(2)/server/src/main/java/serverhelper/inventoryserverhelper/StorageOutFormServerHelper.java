package serverhelper.inventoryserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import impl.inventoryImpl.StorageOutFormServiceImpl;

public class StorageOutFormServerHelper {

	public void go() {
		try {
			StorageOutFromInventorydataService storageOutFormInventorydataService = new StorageOutFormServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("storageOutFormInventorydataService", storageOutFormInventorydataService);
			System.out.println("storageOutFormInventorydataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
