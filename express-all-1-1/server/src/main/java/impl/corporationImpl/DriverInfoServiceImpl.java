package impl.corporationImpl;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import ioHelper.IOHelper;
import po.DriverInfoPO;

public class DriverInfoServiceImpl extends UnicastRemoteObject implements DriverInfoCorporationdataService {
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allDriverInfo;
	File file = new File("司机基本信息.txt");
	IOHelper ioHelper;
	
	public DriverInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverInfoPO find(String driverNumber) throws RemoteException, EOFException {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfoServiceImpl...server finding...");
		ioHelper = new IOHelper();
		allDriverInfo = ioHelper.readFromFile(file);
		if(allDriverInfo.containsKey(driverNumber)) {
			DriverInfoPO po = (DriverInfoPO) allDriverInfo.get(driverNumber);
			System.out.println("Find: " + po.getDriverNumber() + " " + po.getName());
			System.out.println("Find DriverInfoPO Over!!");
			return po;
		}
		System.out.println("Find DriverInfoPO Over!!");
		return null;
	}

	public void update(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfoServiceImpl...server updating...");
		add(po);
		System.out.println("Update DriverInfoPO Over!!");
	}

	public void add(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfoServiceImpl...server adding...");
		ioHelper = new IOHelper();
		allDriverInfo = ioHelper.readFromFile(file);
		allDriverInfo.put(po.getDriverNumber(), po);
		System.out.println("To be Added: " + po.getDriverNumber() + " " + po.getName());
		ioHelper.writeToFile(allDriverInfo, file);
		System.out.println("Add DriverInfoPO Over!!");
	}

	public void delete(DriverInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfoServiceImpl...server deleting...");
		ioHelper = new IOHelper();
		allDriverInfo = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " + po.getDriverNumber() + " " + po.getName());
		allDriverInfo.remove(po.getDriverNumber());
		ioHelper.writeToFile(allDriverInfo, file);
		System.out.println("Delete DriverInfoPO Over!!");
	}

}
