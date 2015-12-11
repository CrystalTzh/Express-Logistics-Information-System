package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.OfficeArrivalFormPO;

public interface OfficeArrivalFormTransitdataService extends Remote{

	public OfficeArrivalFormPO find(String NO) throws RemoteException, IllegalArgumentException;

	public void insert(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	
	public void delete(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	
	public void update(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException;
	
}
