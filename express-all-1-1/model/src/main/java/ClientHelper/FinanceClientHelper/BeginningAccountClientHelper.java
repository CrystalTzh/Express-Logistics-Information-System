package ClientHelper.FinanceClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;
import dataservice.financedataservice.BeginningAccountdataService;
import po.BeginningAccountPO;

public class BeginningAccountClientHelper {
	public BeginningAccountClientHelper(){
		URL url=new URL();
//		BeginningAccountPO po=new BeginningAccountPO(0, null, null, null, null);
//		try {
//			BeginningAccountdataService binfo=(BeginningAccountdataService)
//					Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getBeginningAccountService());
//			binfo.delete(po);
//			binfo.find(2015);
//			binfo.insert(po);
//			binfo.update(po);
//		
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (NotBoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
