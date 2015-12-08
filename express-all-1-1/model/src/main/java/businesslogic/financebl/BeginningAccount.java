package businesslogic.financebl;

import java.util.ArrayList;

import businesslogicservice.financeblservice.BeginningAccountFinanceblService;
import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.UserAccountPO;

public class BeginningAccount implements BeginningAccountFinanceblService{

	/* (non-Javadoc)
	 * @see businesslogicservice.financeblservice.BeginningAccountFinanceblService#initAccounts(int, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList, java.util.ArrayList)
	 */
	public boolean initAccounts(int year, ArrayList<UserAccountPO> userInfopo, ArrayList<CarInfoPO> carInfopo,
			ArrayList<DriverInfoPO> driverInfopo, ArrayList<BankAccountInfoPO> accountInfopo) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
