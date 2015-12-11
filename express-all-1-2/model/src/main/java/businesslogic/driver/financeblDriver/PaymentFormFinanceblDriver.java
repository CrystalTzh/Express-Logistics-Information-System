package businesslogic.driver.financeblDriver;

import businesslogicservice.financeblservice.PaymentFormFinanceblService;
import vo.PaymentFormVO;

public class PaymentFormFinanceblDriver {
	public void driver(PaymentFormFinanceblService paymentFormFinanceblStub){
		PaymentFormVO paymentFormVO = paymentFormFinanceblStub.PaymentFormcreate();
//		FormState state = paymentFormVO.getFormstate();
//		System.out.println("The state of current form is "+state);
		paymentFormFinanceblStub.PaymentFormcreate();
		paymentFormFinanceblStub.PaymentFormcancel(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormsave(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormsubmit(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormwithdraw(paymentFormVO);
	}
}
