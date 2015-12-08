package impl.transitImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormImpl extends UnicastRemoteObject implements OfficeArrivalFormTransitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public OfficeArrivalFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public OfficeArrivalFormPO find(long NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find OfficeArrivalFormPO Start!!");
		return null;
	}

	public void insert(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert OfficeArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getNO()))) {
			System.out.println("待插入的OfficeArrivalFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("OfficeArrivalFormPO.ser", po);
			System.out.println("插入OfficeArrivalFormPO对象成功！！！");
		}
	}

	public void delete(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete OfficeArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
	}

	public void update(OfficeArrivalFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update OfficeArrivalFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}

	}
	public boolean equals(OfficeArrivalFormPO po1, OfficeArrivalFormPO po2) {
		if(po1.getNO() == po2.getNO()) {
			return true;
		}
		return false;
	}
}
