/**
 * @author 谭琼
 * 2015年12月4日
 */
package businesslogic.corporationbl;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.BankAccountcorporationblService;
import clienthelper.corporatioclienthelper.BankAccountClientHelper;
import po.BankAccountInfoPO;
import vo.BankAccountInfoVO;

public class BankAccountbl implements BankAccountcorporationblService{

	BankAccountClientHelper bankAccountClientHelper = new BankAccountClientHelper();
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.BankAccountcorporationblService#find(java.lang.String)
	 */
	public BankAccountInfoVO find(String accountID) {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountbl...findBankAccount...");
		BankAccountInfoPO po = bankAccountClientHelper.goFind(accountID);
		//将PO包装成VO
		if(po != null) {
			BankAccountInfoVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.BankAccountcorporationblService#keyFindBanAccount(java.lang.String)
	 */
	public ArrayList<BankAccountInfoVO> keyFindBanAccount(String keyID) {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountbl...keyFindBanAccount...");
		ArrayList<BankAccountInfoPO> listPO = bankAccountClientHelper.gokeyFind(keyID);
		ArrayList<BankAccountInfoVO> listVO = new ArrayList<BankAccountInfoVO> ();
		for(BankAccountInfoPO po : listPO) {//逐一进行遍历，将PO包装为对应的VO
			BankAccountInfoVO vo = this.wrappPOtoVO(po);
			listVO.add(vo);
		}
		return listVO;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.BankAccountcorporationblService#add(po.BankAccountInfoPO)
	 */
	public boolean add(BankAccountInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountbl...addBankAccount...");
		BankAccountInfoPO po = wrappVOtoPO(vo);
		if(bankAccountClientHelper.goInsert(po)) {//建立RMI连接
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.BankAccountcorporationblService#delete(po.BankAccountInfoPO)
	 */
	public boolean delete(BankAccountInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountbl...deleteBankAccount...");
		BankAccountInfoPO po = wrappVOtoPO(vo);
		if(bankAccountClientHelper.goDelete(po)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.BankAccountcorporationblService#update(po.BankAccountInfoPO)
	 */
	public boolean update(BankAccountInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入BankAccountbl...updateBankAccount...");
		BankAccountInfoPO po = wrappVOtoPO(vo);
		if(bankAccountClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将银行账户信息的VO持久化对象包装为PO
	 * @param vo
	 * @return
	 */
	public BankAccountInfoPO wrappVOtoPO(BankAccountInfoVO vo) {
		BankAccountInfoPO po = new BankAccountInfoPO();
		po.setAccountId(vo.getAccountId());
		po.setAccountName(vo.getAccountName());
		po.setBalance(vo.getBalance());
		return po;
	}
	
	/**
	 * 将银行账户信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public BankAccountInfoVO  wrappPOtoVO(BankAccountInfoPO po) {
		BankAccountInfoVO vo = new BankAccountInfoVO();
		vo.setAccountId(po.getAccountId());
		vo.setAccountName(po.getAccountName());
		vo.setBalance(po.getBalance());
		return vo;
	}
}
