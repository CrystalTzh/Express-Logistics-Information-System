package businesslogicservice.financeblservice;

import java.util.ArrayList;
import java.util.Hashtable;

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
 * 期初建账业务逻辑层接口
 */
public interface BeginningAccountFinanceblService {
	
	/**
	 * 同步营业厅信息到期初建账信息中
	 * @return
	 */
	public boolean syncOffice();
	
	/**
	 * 同步中转中心信息到期初建账信息中
	 * @return
	 */
	public boolean syncTransferOffice();
	
	/**
	 * 同步库存信息到期初建账信息中
	 * @return
	 */
	public boolean syncInventory();
	
	/**
	 * 同步司机信息到期初建账信息中
	 * @return
	 */
	public boolean syncDriver();
	
	/**
	 * 同步车辆信息到期初建账信息中
	 * @return
	 */
	public boolean syncCar();
	
	/**
	 * 同步用户账户信息到期初建账信息中
	 * @return
	 */
	public boolean syncUserAccount();
	
	/**
	 * 同步银行账户信息到期初建账信息中
	 * @return
	 */
	public boolean syncBankAccount();
	
	/**
	 * 获得期初建账信息中的所有营业厅信息
	 * @return Hashtable<City, ArrayList<OfficeVO>>
	 */
	public Hashtable<City, ArrayList<OfficeVO>> findAllOfficeInfo();
	
	/**
	 * 获得期初建账信息中的所有中转中心信息
	 * @return Hashtable<City, ArrayList<TransferOfficeVO>>
	 */
	public Hashtable<City, ArrayList<TransferOfficeVO>> findAllTransferOfficeInfo(); 
	
	/**
	 * 获得期初建账信息中所有库存信息
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<InventoryInfoVO> findAllInventoryInfo();
	
	/**
	 * 获得期初建账信息中的所有司机信息
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<DriverInfoVO> findAllDriverInfo();
	
	/**
	 * 获得所有期初建账信息中的所有车辆信息
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<CarInfoVO> findAlCarInfo();
	
	/**
	 * 获得所有期初建账信息中的所有用户账户信息
	 * @return 返回一个Hashtable<UserRole,  ArrayList<UserAccountPO>>
	 */
	public Hashtable<UserRole,  ArrayList<UserAccountVO>> findAllUserAccountInfo();
	
	/**
	 * 获得所有期初建账信息中的所有银行账户信息
	 * @return 为空时，是一个空的ArrayList，不会是null值
	 */
	public ArrayList<BankAccountInfoVO> findAllBankAccountInfo();
}
