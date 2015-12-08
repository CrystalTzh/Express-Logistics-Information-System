package clienthelper.inventoryInfoclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.URL;
import businesslogic.inventorybl.LocationNode;
import dataservice.corporationdataservice.DriverInfoCorporationdataService;
import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import state.NodeState;
import state.Zone;

public class InventoryInfoClientHelper {

	public InventoryInfoClientHelper(){
		URL url = new URL();
		ArrayList<LocationNode> locationNode = new ArrayList<LocationNode>();
		InventoryInfoPO po = new InventoryInfoPO();
		
		Zone zone = Zone.CAR;
		int line = 1;
		int shelf = 2;
		int tag = 3;
		long ID = 1234567890;
		NodeState state = NodeState.VACANT;
		LocationNode locationnode = new LocationNode(zone,line,shelf,tag,ID,state);
		locationNode.add(locationnode);
		
		double limit = po.getLimit();
		Zone emptyZone = po.getEmptyZone();
		try {
			InventoryInfoPO ipo = new InventoryInfoPO(locationNode, limit, emptyZone);
			InventoryInfoInventorydataService iinfo = (InventoryInfoInventorydataService)
						Naming.lookup("rmi://127.0.0.1:"+url.getPort()+"/"+url.getInventoryInfoService());
			iinfo.find();
			iinfo.update(ipo);
			
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
