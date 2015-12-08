/**
 * 用户模块业务逻辑层接口
 * @author 谭琼
 */
package businesslogicservice.userblservice;

import vo.UserAccountVO;

/**
 * 用户账户信息业务逻辑层接口
 */
public interface UserAccountuserblService {
	
	public UserAccountVO create();
	
	/**
	 * 添加用户账户信息
	 * @param vo
	 * @return
	 */
	public boolean add(UserAccountVO vo);
	
	/**
	 * 删除用户账户信息
	 * @param vo
	 * @return
	 */
	public boolean delete(UserAccountVO vo);
	
	/**
	 * 根据用户账号查找用户账户信息
	 * @param accountID
	 * @return
	 */
	public UserAccountVO find(String accountID);
	
	/**
	 * 更新用户账户信息
	 * @param vo
	 * @return
	 */
	public boolean update(UserAccountVO vo);
}
