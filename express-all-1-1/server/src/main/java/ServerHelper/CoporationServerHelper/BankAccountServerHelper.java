/**
 * @author 谭琼
 * 2015年12月4日
 */
package ServerHelper.CoporationServerHelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import dataservice.corporationdataservice.BankAccountCorporationdataService;
import impl.corporationImpl.BankAccountImpl;

public class BankAccountServerHelper {
	public void go() {
		try {
			BankAccountCorporationdataService bankAccountCorporationdataService = new BankAccountImpl();
			Registry registry = LocateRegistry.createRegistry(32003);
			registry.rebind("bankAccountCorporationdataService", bankAccountCorporationdataService);
			System.out.println("bankAccountCorporationdataService RMI服务绑定成功...等待远程调用请求...");
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}
