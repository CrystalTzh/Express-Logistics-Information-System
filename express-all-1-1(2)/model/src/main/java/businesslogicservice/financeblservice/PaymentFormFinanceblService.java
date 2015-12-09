package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.PaymentFormVO;

public interface PaymentFormFinanceblService {
	public PaymentFormVO PaymentFormcreate ();
	public void PaymentFormcancel (PaymentFormVO vo);
	public boolean PaymentFormsave (PaymentFormVO vo);
	public boolean PaymentFormsubmit (PaymentFormVO vo);
	public boolean PaymentFormwithdraw (PaymentFormVO vo);
	

}
