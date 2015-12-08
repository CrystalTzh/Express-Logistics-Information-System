package datastub.corporationdatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.corporationdataservice.CarInfoCorporationdataService;
import po.CarInfoPO;
import po.OrderFormPO;

public class CarInfoCorporationdataStub implements CarInfoCorporationdataService{
	public ArrayList<CarInfoPO> find() throws RemoteException {
		System.out.println("Find Succeed!\n");
		ArrayList<CarInfoPO> po = new ArrayList<CarInfoPO>();
		return po;
	}
	public void update(CarInfoPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
	public void add(CarInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
	}
	public void delete(CarInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
	}
	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.CarInfoCorporationdataService#find(java.lang.String)
	 */
	public CarInfoPO find(String carNumber) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
}
