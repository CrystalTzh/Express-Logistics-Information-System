package datastub.corporationdatastub;

import java.rmi.RemoteException;

import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import po.DriverInfoPO;
import state.SexList;

public class DriverInfoCorporationdataStub implements DriverInfoCorporationdataService{

	public DriverInfoPO find(String number) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		DriverInfoPO po=new DriverInfoPO("a", "a", "b", "c", "0", "d", SexList.MAN);
		return po;
	}

	public void update(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	public void add(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
	}

	public void delete(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
	}

}
