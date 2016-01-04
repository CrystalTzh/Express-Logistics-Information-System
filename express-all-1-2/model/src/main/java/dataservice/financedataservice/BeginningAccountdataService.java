package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import po.OfficePO;
import po.TransferOfficePO;
import po.UserAccountPO;
import state.City;
import state.UserRole;

/**
 * 期初建账数据层接口
 */
public interface BeginningAccountdataService extends Remote{
		
	/**
	 * 同步营业厅信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncOffice() throws RemoteException;
	
	/**
	 * 同步中转中心信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncTransferOffice() throws RemoteException;
	
	/**
	 * 同步库存信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncInventory() throws RemoteException;
	
	/**
	 * 同步司机信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncDriver() throws RemoteException;
	
	/**
	 * 同步车辆信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncCar() throws RemoteException;
	
	/**
	 * 同步用户账户信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncUserAccount() throws RemoteException;
	
	/**
	 * 同步银行账户信息到期初建账信息中
	 * @return
	 * @throws RemoteException
	 */
	public void syncBankAccount() throws RemoteException;
	
	/**
	 * 获得期初建账信息中的所有营业厅信息
	 * @return Hashtable<City, ArrayList<OfficePO>>
	 * @throws RemoteException
	 */
	public Hashtable<City, ArrayList<OfficePO>> findAllOfficeInfo() throws RemoteException;
	
	/**
	 * 获得期初建账信息中的所有中转中心信息
	 * @return Hashtable<City, ArrayList<TransferOfficePO>>
	 * @throws RemoteException
	 */
	public Hashtable<City, ArrayList<TransferOfficePO>> findAllTransferOfficeInfo() throws RemoteException; 
	
	/**
	 * 获得期初建账信息中所有库存信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<InventoryInfoPO> findAllInventoryInfo() throws RemoteException;
	
	/**
	 * 获得期初建账信息中的所有司机信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<DriverInfoPO> findAllDriverInfo() throws RemoteException;
	
	/**
	 * 获得所有期初建账信息中的所有车辆信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<CarInfoPO> findAlCarInfo() throws RemoteException;
	
	/**
	 * 获得所有期初建账信息中的所有用户账户信息
	 * @return 返回一个Hashtable<UserRole,  ArrayList<UserAccountPO>>
	 * @throws RemoteException
	 */
	public Hashtable<UserRole,  ArrayList<UserAccountPO>> findAllUserAccountInfo() throws RemoteException;
	
	/**
	 * 获得所有期初建账信息中的所有银行账户信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<BankAccountInfoPO> findAllBankAccountInfo() throws RemoteException;
}
