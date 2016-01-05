package impl.financeImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.financedataservice.ProfitChartdataService;
import iohelper.IOHelper;
import po.ProfitChartPO;

public class ProfitChartServiceClientImpl extends UnicastRemoteObject implements ProfitChartdataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allProfitChart;
	File file = new File("经营情况表基本信息.txt");
	IOHelper ioHelper;

	public ProfitChartServiceClientImpl() throws RemoteException {
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

	public ProfitChartPO find(String nO) {
		System.out.println("Find PaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allProfitChart = ioHelper.readFromFile(file);
		if (allProfitChart.containsKey(nO)) {
			ProfitChartPO po = (ProfitChartPO) allProfitChart.get(nO);
			System.out.println(po.getNO());
			System.out.println("Find PaymentFormPO Over!!");
			return po;
		} else {
			System.out.print("exception");
		}
		return null;
	}

	@Override
	public void insert(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
