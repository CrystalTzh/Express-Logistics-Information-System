package impl.transitImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.transitdataservice.OrderFormTransitdataService;
import po.OrderFormPO;

public class OrderFormTransitImpl extends UnicastRemoteObject implements OrderFormTransitdataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OrderFormTransitImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public OrderFormPO find(long ID) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Find OrderFormPO Start!!");
		return null;
	}

	public void insert(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Insert OrderFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
		if(po.equals(find(po.getID()))) {
			System.out.println("待插入的OrderFormPO已存在！！");
		} else {
			FileHelper filehelper = new FileHelper();
			filehelper.saveToFile("OrderFormPO.ser", po);
			System.out.println("插入OrderFormPO对象成功！！！");
		}
	}

	public void delete(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Delete OrderFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}
	}

	public void update(OrderFormPO po) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("Update OrderFormPO Start!!");
		if(po == null){
			throw new IllegalArgumentException();
		}

	}
	public boolean equals(OrderFormPO po1, OrderFormPO po2) {
		if(po1.getID() == po2.getID()) {
			return true;
		}
		return false;
	}
	

}
