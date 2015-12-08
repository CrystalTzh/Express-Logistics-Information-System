package datadriver.financedatadriver;

import java.rmi.RemoteException;

import po.ReceiptFormPO;
import dataservice.financedataservice.ReceiptFormdataService;

public class ReceiptFormdataDriver {
	public void driver(ReceiptFormdataService receiptFormdataStub) throws RemoteException{
		ReceiptFormPO po = new ReceiptFormPO(null, 0, null, null, 0);
		receiptFormdataStub.delete(po);
		receiptFormdataStub.find(0);
		receiptFormdataStub.insert(po);
		receiptFormdataStub.update(po);
	}
}