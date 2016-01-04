package datastub.transitdatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.transitdataservice.CarInputFormTransitdataService;
import po.CarInputFormPO;

public class CarInputTransitFormdataStub implements CarInputFormTransitdataService{
	public CarInputFormPO find(String NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		CarInputFormPO po = new CarInputFormPO();
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
	@Override
	public ArrayList<CarInputFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
