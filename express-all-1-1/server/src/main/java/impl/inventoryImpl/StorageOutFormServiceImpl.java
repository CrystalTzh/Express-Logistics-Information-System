package impl.inventoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.StorageOutFormPO;

public class StorageOutFormServiceImpl extends UnicastRemoteObject implements StorageOutFromInventorydataService {

	public StorageOutFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageOutFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding StorageOutFormPO...");
		return null;
	}

	public void insert(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("inserting StorageOutFormPO...");
		
	}

	public void delete(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("deleting StorageOutFormPO...");
	}

	public void update(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("updating StorageOutFormPO...");
	}

}
