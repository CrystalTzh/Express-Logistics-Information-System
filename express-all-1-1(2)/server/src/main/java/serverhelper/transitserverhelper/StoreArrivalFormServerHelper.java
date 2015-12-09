package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import impl.transitImpl.StoreArrivalFormImpl;

public class StoreArrivalFormServerHelper {
	
	public void go() {
		try {
			StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = new StoreArrivalFormImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("storeArrivalFormTransitdataService", storeArrivalFormTransitdataService);
			System.out.println("storeArrivalFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
