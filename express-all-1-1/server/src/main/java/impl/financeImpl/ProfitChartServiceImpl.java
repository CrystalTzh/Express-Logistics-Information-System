package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.ProfitChartdataService;
import po.ProfitChartPO;

public class ProfitChartServiceImpl extends UnicastRemoteObject implements ProfitChartdataService {

	public ProfitChartServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("creating ProfitChartPO...");
	}

	public void update(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub

	}

}
