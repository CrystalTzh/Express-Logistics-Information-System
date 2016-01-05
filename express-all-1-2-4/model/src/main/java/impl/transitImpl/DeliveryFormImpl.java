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

import dataservice.transitdataservice.DeliveryFormTransitdataService;
import iohelper.IOHelper;
import po.DeliveryFormPO;

public class DeliveryFormImpl extends UnicastRemoteObject implements DeliveryFormTransitdataService{
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allDeliveryForm;
	File file = new File("派件单基本信息.txt");
	IOHelper ioHelper;
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	public DeliveryFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeliveryFormPO find(String NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find DeliveryFormPO Start!!");
		ioHelper = new IOHelper();
		allDeliveryForm= ioHelper.readFromFile(file);
		if(allDeliveryForm.containsKey(NO)) {
			DeliveryFormPO po = (DeliveryFormPO) allDeliveryForm.get(NO);
			System.out.println(po.getID());
			System.out.println("Find DeliveryFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(DeliveryFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert DeliveryFormPO Start!!");
		ioHelper = new IOHelper();
		allDeliveryForm = ioHelper.readFromFile(file);
		allDeliveryForm.put(po.getID(), po);
		System.out.println(po.getID());
		ioHelper.writeToFile(allDeliveryForm, file);
		System.out.println("Add DeliveryFormPO Over!!");
	}

	public void delete(DeliveryFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete DeliveryFormPO Start!!");
		
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allDeliveryForm = ioHelper.readFromFile(file);
		System.out.println(po.getID() );
		allDeliveryForm.remove(po.getID());
		ioHelper.writeToFile(allDeliveryForm, file);
	}

	public void update(DeliveryFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update DeliveryFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<DeliveryFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}