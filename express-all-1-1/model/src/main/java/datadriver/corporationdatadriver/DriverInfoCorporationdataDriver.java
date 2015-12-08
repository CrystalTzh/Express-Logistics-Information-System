package datadriver.corporationdatadriver;

import java.io.EOFException;
import java.rmi.RemoteException;


import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import po.DriverInfoPO;

public class DriverInfoCorporationdataDriver {
	public void driver(DriverInfoCorporationdataService driverInfoCorporationdatadataStub) throws RemoteException, EOFException{
		DriverInfoPO po=new DriverInfoPO(null, null, null, null, null, null, null);
		
		driverInfoCorporationdatadataStub.find("0");
		
		driverInfoCorporationdatadataStub.update(po);
	}
}
