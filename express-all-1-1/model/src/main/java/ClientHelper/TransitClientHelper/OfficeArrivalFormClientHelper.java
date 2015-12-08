package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormClientHelper {
	public OfficeArrivalFormPO goFind(long NO) {
		try {
			OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/officeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			OfficeArrivalFormPO po = officeArrivalFormTransitdataService.find(NO);
			return po;
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
		return null;
		
	}
	public boolean goInsert(OfficeArrivalFormPO po) {
		try {
			OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/officeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			officeArrivalFormTransitdataService.insert(po);
			return true;
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
		return false;
		
	}
	public boolean goDelete(OfficeArrivalFormPO po) {
		try {
			OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/officeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			officeArrivalFormTransitdataService.delete(po);
			return true;
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
		return false;
		
	}
	public boolean goUpdate(OfficeArrivalFormPO po ) {
		try {
			OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/officeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			officeArrivalFormTransitdataService.update(po);
			return true;
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
		return false;
		
	}
}
