package datadriver.transitdatadriver;

import java.rmi.RemoteException;

import po.DeliveryFormPO;
import dataservice.transitdataservice.DeliveryFormTransitdataService;

public class DeliveryFormTransitdataDriver {
	public void driver(DeliveryFormTransitdataService deliveryFormTransitdataStub) throws RemoteException{
		DeliveryFormPO po = new DeliveryFormPO(null, null, null);
		deliveryFormTransitdataStub.delete(po);
		deliveryFormTransitdataStub.find(null);
		deliveryFormTransitdataStub.insert(po);
		deliveryFormTransitdataStub.update(po);
	}
}
