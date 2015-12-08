package datastub.inventorydatastub;

import java.rmi.RemoteException;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.StorageOutFormPO;
import state.Transport;

public class StorageOutFormInventorydataStub implements StorageOutFromInventorydataService {

	public StorageOutFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find Succeed!\n");
		StorageOutFormPO po=new StorageOutFormPO("001","A", "10086", "b", Transport.CAR);
		return po;
	}

	public void insert(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

}
