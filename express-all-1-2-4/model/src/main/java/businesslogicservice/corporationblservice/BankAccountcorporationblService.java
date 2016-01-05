/**
 * 公司信息业务逻辑接口
 * @author 谭琼
 * 2015年12月4日
 */
package businesslogicservice.corporationblservice;

import java.util.ArrayList;

import vo.BankAccountInfoVO;

/**
 * 银行账户信息业务逻辑接口
 */
public interface BankAccountcorporationblService {
	
	/**
	 * 找到所有银行账户
	 * @return
	 */
	public ArrayList<BankAccountInfoVO> findAllBankAccouts();
	
	/**
	 * 根据银行账户的账号查找银行账户
	 * @param accountID
	 * @return 
	 */
	public BankAccountInfoVO find(String accountID);
	
//	/**
//	 * 根据银行账号关键字查找银行账户信息
//	 * @param keyID
//	 * @return
//	 */
//	public ArrayList<BankAccountInfoVO> keyFindBanAccount(String keyID);
	
	/**
	 * 添加银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean add(BankAccountInfoVO vo);
	
	/**
	 * 删除银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean delete(BankAccountInfoVO vo);
	
	/**
	 * 更新银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean update(BankAccountInfoVO vo);
	
}
