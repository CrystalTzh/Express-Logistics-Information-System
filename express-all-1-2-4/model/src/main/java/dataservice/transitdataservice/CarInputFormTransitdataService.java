package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.CarInputFormPO;

public interface CarInputFormTransitdataService extends Remote{
	public CarInputFormPO find(String NO) throws RemoteException, IllegalArgumentException;
	public void insert(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(CarInputFormPO po) throws RemoteException, IllegalArgumentException;
	public ArrayList<CarInputFormPO> findAll()throws RemoteException, IllegalArgumentException;
	
}
