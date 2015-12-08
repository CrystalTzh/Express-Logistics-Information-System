package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.ReceiptFormFormapprovalblService;
import state.FormState;
import vo.ReceiptFormVO;

public class ReceiptFormFormapprovalblDriver {
	public void drive(ReceiptFormFormapprovalblService receiptFormFormapprovalblStub) {
		ArrayList<Long> NO = new ArrayList();
		NO.add((long) 1);
		NO.add((long) 2);
		NO.add((long) 3);
		ReceiptFormVO receiptFormVO = new ReceiptFormVO("date", 1,
				"expressManNumber",  NO, 123, FormState.SUBMITTED);
		if(receiptFormFormapprovalblStub.ReceiptFormjudge(receiptFormVO))
			System.out.println("Judge ReceiptForm successfully!");
	}
}
