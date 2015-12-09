package clienthelper.financeclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;
import dataservice.financedataservice.CostPayChartdataService;
import po.CostpayChartPO;



public class CostPayChartClientHelper {
	CostPayChartdataService paymentFormdataService=null;
	public CostpayChartPO goFind(String NO) {
		System.out.println("进入CostPayChartClientHelper...client wants to finds Form...");
		paymentFormdataService = go();
		CostpayChartPO po;
		try {
			po = paymentFormdataService.find(NO);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean goInsert(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to insert Form ...");
		paymentFormdataService = go();
		try {
			paymentFormdataService.insert(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goDelete(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to delete Form...");
		paymentFormdataService = go();
		try {
			paymentFormdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean goUpdate(CostpayChartPO po) {
		System.out.println("进入PaymentFormClientHelper...client wants to update Car...");
		paymentFormdataService= go();
		try {
			paymentFormdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public CostPayChartdataService go() {
		System.out.println("进入ReceiptFormClientHelper...go...");
		if(paymentFormdataService == null) {
			try {
				paymentFormdataService = (CostPayChartdataService)Naming
						.lookup("rmi://127.0.0.1:32010/paymentFormdataService");
				System.out.println("paymentFormdataService RMI服务查找成功...");
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
		return paymentFormdataService;
	}
}
