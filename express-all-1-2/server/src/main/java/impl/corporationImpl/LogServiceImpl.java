/**
 * @author 谭琼
 * 2015年12月16日
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
import java.util.Calendar;

import dataservice.corporationdataservice.LogCorporationdataService;
import iohelper.LogIOHelper;
import po.LogPO;

/**
 * 日志数据层实现
 */
public class LogServiceImpl extends UnicastRemoteObject implements LogCorporationdataService {

	private static final long serialVersionUID = 1L;
	FileInputStream inOne;
	ObjectInputStream inTwo;
	FileOutputStream outOne;
	ObjectOutputStream outTwo;
	ArrayList<LogPO> logInfo;// 日志集合【本身有序，按照时间排序】
	File file = new File("日志信息.txt");
	LogIOHelper logIOHelper;

	/**
	 * @throws RemoteException
	 */
	public LogServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see dataservice.corporationdataservice.LogCorporationdataService#add(po.
	 * LogPO)
	 */
	public void add(LogPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入LogServiceImpl...server adding...");
		logIOHelper = new LogIOHelper();
		logInfo = logIOHelper.readFromFile(file);
		logInfo.add(po);
		System.out.println("To be added: " + po.toString());
		logIOHelper.writeToFile(logInfo, file);
		System.out.println("Add LogPO done!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * dataservice.corporationdataservice.LogCorporationdataService#find(java.
	 * util.Calendar, java.util.Calendar)
	 */
	public ArrayList<LogPO> find(Calendar startDate, Calendar endDate) throws RemoteException {
		System.out.println("进入LogServiceImpl...server finding...");
		logIOHelper = new LogIOHelper();
		logInfo = logIOHelper.readFromFile(file);
//		System.out.println(logInfo.get(0));
		if (logInfo == null) {// 1.日志为空
			System.out.println("日志记录为空");
			return new ArrayList<LogPO>();
		}
		// 2.日志不为空
		int startIndex = 0;// 没找到开始日期默认到最早的日志记录
		int endIndex = logInfo.size() - 1;// 没找到结束日期默认到最新的日志记录
		boolean hasSetStart = false;

		for (int i = 0; i < logInfo.size(); i++) {
			LogPO log = logInfo.get(i);
			Calendar date = log.getOperationTime();

			// 寻找开始日期对应在logInfo中的位置
			if (!hasSetStart) {
				// 如果startDate早于日志记录的第一个记录的日期，
				if (compare(startDate, logInfo.get(0).getOperationTime()) < 0) {
					if(compare(endDate, logInfo.get(0).getOperationTime()) >= 0) {
						//且截止日期晚于或等于第一个记录的日期，那么startIndex设为0
						hasSetStart = true;
					} else {//且截止日期早于第一个记录的日期，那么无对应的日志记录
						System.out.println("日志记录为空hasSet");
						return null;
					}
					
				}
				
				if (compare(date, startDate) == 0) {
					startIndex = i;
					hasSetStart = true;
				}
			}

			if (compare(date, endDate) <= 0) {
				// 当前日志的日期小于等于设置的结束日期，且下一条日志【有下一条日志时】的日期大于结束日期
				if (i <= logInfo.size() - 2) {// 有下一条日志
					LogPO nextLog = logInfo.get(i + 1);
					if (compare(nextLog.getOperationTime(), endDate) > 0) {
						endIndex = i;
						break;
					}
				}
			}
		}

		if (!hasSetStart) {// 未找到任何日志
			System.out.println("日志记录为空hasSetStart");
			return null;
		}

		System.out.println("startIndex: " + startIndex + " endIndex: " + endIndex + "logInfoSize: " + logInfo.size());
		ArrayList<LogPO> findLogs = new ArrayList<LogPO>();
		System.out.println("Have found log: ");
		for (int j = startIndex; j <=endIndex; j++) {
			findLogs.add(logInfo.get(j));
		}
//		System.out.println("The fist one of found logs is " + findLogs.get(0));
		return findLogs;
	}

	/**
	 * 比较日期day1和日期day2的大小
	 * 
	 * @param day1
	 * @param day2
	 * @return
	 */
	public int compare(Calendar day1, Calendar day2) {
		int year1 = day1.get(Calendar.YEAR);
		int month1 = day1.get(Calendar.MONTH);
		int date1 = day1.get(Calendar.DATE);
		int year2 = day2.get(Calendar.YEAR);
		int month2 = day2.get(Calendar.MONTH);
		int date2 = day2.get(Calendar.DATE);

		if (year1 < year2) {
			return -1;
		}
		if (year1 == year2 && month1 < month2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 < date2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 == date2) {
			return 0;
		}
		return 1;
	}

}
