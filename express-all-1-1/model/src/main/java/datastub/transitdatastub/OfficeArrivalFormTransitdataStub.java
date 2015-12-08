package datastub.transitdatastub;

import java.rmi.RemoteException;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormTransitdataStub implements OfficeArrivalFormTransitdataService{

	public OfficeArrivalFormPO find(long NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		 OfficeArrivalFormPO po=new  OfficeArrivalFormPO (12222, null, 10086, null, null, null);
		return po;
	}

	public void insert(OfficeArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(OfficeArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(OfficeArrivalFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

}
