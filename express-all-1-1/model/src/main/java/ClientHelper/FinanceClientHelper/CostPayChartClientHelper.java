package ClientHelper.FinanceClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;

import dataservice.financedataservice.CostPayChartdataService;
import po.CostpayChartPO;


public class CostPayChartClientHelper {
	public CostPayChartClientHelper(){
		URL url=new URL();
		CostpayChartPO po=new CostpayChartPO(0, 0, 0, null);
		try {
			CostPayChartdataService cinfo=(CostPayChartdataService)
					Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getCostPayChartService());
			cinfo.delete(po);
			cinfo.find(1000);
			cinfo.insert(po);
			cinfo.update(po);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
