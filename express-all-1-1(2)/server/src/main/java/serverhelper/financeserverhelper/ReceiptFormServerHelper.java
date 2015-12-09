package serverhelper.financeserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.financedataservice.ReceiptFormdataService;
import impl.financeImpl.ReceiptFormServiceImpl;

public class ReceiptFormServerHelper {
	public void go() {
		try {
			ReceiptFormdataService receiptFormdataService = new ReceiptFormServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("receiptFormdataService", receiptFormdataService);
			System.out.println("receiptFormdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
