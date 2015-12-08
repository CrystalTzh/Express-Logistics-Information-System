package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.StoreArrivalFormTransitblService;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormTransitblDriver {
	public void drive(StoreArrivalFormTransitblService storeArrivalFormTransitblStub) {
		StoreArrivalFormVO storeArrivalFormVO = new StoreArrivalFormVO();
		if(storeArrivalFormTransitblStub.StoreArrivalFormsubmit(storeArrivalFormVO))
			System.out.println("Submit StoreArrivalForm  successfully!");
	}
}
