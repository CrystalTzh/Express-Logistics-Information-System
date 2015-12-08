package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import po.StoreArrivalFormPO;

public class StoreArrivalFormClientHelper {
	public StoreArrivalFormPO goFind(long NO) {
		try {
			StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = (StoreArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/storeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			StoreArrivalFormPO po = storeArrivalFormTransitdataService.find(NO);
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
	public boolean goInsert(StoreArrivalFormPO po) {
		try {
			StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = (StoreArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/storeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			storeArrivalFormTransitdataService.insert(po);
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
	public boolean goDelete(StoreArrivalFormPO po) {
		try {
			StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = (StoreArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/storeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			storeArrivalFormTransitdataService.delete(po);
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
	public boolean goUpdate(StoreArrivalFormPO po) {
		try {
			StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = (StoreArrivalFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/storeArrivalFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			storeArrivalFormTransitdataService.update(po);
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
