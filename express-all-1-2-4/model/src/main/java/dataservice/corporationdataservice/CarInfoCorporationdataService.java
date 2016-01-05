package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CarInfoPO;

/**
 * 司机信息数据层接口
 */
public interface CarInfoCorporationdataService extends Remote {
	
	/**
	 * 找到服务器中所有的车辆信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CarInfoPO> findAll() throws RemoteException;
	
	/**
	 * 添加车辆信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(CarInfoPO po)throws RemoteException;
	
	/**
	 * 删除车辆信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(CarInfoPO po) throws RemoteException;
	
	/**
	 * 更新车辆信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(CarInfoPO po) throws RemoteException;
	
	/**
	 * 查找车辆信息
	 * @param carNumber
	 * @return
	 * @throws RemoteException
	 */
	public CarInfoPO find(String carNumber) throws RemoteException;
}
