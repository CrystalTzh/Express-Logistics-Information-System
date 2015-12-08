package clienthelper.corporatioclienthelper;

import java.io.EOFException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import po.DriverInfoPO;
import vo.DriverInfoVO;

public class DriverInfoClientHelper {
	DriverInfoCorporationdataService driverInfoCorporationdataService = null;

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

	public DriverInfoPO goFind(String driverNumber) {
		System.out.println("进入DriverInfoClientHelper...client wants to find Driver...");
		DriverInfoPO po ;
		driverInfoCorporationdataService = go();
		try {
			po = driverInfoCorporationdataService.find(driverNumber);
			return po;
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public DriverInfoCorporationdataService go() {
		System.out.println("进入DriverInfoClientHelper...go...");
		if(driverInfoCorporationdataService == null) {
			try {
				 driverInfoCorporationdataService = (DriverInfoCorporationdataService) Naming
						.lookup("rmi://127.0.0.1:32001/driverInfoCorporationdataService");
				System.out.println("driverInfoCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println("其他异常！！");
				e.printStackTrace();
			}
		}
		return driverInfoCorporationdataService; 
	}
}
