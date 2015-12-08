/**
 * @author 谭琼
 * 2015年11月27日
 */
package ServerHelper.CoporationServerHelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import impl.corporationImpl.DriverInfoServiceImpl;

public class DriverInfoServerHelper {
	public void go() {
		try {
			DriverInfoCorporationdataService driverInfoCorporationdataService = new DriverInfoServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32001);
			registry.rebind("driverInfoCorporationdataService", driverInfoCorporationdataService);
			System.out.println("driverInfoCorporationdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
