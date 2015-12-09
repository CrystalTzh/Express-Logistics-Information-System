/**
 * 库存模块数据层接口
 * @author 谭琼
 */
package dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InventoryInfoPO;

/**
 * 库存信息数据层模块
 */
public interface InventoryInfoInventorydataService extends Remote {
	
	/**
	 * 根据仓库的标识查找库存信息
	 * @param inventoryID
	 * @return
	 * @throws RemoteException
	 */
	public InventoryInfoPO findInventoryInfo(String inventoryID) throws RemoteException;
	
	/**
	 * 更新某仓库信息
	 * @param po
	 * @throws RemoteException
	 */
	public void updateInventoryInfo(InventoryInfoPO po) throws RemoteException;
	
	/**
	 * 增加一个仓库
	 * @param po
	 * @throws RemoteException
	 */
	public void addInventoryInfo(InventoryInfoPO po) throws RemoteException;
	
	/**
	 * 删除一个仓库
	 * @param po
	 * @throws RemoteException
	 */
	public void deleteInventoryInfo(InventoryInfoPO po) throws RemoteException;
}
