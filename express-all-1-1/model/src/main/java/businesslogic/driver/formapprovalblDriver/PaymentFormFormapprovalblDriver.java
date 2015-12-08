package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.PaymentFormFormapprovalblService;
import state.FormState;
import vo.PaymentFormVO;

public class PaymentFormFormapprovalblDriver {
	public void drive(PaymentFormFormapprovalblService paymentFormFormapprovalblStub) {
		ArrayList<Long> allNO = new ArrayList();
		allNO.add((long) 1);
		allNO.add((long) 2);
		allNO.add((long) 3);
		PaymentFormVO paymentFormVO = new PaymentFormVO("date", 1.0,
				"name", 12345, 5000.00, 2013, allNO, 500000.00, 
				10000, "2013年12月", 23456,2000.00, FormState.SUBMITTED);
		if(paymentFormFormapprovalblStub.PaymentFormjudge(paymentFormVO))
			System.out.println("Judge PaymentForm successfully!");
}
}
