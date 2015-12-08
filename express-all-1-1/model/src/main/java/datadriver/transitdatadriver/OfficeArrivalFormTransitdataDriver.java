package datadriver.transitdatadriver;

import java.rmi.RemoteException;


import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormTransitdataDriver {
	public void driver(OfficeArrivalFormTransitdataService officeArrivalFormTransitdataStub) throws RemoteException{
		OfficeArrivalFormPO po=new  OfficeArrivalFormPO (12222, null, 10086, null, null, null);
		officeArrivalFormTransitdataStub.delete(po);
		officeArrivalFormTransitdataStub.find(0);
		officeArrivalFormTransitdataStub.insert(po);
		officeArrivalFormTransitdataStub.update(po);
	}
}
