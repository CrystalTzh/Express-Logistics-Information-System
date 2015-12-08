package ClientHelper.TransitClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.transitdataservice.TransferFormdTransitataService;
import po.TransferFormPO;

public class TranferFormClientHelper {
	public TransferFormPO goFind(long NO) {
		try {
			TransferFormdTransitataService transferFormdTransitataService = (TransferFormdTransitataService) 
					Naming.lookup("rmi://127.0.0.1:32000/transferFormdTransitataService");
			System.out.println("RMI服务查找成功...");
			TransferFormPO po = transferFormdTransitataService.find(NO);
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
	public boolean goInsert(TransferFormPO po) {
		try {
			TransferFormdTransitataService transferFormdTransitataService = (TransferFormdTransitataService) 
					Naming.lookup("rmi://127.0.0.1:32000/transferFormdTransitataService");
			System.out.println("RMI服务查找成功...");
			transferFormdTransitataService.insert(po);
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
	public boolean goDelete(TransferFormPO po) {
		try {
			TransferFormdTransitataService transferFormdTransitataService = (TransferFormdTransitataService) 
					Naming.lookup("rmi://127.0.0.1:32000/transferFormdTransitataService");
			System.out.println("RMI服务查找成功...");
			transferFormdTransitataService.delete(po);
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
	public boolean goUpdate( TransferFormPO po) {
		try {
			TransferFormdTransitataService transferFormdTransitataService = (TransferFormdTransitataService) 
					Naming.lookup("rmi://127.0.0.1:32000/transferFormdTransitataService");
			System.out.println("RMI服务查找成功...");
			transferFormdTransitataService.update(po);
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
