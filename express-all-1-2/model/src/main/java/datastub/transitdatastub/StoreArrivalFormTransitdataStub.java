package datastub.transitdatastub;

import java.rmi.RemoteException;

import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import po.StoreArrivalFormPO;

public class StoreArrivalFormTransitdataStub implements StoreArrivalFormTransitdataService{

	public StoreArrivalFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		StoreArrivalFormPO po=new StoreArrivalFormPO();
		return po;
	}

	public void insert(StoreArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
	}

	public void delete(StoreArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
	}

	public void update(StoreArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
	}

}
