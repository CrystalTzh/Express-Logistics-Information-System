/**
 * 公司常量信息业务逻辑接口
 * @author 谭琼
 * 2015年12月8日
 */
package businesslogicservice.constblservice;

import vo.SalaryVO;

/**
 * 薪资标准信息业务逻辑接口
 */
public interface SalaryInfoConstblService{
	
	/**
	 * 查找薪资标准
	 * @return
	 */
	public SalaryVO find();
	
	/**
	 * 更新薪资标准
	 * @param vo
	 * @return
	 */
	public boolean update(SalaryVO vo);
}
