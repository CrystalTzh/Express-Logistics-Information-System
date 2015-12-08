package datadriver.userdatadriver;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserAccountUserdataService;
import po.UserAccountPO;
import state.UserRole;



public class UserdataDriver {
	public void driver(UserAccountUserdataService userdataStub) throws RemoteException{
		UserAccountPO po=new UserAccountPO("10086", "a", null, null, UserRole.OFFICEMAN);
		userdataStub.delete(po);
		userdataStub.find("0");
		userdataStub.add(po);
		userdataStub.update(po);
	}
}
