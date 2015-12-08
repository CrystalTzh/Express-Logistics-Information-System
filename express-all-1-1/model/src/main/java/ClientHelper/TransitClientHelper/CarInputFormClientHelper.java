package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import dataservice.transitdataservice.CarInputFormTransitdataService;
import po.CarInputFormPO;

public class CarInputFormClientHelper {
	public CarInputFormPO goFind(long NO) {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = (CarInputFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carInputFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			CarInputFormPO po = carInputFormTransitdataService.find(NO);
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
	
	public boolean goInsert(CarInputFormPO po) {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = (CarInputFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carInputFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			carInputFormTransitdataService.insert(po);
			return true;
			
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
		return false;
	}
	
	public boolean goDelete(CarInputFormPO po) {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = (CarInputFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carInputFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			carInputFormTransitdataService.delete(po);
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
	
	public boolean goUpdate(CarInputFormPO po) {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = (CarInputFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carInputFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			carInputFormTransitdataService.update(po);
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
	
	public void goPrint() {
		try {
			CarInputFormTransitdataService carInputFormTransitdataService = (CarInputFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/carInputFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			String str = carInputFormTransitdataService.print("123");
			System.out.println(str);
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

	
}