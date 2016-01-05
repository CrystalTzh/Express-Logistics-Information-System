package clienthelper.financeclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.financedataservice.ProfitChartdataService;
import po.ProfitChartPO;

public class ProfitChartClientHelper {
	ProfitChartdataService profitChartdataService=null;
	public ProfitChartPO goFind(String NO) throws RemoteException {
		System.out.println("进入ProfitChartClientHelper...client wants to finds Form...");
		profitChartdataService = go();
		ProfitChartPO po;
		po = profitChartdataService.find(NO);
		return po;
		
	}
	
	
	public ProfitChartdataService go() {
		System.out.println("进入profitchartClientHelper...go...");
		if(profitChartdataService == null) {
			try {
//				profitChartdataService = (ProfitChartdataService)Naming
//				.lookup("rmi://127.0.0.1:32444/profitChartdataService");
		profitChartdataService = (ProfitChartdataService)Naming
				.lookup(URL.getURL(ServiceName.PROFITCHART.toString()));

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
		return profitChartdataService;
	}
}
