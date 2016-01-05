package clienthelper.transitclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import po.OfficeArrivalFormPO;

public class OfficeArrivalFormClientHelper {
	
	OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = null;
	
	public OfficeArrivalFormPO goFind(String NO) {
		System.out.println("进入OfficeArrivalFormClientHelper...client wants to finds Form...");
		officeArrivalFormTransitdataService = go();
		OfficeArrivalFormPO po;
		try {
			po = officeArrivalFormTransitdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(OfficeArrivalFormPO po) {
		System.out.println("进入OfficeArrivalFormClientHelper...client wants to insert Form ...");
		officeArrivalFormTransitdataService = go();
		try {
			officeArrivalFormTransitdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(OfficeArrivalFormPO po) {
		System.out.println("进入OfficeArrivalFormClientHelper...client wants to delete Form...");
		officeArrivalFormTransitdataService = go();
		try {
			officeArrivalFormTransitdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(OfficeArrivalFormPO po ) {
		System.out.println("进入OfficeArrivalFormClientHelper...client wants to update Car...");
		officeArrivalFormTransitdataService= go();
		try {
			officeArrivalFormTransitdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public OfficeArrivalFormTransitdataService go() {
		System.out.println("进入OfficeArrivalFormClientHelper...go...");
		if(officeArrivalFormTransitdataService == null) {
			try {
//				officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/officeArrivalFormTransitdataService");
				officeArrivalFormTransitdataService = (OfficeArrivalFormTransitdataService)Naming
						.lookup(URL.getURL(ServiceName.OFFICEARRIVALFORM.toString()));
				System.out.println("officeArrivalFormTransitdataService RMI服务查找成功...");
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
		return officeArrivalFormTransitdataService;
	}
	
	public ArrayList<OfficeArrivalFormPO> goFindAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormClientHelper...client wants to find allform...");
		officeArrivalFormTransitdataService= go();
		try {
			return officeArrivalFormTransitdataService.findAll();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
}
