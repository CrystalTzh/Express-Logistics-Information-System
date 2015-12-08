package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.TransferFormFormapprovalblService;
import vo.TransferFormVO;

public class TransferFormFormapprovalblDriver {
	public void drive(TransferFormFormapprovalblService transferFormFormapprovalblStub) {
		TransferFormVO transferFormVO = new TransferFormVO();
		if(transferFormFormapprovalblStub.TransferFormjudge(transferFormVO))
			System.out.println("Judge TransferForm successfully!");
	}
}
