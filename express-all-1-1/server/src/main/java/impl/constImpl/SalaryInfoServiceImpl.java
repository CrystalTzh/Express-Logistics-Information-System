/**
 * 常量信息模块数据层实现
 * @author 谭琼
 * 2015年12月6日
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

import dataservice.constdataservice.SalaryInfoConstdataService;
import ioHelper.IOHelper;
import po.SalaryPO;
import state.ConstType;

/**
 * 薪资标准信息数据层实现 
 */
public class SalaryInfoServiceImpl extends UnicastRemoteObject implements SalaryInfoConstdataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	Hashtable allConstInfo = new Hashtable();
	File file = new File("公司常量基本信息.txt");
	IOHelper ioHelper;
	
	public SalaryInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#init()
	 */
	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入SalaryInfoServiceImpl...server initing...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		SalaryPO po = new SalaryPO();
		po.setReceiveOrderBonus("1.0");
		po.setSendOrderBonus("0.5");
		po.setDriverInCityPay("50");
		po.setDriverOutCityPay("200");
		po.setOfficeManSalary("3000");
		
		System.out.println("To be updated: ");
		System.out.println("快递员揽件提成 " + po.getReceiveOrderBonus());
		System.out.println("快递员派件提成" + po.getSendOrderBonus());
		System.out.println("司机市内计次" + po.getDriverInCityPay());
		System.out.println("司机跨市计次" + po.getDriverOutCityPay());
		System.out.println("业务员月薪" + po.getOfficeManSalary());
		
		allConstInfo.put(ConstType.SALARY, po);
		ioHelper.writeToFile(allConstInfo, file);
		System.out.println("Init SalaryInfo Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#update(po.ConstPO)
	 */
	public void update(SalaryPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入SalaryInfoServiceImpl...server updating...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		
		allConstInfo.put(ConstType.SALARY, po);
		
		System.out.println("To be added: ");
		System.out.println("快递员揽件提成: " + po.getReceiveOrderBonus());
		System.out.println("快递员派件提成: " + po.getSendOrderBonus());
		System.out.println("司机市内计次: " + po.getDriverInCityPay());
		System.out.println("司机跨市计次: " + po.getDriverOutCityPay());
		System.out.println("业务员月薪: " + po.getOfficeManSalary());
		
		ioHelper.writeToFile(allConstInfo, file);
		System.out.println("Update salary Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.constdataservice.ConstdataService#find(boolean)
	 */
	public SalaryPO find() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入SalaryInfoServiceImpl...server finding...");
		ioHelper = new IOHelper();
		allConstInfo = ioHelper.readFromFile(file);
		SalaryPO po = (SalaryPO)allConstInfo.get(ConstType.SALARY);
		
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
			SalaryInfoServiceImpl salaryInfoServiceImpl = new SalaryInfoServiceImpl();
//			salaryInfoServiceImpl.init();
			salaryInfoServiceImpl.find();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
