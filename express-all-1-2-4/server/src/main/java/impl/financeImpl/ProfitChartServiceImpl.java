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

public class ProfitChartServiceImpl extends UnicastRemoteObject implements ProfitChartdataService {
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
	public ProfitChartServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void create(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("creating ProfitChartPO...");
	}

	@Override
	public ProfitChartPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find PaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allProfitChart= ioHelper.readFromFile(file);
		if(allProfitChart.containsKey(NO)) {
			ProfitChartPO po = (ProfitChartPO) allProfitChart.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find PaymentFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insert(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert ProfitChartPO Start!!");
		ioHelper = new IOHelper();
		allProfitChart = ioHelper.readFromFile(file);
		allProfitChart.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allProfitChart, file);
		System.out.println("Add ProfitChartPO Over!!");
	}

	@Override
	public void delete(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete ProfitChartPO Start!!");
		
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allProfitChart = ioHelper.readFromFile(file);
		System.out.println(po.getNO() );
		allProfitChart.remove(po.getNO());
		ioHelper.writeToFile(allProfitChart, file);
	}

	@Override
	public void update(ProfitChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update ProfitChartPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

}
