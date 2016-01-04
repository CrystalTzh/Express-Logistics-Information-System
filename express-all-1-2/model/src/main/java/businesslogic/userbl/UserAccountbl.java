/**
 * 用户信息业务逻辑
 * @author 谭琼
 * 2015年12月3日
 */
package businesslogic.userbl;

import java.util.ArrayList;

import businesslogicservice.userblservice.UserAccountuserblService;
import clienthelper.useraccountclienthelper.UserAccountClientHelper;
import po.UserAccountPO;
import state.UserRole;
import vo.UserAccountVO;

/**
 * 用户账户信息业务逻辑
 */
public class UserAccountbl implements UserAccountuserblService{
	
	UserAccountClientHelper userAccountClientHelper = new UserAccountClientHelper();
	
	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#findAll(state.UserRole)
	 */
	public ArrayList<UserAccountVO> findAll(UserRole userRole) {
		System.out.println("进入UserAccountbl...findAll...");
		ArrayList<UserAccountPO> allUsersPO = userAccountClientHelper.goFindAll(userRole);
		if(allUsersPO.size() == 0) {return null;}
		ArrayList<UserAccountVO> allUsersVO = new ArrayList<UserAccountVO>();
		for(int i = 0; i < allUsersPO.size(); i++) {
			UserAccountVO vo = this.wrappPOtoVO(allUsersPO.get(i));
			allUsersVO.add(vo);
		}
		return allUsersVO;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#add(vo.UserAccountVO)
	 */
	public boolean add(UserAccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountbl...addUserAccount...");
		UserAccountPO po = this.wrappVOtoPO(vo);
		if(userAccountClientHelper.goInsert(po)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#delete(vo.UserAccountVO)
	 */
	public boolean delete(UserAccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountbl...deleteUserAccount...");
		UserAccountPO po = this.wrappVOtoPO(vo);
		if(userAccountClientHelper.goDelete(po)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#find(long)
	 */
	public UserAccountVO find(String accountID) {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountbl...findUserAccount...");
		UserAccountPO po = userAccountClientHelper.goFind(accountID);
		if(po != null) {
			UserAccountVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#update(vo.UserAccountVO)
	 */
	public boolean update(UserAccountVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入UserAccountbl...updateUserAccount...");
		UserAccountPO po = this.wrappVOtoPO(vo);
		if(userAccountClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}

	/**
	 * 将用户账户信息的PO包装成VO
	 * @param po
	 * @return
	 */
	public UserAccountVO wrappPOtoVO(UserAccountPO po) {
		UserAccountVO vo = new UserAccountVO();
		vo.setAccountID(po.getUserAccountID());
		vo.setInitialPassword(po.getInitialPassword());
		vo.setPassword(po.getPassword());
		vo.setUserName(po.getUserName());
		vo.setUserRole(po.getUserRole());
		return vo;
	}
	
	/**
	 * 将用户账户信息的VO包装成PO
	 * @param vo
	 * @return
	 */
	public UserAccountPO wrappVOtoPO(UserAccountVO vo) {
		UserAccountPO po = new UserAccountPO();
		po.setInitialPassword(vo.getInitialPassword());
		po.setPassword(vo.getPassword());
		po.setUserAccountID(vo.getAccountID());
		po.setUserName(vo.getUserName());
		po.setUserRole(vo.getUserRole());
		return po;
	}

}
