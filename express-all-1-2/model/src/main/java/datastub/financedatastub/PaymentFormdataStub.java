package datastub.financedatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.PaymentFormdataService;
import po.PaymentFormPO;

public class PaymentFormdataStub implements PaymentFormdataService{

	public PaymentFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		PaymentFormPO po=new PaymentFormPO();
		return po;
	}

	public void insert(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	@Override
	public ArrayList<PaymentFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
