package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.StorageOutFormFormapprovalblService;
import vo.StorageOutFormVO;

public class StorageOutFormFormapprovalblStub implements StorageOutFormFormapprovalblService{

	public boolean StorageOutFormjudge(StorageOutFormVO vo) {
		// TODO print "Judge StorageOutForm successfully!"
		System.out.println("Call StorageOutFormjudge...");
		return true;
	}
	
}
