package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import dataservice.transitdataservice.CarInputFormTransitdataService;
import dataservice.transitdataservice.DeliveryFormTransitdataService;
import po.CarInputFormPO;
import po.DeliveryFormPO;

public class CarInputFormClientHelper {
	
	CarInputFormTransitdataService carInputFormTransitdataService=null;
	
	public CarInputFormPO goFind(String NO) {
		System.out.println("进入CarInputFormClientHelper...client wants to finds Form...");
		carInputFormTransitdataService = go();
		CarInputFormPO po;
		try {
			po = carInputFormTransitdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(CarInputFormPO po) {
		System.out.println("进入CarInputFormClientHelper...client wants to insert Form ...");
		carInputFormTransitdataService = go();
		try {
			carInputFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(CarInputFormPO po) {
		System.out.println("进入CarInputFormClientHelper...client wants to delete Form...");
		carInputFormTransitdataService = go();
		try {
			carInputFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(CarInputFormPO po) {
		System.out.println("进入CarInputFormClientHelper...client wants to update Car...");
		carInputFormTransitdataService= go();
		try {
			carInputFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public CarInputFormTransitdataService go() {
		System.out.println("进入CarInputFormClientHelper...go...");
		if(carInputFormTransitdataService == null) {
			try {
				carInputFormTransitdataService = (CarInputFormTransitdataService)Naming
						.lookup("rmi://127.0.0.1:32010/carInputFormTransitdataService");
				System.out.println("carInputFormTransitdataService RMI服务查找成功...");
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
		return carInputFormTransitdataService;
	}

	
}