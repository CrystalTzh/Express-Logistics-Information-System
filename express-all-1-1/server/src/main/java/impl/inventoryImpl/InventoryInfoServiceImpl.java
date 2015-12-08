package impl.inventoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import po.InventoryInfoPO;

public class InventoryInfoServiceImpl extends UnicastRemoteObject implements InventoryInfoInventorydataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public InventoryInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryInfoPO find() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding inventoryInfo...");
		
		return null;
	}

	public void update(InventoryInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("updating inventoryInfo...");
		
	}

}
