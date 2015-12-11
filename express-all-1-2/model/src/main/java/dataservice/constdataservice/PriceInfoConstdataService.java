/**
 * 常量信息模块数据层接口
 * @author 谭琼
 * 2015年12月8日
 */
package dataservice.constdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PricePO;

/**
 * 价格常量信息数据层接口
 */
public interface PriceInfoConstdataService extends Remote{

	/**
	 * 初始化价格常量信息
	 * @throws RemoteException
	 */
	public void init() throws RemoteException;
	
	/**
	 * 更新价格常量信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(PricePO po) throws RemoteException;
	
	/**
	 * 查找价格常量信息
	 * @return
	 * @throws RemoteException
	 */
	public PricePO find() throws RemoteException;
}	
