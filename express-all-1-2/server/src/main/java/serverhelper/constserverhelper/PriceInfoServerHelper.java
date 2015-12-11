/**
 * @author 谭琼
 * 2015年12月8日
 */
package serverhelper.constserverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.constdataservice.PriceInfoConstdataService;
import impl.constImpl.PriceInfoServiceImpl;

public class PriceInfoServerHelper {
	public void go() {
		try {
			PriceInfoConstdataService priceInfoConstdataService = new PriceInfoServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("priceInfoConstdataService", priceInfoConstdataService);
			System.out.println("priceInfoConstdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
