/**
 * 用户账户信息数据层实现
 * @author 谭琼
 * 2015年12月5日
 */
package impl.userImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.userdataservice.UserAccountUserdataService;
import iohelper.IOHelper;
import po.UserAccountPO;

/**
 * 用户账户数据层实现
 */
public class UserAccountServiceImpl extends UnicastRemoteObject implements UserAccountUserdataService {

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allUserAccountInfo;
	File file = new File("用户账户基本信息.txt");
	IOHelper ioHelper;
	
	/**
	 * @throws RemoteException
	 */
	public UserAccountServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserAccountPO find(String userAccountID) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountServiceImpl...server finding");
		ioHelper = new IOHelper();
		allUserAccountInfo = ioHelper.readFromFile(file);
		if(allUserAccountInfo.containsKey(userAccountID)) {
			UserAccountPO po = (UserAccountPO) allUserAccountInfo.get(userAccountID);
			System.out.println("Have found: " + po.getUserAccountID() + " " + po.getUserName() + " " + po.getUserRole().toString());
			System.out.println("Find UserAccountPO Done!!");
			return po;
		}
		System.out.println("Unable to find!!");
		return null;
	}

	public void add(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountServiceImpl...server adding");
		ioHelper = new IOHelper();
		allUserAccountInfo = ioHelper.readFromFile(file);
		allUserAccountInfo.put(po.getUserAccountID(), po);
		System.out.println("To be added: " + po.getUserAccountID() + " " + po.getUserName()+ " " + po.getUserRole().toString());
		ioHelper.writeToFile(allUserAccountInfo, file);
		System.out.println("Add UserAccountPO OVer!!");
	}

	public void delete(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountServiceImpl...server deleting");
		ioHelper = new IOHelper();
		allUserAccountInfo = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " + po.getUserAccountID() + " " + po.getUserName()+ " " + po.getUserRole().toString());
		allUserAccountInfo.remove(po.getUserAccountID());
		ioHelper.writeToFile(allUserAccountInfo, file);
		System.out.println("Delete UserAccountPO Done!!");
	}

	public void update(UserAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountServiceImpl...server updating");
		add(po);
		System.out.println("Update UserAccountPO Done!!");
	}
	
}
