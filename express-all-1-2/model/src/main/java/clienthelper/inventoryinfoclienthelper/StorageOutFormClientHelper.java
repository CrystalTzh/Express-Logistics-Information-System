package clienthelper.inventoryinfoclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.StorageOutFormPO;

public class StorageOutFormClientHelper {
	
	StorageOutFromInventorydataService storageOutFormInventorydataService = null;
	
	public StorageOutFormPO goFind(String number) {
		System.out.println("进入StorageOutFormClientHelper...client wants to finds Form...");
		storageOutFormInventorydataService = go();
		StorageOutFormPO po;
		try {
			po = storageOutFormInventorydataService.find(number);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(StorageOutFormPO po) {
		System.out.println("进入StorageOutFormClientHelper...client wants to insert Form ...");
		storageOutFormInventorydataService = go();
		try {
			storageOutFormInventorydataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(StorageOutFormPO po) {
		System.out.println("进入StorageOutFormClientHelper...client wants to delete Form...");
		storageOutFormInventorydataService = go();
		try {
			storageOutFormInventorydataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(StorageOutFormPO po) {
		System.out.println("进入StorageOutFormClientHelper...client wants to update Car...");
		storageOutFormInventorydataService= go();
		try {
			storageOutFormInventorydataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public StorageOutFromInventorydataService go() {
		System.out.println("进入StorageOutFromClientHelper...go...");
		if(storageOutFormInventorydataService == null) {
			try {
				storageOutFormInventorydataService = (StorageOutFromInventorydataService)Naming
						.lookup("rmi://127.0.0.1:32010/storageOutFormInventorydataService");
				System.out.println("storageOutFormInventorydataService RMI服务查找成功...");
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
		return storageOutFormInventorydataService;
	}
	
}
