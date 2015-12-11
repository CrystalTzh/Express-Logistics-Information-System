package serverhelper.transitserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.transitdataservice.TransferFormTransitdataService;
import impl.transitImpl.TransferFormImpl;

public class TransferFormServerHelper {

	public void go() {
		try {
			TransferFormTransitdataService transferFormTransitdataService = new TransferFormImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("transferFormTransitdataService", transferFormTransitdataService);
			System.out.println("transferFormTransitdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
	
}
