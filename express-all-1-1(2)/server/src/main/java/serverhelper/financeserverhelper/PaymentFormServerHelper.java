package serverhelper.financeserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.financedataservice.PaymentFormdataService;
import impl.financeImpl.PaymentFormServiceImpl;


public class PaymentFormServerHelper {
	public void go() {
		try {
			PaymentFormdataService paymentFormdataService = new PaymentFormServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("paymentFormdataService", paymentFormdataService);
			System.out.println("paymentFormdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
