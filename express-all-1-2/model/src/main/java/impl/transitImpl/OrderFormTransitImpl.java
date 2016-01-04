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

import dataservice.transitdataservice.OrderFormTransitdataService;
import iohelper.IOHelper;
import po.OrderFormPO;

public class OrderFormTransitImpl extends UnicastRemoteObject implements OrderFormTransitdataService{

	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allOrderForm;
	File file = new File("寄件单基本信息.txt");
	IOHelper ioHelper;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFormTransitImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderFormPO find(String ID) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find OrderFormPO Start!!");
		ioHelper = new IOHelper();
		allOrderForm= ioHelper.readFromFile(file);
		if(allOrderForm.containsKey(ID)) {
			OrderFormPO po = (OrderFormPO) allOrderForm.get(ID);
			System.out.println(po.getID());
			System.out.println("Find OrderFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert OrderFormPO Start!!");
		ioHelper = new IOHelper();
		allOrderForm = ioHelper.readFromFile(file);
		allOrderForm.put(po.getID(), po);
		System.out.println(po.getID());
		ioHelper.writeToFile(allOrderForm, file);
		System.out.println("Add OrderFormPO Over!!");
	}

	public void delete(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		
		System.out.println("Delete OrderFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allOrderForm = ioHelper.readFromFile(file);
		System.out.println(po.getID());
		allOrderForm.remove(po.getID());
		ioHelper.writeToFile(allOrderForm, file);
	}

	public void update(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update OrderFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<OrderFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
