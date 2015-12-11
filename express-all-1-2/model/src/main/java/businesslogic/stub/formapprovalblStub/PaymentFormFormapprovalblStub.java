package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.PaymentFormFormapprovalblService;
import vo.PaymentFormVO;

public class PaymentFormFormapprovalblStub implements PaymentFormFormapprovalblService{

	public boolean PaymentFormjudge(PaymentFormVO vo) {
		// TODO print "Judge PaymentForm successfully!"
		System.out.println("Call PaymentFormjudge...");
		return true;
	}

}
