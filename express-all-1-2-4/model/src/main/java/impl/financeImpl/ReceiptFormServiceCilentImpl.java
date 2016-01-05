package impl.financeImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import dataservice.financedataservice.ReceiptFormdataService;
import iohelper.IOHelper;
import po.ReceiptFormPO;

public class ReceiptFormServiceCilentImpl extends UnicastRemoteObject implements ReceiptFormdataService{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allReceiptForm;
	File file = new File("收款单基本信息.txt");
	IOHelper ioHelper;

	public ReceiptFormServiceCilentImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReceiptFormPO find(String NO) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find ReceiptFormPO Start!!");
		ioHelper = new IOHelper();
		allReceiptForm= ioHelper.readFromFile(file);
		if(allReceiptForm.containsKey(NO)) {
			ReceiptFormPO po = (ReceiptFormPO) allReceiptForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find ReceiptFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert ReceiptFormPO Start!!");
		ioHelper = new IOHelper();
		allReceiptForm = ioHelper.readFromFile(file);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(df.format(new Date()));
		po.setNO(df.format(new Date()));
		allReceiptForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allReceiptForm, file);
		System.out.println("Add ReceiptFormPO Over!!");
	}

	public void delete(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete ReceiptFormPO Start!!");
		
		if(po==null){
			throw new IllegalArgumentException();
		}
		ioHelper = new IOHelper();
		allReceiptForm = ioHelper.readFromFile(file);
		System.out.println(po.getNO() );
		allReceiptForm.remove(po.getNO());
		ioHelper.writeToFile(allReceiptForm, file);
	}

	public void update(ReceiptFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update ReceiptFormPO Start!!");
		System.out.println("client do");
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@Override
	public ArrayList<ReceiptFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

//	public static void main(String args[]) throws RemoteException{
//		ReceiptFormdataService rds = new ReceiptFormServiceImpl();
//		ReceiptFormPO id = new ReceiptFormPO();
//		id = rds.find("1024000000");
//		System.out.println(id.getDate());
//		System.out.println(id.getId().get(0));
//		System.out.println(id.getNO());
//	}

}
