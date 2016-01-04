/**
 * 公司常量信息模块客户端建立RMI连接
 * @author 谭琼
 * 2015年12月8日
 */
package clienthelper.constclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.constdataservice.PriceInfoConstdataService;
import po.PricePO;

/**
 * 在客户端，价格常量信息建立RMI连接
 */
public class PriceInfoClientHelper {
	PriceInfoConstdataService priceInfoConstdataService = null;
	
	public boolean goUpdate(PricePO po) {
		System.out.println("进入PriceInfoClientHelper...goUpdate...");
		priceInfoConstdataService = this.go();
		try {
			priceInfoConstdataService.update(po);
			return true;
		} catch (RemoteException e) {
			//远程方法调用的时候出现网络中断【服务器没有在规定时间内返回数据】
			//尝试重连：开始跑一个线程，每5秒调用一次ping方法，如果调用成功，结束线程
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程查找价格常量
	 * @return
	 */
	public PricePO goFind() {
		System.out.println("进入PriceInfoClientHelper...goFind...");
		priceInfoConstdataService = this.go();
		try {
			PricePO po = priceInfoConstdataService.find();
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 客户端建立PriceInfoConstdataService服务的RMI连接
	 * @return
	 */
	public PriceInfoConstdataService go() {
		System.out.println("进入PriceInfoClientHelper...go...");
		if(priceInfoConstdataService == null) {
			try {
//				priceInfoConstdataService = (PriceInfoConstdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/priceInfoConstdataService");
				priceInfoConstdataService = (PriceInfoConstdataService)Naming
						.lookup(URL.getURL(ServiceName.PRICEINFO.toString()));
				System.out.println("priceInfoConstdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				System.out.println("其他异常！！");
				e.printStackTrace();
				//进行RMI远程对象查找的时候，无法连接服务器
				//提示确认服务器已连接
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			}
		}
		return priceInfoConstdataService;
	}
}
