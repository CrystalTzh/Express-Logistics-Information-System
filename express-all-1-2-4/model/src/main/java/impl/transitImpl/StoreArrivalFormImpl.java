package impl.transitImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;

import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import iohelper.IOHelper;
import po.StoreArrivalFormPO;

public class StoreArrivalFormImpl extends UnicastRemoteObject implements StoreArrivalFormTransitdataService{

	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allStoreArrivalForm;
	File file = new File("中转中心到达单基本信息.txt");
	IOHelper ioHelper;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StoreArrivalFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreArrivalFormPO find(String NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find OrderFormPO Start!!");
		ioHelper = new IOHelper();
		allStoreArrivalForm= ioHelper.readFromFile(file);
		if(allStoreArrivalForm.containsKey(NO)) {
			StoreArrivalFormPO po = (StoreArrivalFormPO) allStoreArrivalForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find StoreArrivalFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert OrderFormPO Start!!");
		ioHelper = new IOHelper();
		allStoreArrivalForm = ioHelper.readFromFile(file);
		allStoreArrivalForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allStoreArrivalForm, file);
		System.out.println("Add StoreArrivalFormPO Over!!");

	}

	public void delete(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete StoreArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allStoreArrivalForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO());
		allStoreArrivalForm.remove(po.getNO());
		ioHelper.writeToFile(allStoreArrivalForm, file);
	}

	public void update(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update StoreArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<StoreArrivalFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
