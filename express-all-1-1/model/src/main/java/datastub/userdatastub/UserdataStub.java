package datastub.userdatastub;

import java.rmi.RemoteException;

import dataservice.userdataservice.UserAccountUserdataService;
import po.UserAccountPO;
import state.UserRole;

public class UserdataStub implements UserAccountUserdataService {

	public UserAccountPO find(String userAccount) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		UserAccountPO po=new UserAccountPO("10086", "a", userAccount, userAccount, UserRole.OFFICEMAN);
		return po;
	}

	public void add(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

}
