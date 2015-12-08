package ClientHelper.CorporationClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.corporationdataservice.CarInfoCorporationdataService;
import po.CarInfoPO;
import vo.CarInfoVO;

public class CarInfoClientHelper {
	CarInfoCorporationdataService carInfoCorporationdataService = null;

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

	public CarInfoCorporationdataService go() {
		System.out.println("进入CarInfoClientHelper...go...");
		if(carInfoCorporationdataService == null) {
			try {
				carInfoCorporationdataService = (CarInfoCorporationdataService)Naming
						.lookup("rmi://127.0.0.1:32010/carInfoCorporationdataService");
				System.out.println("carInfoCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			}
		}
		return carInfoCorporationdataService;
	}
}
