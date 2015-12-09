/**
 * 用户账户信息模块数据层接口
 * @author 谭琼
 * 2015年12月4日
 */
package dataservice.userdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.UserAccountPO;

/**
 * 用户账户数据层接口
 */
public interface UserAccountUserdataService extends Remote{
	
	/**
	 * 根据用户账号userAccountID查找用户账户信息
	 * @param userAccountID
	 * @return
	 * @throws RemoteException
	 */
	public UserAccountPO find(String userAccountID) throws RemoteException;
	
	/**
	 * 添加用户账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(UserAccountPO po) throws RemoteException;
	
	/**
	 * 删除用户账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(UserAccountPO po) throws RemoteException;
	
	/**
	 * 更新用户账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(UserAccountPO po) throws RemoteException;
}
