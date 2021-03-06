package impl.inventoryImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

import dataservice.inventorydataservice.StorageInFormInventorydataService;
import iohelper.IOHelper;
import po.StorageInFormPO;

public class StorageInFormServiceImpl extends UnicastRemoteObject implements StorageInFormInventorydataService {

	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allStorageInForm;
	File file = new File("入库单基本信息.txt");
	IOHelper ioHelper;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StorageInFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StorageInFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find StorageInFormPO Start!!");
		ioHelper = new IOHelper();
		allStorageInForm= ioHelper.readFromFile(file);
		if(allStorageInForm.containsKey(NO)) {
			StorageInFormPO po = (StorageInFormPO) allStorageInForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find StorageInFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert StorageInFormPO Start!!");
		ioHelper = new IOHelper();
		allStorageInForm = ioHelper.readFromFile(file);
		String NO = NOgenerate(getlargestNO());
		System.out.println(NO+" NO");
		po.setNO(NO);
		allStorageInForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allStorageInForm, file);
		System.out.println("Add StorageInFormPO Over!!");

	}

	public void delete(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete StorageInFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allStorageInForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO());
		allStorageInForm.remove(po.getNO());
		ioHelper.writeToFile(allStorageInForm, file);
	}

	public void update(StorageInFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update StorageInFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			ioHelper = new IOHelper();
			allStorageInForm = ioHelper.readFromFile(file);
			allStorageInForm.put(po.getNO(), po);
			System.out.println(po.getNO());
			ioHelper.writeToFile(allStorageInForm, file);
			System.out.println("Add StorageInFormPO Over!!");
		}
		System.out.println("update over!");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<StorageInFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find AllStorageInFormPO Start!!");
		ioHelper = new IOHelper();
		allStorageInForm= ioHelper.readFromFile(file);
		Enumeration<StorageInFormPO> e = allStorageInForm.elements();
		ArrayList<StorageInFormPO> polist = new ArrayList<StorageInFormPO>();
		while(e.hasMoreElements()){
			polist.add(e.nextElement());
		}
		return polist;
	}

	public String getlargestNO() throws RemoteException{
		Long ID = (long) 0;
		ArrayList<StorageInFormPO> pos = findAll();
		if(pos.size()==0){
			System.out.println("null");
			return "";
		}
		else{
			for(int i=0;i<pos.size();i++){
				Long NO = Long.parseLong(pos.get(i).getNO());
				System.out.println(pos.get(i).getNO());
				if(ID<NO)
					ID = NO; 
			}
			return Long.toString(ID);
		}
		
	}
	
	public String NOgenerate(String NO){
		System.out.println("did");
		
		if(NO==""){
			return "1024000000";
		}else{
			String ID = Long.toString(Long.parseLong(NO)+1);
			return ID;
		}
	}
	
}
