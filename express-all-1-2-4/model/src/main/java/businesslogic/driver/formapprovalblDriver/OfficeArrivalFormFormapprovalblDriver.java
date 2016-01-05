package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.OfficeArrivalFormFormapprovalblService;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalFormFormapprovalblDriver {
	public void drive(OfficeArrivalFormFormapprovalblService officeArrivalFormFormapprovalblStub) {
		OfficeArrivalFormVO officeArrivalFormVO = new OfficeArrivalFormVO();
		if(officeArrivalFormFormapprovalblStub.OfficeArrivalFormjudge(officeArrivalFormVO))
			System.out.println("Judge OfficeArrivalForm successfully!");
	}
}
