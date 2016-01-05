package businesslogic.stub.userblStub;

import java.util.ArrayList;

import businesslogicservice.userblservice.UserAccountuserblService;
import state.UserRole;
import vo.UserAccountVO;

public class UserInfoUserblStub implements UserAccountuserblService {

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#create()
	 */
	public UserAccountVO create() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#add(vo.UserAccountVO)
	 */
	public boolean add(UserAccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#delete(vo.UserAccountVO)
	 */
	public boolean delete(UserAccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#find(java.lang.String)
	 */
	public UserAccountVO find(String accountID) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.userblservice.UserAccountuserblService#update(vo.UserAccountVO)
	 */
	public boolean update(UserAccountVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<UserAccountVO> findAll(UserRole userRole) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
