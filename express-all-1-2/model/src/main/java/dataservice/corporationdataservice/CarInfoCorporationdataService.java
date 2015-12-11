package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CarInfoPO;

public interface CarInfoCorporationdataService extends Remote {
	public void add(CarInfoPO po)throws RemoteException;
	public void delete(CarInfoPO po) throws RemoteException;
	public void update(CarInfoPO po) throws RemoteException;
	/**
	 * @param carNumber
	 * @return
	 */
	public CarInfoPO find(String carNumber) throws RemoteException;
}
