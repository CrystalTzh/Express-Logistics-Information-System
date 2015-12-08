package clienthelper.financeclientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;

import dataservice.financedataservice.PaymentFormdataService;
import po.PaymentFormPO;

public class PaymentFormClientHelper {
	public PaymentFormClientHelper(){
		URL url=new URL();
		PaymentFormPO po=new PaymentFormPO(null, 0, null, 0, null);
		try {
			PaymentFormdataService pinfo=(PaymentFormdataService)
					Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getPaymentFormService());
			pinfo.delete(po);
			pinfo.find(111111);
			pinfo.insert(po);
			pinfo.update(po);
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
