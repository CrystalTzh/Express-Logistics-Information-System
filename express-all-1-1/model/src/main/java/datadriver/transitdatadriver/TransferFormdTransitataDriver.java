package datadriver.transitdatadriver;

import java.rmi.RemoteException;

import po.TransferFormPO;
import state.Transport;
import dataservice.transitdataservice.TransferFormdTransitataService;

public class TransferFormdTransitataDriver {
	public void driver(TransferFormdTransitataService transferFormdTransitataStub) throws RemoteException{
		TransferFormPO po = new TransferFormPO("2015.1.1",123456,"a","b","c",Transport.CAR,"1",1,1,1,null,1.1);
		transferFormdTransitataStub.delete(po);
		transferFormdTransitataStub.find(0);
		transferFormdTransitataStub.insert(po);
		transferFormdTransitataStub.update(po);
	}
}