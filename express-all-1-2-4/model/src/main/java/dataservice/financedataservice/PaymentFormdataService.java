package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.PaymentFormPO;

public interface PaymentFormdataService extends Remote{
	public ArrayList<PaymentFormPO> findAll() throws RemoteException;
	public PaymentFormPO find(String NO) throws RemoteException;
	public void insert(PaymentFormPO po) throws RemoteException;
	public void delete(PaymentFormPO po) throws RemoteException;
	public void update(PaymentFormPO po) throws RemoteException;
}
