package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.OrderFormTransitdataService;
import impl.transitImpl.OrderFormTransitImpl;

public class OrderFormServerHelper {
	
	public void go() {
		try {
			OrderFormTransitdataService orderFormTransitdataService = new OrderFormTransitImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("orderFormTransitdataService", orderFormTransitdataService);
			System.out.println("orderFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
