package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.ReceiptFormFormapprovalblService;
import vo.ReceiptFormVO;

public class ReceiptFormFormapprovalblDriver {
	public void drive(ReceiptFormFormapprovalblService receiptFormFormapprovalblStub) {
		ArrayList<Long> NO = new ArrayList<Long>();
		NO.add((long) 1);
		NO.add((long) 2);
		NO.add((long) 3);
		ReceiptFormVO receiptFormVO = new ReceiptFormVO();
		if(receiptFormFormapprovalblStub.ReceiptFormjudge(receiptFormVO))
			System.out.println("Judge ReceiptForm successfully!");
	}
}
