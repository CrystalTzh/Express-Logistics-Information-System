package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CostpayChartPO;

public interface CostPayChartdataService extends Remote{
	public CostpayChartPO find(long NO) throws RemoteException;
	public void insert(CostpayChartPO po) throws RemoteException;
	public void delete(CostpayChartPO po) throws RemoteException;
	public void update(CostpayChartPO po) throws RemoteException;
}
