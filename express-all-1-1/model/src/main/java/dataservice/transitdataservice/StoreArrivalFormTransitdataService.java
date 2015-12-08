package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StoreArrivalFormPO;

public interface StoreArrivalFormTransitdataService extends Remote{
	public StoreArrivalFormPO find(long NO) throws RemoteException, IllegalArgumentException;
	public void insert(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
}
