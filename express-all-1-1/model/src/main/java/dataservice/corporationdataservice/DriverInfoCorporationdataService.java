package dataservice.corporationdataservice;

import java.io.EOFException;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.DriverInfoPO;

public interface DriverInfoCorporationdataService extends Remote{
	public DriverInfoPO find(String driverNumber) throws RemoteException, EOFException;
	public void update(DriverInfoPO po) throws RemoteException;
	public void add(DriverInfoPO po) throws RemoteException;
	public void delete(DriverInfoPO po) throws RemoteException;
}
