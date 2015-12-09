/**
 * 公司常量信息业务逻辑
 * @author 谭琼
 * 2015年12月4日
 */
package businesslogic.constbl;

import businesslogicservice.constblservice.SalaryInfoConstblService;
import clienthelper.constclienthelper.SalaryInfoClientHelper;
import po.SalaryPO;
import vo.SalaryVO;

/**
 * 薪资标准业务逻辑
 */
public class SalaryInfobl implements SalaryInfoConstblService{

	SalaryInfoClientHelper salaryInfoClientHelper = new SalaryInfoClientHelper();
	
	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.SalaryInfoConstblService#find()
	 */
	public SalaryVO find(){
		// TODO Auto-generated method stub
		System.out.println("进入SalaryInfoImpl...findSalary...");
		SalaryPO po = salaryInfoClientHelper.goFind();
		//将po包装为vo
		if(po != null) {
			SalaryVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.SalaryInfoConstblService#update(vo.ConstInfoVO)
	 */
	public boolean update(SalaryVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入SalaryInfoImpl...updateSalary...");
		SalaryPO po = this.wrappVOtoPO(vo);
		if(salaryInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}

	/**
	 * 将薪资标准信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public SalaryVO wrappPOtoVO(SalaryPO po) {
		SalaryVO vo = new SalaryVO();
		vo.setDriverInCityPay(po.getDriverInCityPay());
		vo.setDriverOutCityPay(po.getDriverOutCityPay());
		vo.setOfficeManSalary(po.getOfficeManSalary());
		vo.setReceiveOrderBonus(po.getReceiveOrderBonus());
		vo.setSendOrderBonus(po.getSendOrderBonus());
		return vo;
	}
	
	/**
	 * 将薪资标准信息的VO包装为PO
	 * @param vo
	 * @return
	 */
	public SalaryPO wrappVOtoPO(SalaryVO vo) {
		SalaryPO po = new SalaryPO();
		po.setDriverInCityPay(vo.getDriverInCityPay());
		po.setDriverOutCityPay(vo.getDriverOutCityPay());
		po.setOfficeManSalary(vo.getOfficeManSalary());
		po.setReceiveOrderBonus(vo.getReceiveOrderBonus());
		po.setSendOrderBonus(vo.getSendOrderBonus());
		return po;
	}
	
}
