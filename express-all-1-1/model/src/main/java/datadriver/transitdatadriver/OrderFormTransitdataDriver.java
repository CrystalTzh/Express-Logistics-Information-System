package datadriver.transitdatadriver;

import java.rmi.RemoteException;

import po.OrderFormPO;
import dataservice.transitdataservice.OrderFormTransitdataService;

public class OrderFormTransitdataDriver {
	public void driver(OrderFormTransitdataService orderFormTransitdataStub) throws RemoteException{
		OrderFormPO po = new OrderFormPO(null, null, null, null, null, null,
				null, null, null, null, 0, 0, 0, null, 
				null, 0, 0, 0, 0, null, null, null, null);
		orderFormTransitdataStub.delete(po);
		orderFormTransitdataStub.find(0);
		orderFormTransitdataStub.insert(po);
		orderFormTransitdataStub.update(po);
	}
}