/**
 * 公司信息模块客户端建立RMI连接
 * @author 谭琼
 * 2015年12月4日
 */
package clienthelper.corporatioclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.corporationdataservice.BankAccountCorporationdataService;
import po.BankAccountInfoPO;

/**
 * 在客户端，银行账户建立RMI连接
 */
public class BankAccountClientHelper {
	
	BankAccountCorporationdataService bankAccountCorporationdataService = null;
	
	/**
	 * 找到所有银行账户
	 * @return
	 */
	public ArrayList<BankAccountInfoPO> findAllBankAccouts() {
		System.out.println("进入BankAccountClientHelper...goFindAllBankAccouts...");
		bankAccountCorporationdataService = go();
		 try {
			return bankAccountCorporationdataService.findAllBankAccouts();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过RMI远程更新银行账户信息
	 * @return
	 */
	public boolean goUpdate(BankAccountInfoPO po) {
		System.out.println("进入BankAccountClientHelper...goUpdate...");
		bankAccountCorporationdataService = go();
		try {
			bankAccountCorporationdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程删除银行账户信息
	 * @param po
	 * @return
	 */
	public boolean goDelete(BankAccountInfoPO po) {
		System.out.println("进入BankAccountClientHelper...goDelete...");
		bankAccountCorporationdataService = go();
		try {
			bankAccountCorporationdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程增加银行账户信息
	 * @param po
	 * @return
	 */
	public boolean goInsert(BankAccountInfoPO po) {
		System.out.println("进入BankAccountClientHelper...goInsert...");
		bankAccountCorporationdataService = go();
		try {
			bankAccountCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过银行账户账号accountID远程查找银行账户信息
	 * @param accountID
	 * @return
	 */
	public BankAccountInfoPO goFind(String accountID) {
		System.out.println("进入BankAccountClientHelper...goFind...");
		bankAccountCorporationdataService = go();
		BankAccountInfoPO po;
		try {
			po = bankAccountCorporationdataService.find(accountID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
//	/**
//	 * 通过关键字keyID远程查找银行账户信息
//	 * @param keyID
//	 * @return
//	 */
//	public ArrayList<BankAccountInfoPO> gokeyFind(String keyID) {
//		System.out.println("进入BankAccountClientHelper...gokeyFind...");
//		bankAccountCorporationdataService = go();
//		ArrayList<BankAccountInfoPO> list;
//		try {
//			list = bankAccountCorporationdataService.keyFind(keyID);
//			return list;
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	/**
	 * 客户端建立bankAccountCorporationdataService服务的RMI连接
	 * @return
	 */
	public BankAccountCorporationdataService go() {
		System.out.println("进入BankAccountClientHelper...go...");
		if(bankAccountCorporationdataService == null) {
			try {
//				bankAccountCorporationdataService = (BankAccountCorporationdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/bankAccountCorporationdataService");
				bankAccountCorporationdataService = (BankAccountCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.BANKACCOUNT.toString()));
				System.out.println("bankAccountCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			}
		}
		return bankAccountCorporationdataService;
	}
}
