/**
 * @author 谭琼
 * 2015年12月14日
 */
package controller.corporationcontroller;

import java.util.ArrayList;

import businesslogic.corporationbl.OfficeInfobl;
import state.BeiJingDistrict;
import state.City;
import vo.OfficeVO;

/**
 * 营业厅信息控制器
 */
public class OfficeInfoController {
	
	/**
	 * 查找某一城市的所有营业厅
	 * @param city
	 * @return
	 */
	public ArrayList<OfficeVO> findAll(City city) {
		System.out.println("进入OfficeInfoController...findAll...");
		OfficeInfobl officeInfobl = new OfficeInfobl();
		return officeInfobl.findAll(city);
	}
	
	/**
	 * 根据编号排序
	 * @param officeInfo
	 * @return
	 */
	public ArrayList<OfficeVO> sortByIDs(ArrayList<OfficeVO> officeInfo) {
		System.out.println(officeInfo.size());
		for(int i = 0; i < officeInfo.size(); i++) {
			for(int j = 0; j < officeInfo.size()-1-i; j++) {
				String id1 = officeInfo.get(j).getOfficeID();
				String id2 = officeInfo.get(j+1).getOfficeID();
				int num1 = Integer.parseInt(id1.substring(3));
				int num2 = Integer.parseInt(id2.substring(3));
				if(num1 > num2) {
					OfficeVO temp = officeInfo.get(j);
					officeInfo.set(j, officeInfo.get(j+1));
					officeInfo.set(j+1, temp);
				}
			}
		}
		return officeInfo;
	}
	
	/**
	 * 根据城市获取下一个营业厅编号
	 * @param city
	 * @return
	 */
	public String getNextOfficeID(City city) {
		System.out.println("进入OfficeInfoController...getNextOfficeID...");
		OfficeInfobl officeInfobl = new OfficeInfobl();
		return officeInfobl.getNextOfficeID(city);
	}
	
	/**
	 * 根据营业厅编号查找营业厅信息
	 * @param officeID
	 * @return
	 */
	public OfficeVO findOffice(String officeID) {
		System.out.println("进入OfficeInfoController...findOffice...");
		OfficeInfobl officeInfobl = new OfficeInfobl();
		OfficeVO vo = officeInfobl.find(officeID);
		return vo;
	}
	
	/**
	 * 添加营业厅信息
	 * @param vo
	 * @return
	 */
	public boolean addOffice(OfficeVO vo) {
		OfficeInfobl officeInfobl = new OfficeInfobl();
		System.out.println("进入OfficeInfoController...addOffice...");
		if(officeInfobl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除营业厅信息
	 * @param vo
	 * @return
	 */
	public boolean deleteOffice(OfficeVO vo) {
		OfficeInfobl officeInfobl = new OfficeInfobl();
		System.out.println("进入OfficeInfoController...deleteOffice...");
		if(officeInfobl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改营业厅的信息
	 * @param vo
	 * @return
	 */
	public boolean modifyOffice(OfficeVO vo) {
		OfficeInfobl officeInfobl = new OfficeInfobl();
		System.out.println("进入OfficeInfoController...modifyOffice...");
		if(officeInfobl.update(vo)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		OfficeInfoController officeInfoController = new OfficeInfoController();
//		String next = officeInfoController.getNextOfficeID(City.BEIJING);
		ArrayList<OfficeVO> beiJingOffice = new ArrayList<OfficeVO>();
		OfficeVO vo1 = new OfficeVO(City.BEIJING, BeiJingDistrict.ChangPing);
		vo1.setOfficeID(officeInfoController.getNextOfficeID(City.BEIJING));
		OfficeVO vo2= new OfficeVO(City.BEIJING, BeiJingDistrict.ChangPing);
		vo2.setOfficeID(officeInfoController.getNextOfficeID(City.BEIJING));
		OfficeVO vo3 = new OfficeVO(City.BEIJING, BeiJingDistrict.ChangPing);
		vo3.setOfficeID(officeInfoController.getNextOfficeID(City.BEIJING));
		beiJingOffice.add(vo3);
		beiJingOffice.add(vo1);
		beiJingOffice.add(vo2);
		System.out.println("排序后：");
		ArrayList<OfficeVO> newOfficeVOs = officeInfoController.sortByIDs(beiJingOffice);
		for(int i = 0; i < newOfficeVOs.size(); i++) {
			System.out.println(newOfficeVOs.get(i).getOfficeID());
		}
//		beiJingOffice = officeInfoController.findAll(City.BEIJING);
//		System.out.println(next);
	}
}
