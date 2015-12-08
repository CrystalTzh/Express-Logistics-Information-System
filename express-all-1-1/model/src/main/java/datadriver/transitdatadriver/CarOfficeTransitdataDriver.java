package datadriver.transitdatadriver;

import java.rmi.RemoteException;


import dataservice.transitdataservice.CarOfficeTransitdataService;
import po.CarOfficeFormPO;

public class CarOfficeTransitdataDriver {
	public void driver(CarOfficeTransitdataService carOfficeTransitdataStub) throws RemoteException{
		CarOfficeFormPO po=new CarOfficeFormPO(10086, "111111", "12", "hell", "9", "123", null, null, null, 1234);
		carOfficeTransitdataStub.delete(po);
		carOfficeTransitdataStub.find(0);
		carOfficeTransitdataStub.insert(po);
		carOfficeTransitdataStub.update(po);
	}
}
