package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.TransferFormPO;

public interface TransferFormTransitdataService extends Remote{
	public TransferFormPO find(String NO) throws RemoteException, IllegalArgumentException;
	public void insert(TransferFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(TransferFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(TransferFormPO po) throws RemoteException, IllegalArgumentException;
}
