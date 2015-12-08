package dataservice.inventorydataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.InventoryInfoPO;

public interface InventoryInfoInventorydataService extends Remote {
	public InventoryInfoPO find() throws RemoteException;
	public void update(InventoryInfoPO po) throws RemoteException;
}
