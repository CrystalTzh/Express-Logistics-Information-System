package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.DeliveryFormTransitblService;
import vo.DeliveryFormVO;

public class DeliveryFormTransitblDriver {
		public void drive(DeliveryFormTransitblService deliveryFormTransitblStub) {
			DeliveryFormVO deliveryFormVO = new DeliveryFormVO();
			if(deliveryFormTransitblStub.DeliveryFormsubmit(deliveryFormVO))
				System.out.println("Submit DeliveryForm successfully!");
		}
}
