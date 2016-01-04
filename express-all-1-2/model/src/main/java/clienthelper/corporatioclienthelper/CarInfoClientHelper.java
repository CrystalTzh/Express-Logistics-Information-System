package clienthelper.corporatioclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.corporationdataservice.CarInfoCorporationdataService;
import po.CarInfoPO;
/**
 * 在客户端，车辆信息建立RMI连接
 */
public class CarInfoClientHelper {
	
	CarInfoCorporationdataService carInfoCorporationdataService = null;

	/**
	 * 远程查找所有车辆信息
	 * @return
	 */
	public ArrayList<CarInfoPO> findAll() {
		System.out.println("进入CarInfoClientHelper...client wants to findAll Car...");
		carInfoCorporationdataService = go();
		try {
			ArrayList<CarInfoPO> allCars = carInfoCorporationdataService.findAll();
			return allCars;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程更新车辆信息
	 * @param po 待更新的车辆信息PO对象
	 * @return
	 */
	public boolean goUpdate(CarInfoPO po) {
		System.out.println("进入CarInfoClientHelper...client wants to update Car...");
		carInfoCorporationdataService = go();
		try {
			carInfoCorporationdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程删除车辆信息
	 * @param po 待删除的车辆信息PO对象
	 * @return
	 */
	public boolean goDelete(CarInfoPO po) {
		System.out.println("进入CarInfoClientHelper...client wants to delete Car...");
		carInfoCorporationdataService = go();
		try {
			carInfoCorporationdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程添加车辆信息
	 * @param po 待添加的车辆信息
	 * @return
	 */
	public boolean goInsert(CarInfoPO po) {
		System.out.println("进入CarInfoClientHelper...client wants to insert Car...");
		carInfoCorporationdataService = go();
		try {
			carInfoCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程查找车辆信息
	 * @param carNumber 车辆代号
	 * @return
	 */
	public CarInfoPO goFind(String carNumber) {
		System.out.println("进入CarInfoClientHelper...client wants to finds Car...");
		carInfoCorporationdataService = go();
		CarInfoPO po;
		try {
			po = carInfoCorporationdataService.find(carNumber);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 建立RMI连接
	 * @return
	 */
	public CarInfoCorporationdataService go() {
		System.out.println("进入CarInfoClientHelper...go...");
		if(carInfoCorporationdataService == null) {
			try {
//				carInfoCorporationdataService = (CarInfoCorporationdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/carInfoCorporationdataService");
				carInfoCorporationdataService = (CarInfoCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.CARINFO.toString()));
				System.out.println("carInfoCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			}
		}
		return carInfoCorporationdataService;
	}
}
