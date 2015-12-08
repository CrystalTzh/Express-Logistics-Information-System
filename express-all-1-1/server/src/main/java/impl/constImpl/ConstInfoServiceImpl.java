/**
 * 常量信息模块数据层实现
 * @author 谭琼
 * 2015年12月46日
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

import dataservice.constdataservice.SalarydataService;
import ioHelper.IOHelper;
import po.SalaryPO;

/**
 * 常量信息数据层实现 
 */
public class ConstInfoServiceImpl extends UnicastRemoteObject implements SalarydataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allSalaryInfo = new Hashtable();
	File file = new File("公司常量基本信息.txt");
	IOHelper ioHelper;
	
	public ConstInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#init()
	 */
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入ConstInfoServiceImpl...server initing...");
		ioHelper = new IOHelper();
		allSalaryInfo = ioHelper.readFromFile(file);
		SalaryPO po = new SalaryPO();
		po.setReceiveOrderBonus("1.0");
		po.setSendOrderBonus("0.5");
		po.setDriverInCityPay("50");
		po.setDriverOutCityPay("200");
		po.setOfficeManSalary("3000");
		
		System.out.println("To be added: ");
		System.out.println("快递员揽件提成 " + po.getReceiveOrderBonus());
		System.out.println("快递员派件提成" + po.getSendOrderBonus());
		System.out.println("司机市内计次" + po.getDriverInCityPay());
		System.out.println("司机跨市计次" + po.getDriverOutCityPay());
		System.out.println("业务员月薪" + po.getOfficeManSalary());
		
		allSalaryInfo.put("salary", po);
		ioHelper.writeToFile(allSalaryInfo, file);
		System.out.println("Init allSalaryInfo Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#update(po.ConstPO)
	 */
	public void update(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入ConstInfoServiceImpl...server updating...");
		ioHelper = new IOHelper();
		allSalaryInfo = ioHelper.readFromFile(file);
		
		allSalaryInfo.put("salary", po);
		
		System.out.println("To be added: ");
		System.out.println("快递员揽件提成: " + po.getReceiveOrderBonus());
		System.out.println("快递员派件提成: " + po.getSendOrderBonus());
		System.out.println("司机市内计次: " + po.getDriverInCityPay());
		System.out.println("司机跨市计次: " + po.getDriverOutCityPay());
		System.out.println("业务员月薪: " + po.getOfficeManSalary());
		
		ioHelper.writeToFile(allSalaryInfo, file);
		System.out.println("Update salary Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#find(boolean)
	 */
	public SalaryPO find() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入ConstInfoServiceImpl...server updating...");
		ioHelper = new IOHelper();
		allSalaryInfo = ioHelper.readFromFile(file);
		SalaryPO po = (SalaryPO)allSalaryInfo.get("salary");
		
		System.out.println("Have found: " );
		System.out.println("快递员揽件提成: " + po.getReceiveOrderBonus());
		System.out.println("快递员派件提成: " + po.getSendOrderBonus());
		System.out.println("司机市内计次: " + po.getDriverInCityPay());
		System.out.println("司机跨市计次: " + po.getDriverOutCityPay());
		System.out.println("业务员月薪: " + po.getOfficeManSalary());
		
		return po;
	}
	
	public static void main(String[] args) {
		try {
			ConstInfoServiceImpl constInfoServiceImpl = new ConstInfoServiceImpl();
//			constInfoServiceImpl.init();
			constInfoServiceImpl.find();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
