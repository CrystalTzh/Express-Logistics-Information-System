package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import dataservice.transitdataservice.DeliveryFormTransitdataService;
import impl.transitImpl.DeliveryFormImpl;

public class DeliveryFormServerHelper {
	public void go() {
		try {
			DeliveryFormTransitdataService deliveryFormTransitdataService = new DeliveryFormImpl();
			Registry registry = LocateRegistry.createRegistry(32100);
			registry.rebind("deliveryFormTransitdataService", deliveryFormTransitdataService);
			System.out.println("deliveryFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
