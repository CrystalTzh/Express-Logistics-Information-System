package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.OrderFormFormapprovalblService;
import vo.OrderFormVO;

public class OrderFormFormapprovalblDriver {
	public void drive(OrderFormFormapprovalblService orderFormFormapprovalblStub) {
		OrderFormVO orderFormVO = new OrderFormVO();
		if(orderFormFormapprovalblStub.OrderFormjudge(orderFormVO))
			System.out.println("Judge OrderForm successfully!");
	}
}
