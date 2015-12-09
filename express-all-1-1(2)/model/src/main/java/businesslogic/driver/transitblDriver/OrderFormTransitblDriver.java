package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.OrderFormTransitblService;
import vo.OrderFormVO;

public class OrderFormTransitblDriver {
	public void drive(OrderFormTransitblService orderFormTransitblStub) {
		OrderFormVO orderFormVO = new OrderFormVO();
		if(orderFormTransitblStub.OrderFormsubmit(orderFormVO))
			System.out.println("Submit OrderForm  successfully!");
	}
}
