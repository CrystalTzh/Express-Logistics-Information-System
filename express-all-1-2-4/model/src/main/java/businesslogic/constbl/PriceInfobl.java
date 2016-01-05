/**
 * 公司常量信息业务逻辑
 * @author 谭琼
 * 2015年12月8日
 */
package businesslogic.constbl;

import businesslogicservice.constblservice.PriceInfoConstblService;
import clienthelper.constclienthelper.PriceInfoClientHelper;
import po.PricePO;
import vo.PriceVO;

/**
 * 价格常量业务逻辑
 */
public class PriceInfobl implements PriceInfoConstblService{

	PriceInfoClientHelper priceInfoClientHelper = new PriceInfoClientHelper();
	
	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.PriceInfoConstblService#find()
	 */
	public PriceVO find() {
		// TODO Auto-generated method stub
		System.out.println("进入PriceInfobl...findPrice...");
		PricePO po = priceInfoClientHelper.goFind();
		if(po != null) {
			PriceVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.PriceInfoConstblService#update(vo.PriceVO)
	 */
	public boolean update(PriceVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入PriceInfobl...updatePrice...");
		PricePO po = this.wrappVOtoPO(vo);
		if(priceInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将价格常量信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public PriceVO wrappPOtoVO(PricePO po) {
		PriceVO vo = new PriceVO();
		vo.setPrice(po.getPrice());
		return vo;
	}
	
	/**
	 * 将价格常量信息的VO包装为PO
	 * @param vo
	 * @return
	 */
	public PricePO wrappVOtoPO(PriceVO vo) {
		PricePO po = new PricePO();
		po.setPrice(vo.getPrice());
		return po;
	}
	
}
