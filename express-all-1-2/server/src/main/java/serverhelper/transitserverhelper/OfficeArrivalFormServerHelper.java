package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import impl.transitImpl.OfficeArrivalFormImpl;

public class OfficeArrivalFormServerHelper {
	public void go() {
		try {
			OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = new OfficeArrivalFormImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("officeArrivalFormTransitdataService", officeArrivalFormTransitdataService);
			System.out.println("officeArrivalFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
