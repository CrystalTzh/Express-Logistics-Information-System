/**
 * @author 谭琼
 * 2015年12月2日
 */
package serverhelper.CoporationServerHelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.corporationdataservice.CarInfoCorporationdataService;
import impl.corporationImpl.CarInfoServiceImpl;

public class CarInfoServerHelper {
	public void go() {
		try {
			CarInfoCorporationdataService carInfoCorporationdataService = new CarInfoServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32010);
			registry.rebind("carInfoCorporationdataService", carInfoCorporationdataService);
			System.out.println("carInfoCorporationdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
