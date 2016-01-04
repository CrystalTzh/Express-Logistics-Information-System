package datastub.financedatastub;


import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Hashtable;

import dataservice.financedataservice.BeginningAccountdataService;
import po.BankAccountInfoPO;
import po.BeginningAccountPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.InventoryInfoPO;
import po.OfficePO;
import po.TransferOfficePO;
import po.UserAccountPO;
import state.City;
import state.UserRole;

public class BeginningAccountdataStub implements BeginningAccountdataService{

	public BeginningAccountPO find(int year) throws RemoteException {
		// TODO Auto-generated method stub
//		System.out.println("Find Succeed!\n");
//		BeginningAccountPO po=new BeginningAccountPO(1024, null, null, null, null);
//		return po;
		return null;
	}

	public void insert(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Succeed!\n");
		
	}

	public void delete(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Delete Succeed!\n");
		
	}

	public void update(BeginningAccountPO po) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Update Succeed!\n");
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncOffice()
	 */
	public void syncOffice() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncTransferOffice()
	 */
	public void syncTransferOffice() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncInventory()
	 */
	public void syncInventory() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncDriver()
	 */
	public void syncDriver() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncCar()
	 */
	public void syncCar() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncUserAccount()
	 */
	public void syncUserAccount() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#syncBankAccount()
	 */
	public void syncBankAccount() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllOfficeInfo()
	 */
	public Hashtable<City, ArrayList<OfficePO>> findAllOfficeInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllTransferOfficeInfo()
	 */
	public Hashtable<City, ArrayList<TransferOfficePO>> findAllTransferOfficeInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllInventoryInfo()
	 */
	public ArrayList<InventoryInfoPO> findAllInventoryInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllDriverInfo()
	 */
	public ArrayList<DriverInfoPO> findAllDriverInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAlCarInfo()
	 */
	public ArrayList<CarInfoPO> findAlCarInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}


	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllBankAccountInfo()
	 */
	public ArrayList<BankAccountInfoPO> findAllBankAccountInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see dataservice.financedataservice.BeginningAccountdataService#findAllUserAccountInfo()
	 */
	public Hashtable<UserRole, ArrayList<UserAccountPO>> findAllUserAccountInfo() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
