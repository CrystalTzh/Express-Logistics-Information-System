/**
 * 公司常量信息控制器
 * @author 谭琼
 * 2015年12月4日
 */
package controller.constcontroller;

import businesslogic.constbl.SalaryInfobl;
import vo.SalaryVO;

/**
 * 薪资标准信息控制器
 */
public class SalaryInfoController {
	
	/**
	 * 查找薪资标准信息
	 * @return
	 */
	public SalaryVO findSalayInfo() {
		System.out.println("进入SalaryInfoController...findSalaryInfo...");
		SalaryInfobl salaryInfobl = new SalaryInfobl();
		SalaryVO vo = salaryInfobl.find();
		return vo;
	}
	
	/**
	 * 修改薪资标准信息
	 * @param vo
	 * @return
	 */
	public boolean modifySalaryInfo(SalaryVO vo) {
		System.out.println("进入SalaryInfoController...modifySalaryInfo...");
		SalaryInfobl salaryInfobl = new SalaryInfobl();
		if(salaryInfobl.update(vo)) {
			return true;
		}
		return false;
	}
}
