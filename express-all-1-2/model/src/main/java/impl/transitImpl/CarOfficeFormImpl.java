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

import dataservice.transitdataservice.CarOfficeTransitdataService;
import iohelper.IOHelper;
import po.CarOfficeFormPO;

public class CarOfficeFormImpl extends UnicastRemoteObject implements CarOfficeTransitdataService{

	/**
	 * 
	 */
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allCarOfficeForm;
	File file = new File("营业厅装车单基本信息.txt");
	IOHelper ioHelper;
	
	private static final long serialVersionUID = 1L;

	public CarOfficeFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarOfficeFormPO find(String NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find CarOfficeFormPO Start!!");
		ioHelper = new IOHelper();
		allCarOfficeForm= ioHelper.readFromFile(file);
		if(allCarOfficeForm.containsKey(NO)) {
			CarOfficeFormPO po = (CarOfficeFormPO) allCarOfficeForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find CarOfficeFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert CarOfficeFormPO Start!!");
		ioHelper = new IOHelper();
		allCarOfficeForm = ioHelper.readFromFile(file);
		allCarOfficeForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allCarOfficeForm,file);
		System.out.println("Add CarOfficeFormPO Over!!");
	}

	public void delete(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete CarOfficeFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allCarOfficeForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO() );
		allCarOfficeForm.remove(po.getNO());
		ioHelper.writeToFile(allCarOfficeForm, file);
	}

	public void update(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update CarOfficeFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<CarOfficeFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
