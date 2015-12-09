package clienthelper.financeclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;

import dataservice.financedataservice.ReceiptFormdataService;

import po.ReceiptFormPO;


public class ReceiptFormClientHelper {
	
	ReceiptFormdataService receiptFormdataService=null;
	
	public ReceiptFormPO goFind(String NO) {
		System.out.println("进入ReceiptFormClientHelper...client wants to finds Form...");
		receiptFormdataService = go();
		ReceiptFormPO po;
		try {
			po = receiptFormdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(ReceiptFormPO po) {
		System.out.println("进入ReceiptFormClientHelper...client wants to insert Form ...");
		receiptFormdataService = go();
		try {
			receiptFormdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(ReceiptFormPO po) {
		System.out.println("进入ReceiptFormClientHelper...client wants to delete Form...");
		receiptFormdataService = go();
		try {
			receiptFormdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(ReceiptFormPO po) {
		System.out.println("进入ReceiptFormClientHelper...client wants to update Car...");
		receiptFormdataService= go();
		try {
			receiptFormdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public ReceiptFormdataService go() {
		System.out.println("进入ReceiptFormClientHelper...go...");
		if(receiptFormdataService == null) {
			try {
				receiptFormdataService = (ReceiptFormdataService)Naming
						.lookup("rmi://127.0.0.1:32010/receiptFormdataService");
				System.out.println("receiptFormdataService RMI服务查找成功...");
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
		return receiptFormdataService;
	}
		
}
