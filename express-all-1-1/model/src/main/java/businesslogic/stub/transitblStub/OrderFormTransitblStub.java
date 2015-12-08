package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.OrderFormTransitblService;
import vo.OrderFormVO;

public class OrderFormTransitblStub implements OrderFormTransitblService{

	public OrderFormVO OrderFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call OrderFormcreate...");
		return null;
	}

	public void OrderFormcancel(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call OrderFormcancel...");
	}

	public boolean OrderFormsave(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call OrderFormsave");
		return false;
	}

	public boolean OrderFormsubmit(OrderFormVO vo) {
		// TODO print "Submit successfully!"
		System.out.println("Call OrderFormsubmit");
		return true;
	}

	public boolean OrderFormwithdraw(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call OrderFormwithdraw...");
		return false;
	}

}
