/**
 * @author 谭琼
 * 2015年12月14日
 */
package controller.corporationcontroller;

import java.util.ArrayList;

import businesslogic.corporationbl.TransferOfficeInfobl;
import state.City;
import vo.TransferOfficeVO;

/**
 * 中转中心信息控制器
 */
public class TransferOfficeInfoController {
	
	/**
	 * 查找某一城市的所有中转中心
	 * @param city
	 * @return
	 */
	public ArrayList<TransferOfficeVO> findAll(City city) {
		System.out.println("进入TransferOfficeInfoController...findAll...");
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		return transferOfficeInfobl.findAll(city);
	}
	
	
	public ArrayList<TransferOfficeVO> sortByIDs(ArrayList<TransferOfficeVO> transferOfficeInfo) {
		for(int i = 0; i < transferOfficeInfo.size(); i++) {
			for(int j = 0; j < transferOfficeInfo.size()-1-i; j++) {
				String id1 = transferOfficeInfo.get(j).getTransferOfficeID();
				String id2 = transferOfficeInfo.get(j+1).getTransferOfficeID();
				int num1 = Integer.parseInt(id1.substring(3));
				int num2 = Integer.parseInt(id2.substring(3));
				if(num1 > num2) {
					TransferOfficeVO temp = transferOfficeInfo.get(j);
					transferOfficeInfo.set(j, transferOfficeInfo.get(j+1));
					transferOfficeInfo.set(j+1, temp);
				}
			}
		}
		return transferOfficeInfo;
	}
	
	/**
	 * 根据城市获取下一个中转中心编号
	 * @param city
	 * @return
	 */
	public String getNextTransferOffceID(City city) {
		System.out.println("进入TransferOfficeInfoController...getNextTransferOffceID...");
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		return transferOfficeInfobl.getNextOffceID(city);
	}
	
	/**
	 * 根据中转中心编号查找中转中心信息
	 * @param transferOfficeID
	 * @return
	 */
	public TransferOfficeVO findTransferOffice(String transferOfficeID) {
		System.out.println("进入TransferOfficeInfoController...findTransferOffice...");
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		TransferOfficeVO vo = transferOfficeInfobl.find(transferOfficeID);
		return vo;
	}
	
	/**
	 * 添加中转中心信息
	 * @param vo
	 * @return
	 */
	public boolean addTransferOffice(TransferOfficeVO vo) {
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		System.out.println("进入TransferOfficeInfoController...addTransferOffice...");
		if(transferOfficeInfobl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除中转中心信息
	 * @param vo
	 * @return
	 */
	public boolean deleteTransferOffice(TransferOfficeVO vo) {
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		System.out.println("进入TransferOfficeInfoController...deleteTransferOffice...");
		if(transferOfficeInfobl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改中转中心的信息
	 * @param vo
	 * @return
	 */
	public boolean modifyTransferOffice(TransferOfficeVO vo) {
		TransferOfficeInfobl transferOfficeInfobl = new TransferOfficeInfobl();
		System.out.println("进入TransferOfficeInfoController...modifyTransferOffice...");
		if(transferOfficeInfobl.update(vo)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		TransferOfficeInfoController transferOfficeInfoController = new TransferOfficeInfoController();
//		String next = transferOfficeInfoController.getNextTransferOffceID(City.BEIJING);
//		TransferOfficeVO vo = new TransferOfficeVO(City.BEIJING, next);
//		transferOfficeInfoController.addTransferOffice(vo);
		
//		transferOfficeInfoController.deleteTransferOffice(vo);
//		transferOfficeInfoController.findTransferOffice("0101");
		ArrayList<TransferOfficeVO> a = transferOfficeInfoController.findAll(City.BEIJING);
		for(int i = 0;i<a.size();i++){
			System.out.println("beijing");
			System.out.println(a.get(i).getTransferOfficeID());
		}
		
	}

}
