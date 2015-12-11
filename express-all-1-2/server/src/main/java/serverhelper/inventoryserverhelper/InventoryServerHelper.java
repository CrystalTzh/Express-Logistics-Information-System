/**
 * @author 谭琼
 * 2015年12月9日
 */
package serverhelper.inventoryserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import impl.inventoryImpl.InventoryInfoServiceImpl;

public class InventoryServerHelper {
	public void go() {
		try {
			InventoryInfoInventorydataService inventoryInfoInventorydataService = new InventoryInfoServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("inventoryInfoInventorydataService", inventoryInfoInventorydataService);
			System.out.println("inventoryInfoInventorydataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
