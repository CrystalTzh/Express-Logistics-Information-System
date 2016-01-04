package businesslogic.financebl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;

import businesslogic.corporationbl.BankAccountbl;
import businesslogic.corporationbl.CarInfobl;
import businesslogic.corporationbl.DriverInfobl;
import businesslogic.corporationbl.OfficeInfobl;
import businesslogic.corporationbl.TransferOfficeInfobl;
import businesslogic.inventorybl.InventoryInfo;
import businesslogic.userbl.UserAccountbl;
import businesslogicservice.financeblservice.BeginningAccountFinanceblService;
import clienthelper.financeclienthelper.BeginningAccountClientHelper;
import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import po.OfficePO;
import po.TransferOfficePO;
import po.UserAccountPO;
import state.City;
import state.UserRole;
import vo.BankAccountInfoVO;
import vo.CarInfoVO;
import vo.DriverInfoVO;
import vo.InventoryInfoVO;
import vo.OfficeVO;
import vo.TransferOfficeVO;
import vo.UserAccountVO;

/**
 * 期初建账逻辑层实现
 */
public class BeginningAccountbl implements BeginningAccountFinanceblService {

	BeginningAccountClientHelper beginningAccountClientHelper = new BeginningAccountClientHelper();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncOffice()
	 */
	public boolean syncOffice() {
		if (beginningAccountClientHelper.goSyncOffice()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncTransferOffice()
	 */
	public boolean syncTransferOffice(){
		if (beginningAccountClientHelper.goSyncTransferOffice()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncInventory()
	 */
	public boolean syncInventory() {
		if (beginningAccountClientHelper.goSyncInventory()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncDriver()
	 */
	public boolean syncDriver() {
		if (beginningAccountClientHelper.goSyncDriver()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncCar()
	 */
	public boolean syncCar() {
		if (beginningAccountClientHelper.goSyncCar()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncUserAccount()
	 */
	public boolean syncUserAccount() {
		if (beginningAccountClientHelper.goSyncUserAccount()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * syncBankAccount()
	 */
	public boolean syncBankAccount() {
		if (beginningAccountClientHelper.goSyncBankAccount()) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllOfficeInfo()
	 */
	public Hashtable<City, ArrayList<OfficeVO>> findAllOfficeInfo() {
		OfficeInfobl officeInfobl = new OfficeInfobl();
		// 将获得的Hashtable<City, ArrayList<OfficePO>>转换为Hashtable<City,
		// ArrayList<OfficeVO>>
		Hashtable<City, ArrayList<OfficePO>> allOfficePOInfo = beginningAccountClientHelper.goFindAllOfficeInfo();
		Hashtable<City, ArrayList<OfficeVO>> allOfficeVOInfo = new Hashtable<City, ArrayList<OfficeVO>>();
		for (Iterator<City> itr = allOfficePOInfo.keySet().iterator(); itr.hasNext();) {
			City key = itr.next();
			ArrayList<OfficePO> POlist = allOfficePOInfo.get(key);
			ArrayList<OfficeVO> VOlist = new ArrayList<OfficeVO>();
			for (int i = 0; i < POlist.size(); i++) {
				OfficeVO vo = officeInfobl.wrappPOtoVO(POlist.get(i));
				VOlist.add(vo);
			}
			allOfficeVOInfo.put(key, VOlist);
		}
		return allOfficeVOInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllTransferOfficeInfo()
	 */
	public Hashtable<City, ArrayList<TransferOfficeVO>> findAllTransferOfficeInfo() {
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		// 将获得的Hashtable<City, ArrayList<TransferOfficeVO>>转换为Hashtable<City,
		// ArrayList<TransferOfficeVO>>
		Hashtable<City, ArrayList<TransferOfficePO>> allTransferOfficePOInfo = beginningAccountClientHelper.goFindAllTransferOfficeInfo();
		Hashtable<City, ArrayList<TransferOfficeVO>> allTransferOfficeVOInfo = new Hashtable<City, ArrayList<TransferOfficeVO>>();
		for (Iterator<City> itr = allTransferOfficePOInfo.keySet().iterator(); itr.hasNext();) {
			City key = itr.next();
			ArrayList<TransferOfficePO> POlist = allTransferOfficePOInfo.get(key);
			ArrayList<TransferOfficeVO> VOlist = new ArrayList<TransferOfficeVO>();
			for (int i = 0; i < POlist.size(); i++) {
				TransferOfficeVO vo = transferOfficeInfobl.wrappPOtoVO(POlist.get(i));
				VOlist.add(vo);
			}
			allTransferOfficeVOInfo.put(key, VOlist);
		}
		return allTransferOfficeVOInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllInventoryInfo()
	 */
	public ArrayList<InventoryInfoVO> findAllInventoryInfo() {
		InventoryInfo inventoryInfobl = new InventoryInfo();
		ArrayList<InventoryInfoPO> allInventoryPOList = beginningAccountClientHelper.goFindAllInventory();
		ArrayList<InventoryInfoVO> allInventoryVOList = new ArrayList<InventoryInfoVO>();
		for(int i = 0; i < allInventoryPOList.size(); i++) {
			InventoryInfoVO vo = inventoryInfobl.wrappPOtoVO(allInventoryPOList.get(i));
			allInventoryVOList.add(vo);
		}
		return allInventoryVOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllDriverInfo()
	 */
	public ArrayList<DriverInfoVO> findAllDriverInfo(){
		DriverInfobl driverInfobl = new DriverInfobl();
		ArrayList<DriverInfoPO> allDriverPOList = beginningAccountClientHelper.goFindAllDiver();
		ArrayList<DriverInfoVO> allDriverVOList = new ArrayList<DriverInfoVO>();
		for(int i = 0; i < allDriverPOList.size(); i++) {
			DriverInfoVO vo = driverInfobl.wrappPOtoVO(allDriverPOList.get(i));
			allDriverVOList.add(vo);
		}
		return allDriverVOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAlCarInfo()
	 */
	public ArrayList<CarInfoVO> findAlCarInfo() {
		CarInfobl carInfobl = new CarInfobl();
		ArrayList<CarInfoPO> allCarPOList = beginningAccountClientHelper.goFindAllCar();
		ArrayList<CarInfoVO> allCarVOList = new ArrayList<CarInfoVO>();
		for(int i = 0; i < allCarPOList.size(); i++) {
			CarInfoVO vo = carInfobl.wrappPOtoVO(allCarPOList.get(i));
			allCarVOList.add(vo);
		}
		return allCarVOList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllUserAccountInfo()
	 */
	public Hashtable<UserRole, ArrayList<UserAccountVO>> findAllUserAccountInfo() {
		UserAccountbl userAccountbl = new UserAccountbl();
		Hashtable<UserRole, ArrayList<UserAccountPO>> allUserAccountPOInfo = beginningAccountClientHelper.goFindAllUserAccountInfo();
		Hashtable<UserRole, ArrayList<UserAccountVO>> allUserAccountVOInfo = new Hashtable<UserRole, ArrayList<UserAccountVO>>();
		for(Iterator<UserRole> itr = allUserAccountPOInfo.keySet().iterator(); itr.hasNext();) {
			UserRole key = itr.next();
			ArrayList<UserAccountPO> POlist = allUserAccountPOInfo.get(key);
			ArrayList<UserAccountVO> VOlist = new ArrayList<UserAccountVO>();
			for(int i = 0; i < POlist.size(); i++) {
				UserAccountVO vo = userAccountbl.wrappPOtoVO(POlist.get(i));
				VOlist.add(vo);
			}
			allUserAccountVOInfo.put(key, VOlist);
		}
		return allUserAccountVOInfo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.financeblservice.BeginningAccountFinanceblService#
	 * findAllBankAccountInfo()
	 */
	public ArrayList<BankAccountInfoVO> findAllBankAccountInfo(){
		BankAccountbl bankAccountbl = new BankAccountbl();
		ArrayList<BankAccountInfoPO> allBankAccountPOList = beginningAccountClientHelper.goFindAllBankAccountInfo();
		ArrayList<BankAccountInfoVO> allBankAccountVOList = new ArrayList<BankAccountInfoVO>();
		for(int i = 0; i < allBankAccountPOList.size(); i++) {
			BankAccountInfoVO vo = bankAccountbl.wrappPOtoVO(allBankAccountPOList.get(i));
			allBankAccountVOList.add(vo);
		}
		return allBankAccountVOList;
	}

}
