/**
 * @author 谭琼
 * 2015年12月16日
 */
package businesslogicservice.corporationblservice;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import vo.LogVO;

/**
 * 日志的逻辑层接口
 */
public interface LogcorporationblService {
	
	/**
	 * 添加一条日志
	 * @param vo
	 * @return
	 * @throws RemoteException
	 */
	public boolean add(LogVO vo) throws RemoteException;
	
	/**
	 * 按照开始日期、结束日期查找日志
	 * @param startDate 开始日期
	 * @param endState 结束日期
	 * @return 从开始日期到结束日期的所有日志记录的集合
	 * @throws RemoteException
	 */
	public ArrayList<LogVO> find(Calendar startDate, Calendar endState) throws RemoteException;
}
