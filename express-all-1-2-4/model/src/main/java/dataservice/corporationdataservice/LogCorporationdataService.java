/**
 * @author 谭琼
 * 2015年12月16日
 */
package dataservice.corporationdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import po.LogPO;

/**
 * 日志数据层接口
 */
public interface LogCorporationdataService  extends Remote{
	
	/**
	 * 添加一条日志
	 * @param po
	 * @throws RemoteException
	 */
	public void add(LogPO po) throws RemoteException;
	
	/**
	 * 按照开始日期、结束日期查找日志
	 * @param startDate 开始日期
	 * @param endState 结束日期
	 * @return 从开始日期到结束日期的所有日志记录的集合
	 * @throws RemoteException
	 */
	public ArrayList<LogPO> find(Calendar startDate, Calendar endState) throws RemoteException;
	
}
