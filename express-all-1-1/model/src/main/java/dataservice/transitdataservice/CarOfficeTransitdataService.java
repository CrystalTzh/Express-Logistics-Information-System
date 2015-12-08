package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CarOfficeFormPO;

public interface CarOfficeTransitdataService extends Remote{
	public CarOfficeFormPO find(long NO) throws RemoteException, IllegalArgumentException;
	public void insert(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException;
}
