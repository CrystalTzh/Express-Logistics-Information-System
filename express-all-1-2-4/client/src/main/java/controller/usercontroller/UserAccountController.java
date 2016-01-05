/**
 * 用户信息控制器
 * @author 谭琼
 * 2015年12月3日
 */
package controller.usercontroller;

import java.util.ArrayList;

import businesslogic.userbl.UserAccountbl;
import state.UserRole;
import vo.UserAccountVO;

/**
 * 用户账户信息控制器 
 */
public class UserAccountController {
	
	UserAccountbl userAccountbl;
	
	/**
	 * 根据用户类型查找用户账户信息
	 * @param userRole
	 * @return
	 */
	public ArrayList<UserAccountVO> findAll(UserRole userRole) {
		System.out.println("进入UserAccountController...findUserAccount...");
		userAccountbl = new UserAccountbl();
		return userAccountbl.findAll(userRole);
	}
	
	/**
	 * 根据用户账号查找账户信息
	 * @param accountID
	 * @return
	 */
	public UserAccountVO findUserAccount(String accountID) {
		System.out.println("进入UserAccountController...findUserAccount...");
		userAccountbl = new UserAccountbl();
		UserAccountVO vo = userAccountbl.find(accountID);
		return vo;
	}
	
	/**
	 * 添加用户账户信息
	 * @param vo
	 * @return
	 */
	public boolean addUserAccount(UserAccountVO vo) {
		System.out.println("进入UserAccountController...addUserAccount...");
		userAccountbl = new UserAccountbl();
		if(userAccountbl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除用户账户信息
	 * @param vo
	 * @return
	 */
	public boolean deleteUserAccount(UserAccountVO vo) {
		System.out.println("进入UserAccountController...deleteUserAccount...");
		userAccountbl = new UserAccountbl();
		if(userAccountbl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改账户信息
	 * @param vo
	 * @return
	 */
	public boolean mofifyUserAccount(UserAccountVO vo) {
		System.out.println("进入UserAccountController...mofifyUserAccount...");
		userAccountbl = new UserAccountbl();
		if(userAccountbl.update(vo)) {
			return true;
		}
		return false;
	}
}
