package datastub.transitdatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormTransitdataStub implements OfficeArrivalFormTransitdataService{

	public OfficeArrivalFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		 OfficeArrivalFormPO po=new  OfficeArrivalFormPO ();
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

	@Override
	public ArrayList<OfficeArrivalFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

}
