/**
 * @author 谭琼
 * 2015年12月9日
 */
package impl.inventoryImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.inventorydataservice.InventoryInfoInventorydataService;
import iohelper.IOHelper;
import po.InventoryInfoPO;

/**
 * 设置库存警戒值数据层实现
 */
public class InventoryInfoServiceImpl extends UnicastRemoteObject implements InventoryInfoInventorydataService{

	private static final long serialVersionUID = 1L;

	/**
	 * @throws RemoteException
	 */
	public InventoryInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allInventoryInfo = new Hashtable();
	File file = new File("仓库库存信息.txt");;
	IOHelper ioHelper;
	
	@SuppressWarnings("unchecked")
	public void init() {
		System.out.println("进入InventoryInfoServiceImpl...server initing...");
		ioHelper = new IOHelper();
		allInventoryInfo = ioHelper.readFromFile(file);
		InventoryInfoPO po = new InventoryInfoPO();
		System.out.println("Limit: " + po.getLimit());
		
		allInventoryInfo.put(po.getInventoryID(), po);
		ioHelper.writeToFile(allInventoryInfo, file);
		System.out.println("Init 01 Inventory Done!");
	}
	
	/* (non-Javadoc)
	 * @see dataservice.inventorydataservice.InventoryInfoInventorydataService#findInventoryInfo(java.lang.String)
	 */
	public InventoryInfoPO findInventoryInfo(String inventoryID) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入InventoryInfoServiceImpl...server findInventoryInfo...");
		ioHelper = new IOHelper();
		allInventoryInfo = ioHelper.readFromFile(file);
		InventoryInfoPO po = (InventoryInfoPO)allInventoryInfo.get(inventoryID);
		System.out.println("server findInventoryInfo done!");
		return po;
	}

	/* (non-Javadoc)
	 * @see dataservice.inventorydataservice.InventoryInfoInventorydataService#updateInventoryInfo(po.InventoryInfoPO)
	 */
	@SuppressWarnings("unchecked")
	public void updateInventoryInfo(InventoryInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入InventoryInfoServiceImpl...server updateInventoryInfo...");
		ioHelper = new IOHelper();
		allInventoryInfo = ioHelper.readFromFile(file);
		allInventoryInfo.put(po.getInventoryID(), po);
		System.out.println("To be updated: ");
		System.out.println(po.getInventoryID() + " " + po.getLimit() + " " + po.getEmptyZone().toString());
		ioHelper.writeToFile(allInventoryInfo, file);
		System.out.println("server updateInventoryInfo done!");
	}

	/* (non-Javadoc)
	 * @see dataservice.inventorydataservice.InventoryInfoInventorydataService#addInventoryInfo(po.InventoryInfoPO)
	 */
	@SuppressWarnings("unchecked")
	public void addInventoryInfo(InventoryInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入InventoryInfoServiceImpl...server addInventoryInfo...");
		ioHelper = new IOHelper();
		allInventoryInfo = ioHelper.readFromFile(file);
		allInventoryInfo.put(po.getInventoryID(), po);
		System.out.println(po.getInventoryID() + " " + po.getLimit() + " " + po.getEmptyZone().toString());
		ioHelper.writeToFile(allInventoryInfo, file);
		System.out.println("server addInventoryInfo done!");
	}

	/* (non-Javadoc)
	 * @see dataservice.inventorydataservice.InventoryInfoInventorydataService#deleteInventoryInfo(po.InventoryInfoPO)
	 */
	public void deleteInventoryInfo(InventoryInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入InventoryInfoServiceImpl...server deleteInventoryInfo...");
		ioHelper = new IOHelper();
		allInventoryInfo = ioHelper.readFromFile(file);
		allInventoryInfo.remove(po.getInventoryID());
		ioHelper.writeToFile(allInventoryInfo, file);
		System.out.println("server deleteInventoryInfo done!");
	}

	public static void main(String[] args) {
		try {
			InventoryInfoServiceImpl impl = new InventoryInfoServiceImpl();
			impl.addInventoryInfo(new InventoryInfoPO("0200"));
//			impl.init();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
