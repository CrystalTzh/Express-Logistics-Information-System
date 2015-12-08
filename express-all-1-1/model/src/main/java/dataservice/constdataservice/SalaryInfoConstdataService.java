/**
 * 常量信息模块数据层接口
 * @author 谭琼
 * 2015年12月4日
 */
package dataservice.constdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.SalaryPO;

/**
 * 薪资标准信息数据层接口
 */
public interface SalaryInfoConstdataService extends Remote{
	
	/**
	 * 初始化薪资标准信息
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	
	/**
	 * 更新薪资标准信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(SalaryPO po) throws RemoteException;
	
	/**
	 * 查找薪资标准信息
	 * @return
	 * @throws RemoteException
	 */
	public SalaryPO find() throws RemoteException;
}
