package datastub.transitdatastub;

import java.rmi.RemoteException;

import dataservice.transitdataservice.OrderFormTransitdataService;
import po.OrderFormPO;

public class OrderFormTransitdataStub implements OrderFormTransitdataService{
	public OrderFormPO find(String ID) throws RemoteException {
		System.out.println("Find Succeed!\n");
		return null;
	}
	public void insert(OrderFormPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(OrderFormPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(OrderFormPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
}
