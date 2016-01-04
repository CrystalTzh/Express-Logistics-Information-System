/**
 * 公司信息模块数据层接口
 * @author 谭琼
 * 2015年12月4日
 */
package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.BankAccountInfoPO;

/**
 * 银行账户数据层接口
 */
public interface BankAccountCorporationdataService extends Remote{
	
	/**
	 * 找到所有银行账户
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountInfoPO> findAllBankAccouts() throws RemoteException;
	
	/**
	 * 添加银行账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(BankAccountInfoPO po) throws RemoteException;
	
	/**
	 * 删除银行账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(BankAccountInfoPO po) throws RemoteException;
	
	/**
	 * 更新银行账户信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(BankAccountInfoPO po) throws RemoteException;
	
	/**
	 * 根据银行账户的账号查找银行账户信息
	 * @param accountID
	 * @return
	 * @throws RemoteException
	 */
	public BankAccountInfoPO find(String accountID) throws RemoteException;
	
//	/**
//	 * 关键字模糊查找银行账户信息
//	 * @param accountID
//	 * @return
//	 * @throws RemoteException
//	 */
//	public ArrayList<BankAccountInfoPO> keyFind(String keyID) throws RemoteException;
}
