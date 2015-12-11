package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.CarOfficeTransitdataService;
import impl.transitImpl.CarOfficeFormImpl;

public class CarOfficeFormServerHelper {
	public void go() {
		try {
			CarOfficeTransitdataService carOfficeTransitdataService = new CarOfficeFormImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("carOfficeTransitdataService", carOfficeTransitdataService);
			System.out.println("carOfficeTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
