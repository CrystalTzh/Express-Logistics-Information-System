package businesslogic.driver.financeblDriver;

import state.FormState;
import vo.PaymentFormVO;
import businesslogicservice.financeblservice.PaymentFormFinanceblService;

public class PaymentFormFinanceblDriver {
	public void driver(PaymentFormFinanceblService paymentFormFinanceblStub){
		PaymentFormVO paymentFormVO = paymentFormFinanceblStub.PaymentFormcreate("20151025", 2000, "徐文杰", 12345678, 1, 0,  null, 0, 0, null,0, 0);
		FormState state = paymentFormVO.getFormstate();
		System.out.println("The state of current form is "+state);
		paymentFormFinanceblStub.PaymentFormcreate();
		paymentFormFinanceblStub.PaymentFormcancel(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormsave(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormsubmit(paymentFormVO);
		paymentFormFinanceblStub.PaymentFormwithdraw(paymentFormVO);
	}
}
