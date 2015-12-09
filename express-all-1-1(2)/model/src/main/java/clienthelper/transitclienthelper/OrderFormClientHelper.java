package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.DeliveryFormTransitdataService;
import dataservice.transitdataservice.OrderFormTransitdataService;
import po.DeliveryFormPO;
import po.OrderFormPO;

public class OrderFormClientHelper {
	
	OrderFormTransitdataService orderFormTransitdataService = null;
	
	public OrderFormPO goFind(String number) {
		System.out.println("进入OrderFormClientHelper...client wants to finds Form...");
		orderFormTransitdataService = go();
		OrderFormPO po;
		try {
			po = orderFormTransitdataService.find(number);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(OrderFormPO po) {
		System.out.println("进入OrderFormClientHelper...client wants to insert Form ...");
		orderFormTransitdataService = go();
		try {
			orderFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(OrderFormPO po) {
		System.out.println("进入OrderFormClientHelper...client wants to delete Form...");
		orderFormTransitdataService = go();
		try {
			orderFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(OrderFormPO po) {
		System.out.println("进入OrderFormClientHelper...client wants to update Car...");
		orderFormTransitdataService= go();
		try {
			orderFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public OrderFormTransitdataService go() {
		System.out.println("进入OrderFormClientHelper...go...");
		if(orderFormTransitdataService == null) {
			try {
				orderFormTransitdataService = (OrderFormTransitdataService)Naming
						.lookup("rmi://127.0.0.1:32010/orderFormTransitdataService");
				System.out.println("orderFormTransitdataService RMI服务查找成功...");
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
		return orderFormTransitdataService;
	}
}
