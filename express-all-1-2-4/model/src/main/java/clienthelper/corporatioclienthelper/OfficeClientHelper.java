/**
 * @author 谭琼
 * 2015年12月14日
 */
package clienthelper.corporatioclienthelper;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

import RMIHelper.ServiceName;
import RMIHelper.URL;
import dataservice.corporationdataservice.OfficeCorporationdataService;
import po.OfficePO;
import state.City;

/**
 * 在客户端，中转中心建立RMI连接
 */
public class OfficeClientHelper {
	
	OfficeCorporationdataService officeCorporationdataService = null;
	
	public ArrayList<OfficePO> goFindAll(City city) {
		System.out.println("进入OfficeClientHelper...findAll...");
		officeCorporationdataService = go();
		try {
			return officeCorporationdataService.findAll(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程获得下一个营业厅编号
	 * @param city
	 * @return
	 */
	public String goGetNextOfficeID(City city) {
		System.out.println("进入OfficeClientHelper...goGetNextOfficeID...");
		officeCorporationdataService = go();
		try {
			return officeCorporationdataService.getNextOfficeID(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程更新营业厅信息
	 * @param officeID
	 * @return
	 */
	public boolean goUpdate(OfficePO po) {
		System.out.println("进入OfficeClientHelper...goUpdate...");
		officeCorporationdataService = go();
		try {
			officeCorporationdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程删除营业厅信息
	 * @param po
	 * @return
	 */
	public boolean goDelete(OfficePO po) {
		System.out.println("进入OfficeClientHelper...goDelete...");
		officeCorporationdataService = go();
		try {
			officeCorporationdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程添加营业厅信息
	 * @param po
	 * @return
	 */
	public boolean goInsert(OfficePO po) {
		System.out.println("进入OfficeClientHelper...goInsert...");
		officeCorporationdataService = go();
		try {
			officeCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 远程查找营业厅信息
	 * @param officeID
	 * @return
	 */
	public OfficePO goFind(String officeID) {
		System.out.println("进入OfficeClientHelper...goFind...");
		officeCorporationdataService = go();
		OfficePO po;
		try {
			po = officeCorporationdataService.find(officeID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 客户端建立officeCorporationdataService服务的RMI连接
	 * @return
	 */
	public OfficeCorporationdataService go() {
		System.out.println("进入OfficeClientHelper...go...");
		if(officeCorporationdataService == null) {
			try {
//				officeCorporationdataService = (OfficeCorporationdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/officeCorporationdataService");
				officeCorporationdataService = (OfficeCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.OFFICE.toString()));
				System.out.println("officeCorporationdataService RMI服务查找成功...");
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
		return officeCorporationdataService;
	}
}
