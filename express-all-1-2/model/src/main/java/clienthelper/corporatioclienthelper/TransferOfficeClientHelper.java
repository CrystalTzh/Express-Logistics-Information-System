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
import dataservice.corporationdataservice.TransferOfficeCorporationdataService;
import po.TransferOfficePO;
import state.City;

/**
 * 在客户端，中转中心建立RMI连接
 */
public class TransferOfficeClientHelper {
	
	TransferOfficeCorporationdataService transferOfficeCorporationdataService = null;
	
	/**
	 * 查找某城市的所有中转中心
	 * @param city
	 * @return
	 */
	public ArrayList<TransferOfficePO> goFindAll(City city) {
		System.out.println("进入TransferOfficeClientHelper...findAll...");
		transferOfficeCorporationdataService = go();
		try {
			return transferOfficeCorporationdataService.findAll(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 远程获得下一个中转中心编号
	 * @param city
	 * @return
	 */
	public String goGetNextTransferOfficeID(City city) {
		System.out.println("进入TransferOfficeClientHelper...goGetNextTransferOfficeID...");
		transferOfficeCorporationdataService = go();
		try {
			return transferOfficeCorporationdataService.getNextTransferOfficeID(city);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 通过RMI远程更新中转中心信息
	 * @return
	 */
	public boolean goUpdate(TransferOfficePO po) {
		System.out.println("进入TransferOfficeClientHelper...goUpdate...");
		transferOfficeCorporationdataService = go();
		try {
			transferOfficeCorporationdataService.update(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程删除中转中心信息
	 * @param po
	 * @return
	 */
	public boolean goDelete(TransferOfficePO po) {
		System.out.println("进入TransferOfficeClientHelper...goDelete...");
		transferOfficeCorporationdataService = go();
		try {
			transferOfficeCorporationdataService.delete(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过RMI远程增加中转中心信息
	 * @param po
	 * @return
	 */
	public boolean goInsert(TransferOfficePO po) {
		System.out.println("进入TransferOfficeClientHelper...goInsert...");
		transferOfficeCorporationdataService = go();
		try {
			transferOfficeCorporationdataService.add(po);
			return true;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * 通过中转中心编号transferOfficeID远程查找中转中心信息
	 * @param transferOfficeID
	 * @return
	 */
	public TransferOfficePO goFind(String transferOfficeID) {
		System.out.println("进入TransferOfficeClientHelper...goFind...");
		transferOfficeCorporationdataService = go();
		TransferOfficePO po;
		try {
			po = transferOfficeCorporationdataService.find(transferOfficeID);
			return po;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 客户端建立transferOfficeCorporationdataService服务的RMI连接
	 * @return
	 */
	public TransferOfficeCorporationdataService go() {
		System.out.println("进入TransferOfficeClientHelper...go...");
		if(transferOfficeCorporationdataService == null) {
			try {
//				transferOfficeCorporationdataService = (TransferOfficeCorporationdataService)Naming
//						.lookup("rmi://127.0.0.1:32004/transferOfficeCorporationdataService");
				transferOfficeCorporationdataService = (TransferOfficeCorporationdataService)Naming
						.lookup(URL.getURL(ServiceName.TRANSFEROFFICE.toString()));
				System.out.println("transferOfficeCorporationdataService RMI服务查找成功...");
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
		return transferOfficeCorporationdataService;
	}
	
	public static void main(String[] args) {
		TransferOfficeClientHelper transfer = new TransferOfficeClientHelper();
		ArrayList<TransferOfficePO> a = transfer.goFindAll(City.BEIJING);
		for(int i = 0;i<a.size();i++){
			System.out.println(a.get(i).getTransferOfficeID());
		}
	}
}



