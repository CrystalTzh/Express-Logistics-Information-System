package serverhelper.financeserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import dataservice.financedataservice.ProfitChartdataService;

import impl.financeImpl.ProfitChartServiceImpl;

public class ProfitChartServerHelper {
	public void go() {
		try {
			ProfitChartdataService profitChartdataService = new ProfitChartServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("profitChartdataService", profitChartdataService);
			System.out.println("profitChartdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
