package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.DeliveryFormTransitblService;
import vo.DeliveryFormVO;

public class DeliveryFormTransitblStub implements DeliveryFormTransitblService{

	public DeliveryFormVO DeliveryFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call DeliveryFormcreate...");
		return null;
	}

	public void DeliveryFormcancel(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call DeliveryFormcancel...");
	}

	public boolean DeliveryFormsave(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call DeliveryFormsave...");
		return false;
	}

	public boolean DeliveryFormsubmit(DeliveryFormVO vo) {
		// TODO print "Submit successfully!"
		System.out.println("Call DeliveryFormsubmit...");
		return true;
	}

	public boolean DeliveryFormwithdraw(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call DeliveryFormwithdraw");
		return false;
	}

}
