/**
 * @author 谭琼
 * 2015年12月8日
 */
package serverhelper.constserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.constdataservice.SalaryInfoConstdataService;
import impl.constImpl.SalaryInfoServiceImpl;

public class SalaryInfoServerHelper {
	public void go() {
		try {
			SalaryInfoConstdataService salaryInfoConstdataService = new SalaryInfoServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("salaryInfoConstdataService", salaryInfoConstdataService);
			System.out.println("salarydataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
