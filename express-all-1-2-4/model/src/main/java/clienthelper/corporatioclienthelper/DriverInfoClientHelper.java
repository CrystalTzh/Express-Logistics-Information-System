package clienthelper.corporatioclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import po.DriverInfoPO;
/**
 * 在客户端，司机信息建立RMI连接
 */
public class DriverInfoClientHelper {
	
	DriverInfoCorporationdataService driverInfoCorporationdataService = null;

	/**
	 * 远程查找所有司机信息
	 * @return
	 */
	public ArrayList<DriverInfoPO> findAll() {
		System.out.println("进入DriverInfoClientHelper...client wants to findAll Driver...");
		driverInfoCorporationdataService = go();
		try {
			ArrayList<DriverInfoPO> allDrivers = driverInfoCorporationdataService.findAll();
			return allDrivers;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程更新司机信息
	 * @param po
	 * @return
	 */
	public boolean goUpdate(DriverInfoPO po) {
		System.out.println("进入DriverInfoClientHelper...client wants to update Driver...");
		driverInfoCorporationdataService = go();
		try {
			driverInfoCorporationdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程删除司机信息
	 * @param po
	 * @return
	 */
	public boolean goDelete(DriverInfoPO po) {
		System.out.println("进入DriverInfoClientHelper...client wants to  delete Driver...");
		driverInfoCorporationdataService = go();
		try {
			driverInfoCorporationdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程添加司机信息
	 * @param po
	 * @return
	 */
	public boolean goInsert(DriverInfoPO po) {
		System.out.println("进入DriverInfoClientHelper...client wants to  insert Driver...");
		driverInfoCorporationdataService = go();
		try {
			driverInfoCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 远程查找司机信息
	 * @param driverNumber
	 * @return
	 */
	public DriverInfoPO goFind(String driverNumber) {
		System.out.println("进入DriverInfoClientHelper...client wants to find Driver...");
		DriverInfoPO po ;
		driverInfoCorporationdataService = go();
		try {
			po = driverInfoCorporationdataService.find(driverNumber);
			return po;
			
		} catch (RemoteException e) {
			e.printStackTrace();
//			System.out.println("尝试重新连接...5秒...");
//			Thread t = new Thread(new DriverThreadHelper(driverInfoCorporationdataService));
//			t.start();
		} 
		return null;
	}
	
	/**
	 * 建立RMI连接
	 * @return
	 */
	public DriverInfoCorporationdataService go() {
		System.out.println("进入DriverInfoClientHelper...go...");
		if(driverInfoCorporationdataService == null) {
			System.out.println("driverInfoCorporationdataService为null");
			try {
//				 driverInfoCorporationdataService = (DriverInfoCorporationdataService) Naming
//						.lookup("rmi://127.0.0.1:32004/driverInfoCorporationdataService");
				driverInfoCorporationdataService = (DriverInfoCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.DRIVERINFO.toString()));
				System.out.println("driverInfoCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			} catch (RemoteException e) {
//				System.out.println("其他异常！！");
//				e.printStackTrace();
				System.out.println("请确认服务器是否已连接...");
				System.exit(0);
			}
		}
		return driverInfoCorporationdataService; 
	}
}
