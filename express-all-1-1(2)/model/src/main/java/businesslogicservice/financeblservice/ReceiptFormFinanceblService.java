package businesslogicservice.financeblservice;

import vo.ReceiptFormVO;

public interface ReceiptFormFinanceblService {
	public ReceiptFormVO ReceiptFormcreate ();
	public void ReceiptFormcancel (ReceiptFormVO vo);
	public boolean ReceiptFormsave (ReceiptFormVO vo);
	public boolean ReceiptFormsubmit (ReceiptFormVO vo);
	public boolean ReceiptFormwithdraw (ReceiptFormVO vo);
	
}
