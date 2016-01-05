package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.PaymentFormFormapprovalblService;
import vo.PaymentFormVO;

public class PaymentFormFormapprovalblDriver {
	public void drive(PaymentFormFormapprovalblService paymentFormFormapprovalblStub) {
		ArrayList<Long> allNO = new ArrayList<Long>();
		allNO.add((long) 1);
		allNO.add((long) 2);
		allNO.add((long) 3);
		PaymentFormVO paymentFormVO = new PaymentFormVO();
		if(paymentFormFormapprovalblStub.PaymentFormjudge(paymentFormVO))
			System.out.println("Judge PaymentForm successfully!");
}
}
