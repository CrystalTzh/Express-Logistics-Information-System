package clienthelper.financeclientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;

import dataservice.financedataservice.ProfitChartdataService;
import po.ProfitChartPO;

public class ProfitChartClientHelper {
	public ProfitChartClientHelper(){
		URL url=new URL();
		ProfitChartPO po=new ProfitChartPO(null, null, 0);
		try {
			ProfitChartdataService pinfo=(ProfitChartdataService)
					Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getProfitChartService());
			pinfo.update(po);
			pinfo.create(po);
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
