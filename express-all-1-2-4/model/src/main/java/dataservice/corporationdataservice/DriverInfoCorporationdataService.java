package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DriverInfoPO;

/**
 * 司机信息数据层接口
 */
public interface DriverInfoCorporationdataService extends Remote{
	
	/**
	 * 查找所有司机信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverInfoPO> findAll() throws RemoteException;
	
	/**
	 * 根据司机编号查找司机信息
	 * @param driverNumber
	 * @return
	 * @throws RemoteException
	 */
	public DriverInfoPO find(String driverNumber) throws RemoteException;
	
	/**
	 * 更新司机信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(DriverInfoPO po) throws RemoteException;
	
	/**
	 * 添加司机信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(DriverInfoPO po) throws RemoteException;
	
	/**
	 * 删除司机信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(DriverInfoPO po) throws RemoteException;
}
