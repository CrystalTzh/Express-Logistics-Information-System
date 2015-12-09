package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.BankAccountInfoPO;

public interface BankAccountInfodataService extends Remote{
	public BankAccountInfoPO find(long bankAccount) throws RemoteException;
	public void insert(BankAccountInfoPO po) throws RemoteException;
	public void delete(BankAccountInfoPO po) throws RemoteException;
	public void update(BankAccountInfoPO po) throws RemoteException;
	
}
