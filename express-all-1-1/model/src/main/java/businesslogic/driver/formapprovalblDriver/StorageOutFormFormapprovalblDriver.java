package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.StorageOutFormFormapprovalblService;
import vo.StorageOutFormVO;

public class StorageOutFormFormapprovalblDriver {
	public void drive(StorageOutFormFormapprovalblService storageOutFormFormapprovalblStub) {
		StorageOutFormVO storageOutFormVO = new StorageOutFormVO();
		if(storageOutFormFormapprovalblStub.StorageOutFormjudge(storageOutFormVO))
			System.out.println("Judge StorageOutForm successfully!");
	}
}
