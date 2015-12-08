package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.DeliveryFormFormapprovalblService;
import state.FormState;
import vo.DeliveryFormVO;

public class DeliveryFormFormapprovalblDriver {
	public void drive(DeliveryFormFormapprovalblService deliveryFormFormapprovalblStub) {
		DeliveryFormVO deliveryFormVO = new DeliveryFormVO("a", 1, "d", FormState.SUBMITTED);
		if(deliveryFormFormapprovalblStub.DeliveryFormjudge(deliveryFormVO))
			System.out.println("Judge DeliveryForm successfully!");
	}
}	
