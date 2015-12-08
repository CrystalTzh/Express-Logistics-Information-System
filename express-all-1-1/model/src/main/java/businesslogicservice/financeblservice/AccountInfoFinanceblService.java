package businesslogicservice.financeblservice;

import po.BankAccountInfoPO;

public interface AccountInfoFinanceblService {
	public BankAccountInfoPO create();
	public boolean add(BankAccountInfoPO vo);
	public boolean delete(BankAccountInfoPO vo);
	public BankAccountInfoPO find(long bankAccount);
	
	public BankAccountInfoPO add(long bankAccount,int password);
}
