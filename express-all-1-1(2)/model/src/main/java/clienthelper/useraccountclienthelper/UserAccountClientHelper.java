/**
 * 用户模块客户端建立RMI连接
 * @author 谭琼
 * 2015年12月5日
 */
package clienthelper.useraccountclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.userdataservice.UserAccountUserdataService;
import po.UserAccountPO;

/**
 * 在客户端，用户账户建立RMI连接
 */
public class UserAccountClientHelper {

	UserAccountUserdataService userAccountUserdataService = null;

	/**
	 * 通过RMI远程更新用户账户信息
	 * 
	 * @param po
	 * @return
	 */
	public boolean goUpdate(UserAccountPO po) {
		System.out.println("进入UserAccountClientHelper...goUpadte...");
		userAccountUserdataService = go();
		try {
			userAccountUserdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 通过RMI远程删除用户账户信息
	 * 
	 * @param po
	 * @return
	 */
	public boolean goDelete(UserAccountPO po) {
		System.out.println("进入UserAccountClientHelper...goDelete...");
		userAccountUserdataService = go();
		try {
			userAccountUserdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 通过RMI远程删除用户账户信息
	 * 
	 * @param po
	 * @return
	 */
	public boolean goInsert(UserAccountPO po) {
		System.out.println("进入UserAccountClientHelper...goInsert...");
		userAccountUserdataService = go();
		try {
			userAccountUserdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 通过RMI远程查找用户账户信息
	 * 
	 * @param accountID
	 * @return
	 */
	public UserAccountPO goFind(String accountID) {
		System.out.println("进入UserAccountClientHelper...goFind...");
		userAccountUserdataService = go();
		UserAccountPO po;
		try {
			po = userAccountUserdataService.find(accountID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 客户端建立userAccountUserdataService服务的RMI连接
	 * @return
	 */
	public UserAccountUserdataService go() {
		System.out.println("进入UserAccountClientHelper...go...");
		if (userAccountUserdataService == null) {
			try {
				userAccountUserdataService = (UserAccountUserdataService) Naming
						.lookup("rmi://127.0.0.1:32003/userAccountUserdataService");
				System.out.println("userAccountUserdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			}
		}
		return userAccountUserdataService;
	}
}
