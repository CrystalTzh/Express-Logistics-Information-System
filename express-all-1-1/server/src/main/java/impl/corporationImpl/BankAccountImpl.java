/**
 * 公司信息模块数据层实现
 * @author 谭琼
 * 2015年12月4日
 */
package impl.corporationImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import dataservice.corporationdataservice.BankAccountCorporationdataService;
import ioHelper.IOHelper;
import po.BankAccountInfoPO;

/**
 * 银行账户数据层实现 
 */
public class BankAccountImpl extends UnicastRemoteObject implements BankAccountCorporationdataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allBankAccountInfo;
	File file = new File("银行账户基本信息.txt");
	IOHelper ioHelper;
	
	/**
	 * @throws RemoteException
	 */
	public BankAccountImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.BankAccountCorporationdataService#add(po.BankAccountInfoPO)
	 */
	public void add(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountImpl...server adding...");
		ioHelper = new IOHelper();
		allBankAccountInfo = ioHelper.readFromFile(file);
		allBankAccountInfo.put(po.getAccountId(), po);
		System.out.println("To be added: " + po.getAccountId() + " " + po.getBalance());
		ioHelper.writeToFile(allBankAccountInfo, file);
		System.out.println("Add BankAccountInfoPO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.BankAccountCorporationdataService#delete(po.BankAccountInfoPO)
	 */
	public void delete(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountImpl...server deleting...");
		ioHelper = new IOHelper();
		allBankAccountInfo = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " + po.getAccountId() + " " + po.getBalance());
		allBankAccountInfo.remove(po.getAccountId());
		ioHelper.writeToFile(allBankAccountInfo, file);
		System.out.println("Delete BankAccountInfoPO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.BankAccountCorporationdataService#update(po.BankAccountInfoPO)
	 */
	public void update(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountImpl...server updating...");
		add(po);
		System.out.println("Update DriverInfoPO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.BankAccountCorporationdataService#find(java.lang.String)
	 */
	public BankAccountInfoPO find(String accountID) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountImpl...server finding...");
		ioHelper = new IOHelper();
		allBankAccountInfo = ioHelper.readFromFile(file);
		if(allBankAccountInfo.containsKey(accountID)) {
			BankAccountInfoPO po = (BankAccountInfoPO) allBankAccountInfo.get(accountID);
			System.out.println("Have found: " + po.getAccountId() + " " + po.getBalance());
			System.out.println("Find BankAccountInfoPO Done!!");
			return po;
		}
		System.out.println("Unable to find!!");
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.BankAccountCorporationdataService#keyFind(java.lang.String)
	 */
	public ArrayList<BankAccountInfoPO> keyFind(String keyID) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountImpl...server keyFinding...");
		ioHelper = new IOHelper();
		allBankAccountInfo = ioHelper.readFromFile(file);
		ArrayList<BankAccountInfoPO> list = new ArrayList<BankAccountInfoPO>();
		//遍历key寻找包含串keyID的value
		for(Iterator itr = allBankAccountInfo.keySet().iterator(); itr.hasNext();) {
			String key = (String) itr.next();
			if(key.contains(keyID)) {
				list.add((BankAccountInfoPO)allBankAccountInfo.get(key));
			}
		}
		return list;
	}
	
//	public static void main(String[] args) {
//		try {
//			BankAccountImpl  bankAccountImpl = new BankAccountImpl();
//			ArrayList<BankAccountInfoPO> list = bankAccountImpl.keyFind("600");
//			for(BankAccountInfoPO po : list) {
//				System.out.println(po.getAccountName());
//			}
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
