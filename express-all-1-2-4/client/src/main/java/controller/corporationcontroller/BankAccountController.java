/**公司信息控制器
 * @author 谭琼
 * 2015年12月4日
 */
package controller.corporationcontroller;

import java.util.ArrayList;

import businesslogic.corporationbl.BankAccountbl;
import vo.BankAccountInfoVO;

/**
 * 银行账户信息控制器
 */
public class BankAccountController {
	
	/**
	 * 找到所有银行账户
	 * @return
	 */
	public ArrayList<BankAccountInfoVO> findAllBankAccounts() {
		System.out.println("进入BankAccountController...findAllBankAccounts...");
		BankAccountbl bankAccountbl = new BankAccountbl();
		return bankAccountbl.findAllBankAccouts();
	}
	
	/**
	 * 根据银行账户的账号查找银行账户信息
	 * @param accountID
	 * @return
	 */
	public BankAccountInfoVO findBankAccount(String accountID) {
		System.out.println("进入BankAccountController...findBankAccount...");
		BankAccountbl bankAccountbl = new BankAccountbl();
		BankAccountInfoVO vo = bankAccountbl.find(accountID);
		return vo;
	}
	
	/**
	 * 根据银行账号关键字查找银行账户信息
	 * @param keyID
	 * @return
	 */
	public ArrayList<BankAccountInfoVO> keyFindBanAccount(String keyID) {
		System.out.println("进入BankAccountController...keyFindBanAccount...");
		return null;
	}
	
	/**
	 * 添加银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean addBankAccount(BankAccountInfoVO vo) {
		System.out.println("进入BankAccountController...addBankAccount...");
		BankAccountbl bankAccountbl = new BankAccountbl();
		if(bankAccountbl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean deleteAccount(BankAccountInfoVO vo) {
		System.out.println("进入BankAccountController...deleteBankAccount...");
		BankAccountbl bankAccountbl = new BankAccountbl();
		if(bankAccountbl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改银行账户信息
	 * @param vo
	 * @return
	 */
	public boolean modifyBankAccount(BankAccountInfoVO vo) {
		System.out.println("进入BankAccountController...modifyBankAccount...");
		BankAccountbl bankAccountbl = new BankAccountbl();
		if(bankAccountbl.update(vo)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		BankAccountController controller = new BankAccountController();
		ArrayList<BankAccountInfoVO> allBankAccounts = controller.findAllBankAccounts();
		if(allBankAccounts == null) {System.out.println("还没有银行账户...");}
		else {
			System.out.println("所有银行账户的账号如下:");
			for(int i = 0; i < allBankAccounts.size(); i++) {
				System.out.println(allBankAccounts.get(i).getAccountId());
			}
		}
	}
}
