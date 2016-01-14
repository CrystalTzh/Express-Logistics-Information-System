/**
 * @author 谭琼
 * 2015年12月9日
 */
package clienthelper.inventoryinfoclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import po.InventoryInfoPO;

/**
 * 在客户端，库存信息建立RMI连接
 */
public class InventoryInfoClientHelper {
	
	InventoryInfoInventorydataService inventoryInfoInventorydataService = null;
	
	/**
	 * 通过RMI远程查找某仓库的库存信息
	 * @param inventoryID
	 * @return
	 */
	public InventoryInfoPO goFindInventoryInfo(String inventoryID) {
		System.out.println("进入InventoryInfoClientHelper...goFindInventoryInfo...");
		inventoryInfoInventorydataService = this.go();
		try {
			InventoryInfoPO po = inventoryInfoInventorydataService.findInventoryInfo(inventoryID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过RMI远程更新某仓库的库存信息
	 * @param po
	 * @return
	 */
	public boolean goUpdateInventoryInfo(InventoryInfoPO po) {
		System.out.println("进入InventoryInfoClientHelper...goUpdateInventoryInfo...");
		inventoryInfoInventorydataService = this.go();
		try {
			inventoryInfoInventorydataService.updateInventoryInfo(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程增加一个仓库
	 * @param po
	 * @return
	 */
	public boolean goAddInventoryInfo(InventoryInfoPO po) {
		System.out.println("进入InventoryInfoClientHelper...goAddInventoryInfo...");
		inventoryInfoInventorydataService = this.go();
		try {
			inventoryInfoInventorydataService.addInventoryInfo(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程删除一个仓库
	 * @param po
	 * @return
	 */
	public boolean goDeleteInventoryInfo(InventoryInfoPO po) {
		System.out.println("进入InventoryInfoClientHelper...goDeleteInventoryInfo...");
		inventoryInfoInventorydataService = this.go();
		try {
			inventoryInfoInventorydataService.deleteInventoryInfo(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 客户端建立PriceInfoConstdataService服务的RMI连接
	 * @return
	 */
	public InventoryInfoInventorydataService go() {
		System.out.println("进入InventoryInfoClientHelper...go...");
		if(inventoryInfoInventorydataService == null) {
			try {
//				inventoryInfoInventorydataService = (InventoryInfoInventorydataService)Naming
//						.lookup("rmi://127.0.0.1:32004/inventoryInfoInventorydataService");
				inventoryInfoInventorydataService = (InventoryInfoInventorydataService)Naming
						.lookup(URL.getURL(ServiceName.INVENTORYINFO.toString()));
				System.out.println("inventoryInfoInventorydataService RMI服务查找成功...");
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
		}
		return inventoryInfoInventorydataService;
	}
	
	public static void main(String[] args) {
		InventoryInfoClientHelper inventoryInfoClientHelper = new InventoryInfoClientHelper();
//		inventoryInfoClientHelper.goAddInventoryInfo(new InventoryInfoPO("0210"));
		InventoryInfoPO po = inventoryInfoClientHelper.goFindInventoryInfo("0251");
		System.out.println(po.getLimit());
	}
	
}
