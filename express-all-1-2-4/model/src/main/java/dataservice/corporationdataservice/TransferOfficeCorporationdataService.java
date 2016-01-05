/**
 * @author 谭琼
 * 2015年12月14日
 */
package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransferOfficePO;
import state.City;

/**
 * 中转中心数据层接口
 */
public interface TransferOfficeCorporationdataService extends Remote{
	
	/**
	 * 查找某一城市的所有中转中心
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<TransferOfficePO> findAll(City city) throws RemoteException;
	
	/**
	 * 查找中转中心信息
	 * @param transferOfficeID
	 * @return
	 * @throws RemoteException
	 */
	public TransferOfficePO find(String transferOfficeID) throws RemoteException;
	
	/**
	 * 更新中转中心信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(TransferOfficePO po) throws RemoteException;
	
	/**
	 * 添加中转中心信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(TransferOfficePO po) throws RemoteException;
	
	/**
	 * 删除中转中心信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(TransferOfficePO po) throws RemoteException;
	
	/**
	 * 获取下一个中转中心编号(城市编码+一位数字)
	 * @param city
	 * @return
	 * @throws RemoteException
	 */
	public String getNextTransferOfficeID(City city) throws RemoteException;
}
