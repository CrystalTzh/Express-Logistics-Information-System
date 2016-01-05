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

import dataservice.financedataservice.PaymentFormdataService;
import iohelper.IOHelper;
import po.PaymentFormPO;


public class PaymentFormServiceImpl extends UnicastRemoteObject implements PaymentFormdataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable<String, PaymentFormPO> allPaymentForm;
	File file = new File("付款单基本信息.txt");
	IOHelper ioHelper;
	public PaymentFormServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@SuppressWarnings("unchecked")
	public PaymentFormPO find(String NO) throws RemoteException {
		System.out.println("Find PaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allPaymentForm= ioHelper.readFromFile(file);
		if(allPaymentForm.containsKey(NO)) {
			PaymentFormPO po = (PaymentFormPO) allPaymentForm.get(NO);
			System.out.println(po.getNO());
			System.out.println("Find PaymentFormPO Over!!");
			return po;
		}else{
			System.out.print("exception");
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public void insert(PaymentFormPO po) throws RemoteException {
		System.out.println("Insert ReceiptFormPO Start!!");
		ioHelper = new IOHelper();
		allPaymentForm = ioHelper.readFromFile(file);
		String NO = NOgenerate(getlargestNO());
		System.out.println(NO+" NO");
		po.setNO(NO);
		allPaymentForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allPaymentForm, file);
		System.out.println("Add ReceiptFormPO Over!!");
		
	}

	@SuppressWarnings("unchecked")
	public void delete(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
				System.out.println("Delete ReceiptFormPO Start!!");
				
				if(po==null){
					throw new IllegalArgumentException();
				}
				ioHelper = new IOHelper();
				allPaymentForm = ioHelper.readFromFile(file);
				System.out.println(po.getNO() );
				allPaymentForm.remove(po.getNO());
				ioHelper.writeToFile(allPaymentForm, file);
		
	}

	public void update(PaymentFormPO po) throws RemoteException {
		// TODO Auto-generated method stub
				System.out.println("Update PaymentFormPO Start!!");
				if(po==null){
					throw new IllegalArgumentException();
				}else{
					ioHelper = new IOHelper();
					allPaymentForm = ioHelper.readFromFile(file);
					allPaymentForm.put(po.getNO(), po);
					System.out.println(po.getNO());
					ioHelper.writeToFile(allPaymentForm, file);
					System.out.println("Add ReceiptFormPO Over!!");
				}
				System.out.println("update over!");
		
	}

	@SuppressWarnings("unchecked")
	public ArrayList<PaymentFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Find AllPaymentFormPO Start!!");
		ioHelper = new IOHelper();
		allPaymentForm= ioHelper.readFromFile(file);
		Enumeration<PaymentFormPO> e = allPaymentForm.elements();
		ArrayList<PaymentFormPO> polist = new ArrayList<PaymentFormPO>();
		while(e.hasMoreElements()){
			polist.add(e.nextElement());
		}
		return polist;
	}
	
	public String getlargestNO() throws RemoteException{
		Long ID = (long) 0;
		ArrayList<PaymentFormPO> pos = findAll();
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
