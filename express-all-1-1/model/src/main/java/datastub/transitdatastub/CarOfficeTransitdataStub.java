package datastub.transitdatastub;

import java.rmi.RemoteException;


import dataservice.transitdataservice.CarOfficeTransitdataService;
import po.CarOfficeFormPO;

public class CarOfficeTransitdataStub implements CarOfficeTransitdataService{

	public CarOfficeFormPO find(long NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		CarOfficeFormPO po=new CarOfficeFormPO(10086, "111111", "12", "hell", "9", "123", null, null, null, 1234);
		return po;
	}

	public void insert(CarOfficeFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(CarOfficeFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(CarOfficeFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	

}
