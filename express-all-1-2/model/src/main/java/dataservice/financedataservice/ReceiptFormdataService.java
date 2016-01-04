package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceiptFormPO;

public interface ReceiptFormdataService extends Remote{
	public ArrayList<ReceiptFormPO> findAll() throws RemoteException;
	public ReceiptFormPO find(String NO) throws RemoteException;
	public void insert(ReceiptFormPO po) throws RemoteException;
	public void delete(ReceiptFormPO po) throws RemoteException;
	public void update(ReceiptFormPO po) throws RemoteException;
}
