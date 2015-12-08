/**
 * @author 谭琼
 * 2015年12月3日
 */
package serverhelper.UserServerHelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.userdataservice.UserAccountUserdataService;
import impl.userImpl.UserAccountServiceImpl;

public class UserAccountServerHelper {
	public void go() {
		try {
			UserAccountUserdataService userAccountUserdataService = new UserAccountServiceImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("userAccountUserdataService", userAccountUserdataService);
			System.out.println("userAccountUserdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
