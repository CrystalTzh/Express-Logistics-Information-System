package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CarInputFormPO;

public interface CarInputFormTransitdataService extends Remote{
	public CarInputFormPO find(long NO) throws RemoteException, IllegalArgumentException;
	public void insert(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public String print(String str) throws RemoteException, IllegalArgumentException;
	
}
