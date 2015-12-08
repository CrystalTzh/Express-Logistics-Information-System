package datadriver.financedatadriver;

import java.rmi.RemoteException;

import dataservice.financedataservice.BeginningAccountdataService;
import po.BeginningAccountPO;

public class BeginningAccountdataDriver {
	public void driver(BeginningAccountdataService beginningAccountdataStub) throws RemoteException{
		
//		BeginningAccountPO po=new BeginningAccountPO(0, null, null, null, null);
//		beginningAccountdataStub.update(po);
//		beginningAccountdataStub.find(1024);
//		beginningAccountdataStub.delete(po);
//		beginningAccountdataStub.insert(po);
	}
}
