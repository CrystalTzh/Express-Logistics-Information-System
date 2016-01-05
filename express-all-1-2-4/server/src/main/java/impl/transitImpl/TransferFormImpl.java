package impl.transitImpl;

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

import dataservice.transitdataservice.TransferFormTransitdataService;
import iohelper.IOHelper;
import po.TransferFormPO;

public class TransferFormImpl extends UnicastRemoteObject implements TransferFormTransitdataService{

	/**
	 * 
	 */
	
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allTransferForm;
	File file = new File("中转单基本信息.txt");
	IOHelper ioHelper;
	
	private static final long serialVersionUID = 1L;

	public TransferFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferFormPO find(String NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find TransferFormPO Start!!");
		ioHelper = new IOHelper();
		allTransferForm= ioHelper.readFromFile(file);
		if(allTransferForm.containsKey(NO)) {
			TransferFormPO po = (TransferFormPO) allTransferForm.get(NO);
			System.out.println(po.getRelayFormNumber());
			System.out.println("Find TransferFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert TransferFormPO Start!!");
		ioHelper = new IOHelper();
		allTransferForm = ioHelper.readFromFile(file);
		allTransferForm.put(po.getRelayFormNumber(), po);
		System.out.println(po.getRelayFormNumber());
		ioHelper.writeToFile(allTransferForm, file);
		System.out.println("Add TransferFormPO Over!!");
	}

	public void delete(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete TransferFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allTransferForm = ioHelper.readFromFile(file);
		System.out.println(po.getRelayFormNumber());
		allTransferForm.remove(po.getRelayFormNumber());
		ioHelper.writeToFile(allTransferForm, file);
	}

	public void update(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update TransferFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<TransferFormPO> findAll() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find AllPaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allTransferForm= ioHelper.readFromFile(file);
		Enumeration<TransferFormPO> e = allTransferForm.elements();
		ArrayList<TransferFormPO> polist = new ArrayList<TransferFormPO>();
		while(e.hasMoreElements()){
			polist.add(e.nextElement());
		}
		return polist;
	}
	
}