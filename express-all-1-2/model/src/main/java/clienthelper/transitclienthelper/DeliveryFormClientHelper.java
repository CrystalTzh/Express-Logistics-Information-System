package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.transitdataservice.DeliveryFormTransitdataService;
import po.DeliveryFormPO;

public class DeliveryFormClientHelper {
	
	DeliveryFormTransitdataService deliveryFormTransitdataService=null;
	
	public DeliveryFormPO goFind(String ID) {
		System.out.println("进入DeliveryFormClientHelper...client wants to finds Form...");
		deliveryFormTransitdataService = go();
		DeliveryFormPO po;
		try {
			po = deliveryFormTransitdataService.find(ID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(DeliveryFormPO po) {
		System.out.println("进入DeliveryFormClientHelper...client wants to insert Form ...");
		deliveryFormTransitdataService = go();
		try {
			deliveryFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(DeliveryFormPO po) {
		System.out.println("进入DeliveryFormClientHelper...client wants to delete Form...");
		deliveryFormTransitdataService = go();
		try {
			deliveryFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(DeliveryFormPO po) {
		System.out.println("进入DeliveryFormClientHelper...client wants to update Car...");
		deliveryFormTransitdataService= go();
		try {
			deliveryFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public DeliveryFormTransitdataService go() {
		System.out.println("进入DeliveryFormClientHelper...go...");
		if(deliveryFormTransitdataService == null) {
			try {
//				deliveryFormTransitdataService = (DeliveryFormTransitdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/deliveryFormTransitdataService");
				deliveryFormTransitdataService = (DeliveryFormTransitdataService)Naming
						.lookup(URL.getURL(ServiceName.DELIVERYFORM.toString()));
				System.out.println("deliveryFormTransitdataService RMI服务查找成功...");
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
		return deliveryFormTransitdataService;
	}
	public ArrayList<DeliveryFormPO> goFindAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormClientHelper...client wants to find allform...");
		deliveryFormTransitdataService= go();
		try {
			return deliveryFormTransitdataService.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
