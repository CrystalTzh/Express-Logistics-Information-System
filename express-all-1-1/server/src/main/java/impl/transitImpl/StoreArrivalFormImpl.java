package impl.transitImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import po.StoreArrivalFormPO;

public class StoreArrivalFormImpl extends UnicastRemoteObject implements StoreArrivalFormTransitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public StoreArrivalFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public StoreArrivalFormPO find(long NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find StoreArrivalFormPO Start!!");
		return null;
	}

	public void insert(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert StoreArrivalFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getNO()))) {
			System.out.println("待插入的StoreArrivalFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("StoreArrivalFormPO.ser", po);
			System.out.println("插入StoreArrivalFormPO对象成功！！！");
		}

	}

	public void delete(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete StoreArrivalFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
	}

	public void update(StoreArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update StoreArrivalFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
	}
	public boolean equals(StoreArrivalFormPO po1, StoreArrivalFormPO po2) {
		if(po1.getNO() == po2.getNO()) {
			return true;
		}
		return false;
	}
}
