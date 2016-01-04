package impl.financeImpl;

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

import dataservice.financedataservice.ReceiptFormdataService;
import iohelper.IOHelper;
import po.PaymentFormPO;
import po.ReceiptFormPO;

public class ReceiptFormServiceImpl extends UnicastRemoteObject implements ReceiptFormdataService{
	
	
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

	public ReceiptFormServiceImpl() throws RemoteException {
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
			System.out.println(po.getId().get(0));
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
		String NO = NOgenerate(getlargestNO());
		System.out.println(NO+" NO");
		po.setNO(NO);
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
		if(po==null){
			throw new IllegalArgumentException();
		}else{
			insert(po);
		}
		System.out.println("update over!");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ReceiptFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find AllReceiptFormPO Start!!");
		ioHelper = new IOHelper();
		allReceiptForm= ioHelper.readFromFile(file);
		Enumeration<ReceiptFormPO> e = allReceiptForm.elements();
		ArrayList<ReceiptFormPO> polist = new ArrayList<ReceiptFormPO>();
		while(e.hasMoreElements()){
			polist.add(e.nextElement());
		}
		return polist;
	}
	
	public String getlargestNO() throws RemoteException{
		Long ID = (long) 0;
		ArrayList<ReceiptFormPO> pos = findAll();
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

//	public static void main(String args[]) throws RemoteException{
//		ReceiptFormdataService rds = new ReceiptFormServiceImpl();
//		ReceiptFormPO id = new ReceiptFormPO();
//		id = rds.find("001");
//		System.out.println(id.getDate());
//		System.out.println(id.getId().get(0));
//	}
	
}
