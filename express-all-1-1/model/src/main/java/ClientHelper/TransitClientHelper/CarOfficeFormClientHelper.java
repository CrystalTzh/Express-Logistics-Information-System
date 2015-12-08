package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.CarOfficeTransitdataService;
import po.CarOfficeFormPO;

public class CarOfficeFormClientHelper {
	public CarOfficeFormPO goFind(long NO) {
		try {
			CarOfficeTransitdataService carOfficeTransitdataService = (CarOfficeTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carOfficeTransitdataService");
			System.out.println("RMI服务查找成功...");
			CarOfficeFormPO po = carOfficeTransitdataService.find(NO);
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
	public boolean goInsert(CarOfficeFormPO po) {
		try {
			CarOfficeTransitdataService carOfficeTransitdataService = (CarOfficeTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carOfficeTransitdataService");
			System.out.println("RMI服务查找成功...");
			carOfficeTransitdataService.insert(po);
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
	public boolean goDelete(CarOfficeFormPO po) {
		try {
			CarOfficeTransitdataService carOfficeTransitdataService = (CarOfficeTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carOfficeTransitdataService");
			System.out.println("RMI服务查找成功...");
			carOfficeTransitdataService.delete(po);
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
	public boolean goUpdate(CarOfficeFormPO po) {
		try {
			CarOfficeTransitdataService carOfficeTransitdataService = (CarOfficeTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carOfficeTransitdataService");
			System.out.println("RMI服务查找成功...");
			carOfficeTransitdataService.update(po);
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
