package businesslogicservice.constblservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import vo.ConstInfoVO;

public interface ConstInfoConstblService extends Remote {
	
	public ConstInfoVO find() throws RemoteException, IllegalArgumentException;
	
	public ConstInfoVO update(ConstInfoVO vo) throws RemoteException, IllegalArgumentException;
}
