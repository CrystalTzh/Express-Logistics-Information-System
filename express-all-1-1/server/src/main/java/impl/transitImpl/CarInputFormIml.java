package impl.transitImpl;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.CarInputFormTransitdataService;
import po.CarInputFormPO;

public class CarInputFormIml extends UnicastRemoteObject implements CarInputFormTransitdataService{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarInputFormIml() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}


	public CarInputFormPO find(long NO) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find CarInputFormPO Start!!");
		
		return null;
	}

	public void insert(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert CarInputFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getNO()))) {
			System.out.println("待插入的CarInputFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("CarInputFormPO.ser", po);
			System.out.println("插入CarInputFormPO对象成功！！！");
		}
	}

	public void delete(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete CarInptutFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		
	}

	public void update(CarInputFormPO po) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update CarInptutFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		
	}

	public String print(String str) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Print CarInptutFormPO Start!!");
		if(str == null) {
			throw new IllegalArgumentException();
		}
		return str;
	}
	
	public boolean equals(CarInputFormPO po1, CarInputFormPO po2) {
		if(po1.getNO() == po2.getNO()) {
			return true;
		}
		return false;
	}
	
}
