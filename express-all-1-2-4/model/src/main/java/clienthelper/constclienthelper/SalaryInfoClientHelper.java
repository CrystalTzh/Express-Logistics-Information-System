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
import dataservice.constdataservice.SalaryInfoConstdataService;
import po.SalaryPO;

/**
 * 在客户端，薪资标准信息建立RMI连接
 */
public class SalaryInfoClientHelper {
	SalaryInfoConstdataService salaryInfoConstdataService = null;
	
	/**
	 * 通过RMI远程更新薪资标准
	 * @param po
	 * @return
	 */
	public boolean goUpdate(SalaryPO po) {
		System.out.println("进入SalaryInfoClientHelper...goUpdate...");
		salaryInfoConstdataService = this.go();
		try {
			salaryInfoConstdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程查找薪资标准
	 * @return
	 */
	public SalaryPO goFind() {
		System.out.println("进入SalaryInfoClientHelper...goFind...");
		salaryInfoConstdataService = this.go();
		try {
			SalaryPO po = salaryInfoConstdataService.find();
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 客户端建立SalaryInfoConstdataService服务的RMI连接
	 * @return
	 */
	public SalaryInfoConstdataService go() {
		System.out.println("进入SalaryInfoClientHelper...go...");
		if(salaryInfoConstdataService == null) {
			try {
//				salaryInfoConstdataService = (SalaryInfoConstdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/salaryInfoConstdataService");
				salaryInfoConstdataService = (SalaryInfoConstdataService)Naming
						.lookup(URL.getURL(ServiceName.SALARYINFO.toString()));
				System.out.println("salaryInfoConstdataService RMI服务查找成功...");
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				System.out.println("URL格式错误！！");
				e.printStackTrace();
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				System.out.println("其他异常！！");
				e.printStackTrace();
			} catch (NotBoundException e) {
				// TODO Auto-generated catch block
				System.out.println("指定服务名称不存在！！");
				e.printStackTrace();
			}
		}
		return salaryInfoConstdataService;
	}
}

