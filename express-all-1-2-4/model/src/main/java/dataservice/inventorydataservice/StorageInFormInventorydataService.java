package dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageInFormPO;

public interface StorageInFormInventorydataService extends Remote{
	public ArrayList<StorageInFormPO> findAll() throws RemoteException;
	public StorageInFormPO find(String no) throws RemoteException;
	public void insert(StorageInFormPO po) throws RemoteException;
	public void delete(StorageInFormPO po) throws RemoteException;
	public void update(StorageInFormPO po) throws RemoteException;
}
