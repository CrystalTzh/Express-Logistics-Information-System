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

import dataservice.financedataservice.PaymentFormdataService;
import iohelper.IOHelper;
import po.PaymentFormPO;


public class PaymentFormServiceClientImpl extends UnicastRemoteObject implements PaymentFormdataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allPaymentForm;
	File file = new File("付款单基本信息.txt");
	IOHelper ioHelper;
	public PaymentFormServiceClientImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

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
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		System.out.println(df.format(new Date()));
		po.setNO(df.format(new Date()));
		allPaymentForm.put(po.getNO(), po);
		System.out.println(po.getNO());
		ioHelper.writeToFile(allPaymentForm, file);
		System.out.println("Add ReceiptFormPO Over!!");
		
	}

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
					insert(po);
				}
				System.out.println("update over!");
		
	}

	@Override
	public ArrayList<PaymentFormPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
