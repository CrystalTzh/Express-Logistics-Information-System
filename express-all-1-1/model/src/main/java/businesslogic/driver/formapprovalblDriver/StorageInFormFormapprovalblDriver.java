package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.OfficeArrivalFormFormapprovalblService;
import businesslogicservice.formapprovalblservice.StorageInFormFormapprovalblService;
import state.FormState;
import state.State;
import vo.OfficeArrivalFormVO;
import vo.StorageInFormVO;

public class StorageInFormFormapprovalblDriver {
	public void drive(StorageInFormFormapprovalblService storageInFormFormapprovalblStub) {
		StorageInFormVO storageInFormVO = new StorageInFormVO();
		if(storageInFormFormapprovalblStub.StorageInFormjudge(storageInFormVO))
			System.out.println("Judge StorageInForm successfully!");
	}
}
