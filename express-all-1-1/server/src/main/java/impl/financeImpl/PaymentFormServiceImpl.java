package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.PaymentFormdataService;
import po.PaymentFormPO;

public class PaymentFormServiceImpl extends UnicastRemoteObject implements PaymentFormdataService{

	public PaymentFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentFormPO find(long NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding PaymentFormPO...");
		return null;
	}

	public void insert(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	

}
