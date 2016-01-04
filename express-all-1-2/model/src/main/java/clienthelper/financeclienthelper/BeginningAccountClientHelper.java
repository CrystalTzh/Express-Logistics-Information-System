package clienthelper.financeclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.financedataservice.BeginningAccountdataService;
import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import po.OfficePO;
import po.TransferOfficePO;
import po.UserAccountPO;
import state.City;
import state.UserRole;
/**
 * 在客户端，期初建账建立RMI连接
 */
public class BeginningAccountClientHelper {
	
	BeginningAccountdataService beginningAccountdataService = null;
	
	/**
	 * 远程更新营业厅
	 * @return
	 */
	public boolean goSyncOffice() {
		System.out.println("进入BeginningAccountClientHelper...goSyncOffice");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncOffice();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新中转中心
	 * @return
	 */
	public boolean goSyncTransferOffice() {
		System.out.println("进入BeginningAccountClientHelper...goSyncTransferOffice");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncTransferOffice();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新库存信息
	 * @return
	 */
	public boolean goSyncInventory() {
		System.out.println("进入BeginningAccountClientHelper...goSyncInventory");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncInventory();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新司机信息
	 * @return
	 */
	public boolean goSyncDriver() {
		System.out.println("进入BeginningAccountClientHelper...goSyncDriver");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncDriver();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新车辆信息
	 * @return
	 */
	public boolean goSyncCar() {
		System.out.println("进入BeginningAccountClientHelper...goSyncCar");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncCar();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新用户账户信息
	 * @return
	 */
	public boolean goSyncUserAccount() {
		System.out.println("进入BeginningAccountClientHelper...goSyncUserAccount");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncUserAccount();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程更新银行账户信息
	 * @return
	 */
	public boolean goSyncBankAccount() {
		System.out.println("进入BeginningAccountClientHelper...goSyncBankAccount");
		beginningAccountdataService = go();
		try {
			beginningAccountdataService.syncBankAccount();
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程查找某城市的所有营业厅信息
	 * @return
	 */
	public Hashtable<City, ArrayList<OfficePO>> goFindAllOfficeInfo() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllOfficeInfo");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllOfficeInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程查找某城市的所有中转中心信息
	 * @return
	 */
	public Hashtable<City, ArrayList<TransferOfficePO>> goFindAllTransferOfficeInfo() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllTransferOfficeInfo");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllTransferOfficeInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程查找所有库存信息
	 * @return
	 */
	public ArrayList<InventoryInfoPO> goFindAllInventory() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllInventory");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllInventoryInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null; 
	}
	
	/**
	 * 远程查找所有司机信息
	 * @return
	 */
	public ArrayList<DriverInfoPO> goFindAllDiver() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllDiver");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllDriverInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程查找所有车辆信息
	 * @return
	 */
	public ArrayList<CarInfoPO> goFindAllCar() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllCar");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAlCarInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程查找某一职位的所有用户账户信息
	 * @return
	 */
	public Hashtable<UserRole, ArrayList<UserAccountPO>> goFindAllUserAccountInfo() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllUserAccountInfo");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllUserAccountInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程查找所有银行账户信息
	 * @return
	 */
	public ArrayList<BankAccountInfoPO> goFindAllBankAccountInfo() {
		System.out.println("进入BeginningAccountClientHelper...goFindAllBankAccountInfo");
		beginningAccountdataService = go();
		try {
			return beginningAccountdataService.findAllBankAccountInfo();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 客户端建立BeginningAccountdataService服务的RMI连接
	 * @return
	 */
	public BeginningAccountdataService go() {
		System.out.println("进入BeginningAccountClientHelper...go...");
		if(beginningAccountdataService == null) {
			try {
				beginningAccountdataService = (BeginningAccountdataService)Naming
						.lookup(URL.getURL(ServiceName.BEGINNINGACCOUNT.toString()));
				System.out.println("beginningAccountdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return beginningAccountdataService;
	}
}
