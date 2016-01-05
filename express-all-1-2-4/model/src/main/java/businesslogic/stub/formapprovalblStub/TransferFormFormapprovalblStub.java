package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.TransferFormFormapprovalblService;
import vo.TransferFormVO;

public class TransferFormFormapprovalblStub implements TransferFormFormapprovalblService{

	public boolean TransferFormjudge(TransferFormVO vo) {
		// TODO print "judge TransferForm successfully!"
		System.out.println("Call TransferFormjudge...");
		return true;
	}
	
}
