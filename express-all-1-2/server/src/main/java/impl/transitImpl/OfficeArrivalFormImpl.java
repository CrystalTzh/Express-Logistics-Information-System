package impl.transitImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import iohelper.IOHelper;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormImpl extends UnicastRemoteObject implements OfficeArrivalFormTransitdataService{

	/**
	 * 
	 */
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allOfficeArrivalForm;
	File file = new File("营业厅到达单单基本信息.txt");
	IOHelper ioHelper;
	
	private static final long serialVersionUID = 1L;
	
	public OfficeArrivalFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public OfficeArrivalFormPO find(String NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find OfficeArrivalFormPO Start!!");
		ioHelper = new IOHelper();
		allOfficeArrivalForm = ioHelper.readFromFile(file);
		if(allOfficeArrivalForm.containsKey(NO)) {
			OfficeArrivalFormPO po = (OfficeArrivalFormPO) allOfficeArrivalForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find OfficeArrivalFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	public void insert(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert OfficeArrivalFormPO Start!!");
		ioHelper = new IOHelper();
		allOfficeArrivalForm = ioHelper.readFromFile(file);
		allOfficeArrivalForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allOfficeArrivalForm, file);
		System.out.println("Add OfficeArrivalFormPO Over!!");
	}

	public void delete(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete OfficeArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allOfficeArrivalForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO());
		allOfficeArrivalForm.remove(po.getNO());
		ioHelper.writeToFile(allOfficeArrivalForm, file);
	}

	public void update(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update OfficeArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");

	}
	
}
