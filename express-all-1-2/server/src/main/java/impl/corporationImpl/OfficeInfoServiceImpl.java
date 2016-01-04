/**
 * @author 谭琼
 * 2015年12月14日
 */
package impl.corporationImpl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import dataservice.corporationdataservice.OfficeCorporationdataService;
import iohelper.IOHelper;
import po.OfficePO;
import state.City;
import state.InitRelatedFiles;

/**
 * 营业厅数据层实现
 */
public class OfficeInfoServiceImpl extends UnicastRemoteObject implements OfficeCorporationdataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allOffice;
//	File file = new File("营业厅基本信息.txt");
	File file = new File(InitRelatedFiles.OFFICEINFO.toString());
	IOHelper ioHelper;
	
	/**
	 * @throws RemoteException
	 */
	public OfficeInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#findAll()
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<OfficePO> findAll(City city) throws RemoteException {
		System.out.println("进入OfficeInfoServiceImpl...server findAll...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		 ArrayList<OfficePO> allPOs = new  ArrayList<OfficePO>();
		 for(Iterator itr = allOffice.keySet().iterator(); itr.hasNext(); ) {
			 String key = (String) itr.next();
			 if(key.length() > 3) {
				 OfficePO po = (OfficePO) allOffice.get(key);
				 if(po.getCity() == city) {//找对应城市的所有营业厅
					 allPOs.add((OfficePO) allOffice.get(key));
				 }
			 }
		 }
		 if(allPOs.size() == 0) {
			 System.out.println("服务器中暂时没有" + city.toString() + "的营业厅信息");
			 return allPOs;
		 }
		 System.out.println("服务器中" + city.toString() + "的所有营业厅：");
		 for(int i = 0; i < allPOs.size(); i++) {
			 OfficePO po = allPOs.get(i);
			 System.out.println(po.getOfficeID() + " " + po.getCity().toString());
		 }
		return allPOs;
	}
	
	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#find(java.lang.String)
	 */
	public OfficePO find(String officeID) throws RemoteException {
		System.out.println("进入OfficeInfoImpl...server finding...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		if(allOffice.containsKey(officeID)) {
			OfficePO po = (OfficePO) allOffice.get(officeID);
			System.out.println("Have found: " + po.getOfficeID() + " " + po.getCity().toString());
			System.out.println("Find OfficePO Done!!");
			return po;
		}
		System.out.println("Unable to find!!");
		return null;
	}


	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#add(po.OfficePO)
	 */
	@SuppressWarnings("unchecked")
	public void add(OfficePO po) throws RemoteException {
		System.out.println("进入OfficeInfoImpl...server adding...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		allOffice.put(po.getOfficeID(), po);
		System.out.println("To be added: " + po.getOfficeID() + " " + po.getCity().toString());
		ioHelper.writeToFile(allOffice, file);
//		OfficePO.add(); 
		System.out.println("Add OfficePO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#update(java.lang.String)
	 */
	@SuppressWarnings("unchecked")
	public void update(OfficePO po) throws RemoteException {
		System.out.println("进入OfficeInfoImpl...server updating...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		allOffice.put(po.getOfficeID(), po);
		System.out.println("To be updated: " + po.getOfficeID() + " " + po.getCity().toString());
		ioHelper.writeToFile(allOffice, file);
		System.out.println("Update OfficePO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#delete(java.lang.String)
	 */
	public void delete(OfficePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入OfficeInfoImpl...server deleting...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " +po.getOfficeID() + " " + po.getCity().toString());
		allOffice.remove(po.getOfficeID());
		ioHelper.writeToFile(allOffice, file);
//		OfficePO.delete();//营业厅数量减去1
		System.out.println("Delete OfficePO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.OfficeCorporationdataService#getNextOfficeID()
	 */
	@SuppressWarnings("unchecked")
	public String getNextOfficeID(City city) throws RemoteException {
		System.out.println("进入OfficeInfoImpl...server getNextOfficeID...");
		ioHelper = new IOHelper();
		allOffice = ioHelper.readFromFile(file);
		//在营业厅信息中存"城市编号"对应的上次创建的营业厅的编号
		
		if(!allOffice.containsKey(city.toNum())) {//还没有此城市的营业厅创建
			//创建此城市的第一个营业厅编号
			String officeID = city.toNum() + "000";
			//存回去.并作为返回值返回
			allOffice.put(city.toNum(), officeID);
			ioHelper.writeToFile(allOffice, file);
			return officeID;
		} else {//已有营业厅创建
			//取后三位，加1
			String lastOfficeID = (String) allOffice.get(city.toNum());
			System.out.println("从硬盘中找到的上一个营业厅编号：" + lastOfficeID);
			String number = lastOfficeID.substring(lastOfficeID.length()-3, lastOfficeID.length());
			int num = Integer.parseInt(number);
			++num;
			String newNumber = String.valueOf(num);
			if(newNumber.length() < 3) {
				for(int i = newNumber.length(); i < 3; i++) {
					newNumber = '0' + newNumber;
				}
			}
			//存回去.并作为返回值返回
			String newOfficeID = city.toNum() + newNumber;
			allOffice.put(city.toNum(), newOfficeID);
			ioHelper.writeToFile(allOffice, file);
			return newOfficeID;
		}
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			OfficeInfoServiceImpl officeInfoServiceImpl = new OfficeInfoServiceImpl();
//			String next = officeInfoServiceImpl.getNextOfficeID(City.BEIJING);
//			OfficePO po = new OfficePO(City.BEIJING, BeiJingDistrict.ChangPing);
//			po.setOfficeID(next);
//			officeInfoServiceImpl.add(po);
			
//			System.out.println("下一个编号为：" + next);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
