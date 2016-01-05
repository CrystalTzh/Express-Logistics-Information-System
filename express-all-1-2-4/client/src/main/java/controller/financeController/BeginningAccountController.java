/**
 * @author 谭琼
 * 2015年12月23日
 */
package controller.financeController;

import java.util.ArrayList;
import java.util.Hashtable;

import businesslogic.financebl.BeginningAccountbl;
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
 * 期初建账控制器
 */
public class BeginningAccountController {

	BeginningAccountbl beginningAccountbl = new BeginningAccountbl();

	/**
	 * 同步营业厅信息到期初建账信息中
	 * @return
	 */
	public boolean syncOffice() {
		System.out.println("进入BeginningAccountController...syncOffice...");
		if(beginningAccountbl.syncOffice()) {
			return true;
		}
		return false;
	}

	/**
	 * 同步中转中心信息到期初建账信息中
	 * 
	 * @return
	 */
	public boolean syncTransferOffice() {
		System.out.println("进入BeginningAccountController...syncTransferOffice...");
		if(beginningAccountbl.syncTransferOffice()) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @return
	 */
	public boolean syncInventory() {
		System.out.println("进入BeginningAccountController...syncInventory...");
		if(beginningAccountbl.syncTransferOffice()) {
			return true;
		}
		return false;
	}

	/**
	 * 同步司机信息到期初建账信息中
	 * 
	 * @return
	 */
	public boolean syncDriver() {
		System.out.println("进入BeginningAccountController...syncDriver...");
		if(beginningAccountbl.syncDriver()) {
			return true;
		}
		return false;
	}

	/**
	 * 同步车辆信息到期初建账信息中
	 * 
	 * @return
	 */
	public boolean syncCar() {
		System.out.println("进入BeginningAccountController...syncCar...");
		if(beginningAccountbl.syncCar()) {
			return true;
		}
		return false;
	}

	/**
	 * 同步用户账户信息到期初建账信息中
	 * 
	 * @return
	 */
	public boolean syncUserAccount() {
		System.out.println("进入BeginningAccountController...syncUserAccount...");
		if(beginningAccountbl.syncUserAccount()) {
			return true;
		}
		return false;
	}

	/**
	 * 同步银行账户信息到期初建账信息中
	 * 
	 * @return
	 */
	public boolean syncBankAccount() {
		System.out.println("进入BeginningAccountController...syncBankAccount...");
		if(beginningAccountbl.syncBankAccount()) {
			return true;
		}
		return false;
	}

	/**
	 * 获得期初建账信息中的所有营业厅信息
	 * 
	 * @return Hashtable<City, ArrayList<OfficeVO>>
	 * @return
	 */
	public Hashtable<City, ArrayList<OfficeVO>> findAllOfficeInfo() {
		System.out.println("进入BeginningAccountController...findAllOfficeInfo...");
		return beginningAccountbl.findAllOfficeInfo();
	}

	/**
	 * 获得期初建账信息中的所有中转中心信息
	 * 
	 * @return Hashtable<City, ArrayList<TransferOfficeVO>>
	 */
	public Hashtable<City, ArrayList<TransferOfficeVO>> findAllTransferOfficeInfo() {
		System.out.println("进入BeginningAccountController...findAllTransferOfficeInfo...");
		return beginningAccountbl.findAllTransferOfficeInfo();
	}

	/**
	 * 获得期初建账信息中所有库存信息
	 * 
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<InventoryInfoVO> findAllInventoryInfo() {
		System.out.println("进入BeginningAccountController...findAllInventoryInfo...");
		return beginningAccountbl.findAllInventoryInfo();
	}

	/**
	 * 获得期初建账信息中的所有司机信息
	 * 
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<DriverInfoVO> findAllDriverInfo() {
		System.out.println("进入BeginningAccountController...findAllDriverInfo...");
		return beginningAccountbl.findAllDriverInfo();
	}

	/**
	 * 获得所有期初建账信息中的所有车辆信息
	 * 
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<CarInfoVO> findAlCarInfo() {
		System.out.println("进入BeginningAccountController...findAlCarInfo...");
		return beginningAccountbl.findAlCarInfo();
	}

	/**
	 * 获得所有期初建账信息中的所有用户账户信息
	 * 
	 * @return 返回一个Hashtable<UserRole, ArrayList<UserAccountPO>>
	 */
	public Hashtable<UserRole, ArrayList<UserAccountVO>> findAllUserAccountInfo() {
		System.out.println("进入BeginningAccountController...findAllUserAccountInfo...");
		return beginningAccountbl.findAllUserAccountInfo();
	}

	/**
	 * 获得所有期初建账信息中的所有银行账户信息
	 * 
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<BankAccountInfoVO> findAllBankAccountInfo() {
		System.out.println("进入BeginningAccountController...findAllBankAccountInfo...");
		return beginningAccountbl.findAllBankAccountInfo();
	}
	
	public static void main(String[] args) {
		BeginningAccountController beginningAccountController = new BeginningAccountController();
		ArrayList<BankAccountInfoVO> list = beginningAccountController.findAllBankAccountInfo();
		for(int i = 0; i < list.size(); i++) {
			BankAccountInfoVO vo = list.get(i);
			System.out.println(vo.getAccountName() + " " + vo.getAccountId() + " " + vo.getBalance());
		}
	}
}
