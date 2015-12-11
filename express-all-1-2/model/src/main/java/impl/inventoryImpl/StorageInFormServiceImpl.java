package impl.inventoryImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.inventorydataservice.StorageInFormInventorydataService;
import po.StorageInFormPO;

public class StorageInFormServiceImpl extends UnicastRemoteObject implements StorageInFormInventorydataService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageInFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageInFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding StorageInFormPO...");
		return null;
	}

	public void insert(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("inserting StorageInFormPO...");

	}

	public void delete(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("deleting StorageInFormPO...");

	}

	public void update(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("updating StorageInFormPO...");
	}

}
