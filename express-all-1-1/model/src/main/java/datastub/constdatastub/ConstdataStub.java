package datastub.constdatastub;

import java.rmi.RemoteException;

import businesslogicservice.constblservice.ConstInfoConstblService;
import vo.ConstInfoVO;

public class ConstdataStub implements ConstInfoConstblService {

	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.ConstInfoConstblService#find()
	 */
	public ConstInfoVO find() throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.constblservice.ConstInfoConstblService#update(vo.ConstInfoVO)
	 */
	public ConstInfoVO update(ConstInfoVO vo) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		return null;
	}


}
