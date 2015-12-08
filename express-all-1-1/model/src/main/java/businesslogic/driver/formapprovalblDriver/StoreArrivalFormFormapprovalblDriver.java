package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.StoreArrivalFormFormapprovalblService;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormFormapprovalblDriver {
	public void drive(StoreArrivalFormFormapprovalblService storeArrivalFormFormapprovalblStub) {
		StoreArrivalFormVO storeArrivalFormVO = new StoreArrivalFormVO();
		if(storeArrivalFormFormapprovalblStub.StoreArrivalFormjudge(storeArrivalFormVO))
			System.out.println("Judge StoreArrivalForm successfully!");
	}
}
