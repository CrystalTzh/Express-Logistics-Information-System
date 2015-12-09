package datastub.transitdatastub;

import java.rmi.RemoteException;

import dataservice.transitdataservice.TransferFormTransitdataService;
import po.TransferFormPO;

public class TransferFormdTransitataStub implements TransferFormTransitdataService{
	public TransferFormPO find(String NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		TransferFormPO po = new TransferFormPO();
		return po;
	}
	public void insert(TransferFormPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(TransferFormPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(TransferFormPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
}
