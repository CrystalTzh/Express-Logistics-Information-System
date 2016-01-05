package datastub.transitdatastub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.transitdataservice.DeliveryFormTransitdataService;
import po.DeliveryFormPO;

public class DeliveryFormTransitdataStub implements DeliveryFormTransitdataService{
	public DeliveryFormPO find(String NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		DeliveryFormPO po = new DeliveryFormPO();
		return po;
	}
	public void insert(DeliveryFormPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(DeliveryFormPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(DeliveryFormPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
	@Override
	public ArrayList<DeliveryFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
}
