package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.StoreArrivalFormFormapprovalblService;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormFormapprovalblStub implements StoreArrivalFormFormapprovalblService{

	public boolean StoreArrivalFormjudge(StoreArrivalFormVO vo) {
		// TODO print "Judge StoreArrivalForm successfully!"
		System.out.println("Call StoreArrivalFormjudge...");
		return true;
	}

}
