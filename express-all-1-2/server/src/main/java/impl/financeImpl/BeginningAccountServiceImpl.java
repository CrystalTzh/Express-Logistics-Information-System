package impl.financeImpl;

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

import dataservice.financedataservice.BeginningAccountdataService;
import impl.corporationImpl.BankAccountImpl;
import impl.corporationImpl.CarInfoServiceImpl;
import impl.corporationImpl.DriverInfoServiceImpl;
import impl.corporationImpl.OfficeInfoServiceImpl;
import impl.corporationImpl.TransferOfficeInfoServiceImpl;
import impl.userImpl.UserAccountServiceImpl;
import iohelper.IOHelper;
import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import po.OfficePO;
import po.TransferOfficePO;
import po.UserAccountPO;
import state.City;
import state.InitRelatedFiles;
import state.UserRole;

public class BeginningAccountServiceImpl extends UnicastRemoteObject implements BeginningAccountdataService {

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	@SuppressWarnings("rawtypes")
	Hashtable beginningAccountInfo;
	File file = new File("期初建账信息.txt");
	IOHelper ioHelper;

	public BeginningAccountServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dataservice.financedataservice.BeginningAccountdataService#syncOffice()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void syncOffice() throws RemoteException {
		// 找到所有的营业厅信息
		OfficeInfoServiceImpl impl = new OfficeInfoServiceImpl();
		ArrayList<OfficePO> allBeijingOfficeList = impl.findAll(City.BEIJING);
		ArrayList<OfficePO> allGuangZhouOfficeList = impl.findAll(City.GUANGZHOU);
		ArrayList<OfficePO> allShangHaiOfficList = impl.findAll(City.SHANGHAI);
		ArrayList<OfficePO> allNanJingOfficeList = impl.findAll(City.NANJING);
		Hashtable<City, ArrayList<OfficePO>> allOfficeInfo = new Hashtable<City, ArrayList<OfficePO>>();
		allOfficeInfo.put(City.BEIJING, allBeijingOfficeList);
		allOfficeInfo.put(City.GUANGZHOU, allGuangZhouOfficeList);
		allOfficeInfo.put(City.SHANGHAI, allShangHaiOfficList);
		allOfficeInfo.put(City.NANJING, allNanJingOfficeList);

		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing office...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.OFFICEINFO.toString(), allOfficeInfo);
		ioHelper.writeToFile(beginningAccountInfo, file);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * syncTransferOffice()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void syncTransferOffice() throws RemoteException {
		// 找到所有的中转中心信息
		TransferOfficeInfoServiceImpl impl = new TransferOfficeInfoServiceImpl();
		ArrayList<TransferOfficePO> allBeijingTransferOfficeList = impl.findAll(City.BEIJING);
		ArrayList<TransferOfficePO> allGuangZhouTransferOfficeList = impl.findAll(City.GUANGZHOU);
		ArrayList<TransferOfficePO> allShangHaiTransferOfficList = impl.findAll(City.SHANGHAI);
		ArrayList<TransferOfficePO> allNanJingTransferOfficeList = impl.findAll(City.NANJING);
		Hashtable<City, ArrayList<TransferOfficePO>> allTransferOfficeInfo = new Hashtable<City, ArrayList<TransferOfficePO>>();
		allTransferOfficeInfo.put(City.BEIJING, allBeijingTransferOfficeList);
		allTransferOfficeInfo.put(City.GUANGZHOU, allGuangZhouTransferOfficeList);
		allTransferOfficeInfo.put(City.SHANGHAI, allShangHaiTransferOfficList);
		allTransferOfficeInfo.put(City.NANJING, allNanJingTransferOfficeList);

		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing transfer office...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.TRANSFEROFFICEINFO.toString(), allTransferOfficeInfo);
		ioHelper.writeToFile(beginningAccountInfo, file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dataservice.financedataservice.BeginningAccountdataService#syncInventory(
	 * )
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void syncInventory() throws RemoteException {
		// 找到所有的库存信息
		System.out.println("进入BeginningAccountServiceImpl...server syncInventory...");

		ioHelper = new IOHelper();
		Hashtable all = ioHelper.readFromFile(new File(InitRelatedFiles.INVENTOTYINFO.toString()));
		ArrayList<InventoryInfoPO> allInventoryList = new ArrayList<InventoryInfoPO>();
		for (Iterator itr = all.keySet().iterator(); itr.hasNext();) {
			String key = (String) itr.next();
			allInventoryList.add((InventoryInfoPO) all.get(key));
		}
		if (allInventoryList.size() == 0) {
			System.out.println("服务器中暂时没有库存信息..");
		} else {
			System.out.println("服务器中的所有库存信息：");
			for (int i = 0; i < allInventoryList.size(); i++) {
				InventoryInfoPO po = allInventoryList.get(i);
				System.out.println(po.getInventoryID() + " " + po.getLimit() + " " + po.getEmptyZone().toString());
			}
		}

		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing inventory...");
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.INVENTOTYINFO.toString(), allInventoryList);
		ioHelper.writeToFile(beginningAccountInfo, file);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dataservice.financedataservice.BeginningAccountdataService#syncDriver()
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void syncDriver() throws RemoteException {
		// 找到所有司机信息
		System.out.println("进入BeginningAccountServiceImpl...server syncDriver...");
		DriverInfoServiceImpl impl = new DriverInfoServiceImpl();
		ArrayList<DriverInfoPO> allDriverList = impl.findAll();

		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing car...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.DRIVERINFO.toString(), allDriverList);
		ioHelper.writeToFile(beginningAccountInfo, file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncCar()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void syncCar() throws RemoteException {
		// 找到所有的车辆信息
		System.out.println("进入BeginningAccountServiceImpl...server syncCar...");
		CarInfoServiceImpl impl = new CarInfoServiceImpl();
		ArrayList<CarInfoPO> allCarList = impl.findAll();

		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing car...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.CARINFO.toString(), allCarList);
		ioHelper.writeToFile(beginningAccountInfo, file);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * syncUserAccount()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void syncUserAccount() throws RemoteException {
		// 找到所有的用户账户
		System.out.println("进入BeginningAccountServiceImpl...server syncUserAccount...");

		UserAccountServiceImpl impl = new UserAccountServiceImpl();
		
		//找到所有快递员
		ArrayList<UserAccountPO> allExpressManList = impl.findAll(UserRole.EXPRESSMAN);
		//找到所有营业厅业务员
		ArrayList<UserAccountPO> allOfficeManList = impl.findAll(UserRole.OFFICEMAN);
		//找到所有中转中心业务员
		ArrayList<UserAccountPO> allTransferOfficeManList = impl.findAll(UserRole.TRANSITCENTERMAN);
		//找到所有仓库管理人员
		ArrayList<UserAccountPO> allInventoryManList = impl.findAll(UserRole.INVENTORYMAN);
		//找到所有高级财务人员
		ArrayList<UserAccountPO> allAdFinanceManList = impl.findAll(UserRole.ADFINANCEMAN);
		//找到所有普通财务人员
		ArrayList<UserAccountPO> allGeFinanceManList = impl.findAll(UserRole.GEFINACEMAN);
		//找到所有总经理
		ArrayList<UserAccountPO> allManagerList = impl.findAll(UserRole.MANAGER);
		//找到所有管理员
		ArrayList<UserAccountPO> allAdministerList = impl.findAll(UserRole.ADMINISTRATOR);
		
		Hashtable<UserRole, ArrayList<UserAccountPO>> allUserAccountInfo = new Hashtable<UserRole, ArrayList<UserAccountPO>>();
		allUserAccountInfo.put(UserRole.EXPRESSMAN, allExpressManList);
		allUserAccountInfo.put(UserRole.OFFICEMAN, allOfficeManList);
		allUserAccountInfo.put(UserRole.TRANSITCENTERMAN, allTransferOfficeManList);
		allUserAccountInfo.put(UserRole.INVENTORYMAN, allInventoryManList);
		allUserAccountInfo.put(UserRole.ADFINANCEMAN, allAdFinanceManList);
		allUserAccountInfo.put(UserRole.GEFINACEMAN, allGeFinanceManList);
		allUserAccountInfo.put(UserRole.MANAGER, allManagerList);
		allUserAccountInfo.put(UserRole.ADMINISTRATOR, allAdministerList);
		
		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing user acccoutns...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.USERACCOUNTNFO.toString(), allUserAccountInfo);
		ioHelper.writeToFile(beginningAccountInfo, file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * syncBankAccount()
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void syncBankAccount() throws RemoteException {
		// 找到所有的银行账户
		BankAccountImpl impl = new BankAccountImpl();
		ArrayList<BankAccountInfoPO> allBankAccountsList = impl.findAllBankAccouts();
		
		// 同步到自己这里：更新到期初建账信息这里
		System.out.println("server syncing bank acccoutns...");
		ioHelper = new IOHelper();
		Hashtable beginningAccountInfo = ioHelper.readFromFile(file);
		beginningAccountInfo.put(InitRelatedFiles.BANKACCOUNTINFO.toString(), allBankAccountsList);
		ioHelper.writeToFile(beginningAccountInfo, file);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * findAllOfficeInfo()
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<City, ArrayList<OfficePO>> findAllOfficeInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllOfficeInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		Hashtable<City, ArrayList<OfficePO>> allOfficeInfo = new Hashtable<City, ArrayList<OfficePO>>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.OFFICEINFO.toString())) {
			allOfficeInfo = (Hashtable<City, ArrayList<OfficePO>>) beginningAccountInfo.get(InitRelatedFiles.OFFICEINFO.toString());
			System.out.println("期初建账信息中找到了营业厅信息...");
			for(Iterator<City> itr = allOfficeInfo.keySet().iterator(); itr.hasNext();) {
				City key = itr.next();
				ArrayList<OfficePO> list = allOfficeInfo.get(key);
				for(int i = 0; i < list.size(); i++) {
					OfficePO po = list.get(i);
					System.out.println(po.getOfficeID() + " " + po.getCity().toString());
				}
			}
			return allOfficeInfo;
		}
		System.out.println("期初建账信息中还没有营业厅信息...");
		return allOfficeInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * findAllTransferOfficeInfo()
	 */
	@SuppressWarnings("unchecked")
	public Hashtable<City, ArrayList<TransferOfficePO>> findAllTransferOfficeInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllTransferOfficeInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		Hashtable<City, ArrayList<TransferOfficePO>> allTransferOfficeInfo = new Hashtable<City, ArrayList<TransferOfficePO>>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.TRANSFEROFFICEINFO.toString())) {
			allTransferOfficeInfo = (Hashtable<City, ArrayList<TransferOfficePO>>) beginningAccountInfo.get(InitRelatedFiles.TRANSFEROFFICEINFO.toString());
			System.out.println("期初建账信息中找到了中转中心信息...");
			for(Iterator<City> itr = allTransferOfficeInfo.keySet().iterator(); itr.hasNext();) {
				City key = itr.next();
				ArrayList<TransferOfficePO> list = allTransferOfficeInfo.get(key);
				for(int i = 0; i < list.size(); i++) {
					TransferOfficePO po = list.get(i);
					System.out.println(po.getTransferOfficeID() + " " + po.getCity().toString());
				}
			}
			return allTransferOfficeInfo;
		}
		System.out.println("期初建账信息中还没有中转中心信息...");
		return allTransferOfficeInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * findAllInventoryInfo()
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<InventoryInfoPO> findAllInventoryInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllInventoryInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		ArrayList<InventoryInfoPO> allInventoryInfo = new ArrayList<InventoryInfoPO>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.INVENTOTYINFO.toString())) {
			allInventoryInfo = (ArrayList<InventoryInfoPO>) beginningAccountInfo
					.get(InitRelatedFiles.INVENTOTYINFO.toString());
			System.out.println("期初建账信息中找到了库存信息...");
			for(int i = 0; i < allInventoryInfo.size(); i++) {
				InventoryInfoPO po = allInventoryInfo.get(i);
				System.out.println(po.getInventoryID() + " " + po.getLimit() + " " + po.getEmptyZone().toString());
			}
			return allInventoryInfo;
		}
		System.out.println("期初建账信息中还没有库存信息...");
		return allInventoryInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * findAllDriverInfo()
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<DriverInfoPO> findAllDriverInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllDriverInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		ArrayList<DriverInfoPO> allDriverInfo = new ArrayList<DriverInfoPO>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.DRIVERINFO.toString())) {
			allDriverInfo = (ArrayList<DriverInfoPO>) beginningAccountInfo.get(InitRelatedFiles.DRIVERINFO.toString());
			System.out.println("期初建账信息中找到了司机信息...");
			for(int i = 0; i < allDriverInfo.size(); i++) {
				DriverInfoPO po = allDriverInfo.get(i);
				System.out.println(po.getDriverNumber() + " " + po.getName());
			}
			return allDriverInfo;
		}
		System.out.println("期初建账信息中还没有司机信息...");
		return allDriverInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dataservice.financedataservice.BeginningAccountdataService#findAlCarInfo(
	 * )
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<CarInfoPO> findAlCarInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAlCarInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		ArrayList<CarInfoPO> allCarInfo = new ArrayList<CarInfoPO>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.CARINFO.toString())) {
			allCarInfo = (ArrayList<CarInfoPO>) beginningAccountInfo.get(InitRelatedFiles.CARINFO.toString());
			System.out.println("期初建账信息中找到了车辆信息...");
			for(int i = 0; i < allCarInfo.size(); i++) {
				CarInfoPO po = allCarInfo.get(i);
				System.out.println(po.getCarNumber() + " " + po.getPlateNumber());
			}
			return allCarInfo;
		}
		System.out.println("期初建账信息中还没有车辆信息...");
		return allCarInfo;
	}
	
	

	@SuppressWarnings("unchecked")
	public Hashtable<UserRole,  ArrayList<UserAccountPO>> findAllUserAccountInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllUserAccountInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		Hashtable<UserRole, ArrayList<UserAccountPO>> allUserAccountInfo = new Hashtable<UserRole, ArrayList<UserAccountPO>>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.USERACCOUNTNFO.toString())) {
			allUserAccountInfo = (Hashtable<UserRole, ArrayList<UserAccountPO>>) beginningAccountInfo
					.get(InitRelatedFiles.USERACCOUNTNFO.toString());
			System.out.println("期初建账信息中找到了用户账户信息...");
			for(Iterator<UserRole> itr = allUserAccountInfo.keySet().iterator(); itr.hasNext();) {
				UserRole key = itr.next();
				ArrayList<UserAccountPO> list = allUserAccountInfo.get(key);
				for(int j = 0; j < list.size(); j++) {
					UserAccountPO po = list.get(j);
					System.out.println(po.getUserAccountID() + " " + po.getUserRole().toString() + " " + po.getUserName());
				}
			}
			return allUserAccountInfo;
		}
		System.out.println("期初建账信息中还没有用户账户信息...");
		return allUserAccountInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.financedataservice.BeginningAccountdataService#
	 * findAllBankAccountInfo()
	 */
	@SuppressWarnings("unchecked")
	public ArrayList<BankAccountInfoPO> findAllBankAccountInfo() throws RemoteException {
		System.out.println("进入BeginningAccountServiceImpl...server findAllBankAccountInfo...");
		ioHelper = new IOHelper();
		beginningAccountInfo = ioHelper.readFromFile(file);
		ArrayList<BankAccountInfoPO> allBankAccountInfo = new ArrayList<BankAccountInfoPO>();
		if (beginningAccountInfo.containsKey(InitRelatedFiles.BANKACCOUNTINFO.toString())) {
			allBankAccountInfo = (ArrayList<BankAccountInfoPO>) beginningAccountInfo
					.get(InitRelatedFiles.BANKACCOUNTINFO.toString());
			System.out.println("期初建账信息中找到了银行账户信息...");
			for(int i = 0; i < allBankAccountInfo.size(); i++) {
				BankAccountInfoPO po = allBankAccountInfo.get(i);
				System.out.println(po.getAccountId() + " " + po.getAccountName() + " " + po.getBalance());
			}
			return allBankAccountInfo;
		}
		System.out.println("期初建账信息中还没有银行账户信息...");
		return allBankAccountInfo;
	}
	
	public static void main(String[] args) {
		try {
			BeginningAccountServiceImpl impl  = new BeginningAccountServiceImpl();
//			impl.syncBankAccount();
//			impl.findAllBankAccountInfo();
			
//			impl.syncCar();
//			impl.findAlCarInfo();
			
//			impl.syncDriver();
//			impl.findAllDriverInfo();
			
//			impl.syncInventory();
//			impl.findAllInventoryInfo();
			
			impl.syncOffice();
			impl.findAllOfficeInfo();
			
//			impl.syncTransferOffice();
//			impl.findAllTransferOfficeInfo();
			
//			impl.syncUserAccount();
//			impl.findAllUserAccountInfo();
			
			
			
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
