package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.CarInputFormTransitdataService;
import impl.transitImpl.CarInputFormIml;

public class CarInputFormServerHelper {
	public void go() {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = new CarInputFormIml();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("carInputFormTransitdataService", carInputFormTransitdataService);
			System.out.println("carInputFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
