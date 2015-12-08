package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.BeginningAccountdataService;

import po.BeginningAccountPO;

public class BeginningAccountServiceImpl extends UnicastRemoteObject implements BeginningAccountdataService {

	public BeginningAccountServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public BeginningAccountPO find(int year) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding BeginningAccountPO...");
		return null;
	}

	public void insert(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
