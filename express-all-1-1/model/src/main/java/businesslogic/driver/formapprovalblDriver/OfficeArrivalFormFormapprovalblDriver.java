package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.OfficeArrivalFormFormapprovalblService;
import state.FormState;
import state.State;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalFormFormapprovalblDriver {
	public void drive(OfficeArrivalFormFormapprovalblService officeArrivalFormFormapprovalblStub) {
		OfficeArrivalFormVO officeArrivalFormVO = new OfficeArrivalFormVO(
				1, "a", 1, "s", "d", State.WELL ,FormState.SUBMITTED);
		if(officeArrivalFormFormapprovalblStub.OfficeArrivalFormjudge(officeArrivalFormVO))
			System.out.println("Judge OfficeArrivalForm successfully!");
	}
}
