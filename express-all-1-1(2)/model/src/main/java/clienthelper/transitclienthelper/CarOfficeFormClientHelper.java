package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.CarOfficeTransitdataService;
import dataservice.transitdataservice.DeliveryFormTransitdataService;
import po.CarOfficeFormPO;
import po.DeliveryFormPO;

public class CarOfficeFormClientHelper {
	
	CarOfficeTransitdataService carOfficeTransitdataService=null;
	
	public CarOfficeFormPO goFind(String NO) {
		System.out.println("进入CarOfficeFormClientHelper...client wants to finds Form...");
		carOfficeTransitdataService = go();
		CarOfficeFormPO po;
		try {
			po = carOfficeTransitdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public boolean goInsert(CarOfficeFormPO po) {
		System.out.println("进入CarOfficeFormClientHelper...client wants to insert Form ...");
		carOfficeTransitdataService = go();
		try {
			carOfficeTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean goDelete(CarOfficeFormPO po) {
		System.out.println("进入CarOfficeFormClientHelper...client wants to delete Form...");
		carOfficeTransitdataService = go();
		try {
			carOfficeTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	public boolean goUpdate(CarOfficeFormPO po) {
		System.out.println("进入CarOfficeFormClientHelper...client wants to update Car...");
		carOfficeTransitdataService= go();
		try {
			carOfficeTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public CarOfficeTransitdataService go() {
		System.out.println("进入DeliveryFormClientHelper...go...");
		if(carOfficeTransitdataService == null) {
			try {
				carOfficeTransitdataService = (CarOfficeTransitdataService)Naming
						.lookup("rmi://127.0.0.1:32010/carOfficeTransitdataService");
				System.out.println("carOfficeTransitdataService RMI服务查找成功...");
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
		return carOfficeTransitdataService;
	}
	
}
