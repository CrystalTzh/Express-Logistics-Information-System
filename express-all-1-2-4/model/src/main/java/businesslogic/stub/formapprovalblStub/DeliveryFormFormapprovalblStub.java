package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.DeliveryFormFormapprovalblService;
import vo.DeliveryFormVO;

public class DeliveryFormFormapprovalblStub implements DeliveryFormFormapprovalblService{

	public boolean DeliveryFormjudge(DeliveryFormVO vo) {
		// TODO print "Judge DeliveryForm successfully!"
		System.out.println("Call DeliveryFormjudge...");
		return true;
	}

}
