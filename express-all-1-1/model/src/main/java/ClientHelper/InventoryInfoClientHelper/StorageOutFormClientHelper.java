package ClientHelper.InventoryInfoClientHelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.URL;
import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import po.StorageOutFormPO;
import state.Transport;

public class StorageOutFormClientHelper {
	public StorageOutFormClientHelper(){
		URL url = new URL();
		String NO = "001";//出库单编号
		String date = "2015.11.23";//出库日期
		String expressNumber = "0012345678";//快递订单号
		String destination = "南京";//目的地
		Transport transport = Transport.CAR;//转运形式
		
		try {
			StorageOutFormPO po = new StorageOutFormPO(NO, date, expressNumber, 
					destination, transport);
			StorageOutFromInventorydataService sis = (StorageOutFromInventorydataService)
						Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getStorageOutFormService());
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
