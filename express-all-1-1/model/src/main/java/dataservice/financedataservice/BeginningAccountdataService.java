package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.BeginningAccountPO;

public interface BeginningAccountdataService extends Remote{
	public BeginningAccountPO find(int year) throws RemoteException;
	public void insert(BeginningAccountPO po) throws RemoteException;
	public void delete(BeginningAccountPO po) throws RemoteException;
	public void update(BeginningAccountPO po) throws RemoteException;
}
