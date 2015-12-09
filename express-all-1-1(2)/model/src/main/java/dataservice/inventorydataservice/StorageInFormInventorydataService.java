package dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.StorageInFormPO;

public interface StorageInFormInventorydataService extends Remote{
	public StorageInFormPO find(String no) throws RemoteException;
	public void insert(StorageInFormPO po) throws RemoteException;
	public void delete(StorageInFormPO po) throws RemoteException;
	public void update(StorageInFormPO po) throws RemoteException;
}
