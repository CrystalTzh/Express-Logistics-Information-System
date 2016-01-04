package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.transitdataservice.TransferFormTransitdataService;
import po.TransferFormPO;

public class TransferFormClientHelper {
	
	TransferFormTransitdataService transferFormTransitdataService = null;
	
	public TransferFormPO goFind(String NO) {
		System.out.println("进入TransferFormClientHelper...client wants to finds Form...");
		transferFormTransitdataService = go();
		TransferFormPO po;
		try {
			po = transferFormTransitdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(TransferFormPO po) {
		System.out.println("进入TransferFormClientHelper...client wants to insert Form ...");
		transferFormTransitdataService = go();
		try {
			transferFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(TransferFormPO po) {
		System.out.println("进入TransferFormClientHelper...client wants to delete Form...");
		transferFormTransitdataService = go();
		try {
			transferFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(TransferFormPO po) {
		System.out.println("进入TransferFormClientHelper...client wants to update Car...");
		transferFormTransitdataService= go();
		try {
			transferFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public TransferFormTransitdataService go() {
		System.out.println("进入TransferFormClientHelper...go...");
		if(transferFormTransitdataService == null) {
			try {
//				transferFormTransitdataService = (TransferFormTransitdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/transferFormTransitdataService");
				transferFormTransitdataService = (TransferFormTransitdataService)Naming
						.lookup(URL.getURL(ServiceName.TRANSFERFORM.toString()));
				System.out.println("transferFormTransitdataService RMI服务查找成功...");
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
		return transferFormTransitdataService;
	}
	
	public ArrayList<TransferFormPO> goFindAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormClientHelper...client wants to find allform...");
		transferFormTransitdataService= go();
		try {
			return transferFormTransitdataService.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;	}
}
