package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.OrderFormTransitdataService;
import po.OrderFormPO;

public class OrderFormClientHelper {
	public OrderFormPO goFind(long ID) {
		try {
			OrderFormTransitdataService orderFormTransitdataService = (OrderFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/orderFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			OrderFormPO po = orderFormTransitdataService.find(ID);
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
	public boolean goInsert(OrderFormPO po) {
		try {
			OrderFormTransitdataService orderFormTransitdataService = (OrderFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/orderFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			orderFormTransitdataService.insert(po);
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
	public boolean goDelete(OrderFormPO po) {
		try {
			OrderFormTransitdataService orderFormTransitdataService = (OrderFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/orderFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			orderFormTransitdataService.delete(po);
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
	public boolean goUpdate(OrderFormPO po) {
		try {
			OrderFormTransitdataService orderFormTransitdataService = (OrderFormTransitdataService) 
					Naming.lookup("rmi://127.0.0.1:32000/orderFormTransitdataService");
			System.out.println("RMI服务查找成功...");
			orderFormTransitdataService.update(po);
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
