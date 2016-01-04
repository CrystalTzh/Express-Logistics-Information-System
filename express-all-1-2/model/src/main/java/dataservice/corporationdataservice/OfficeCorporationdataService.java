/**
 * @author 谭琼
 * 2015年12月14日
 */
package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.OfficePO;
import state.City;

/**
 * 营业厅数据层接口
 */
public interface OfficeCorporationdataService extends Remote{
	
	
	/**
	 * 查找所有营业厅信息
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<OfficePO> findAll(City city) throws RemoteException;
	
	/**
	 * 查找营业厅信息
	 * @param transferOfficeID
	 * @return
	 * @throws RemoteException
	 */
	public OfficePO find(String officeID) throws RemoteException;
	
	/**
	 * 更新营业厅信息
	 * @param po
	 * @throws RemoteException
	 */
	public void update(OfficePO po) throws RemoteException;
	
	/**
	 * 添加营业厅信息
	 * @param po
	 * @throws RemoteException
	 */
	public void add(OfficePO po) throws RemoteException;
	
	/**
	 * 删除营业厅信息
	 * @param po
	 * @throws RemoteException
	 */
	public void delete(OfficePO po) throws RemoteException;
	
	
	/**
	 * 获取下一个营业厅编号(城市编码+三位数字)
	 * @param city
	 * @return
	 * @throws RemoteException
	 */
	public String getNextOfficeID(City city) throws RemoteException;
	
}
