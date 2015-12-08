package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import dataservice.financedataservice.CostPayChartdataService;
import po.CostpayChartPO;


public class CostPayChartServiceImpl extends UnicastRemoteObject implements CostPayChartdataService{

	public CostPayChartServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CostpayChartPO find(long NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("finding CostpayChartPO...");
		return null;
	}

	public void insert(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	
}
