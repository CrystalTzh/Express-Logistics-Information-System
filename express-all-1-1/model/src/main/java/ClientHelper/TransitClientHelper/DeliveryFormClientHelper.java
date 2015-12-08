package ClientHelper.TransitClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.DeliveryFormTransitdataService;
import po.DeliveryFormPO;

public class DeliveryFormClientHelper {
	public DeliveryFormPO goFind(String ID) {
		try {
			DeliveryFormTransitdataService deliveryFormTransitdataService = (DeliveryFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/deliveryFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			DeliveryFormPO po = deliveryFormTransitdataService.find(ID);
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
	public boolean goInsert(DeliveryFormPO po) {
		try {
			DeliveryFormTransitdataService deliveryFormTransitdataService = (DeliveryFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/deliveryFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			deliveryFormTransitdataService.insert(po);
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
	public boolean goDelete(DeliveryFormPO po) {
		try {
			DeliveryFormTransitdataService deliveryFormTransitdataService = (DeliveryFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/deliveryFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			deliveryFormTransitdataService.delete(po);
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
	public boolean goUpdate(DeliveryFormPO po) {
		try {
			DeliveryFormTransitdataService deliveryFormTransitdataService = (DeliveryFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/deliveryFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			deliveryFormTransitdataService.update(po);
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
