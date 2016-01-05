package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StoreArrivalFormPO;

public interface StoreArrivalFormTransitdataService extends Remote{
	public StoreArrivalFormPO find(String NO) throws RemoteException, IllegalArgumentException;
	public void insert(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	public ArrayList<StoreArrivalFormPO> findAll()throws RemoteException, IllegalArgumentException;
}
