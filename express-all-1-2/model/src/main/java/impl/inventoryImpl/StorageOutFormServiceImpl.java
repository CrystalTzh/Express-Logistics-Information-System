package impl.inventoryImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;

import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import iohelper.IOHelper;
import po.StorageOutFormPO;

public class StorageOutFormServiceImpl extends UnicastRemoteObject implements StorageOutFromInventorydataService {

	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allStorageOutForm;
	File file = new File("出库单基本信息.txt");
	IOHelper ioHelper;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageOutFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageOutFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find StorageOutFormPO Start!!");
		ioHelper = new IOHelper();
		allStorageOutForm= ioHelper.readFromFile(file);
		if(allStorageOutForm.containsKey(NO)) {
			StorageOutFormPO po = (StorageOutFormPO) allStorageOutForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find StorageOutFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert StorageOutFormPO Start!!");
		ioHelper = new IOHelper();
		allStorageOutForm = ioHelper.readFromFile(file);
		allStorageOutForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allStorageOutForm, file);
		System.out.println("Add StorageOutFormPO Over!!");
	}

	public void delete(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete StorageOutFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allStorageOutForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO());
		allStorageOutForm.remove(po.getNO());
		ioHelper.writeToFile(allStorageOutForm, file);
	}

	public void update(StorageOutFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update StorageOutFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<StorageOutFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
