/**
 * @author 谭琼
 * 2015年12月17日
 */
package clienthelper.corporatioclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.corporationdataservice.LogCorporationdataService;
import po.LogPO;

/**
 * 在客户端，日志建立RMI连接
 */
public class LogClientHelper{
	
	LogCorporationdataService logCorporationdataService = null;
//	Thread t = new Thread(new LogClientHelper());
	
	/**
	 * 远程添加日志信息
	 * @param po
	 * @return
	 */
	public boolean goInsert(LogPO po) {
		System.out.println("进入LogClientHelper...goInsert...");
		logCorporationdataService = go();
		try {
			logCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			e.printStackTrace();
//			System.out.println("尝试重新连接...5秒...");
//			Thread t = new Thread(new LogThreadHelper(logCorporationdataService));
//			t.start();
		}
		return false;
	}
	
	/**
	 * 远程查找日志信息
	 * @param startDate 开始日期
	 * @param endState 结束日期
	 * @return
	 */
	public ArrayList<LogPO> goFind(Calendar startDate, Calendar endDate) {
		System.out.println("进入LogClientHelper...goFind...");
		logCorporationdataService = go();
		try {
//			System.out.println(tmp.size()+"日志信息条目");
			return logCorporationdataService.find(startDate, endDate);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("查找失败");
		return null;
	}
	
	/**
	 * 客户端建立logCorporationdataService服务的连接
	 * @return
	 */
	public LogCorporationdataService go() {
		System.out.println("进入LogClientHelper...go...");
		if(logCorporationdataService == null) {
			try {
//				logCorporationdataService = (LogCorporationdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/logCorporationdataService");
				logCorporationdataService = (LogCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.LOG.toString()));
				System.out.println("LogCorporationdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
//				System.out.println("其他异常！！");
				e.printStackTrace();
//				System.out.println("请确认服务器是否已连接...");
//				System.exit(0);
//				Thread t = new Thread(new ThreadHelper(logCorporationdataService));
//				t.start();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			}
		}
		return logCorporationdataService;
	}

}
