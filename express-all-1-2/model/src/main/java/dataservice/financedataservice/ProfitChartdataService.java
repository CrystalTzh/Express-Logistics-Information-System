package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.ProfitChartPO;

public interface ProfitChartdataService extends Remote{

	public void create(ProfitChartPO po) throws RemoteException;
	public ProfitChartPO find(String NO) throws RemoteException;
	public void insert(ProfitChartPO po) throws RemoteException;
	public void delete(ProfitChartPO po) throws RemoteException;
	public void update(ProfitChartPO po) throws RemoteException;
}
