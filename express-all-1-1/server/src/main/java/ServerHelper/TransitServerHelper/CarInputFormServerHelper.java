package serverhelper.TransitServerHelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.CarInputFormTransitdataService;
import impl.transitImpl.CarInputFormIml;

public class CarInputFormServerHelper {
	public void goInsert() {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = new CarInputFormIml();
			Registry registry = LocateRegistry.createRegistry(32000);
			registry.rebind("carInputFormTransitdataService", carInputFormTransitdataService);
			System.out.println("RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	public void goPrint() {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = new CarInputFormIml();
			Registry registry = LocateRegistry.createRegistry(32000);
			registry.rebind("carInputFormTransitdataService", carInputFormTransitdataService);
			System.out.println("RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
	}

}
