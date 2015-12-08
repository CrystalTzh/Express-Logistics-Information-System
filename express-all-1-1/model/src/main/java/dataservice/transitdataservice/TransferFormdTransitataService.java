package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.TransferFormPO;

public interface TransferFormdTransitataService extends Remote{
	public TransferFormPO find(long NO) throws RemoteException, IllegalArgumentException;
	public void insert(TransferFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(TransferFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(TransferFormPO po) throws RemoteException, IllegalArgumentException;
}
