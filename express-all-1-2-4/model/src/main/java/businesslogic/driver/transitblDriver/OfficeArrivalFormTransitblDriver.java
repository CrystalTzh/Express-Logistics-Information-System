package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.OfficeArrivalFormTransitblService;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalFormTransitblDriver {
	public void drive(OfficeArrivalFormTransitblService officeArrivalFormTransitblStub) {
		OfficeArrivalFormVO officeArrivalFormVO = new OfficeArrivalFormVO();
		if(officeArrivalFormTransitblStub.OfficeArrivalFormsubmit(officeArrivalFormVO))
			System.out.println("Submit OfficeArrivalForm  successfully!");
	}
}
