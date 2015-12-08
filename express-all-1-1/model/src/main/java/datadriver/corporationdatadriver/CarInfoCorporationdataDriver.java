package datadriver.corporationdatadriver;

import java.rmi.RemoteException;

import po.CarInfoPO;
import dataservice.corporationdataservice.CarInfoCorporationdataService;

public class CarInfoCorporationdataDriver {
	public void driver(CarInfoCorporationdataService carInfoCorporationdataStub) throws RemoteException{
		CarInfoPO po = new CarInfoPO(null, null, null, null, null, null);
		carInfoCorporationdataStub.update(po);
	}
}
