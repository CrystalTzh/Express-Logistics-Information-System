package businesslogicservice.financeblservice;

import java.util.ArrayList;

import po.BankAccountInfoPO;
import po.CarInfoPO;
import po.DriverInfoPO;
import po.UserAccountPO;

public interface BeginningAccountFinanceblService {

	public boolean initAccounts (int year, ArrayList<UserAccountPO> userInfopo,
			ArrayList< CarInfoPO > carInfopo ,
			ArrayList< DriverInfoPO > driverInfopo ,
			ArrayList<BankAccountInfoPO> accountInfopo);
}
