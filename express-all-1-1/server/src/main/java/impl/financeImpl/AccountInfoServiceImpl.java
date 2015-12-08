package impl.financeImpl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.financedataservice.BankAccountInfodataService;
import po.BankAccountInfoPO;


public class AccountInfoServiceImpl extends UnicastRemoteObject implements BankAccountInfodataService{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @throws RemoteException
	 */
	protected AccountInfoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BankAccountInfodataService#find(long)
	 */
	public BankAccountInfoPO find(long bankAccount) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BankAccountInfodataService#insert(po.BankAccountInfoPO)
	 */
	public void insert(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BankAccountInfodataService#delete(po.BankAccountInfoPO)
	 */
	public void delete(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BankAccountInfodataService#update(po.BankAccountInfoPO)
	 */
	public void update(BankAccountInfoPO po) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

}
