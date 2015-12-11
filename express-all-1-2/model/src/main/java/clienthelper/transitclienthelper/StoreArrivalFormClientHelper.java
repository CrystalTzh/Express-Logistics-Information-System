package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.DeliveryFormTransitdataService;
import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import po.DeliveryFormPO;
import po.StoreArrivalFormPO;

public class StoreArrivalFormClientHelper {
	
	StoreArrivalFormTransitdataService storeArrivalFormTransitdataService=null;

	public StoreArrivalFormPO goFind(String number) {
		System.out.println("进入StoreArrivalFormClientHelper...client wants to finds Form...");
		storeArrivalFormTransitdataService = go();
		StoreArrivalFormPO po = null;
		try {
			po = storeArrivalFormTransitdataService.find(number);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(StoreArrivalFormPO po) {
		System.out.println("进入StoreArrivalFormClientHelper...client wants to insert Form ...");
		storeArrivalFormTransitdataService = go();
		try {
			storeArrivalFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(StoreArrivalFormPO po) {
		System.out.println("进入StoreArrivalFormClientHelper...client wants to delete Form...");
		storeArrivalFormTransitdataService = go();
		try {
			storeArrivalFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(StoreArrivalFormPO po) {
		System.out.println("进入StoreArrivalFormClientHelper...client wants to update Car...");
		storeArrivalFormTransitdataService= go();
		try {
			storeArrivalFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public StoreArrivalFormTransitdataService go() {
		System.out.println("进入DeliveryFormClientHelper...go...");
		if(storeArrivalFormTransitdataService == null) {
			try {
				storeArrivalFormTransitdataService = (StoreArrivalFormTransitdataService)Naming
						.lookup("rmi://127.0.0.1:32010/storeArrivalFormTransitdataService");
				System.out.println("storeArrivalFormTransitdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			}
		}
		return storeArrivalFormTransitdataService;
	}
		
}
