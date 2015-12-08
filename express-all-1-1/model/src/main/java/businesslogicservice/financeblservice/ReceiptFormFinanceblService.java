package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.ReceiptFormVO;

public interface ReceiptFormFinanceblService {
	public ReceiptFormVO RecieptFormcreate ();
	public void RecieptFormcancel (ReceiptFormVO vo);
	public boolean RecieptFormsave (ReceiptFormVO vo);
	public boolean RecieptFormsubmit (ReceiptFormVO vo);
	public boolean RecieptFormwithdraw (ReceiptFormVO vo);
	
	public ReceiptFormVO RecieptFormcreate (String date,double money,String e,ArrayList<Long> i,long NO);
}
