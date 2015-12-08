package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.PaymentFormPO;

public interface PaymentFormdataService extends Remote{
	public PaymentFormPO find(long NO) throws RemoteException;
	public void insert(PaymentFormPO po) throws RemoteException;
	public void delete(PaymentFormPO po) throws RemoteException;
	public void update(PaymentFormPO po) throws RemoteException;
}
