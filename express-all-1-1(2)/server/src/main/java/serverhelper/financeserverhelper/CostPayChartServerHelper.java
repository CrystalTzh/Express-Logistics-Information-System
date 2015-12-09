package serverhelper.financeserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.financedataservice.CostPayChartdataService;

import impl.financeImpl.CostPayChartServiceImpl;


public class CostPayChartServerHelper {
	public void go() {
		try {
			CostPayChartdataService costpayChartdataService = new CostPayChartServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("costpayChartdataService", costpayChartdataService);
			System.out.println("costPayChartdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
