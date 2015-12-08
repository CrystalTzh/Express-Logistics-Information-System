package datadriver.transitdatadriver;

import java.rmi.RemoteException;


import dataservice.transitdataservice.StoreArrivalFormTransitdataService;

import po.StoreArrivalFormPO;

public class StoreArrivalFormTransitdataDriver {
	public void driver(StoreArrivalFormTransitdataService storeArrivalFormTransitdataStub) throws RemoteException{
		StoreArrivalFormPO po=new  StoreArrivalFormPO ();
		storeArrivalFormTransitdataStub.delete(po);
		storeArrivalFormTransitdataStub.find(0);
		storeArrivalFormTransitdataStub.insert(po);
		storeArrivalFormTransitdataStub.update(po);
	}
}
