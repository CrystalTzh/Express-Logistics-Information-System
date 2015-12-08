/**
 * 常量信息模块数据层实现
 * @author 谭琼
 * 2015年12月8日
 */
package impl.constImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Hashtable;

import dataservice.constdataservice.PriceInfoConstdataService;
import ioHelper.IOHelper;
import po.PricePO;
import state.ConstType;

/**
 * 常量信息数据层实现 
 */
public class PriceInfoServiceImpl extends UnicastRemoteObject implements PriceInfoConstdataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allConstInfo = new Hashtable();
	File file = new File("公司常量基本信息.txt");
	IOHelper ioHelper;

	/**
	 * @throws RemoteException
	 */
	public PriceInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.PriceInfoConstdataService#init()
	 */
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入PriceInfoServiceImpl...server initing...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		PricePO po = new PricePO();
		po.setPrice(2);
		
		System.out.println("To be added: ");
		System.out.println("距离价格常量: " + po.getPrice());
		
		allConstInfo.put(ConstType.PRICE, po);
		ioHelper.writeToFile(allConstInfo, file);
		System.out.println("Init PriceInfo Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.PriceInfoConstdataService#update(po.PricePO)
	 */
	public void update(PricePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入PriceInfoServiceImpl...server updating...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		
		allConstInfo.put(ConstType.PRICE, po);
		
		System.out.println("To be updated: ");
		System.out.println("距离价格常量: " + po.getPrice());
		
		ioHelper.writeToFile(allConstInfo, file);
		System.out.println("Update Price Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.PriceInfoConstdataService#find()
	 */
	public PricePO find() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入PriceInfoServiceImpl...server finding...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		PricePO po = (PricePO) allConstInfo.get(ConstType.PRICE);
		
		System.out.println("Have found: ");
		System.out.println("距离价格常量: " + po.getPrice());
		
		return po;
	}
	
	public static void main(String[] args) {
		try {
			PriceInfoServiceImpl priceInfoServiceImpl = new PriceInfoServiceImpl();
//			priceInfoServiceImpl.init();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
