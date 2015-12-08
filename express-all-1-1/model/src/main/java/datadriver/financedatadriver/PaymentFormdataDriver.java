package datadriver.financedatadriver;

import java.rmi.RemoteException;


import dataservice.financedataservice.PaymentFormdataService;
import po.PaymentFormPO;

public class PaymentFormdataDriver {
	public void driver(PaymentFormdataService paymentFormdataStub) throws RemoteException{
		
		PaymentFormPO po=new PaymentFormPO("d", 12, "n", 1233, "N");
		paymentFormdataStub.delete(po);
		paymentFormdataStub.insert(po);
		paymentFormdataStub.update(po);
		paymentFormdataStub.find(1233);
	}
}
