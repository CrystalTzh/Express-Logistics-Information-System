package impl.financeImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.financedataservice.CostPayChartdataService;
import iohelper.IOHelper;
import po.CostpayChartPO;


public class CostPayChartServiceClientImpl extends UnicastRemoteObject implements CostPayChartdataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allCostPayChart;
	File file = new File("成本收益表基本信息.txt");
	IOHelper ioHelper;
	public CostPayChartServiceClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CostpayChartPO find(String NO) throws RemoteException {
		System.out.println("Find PaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allCostPayChart= ioHelper.readFromFile(file);
		if(allCostPayChart.containsKey(NO)) {
			CostpayChartPO po = (CostpayChartPO) allCostPayChart.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find PaymentFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert CostPayChartPO Start!!");
		ioHelper = new IOHelper();
		allCostPayChart = ioHelper.readFromFile(file);
		allCostPayChart.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allCostPayChart, file);
		System.out.println("Add CostPayChartPO Over!!");
	}

	public void delete(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete CostPayChartPO Start!!");
		
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allCostPayChart = ioHelper.readFromFile(file);
		System.out.println(po.getNO() );
		allCostPayChart.remove(po.getNO());
		ioHelper.writeToFile(allCostPayChart, file);
	}

	public void update(CostpayChartPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update CostPayChartPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	

	
}
