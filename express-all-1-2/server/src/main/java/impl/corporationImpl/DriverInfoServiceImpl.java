package impl.corporationImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import iohelper.IOHelper;
import po.DriverInfoPO;
import state.InitRelatedFiles;

public class DriverInfoServiceImpl extends UnicastRemoteObject implements DriverInfoCorporationdataService {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allDriverInfo;
//	File file = new File("司机基本信息.txt");
	File file = new File(InitRelatedFiles.DRIVERINFO.toString());
	IOHelper ioHelper;
	
	public DriverInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public DriverInfoPO find(String driverNumber) throws RemoteException{
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

	@SuppressWarnings("unchecked")
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

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.DriverInfoCorporationdataService#findAll()
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<DriverInfoPO> findAll() throws RemoteException {
		System.out.println("进入DriverInfoServiceImpl...server findAll...");
		ioHelper = new IOHelper();
		allDriverInfo = ioHelper.readFromFile(file);
		
		ArrayList<DriverInfoPO> allDriverPO = new ArrayList<DriverInfoPO>();
		for(Iterator itr = allDriverInfo.keySet().iterator(); itr.hasNext();) {
			String key = (String) itr.next();
			allDriverPO.add((DriverInfoPO)allDriverInfo.get(key));
		}
		
		if(allDriverPO.size() == 0) {
			System.out.println("服务器中暂时没有司机信息..");
			return allDriverPO;
		}
		
		System.out.println("服务器中的所有司机信息：");
		for(int i = 0; i < allDriverPO.size(); i++) {
			DriverInfoPO po = allDriverPO.get(i);
			System.out.println(po.getDriverNumber() + " " + po.getName());
		}
		return allDriverPO;
	}
	
	public static void main(String[] args) {
		try {
			DriverInfoServiceImpl driverInfoServiceImpl = new DriverInfoServiceImpl();
			driverInfoServiceImpl.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
