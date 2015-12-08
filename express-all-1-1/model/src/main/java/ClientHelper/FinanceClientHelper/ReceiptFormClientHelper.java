package ClientHelper.FinanceClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;

import dataservice.financedataservice.ReceiptFormdataService;
import po.ReceiptFormPO;


public class ReceiptFormClientHelper {
	public ReceiptFormClientHelper(){
	URL url=new URL();
	ReceiptFormPO po=new ReceiptFormPO(null, 0, null, null, 0);
	
		try {
			ReceiptFormdataService rinfo=(ReceiptFormdataService)
					Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getReceiptFormService());
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
