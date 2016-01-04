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

import dataservice.corporationdataservice.CarInfoCorporationdataService;
import iohelper.IOHelper;
import po.CarInfoPO;
import state.InitRelatedFiles;

public class CarInfoServiceImpl extends UnicastRemoteObject implements CarInfoCorporationdataService {
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allCarInfo;
//	File file = new File("车辆基本信息.txt");
	File file = new File(InitRelatedFiles.CARINFO.toString());
	IOHelper ioHelper;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CarInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void update(CarInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfoServiceImpl...server updating...");
		add(po);
		System.out.println("Update DriverInfoPO Over!!");
	}

	@SuppressWarnings("unchecked")
	public void add(CarInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfoServiceImpl...server adding...");
		ioHelper = new IOHelper();
		allCarInfo = ioHelper.readFromFile(file);
		allCarInfo.put(po.getCarNumber(), po);
		System.out.println("To be added: " + po.getCarNumber() + " " + po.getPlateNumber());
		ioHelper.writeToFile(allCarInfo, file);
		System.out.println("Add CarInfoPO Over!!");
	}

	public void delete(CarInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfoServiceImpl...server deleting...");
		ioHelper = new IOHelper();
		allCarInfo = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " + po.getCarNumber() + " " + po.getPlateNumber());
		allCarInfo.remove(po.getCarNumber());
		ioHelper.writeToFile(allCarInfo, file);
		System.out.println("Delete CarInfoPO Over!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.CarInfoCorporationdataService#find(java.lang.String)
	 */
	public CarInfoPO find(String carNumber) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfoServiceImpl...server finding...");
		ioHelper = new IOHelper();
		allCarInfo = ioHelper.readFromFile(file);
		if(allCarInfo.containsKey(carNumber)) {
			CarInfoPO po = (CarInfoPO) allCarInfo.get(carNumber);
			System.out.println(po.getCarNumber() + " " + po.getPlateNumber());
			System.out.println("Find CarInfoPO Over!!");
			return po;
		}
		System.out.println("Find CarInfoPO Over!!");
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.CarInfoCorporationdataService#findAll()
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<CarInfoPO> findAll() throws RemoteException {
		System.out.println("进入CarInfoServiceImpl...server finding...");
		ioHelper = new IOHelper();
		allCarInfo = ioHelper.readFromFile(file);
		
		ArrayList<CarInfoPO> allCarInfoPO = new ArrayList<CarInfoPO>();
		for(Iterator itr = allCarInfo.keySet().iterator(); itr.hasNext();) {
			String key = (String) itr.next();
			allCarInfoPO.add((CarInfoPO)allCarInfo.get(key));
		}
		
		if(allCarInfoPO.size() == 0) {
			System.out.println("服务器中暂时没有车辆信息..");
			return allCarInfoPO;
		}
		
		System.out.println("服务器中的所有车辆信息：");
		for(int i = 0; i < allCarInfoPO.size(); i++) {
			CarInfoPO po = allCarInfoPO.get(i);
			System.out.println(po.getCarNumber() + " " + po.getPlateNumber());
		}
		return allCarInfoPO;
	}

}
