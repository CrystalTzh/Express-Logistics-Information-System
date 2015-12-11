package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ReceiptFormPO;

public interface ReceiptFormdataService extends Remote{
	public ReceiptFormPO find(String NO) throws RemoteException;
	public void insert(ReceiptFormPO po) throws RemoteException;
	public void delete(ReceiptFormPO po) throws RemoteException;
	public void update(ReceiptFormPO po) throws RemoteException;
}
