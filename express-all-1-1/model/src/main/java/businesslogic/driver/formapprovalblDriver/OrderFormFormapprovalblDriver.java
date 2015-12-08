package businesslogic.driver.formapprovalblDriver;

import businesslogicservice.formapprovalblservice.OrderFormFormapprovalblService;
import state.ExpressType;
import state.FormState;
import vo.OrderFormVO;

public class OrderFormFormapprovalblDriver {
	public void drive(OrderFormFormapprovalblService orderFormFormapprovalblStub) {
		OrderFormVO orderFormVO = new OrderFormVO(
				"sendername", "senderaddress", "sendercomany",
				"sendertel", "sendermobiletel", "receiverName",
				"receiveraddress", "receivercompany","receivertel",
				"receivermobiletel", 1, 1.0, 2.0, "name",
				ExpressType.SCONOMIC, 3.0, 5.0, 27.0, 1234, "date", 
				"realReceiver", "realReceiverDate", FormState.SUBMITTED);
		if(orderFormFormapprovalblStub.OrderFormjudge(orderFormVO))
			System.out.println("Judge OrderForm successfully!");
	}
}
