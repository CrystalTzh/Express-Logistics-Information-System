package datastub.financedatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.financedataservice.ReceiptFormdataService;
import po.ReceiptFormPO;

public class ReceiptFormdataStub implements ReceiptFormdataService{
	public ReceiptFormPO find(String NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		ReceiptFormPO po = new ReceiptFormPO();
		return po;
	}
	public void insert(ReceiptFormPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(ReceiptFormPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(ReceiptFormPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
	@Override
	public ArrayList<ReceiptFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
