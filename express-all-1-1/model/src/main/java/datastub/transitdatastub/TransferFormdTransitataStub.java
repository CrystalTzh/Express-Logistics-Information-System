package datastub.transitdatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.transitdataservice.TransferFormdTransitataService;
import po.TransferFormPO;
import state.Transport;

public class TransferFormdTransitataStub implements TransferFormdTransitataService{
	public TransferFormPO find(long NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		TransferFormPO po = new TransferFormPO("2015.1.1",123456,"a","b","c",Transport.CAR,"1",1,1,1,null,1.1);
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
