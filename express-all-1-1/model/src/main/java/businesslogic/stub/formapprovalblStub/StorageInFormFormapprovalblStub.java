package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.StorageInFormFormapprovalblService;
import vo.StorageInFormVO;

public class StorageInFormFormapprovalblStub implements StorageInFormFormapprovalblService{

	public boolean StorageInFormjudge(StorageInFormVO vo) {
		// TODO print "Judge StorageInForm successfully!"
		System.out.println("Call StorageInFormjudge...");
		return true;
	}

}
