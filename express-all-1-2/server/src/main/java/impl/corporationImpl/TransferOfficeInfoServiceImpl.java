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

import dataservice.corporationdataservice.TransferOfficeCorporationdataService;
import iohelper.IOHelper;
import po.TransferOfficePO;
import state.City;
import state.InitRelatedFiles;

/**
 * 中转中心数据层实现
 */
public class TransferOfficeInfoServiceImpl extends UnicastRemoteObject implements TransferOfficeCorporationdataService{

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable allTranferOffice;
//	File file = new File("中转中心基本信息.txt");
	File file = new File(InitRelatedFiles.TRANSFEROFFICEINFO.toString());
	IOHelper ioHelper;
	
	/**
	 * @throws RemoteException
	 */
	public TransferOfficeInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#findAll(state.City)
	 */
	@SuppressWarnings("rawtypes")
	public ArrayList<TransferOfficePO> findAll(City city) throws RemoteException {
		System.out.println("进入OfficeInfoServiceImpl...server findAll...");
		ioHelper = new IOHelper();
		allTranferOffice = ioHelper.readFromFile(file);
		 ArrayList<TransferOfficePO> allPOs = new  ArrayList<TransferOfficePO>();
		 for(Iterator itr = allTranferOffice.keySet().iterator(); itr.hasNext(); ) {
			 String key = (String) itr.next();
			 if(key.length() > 3) {
				 TransferOfficePO po = (TransferOfficePO) allTranferOffice.get(key);
				 if(po.getCity() == city) {//找对应城市的所有营业厅
					 allPOs.add((TransferOfficePO) allTranferOffice.get(key));
				 }
			 }
		 }
		 if(allPOs.size() == 0) {
			 System.out.println("服务器中暂时没有营业厅信息");
			 return allPOs;
		 }
		 System.out.println("服务器中的所有营业厅：");
		 for(int i = 0; i < allPOs.size(); i++) {
			 TransferOfficePO po = allPOs.get(i);
			 System.out.println(po.getTransferOfficeID() + " " + po.getCity().toString());
		 }
		return allPOs;
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#find(java.lang.String)
	 */
	public TransferOfficePO find(String transferOfficeID) throws RemoteException {
		System.out.println("进入BankAccountImpl...server finding...");
		ioHelper = new IOHelper();
		allTranferOffice = ioHelper.readFromFile(file);
		if(allTranferOffice.containsKey(transferOfficeID)) {
			TransferOfficePO po = (TransferOfficePO) allTranferOffice.get(transferOfficeID);
			System.out.println("Have found: " + po.getTransferOfficeID() + " " + po.getCity());
			System.out.println("Find TransferOfficePO Done!!");
			return po;
		}
		System.out.println("Unable to find!!");
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#update(po.TransferOfficePO)
	 */
	public void update(TransferOfficePO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入TransferOfficeInfoImpl...server updating...");
		add(po);
		System.out.println("Update TransferOfficePO Done!!");
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#add(po.TransferOfficePO)
	 */
	@SuppressWarnings("unchecked")
	public void add(TransferOfficePO po) throws RemoteException {
		System.out.println("进入TransferOfficeInfoImpl...server adding...");
		ioHelper = new IOHelper();
		allTranferOffice = ioHelper.readFromFile(file);
		allTranferOffice.put(po.getTransferOfficeID(), po);
		System.out.println("To be added: " + po.getTransferOfficeID() + " " + po.getCity().toString());
		ioHelper.writeToFile(allTranferOffice, file);
		System.out.println("Add TransferOfficePO Done!!");
		
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#delete(po.TransferOfficePO)
	 */
	public void delete(TransferOfficePO po) throws RemoteException {
		System.out.println("进入TransferOfficeInfoImpl...server deleting...");
		ioHelper = new IOHelper();
		allTranferOffice = ioHelper.readFromFile(file);
		System.out.println("To be deleted: " + po.getTransferOfficeID() + " " + po.getCity().toString());
		allTranferOffice.remove(po.getTransferOfficeID());
		ioHelper.writeToFile(allTranferOffice, file);
		System.out.println("Delete TransferOfficePO Done!!");
		
	}

	/* (non-Javadoc)
	 * @see dataservice.corporationdataservice.TransferOfficeCorporationdataService#getNextTransferOfficeID(state.City)
	 */
	@SuppressWarnings("unchecked")
	public String getNextTransferOfficeID(City city) throws RemoteException {
		System.out.println("进入TransferOfficeInfoImpl...server getNextTransferOfficeID...");
		ioHelper = new IOHelper();
		allTranferOffice = ioHelper.readFromFile(file);
		//在中转中心信息中存"城市编号"对应的上次创建的中转中心的编号
		if(!allTranferOffice.containsKey(city.toNum())) {//还没有此城市的中转中心创建
			//创建此城市的第一个中转中心编号
			String tansferOfficeID = city.toNum() + "0";
			//存回去.并作为返回值返回
			allTranferOffice.put(city.toNum(), tansferOfficeID);
			ioHelper.writeToFile(allTranferOffice, file);
			return tansferOfficeID;
		} else {//已有中转中心创建
			//取最后一位，加1
			String lastTransferOfficeID = (String) allTranferOffice.get(city.toNum());
			System.out.println("从硬盘中找到的上一个中转中心编号：" + lastTransferOfficeID);
			String number = lastTransferOfficeID.substring(lastTransferOfficeID.length()-1);
			int num = Integer.parseInt(number);
			++num;
			//存回去，并作为返回值返回
			String newTransferOfficeID = city.toNum() + num;
			allTranferOffice.put(city.toNum(), newTransferOfficeID);
			ioHelper.writeToFile(allTranferOffice, file);
			return newTransferOfficeID;
		}
	}
	
	public static void main(String[] args) {
		try {
			TransferOfficeInfoServiceImpl transferOfficeInfoServiceImpl = new TransferOfficeInfoServiceImpl();
			transferOfficeInfoServiceImpl.findAll(City.BEIJING);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
