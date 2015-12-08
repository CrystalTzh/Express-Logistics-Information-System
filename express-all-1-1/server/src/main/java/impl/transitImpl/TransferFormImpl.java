package impl.transitImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.TransferFormdTransitataService;
import po.TransferFormPO;

public class TransferFormImpl extends UnicastRemoteObject implements TransferFormdTransitataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public TransferFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public TransferFormPO find(long NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find TransferFormPO Start!!");
		return null;
	}

	public void insert(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert TransferFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getNO()))) {
			System.out.println("待插入的TransferFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("TransferFormPO.ser", po);
			System.out.println("插入TransferFormPO对象成功！！！");
		}

	}

	public void delete(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete TransferFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}

	}

	public void update(TransferFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update TransferFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}

	}
	public boolean equals(TransferFormPO po1, TransferFormPO po2) {
		if(po1.getNO() == po2.getNO()) {
			return true;
		}
		return false;
	}

}
