/**
 * 用户模块业务逻辑层接口
 * @author 谭琼
 */
package businesslogicservice.userblservice;

import java.util.ArrayList;

import state.UserRole;
import vo.UserAccountVO;

/**
 * 用户账户信息业务逻辑层接口
 */
public interface UserAccountuserblService {
	
	/**
	 * 查找特定职位的所有用户账号
	 * @param userRole
	 * @return
	 */
	public ArrayList<UserAccountVO> findAll(UserRole userRole);
	
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
