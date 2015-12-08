package impl.transitImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.CarOfficeTransitdataService;
import po.CarOfficeFormPO;

public class CarOfficeFormImpl extends UnicastRemoteObject implements CarOfficeTransitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarOfficeFormImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public CarOfficeFormPO find(long NO) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find CarOfficeFormPO Start!!");
		return null;
	}

	public void insert(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert CarOfficeFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getNO()))) {
			System.out.println("待插入的CarOfficeFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("CarOfficeFormPO.ser", po);
			System.out.println("插入CarOfficeFormPO对象成功！！！");
		}
	}

	public void delete(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete CarOfficeFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
	}

	public void update(CarOfficeFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update CarOfficeFormPO Start!!");
		if(po==null){
			throw new IllegalArgumentException();
		}
	}
	public boolean equals(CarOfficeFormPO po1, CarOfficeFormPO po2) {
		if(po1.getNO() == po2.getNO()) {
			return true;
		}
		return false;
	}
	
}
