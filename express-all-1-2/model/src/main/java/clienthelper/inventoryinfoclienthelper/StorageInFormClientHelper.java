package clienthelper.inventoryinfoclienthelper;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import dataservice.inventorydataservice.StorageInFormInventorydataService;
import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.InventoryInfoPO;
import po.StorageInFormPO;
import po.StorageOutFormPO;

public class StorageInFormClientHelper {
	
	StorageInFormInventorydataService storageInFormInventorydataService = null;
	InventoryInfoInventorydataService inventoryInfoInventorydataService = null;
	
	
	public StorageInFormPO goFind(String number) {
		System.out.println("进入StorageInFormClientHelper...client wants to finds Form...");
		storageInFormInventorydataService = go();
		StorageInFormPO po;
		try {
			po = storageInFormInventorydataService.find(number);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(StorageInFormPO po) {
		System.out.println("进入StorageInFormClientHelper...client wants to insert Form ...");
		storageInFormInventorydataService = go();
		try {
			storageInFormInventorydataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(StorageInFormPO po) {
		System.out.println("进入StorageInFormClientHelper...client wants to delete Form...");
		storageInFormInventorydataService = go();
		try {
			storageInFormInventorydataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(StorageInFormPO po) {
		System.out.println("进入StorageInFormClientHelper...client wants to update Car...");
		storageInFormInventorydataService= go();
		try {
			storageInFormInventorydataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public StorageInFormInventorydataService go() {
		System.out.println("进入StorageInFormClientHelper...go...");
		if(storageInFormInventorydataService == null) {
			try {
				storageInFormInventorydataService = (StorageInFormInventorydataService)Naming
						.lookup("rmi://127.0.0.1:32010/storageInFormInventorydataService");
				System.out.println("storageInFormInventorydataService RMI服务查找成功...");
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
		return storageInFormInventorydataService;
	}
	
	
	public InventoryInfoPO goFindinventory(String inventoryID){
		System.out.println("进入StorageInFormmClientHelper...client wants to finds positions...");
		inventoryInfoInventorydataService = gotoInventory();
		InventoryInfoPO po;
		try {
			po = inventoryInfoInventorydataService.findInventoryInfo(inventoryID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public InventoryInfoInventorydataService gotoInventory(){
		System.out.println("进入StorageInFormClientHelper...go...");
		if(inventoryInfoInventorydataService == null) {
			try {
				inventoryInfoInventorydataService = (InventoryInfoInventorydataService)Naming
						.lookup("rmi://127.0.0.1:32003/inventoryInfoInventorydataService");
				System.out.println("inventoryInfoInventorydataService RMI服务查找成功...");
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
		return inventoryInfoInventorydataService;
	}
}
