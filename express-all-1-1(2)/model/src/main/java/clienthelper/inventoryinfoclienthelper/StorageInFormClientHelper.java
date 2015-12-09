package clienthelper.inventoryinfoclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;
import dataservice.inventorydataservice.StorageInFormInventorydataService;
import po.StorageInFormPO;
import state.FormState;
import state.Zone;

public class StorageInFormClientHelper {

	public StorageInFormClientHelper(){
		URL url = new URL();
		String NO = "001";
		String date = "2015.11.23";
		String expressNumber = "0012345876";
		String destination = "南京";
		Zone zone = Zone.CAR;
		int line = 1;
		int shelf = 1;
		int tag = 2;
		FormState formstate = FormState.DRAFT;
		try {
			StorageInFormPO po = new StorageInFormPO();
			StorageInFormInventorydataService sis = (StorageInFormInventorydataService)
						Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getStorageInFormService());
			sis.insert(po);
			sis.delete(po);
			sis.update(po);
			sis.find(NO);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			System.out.println("URL格式异常！");
			e.printStackTrace();
		} catch (RemoteException e) {
			System.out.println("创建对象异常！");
			// TODO: handle exception
			e.printStackTrace();
		} catch (NotBoundException e) {
			System.out.println("对象未绑定！");
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
