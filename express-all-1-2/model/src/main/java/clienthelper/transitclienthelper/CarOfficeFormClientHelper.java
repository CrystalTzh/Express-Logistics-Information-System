package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.transitdataservice.CarOfficeTransitdataService;
import po.CarOfficeFormPO;

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
//				carOfficeTransitdataService = (CarOfficeTransitdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/carOfficeTransitdataService");
				carOfficeTransitdataService = (CarOfficeTransitdataService)Naming
						.lookup(URL.getURL(ServiceName.CAROFFICEFORM.toString()));
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
	
	public ArrayList<CarOfficeFormPO> goFindAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormClientHelper...client wants to find allform...");
		carOfficeTransitdataService= go();
		try {
			return carOfficeTransitdataService.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
