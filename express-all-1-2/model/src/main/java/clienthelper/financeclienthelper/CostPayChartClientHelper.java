package clienthelper.financeclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.financedataservice.CostPayChartdataService;
import po.CostpayChartPO;



public class CostPayChartClientHelper {
	CostPayChartdataService costPayChartdataService=null;
	public CostpayChartPO goFind(String NO) {
		System.out.println("进入CostPayChartClientHelper...client wants to finds Form...");
		costPayChartdataService = go();
		CostpayChartPO po;
		try {
			po = costPayChartdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to insert Form ...");
		costPayChartdataService = go();
		try {
			costPayChartdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to delete Form...");
		costPayChartdataService = go();
		try {
			costPayChartdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to update Car...");
		costPayChartdataService= go();
		try {
			costPayChartdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public CostPayChartdataService go() {
		System.out.println("进入ReceiptFormClientHelper...go...");
		if(costPayChartdataService == null) {
			try {
//				costPayChartdataService = (CostPayChartdataService)Naming
//						.lookup("rmi://127.0.0.1:32222/costPayChartdataService");
				costPayChartdataService = (CostPayChartdataService)Naming
						.lookup(URL.getURL(ServiceName.COSTPAYCHART.toString()));
				System.out.println("costPayChartdataService RMI服务查找成功...");
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
		return costPayChartdataService;
	}
}
