package datastub.transitdatastub;

import java.rmi.RemoteException;

import dataservice.transitdataservice.CarInputFormTransitdataService;
import po.CarInputFormPO;

public class CarInputTransitFormdataStub implements CarInputFormTransitdataService{
	public CarInputFormPO find(long NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		CarInputFormPO po = new CarInputFormPO(0, null, null, null, null, null, null, null, 0);
		return po;
	}
	public void insert(CarInputFormPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(CarInputFormPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(CarInputFormPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
	/* (non-Javadoc)
	 * @see dataservice.transitdataservice.CarInputFormTransitdataService#print(java.lang.String)
	 */
	public String print(String str) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
