package dataservice.transitdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OrderFormPO;

public interface OrderFormTransitdataService extends Remote{
	public OrderFormPO find(String ID) throws RemoteException, IllegalArgumentException;
	public void insert(OrderFormPO po) throws RemoteException, IllegalArgumentException;
	public void delete(OrderFormPO po) throws RemoteException, IllegalArgumentException;
	public void update(OrderFormPO po) throws RemoteException, IllegalArgumentException;
	public ArrayList<OrderFormPO> findAll()throws RemoteException, IllegalArgumentException;
}
