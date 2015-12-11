package serverhelper.inventoryserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.inventorydataservice.StorageInFormInventorydataService;
import impl.inventoryImpl.StorageInFormServiceImpl;

public class StorageInFormServerHelper {

	
	public void go() {
		try {
			StorageInFormInventorydataService storageInFormInventorydataService = new StorageInFormServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32004);
			registry.rebind("storageInFormInventorydataService", storageInFormInventorydataService);
			System.out.println("storageInFormInventorydataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
