package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.DeliveryFormPO;

public interface DeliveryFormTransitdataService extends Remote{
	public DeliveryFormPO find(String NO) throws RemoteException, IllegalArgumentException;
	public void insert(DeliveryFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(DeliveryFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(DeliveryFormPO po) throws RemoteException, IllegalArgumentException;
}
