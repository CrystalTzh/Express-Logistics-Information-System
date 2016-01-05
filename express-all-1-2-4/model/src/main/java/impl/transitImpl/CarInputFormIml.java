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

import dataservice.transitdataservice.CarInputFormTransitdataService;
import iohelper.IOHelper;
import po.CarInputFormPO;

public class CarInputFormIml extends UnicastRemoteObject implements CarInputFormTransitdataService{
	
	/**
	 * 
	 */
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allCarInputForm;
	File file = new File("中转中心装车单基本信息.txt");
	IOHelper ioHelper;
	
	private static final long serialVersionUID = 1L;

	public CarInputFormIml() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public CarInputFormPO find(String NO) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find CarInputFormPO Start!!");
		ioHelper = new IOHelper();
		allCarInputForm= ioHelper.readFromFile(file);
		if(allCarInputForm.containsKey(NO)) {
			CarInputFormPO po = (CarInputFormPO) allCarInputForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find CarInputFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert CarInputFormPO Start!!");
		ioHelper = new IOHelper();
		allCarInputForm = ioHelper.readFromFile(file);
		allCarInputForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allCarInputForm, file);
		System.out.println("Add CarInputFormPO Over!!");
	}

	public void delete(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete CarInputFormPO Start!!");
		
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allCarInputForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO() );
		allCarInputForm.remove(po.getNO());
		ioHelper.writeToFile(allCarInputForm, file);
		
	}

	public void update(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update CarInputFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}


	@Override
	public ArrayList<CarInputFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
