package datadriver.transitdatadriver;

import java.rmi.RemoteException;

import po.CarInputFormPO;
import dataservice.transitdataservice.CarInputFormTransitdataService;

public class CarInputTransitFormdataDriver {
	public void driver(CarInputFormTransitdataService carInputTransitFormdataStub) throws RemoteException{
		CarInputFormPO po = new CarInputFormPO(0, null, null, null, null, null, null, null, 0);
		carInputTransitFormdataStub.delete(po);
		carInputTransitFormdataStub.find(0);
		carInputTransitFormdataStub.insert(po);
		carInputTransitFormdataStub.update(po);
	}
}
