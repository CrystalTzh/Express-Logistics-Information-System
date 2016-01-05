package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.ReceiptFormFormapprovalblService;
import vo.ReceiptFormVO;

public class ReceiptFormFormapprovalblStub implements ReceiptFormFormapprovalblService{

	public boolean ReceiptFormjudge(ReceiptFormVO vo) {
		// TODO print "Judge ReceiptForm successfully!"
		System.out.println("Call ReceiptFormjudge...");
		return true;
	}

}
