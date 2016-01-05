package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.StorageInFormFormapprovalblService;
import vo.StorageInFormVO;

public class StorageInFormFormapprovalblDriver {
	public void drive(StorageInFormFormapprovalblService storageInFormFormapprovalblStub) {
		StorageInFormVO storageInFormVO = new StorageInFormVO();
		if(storageInFormFormapprovalblStub.StorageInFormjudge(storageInFormVO))
			System.out.println("Judge StorageInForm successfully!");
	}
}
