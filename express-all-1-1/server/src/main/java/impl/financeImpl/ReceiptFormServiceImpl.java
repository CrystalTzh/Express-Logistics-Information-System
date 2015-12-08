package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.ReceiptFormdataService;
import po.ReceiptFormPO;

public class ReceiptFormServiceImpl extends UnicastRemoteObject implements ReceiptFormdataService{

	public ReceiptFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiptFormPO find(long NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding ReceiptFormPO...");
		return null;
	}

	public void insert(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	

}
