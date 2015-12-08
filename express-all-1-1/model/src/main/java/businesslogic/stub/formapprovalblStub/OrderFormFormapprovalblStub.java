package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.OrderFormFormapprovalblService;
import vo.OrderFormVO;

public class OrderFormFormapprovalblStub implements OrderFormFormapprovalblService{

	public boolean OrderFormjudge(OrderFormVO vo) {
		// TODO print "Judge OderForm successfully!"
		System.out.println("Call OrderFormjudge...");
		return true;
	}

}
