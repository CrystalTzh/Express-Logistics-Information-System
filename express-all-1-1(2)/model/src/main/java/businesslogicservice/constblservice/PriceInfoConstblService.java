/**
 * 公司常量信息业务逻辑接口
 * @author 谭琼
 * 2015年12月8日
 */
package businesslogicservice.constblservice;

import vo.PriceVO;

/**
 * 价格常量信息业务逻辑接口
 */
public interface PriceInfoConstblService {
	
	/**
	 * 查找价格常量
	 * @return
	 */
	public PriceVO find();
	
	/**
	 * 更新价格常量
	 * @param vo
	 * @return
	 */
	public boolean update(PriceVO vo);
}
