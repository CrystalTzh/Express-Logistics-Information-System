/**
 * 公司常量信息控制器
 * @author 谭琼
 * 2015年12月4日
 */
package controller.constcontroller;

import businesslogic.constbl.PriceInfobl;
import vo.PriceVO;

/**
 * 价格常量信息控制器
 */
public class PriceInfoController {
	/**
	 * 查找价格常量信息
	 * @return
	 */
	public PriceVO findSalayInfo() {
		System.out.println("进入PriceInfoController...findPriceInfo...");
		PriceInfobl priceInfobl = new PriceInfobl();
		PriceVO vo = priceInfobl.find();
		return vo;
	}
	
	/**
	 * 修改价格常量信息
	 * @param vo
	 * @return
	 */
	public boolean modifySalaryInfo(PriceVO vo) {
		System.out.println("进入PriceInfoController...modifyPriceInfo...");
		PriceInfobl priceInfobl = new PriceInfobl();
		if(priceInfobl.update(vo)) {
			return true;
		}
		return false;
	}
}
