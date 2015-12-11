package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.StoreArrivalFormTransitblService;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormTransitblStub implements StoreArrivalFormTransitblService{

	public StoreArrivalFormVO StoreArrivalFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call StoreArrivalFormcreate...");
		return null;
	}

	public void StoreArrivalFormcancel(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call StoreArrivalFormcancel...");
	}

	public boolean StoreArrivalFormsave(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		System.out.println("Call StoreArrivalFormsave...");
		return false;
	}

	public boolean StoreArrivalFormsubmit(StoreArrivalFormVO vo) {
		// TODO print "Submit successfully!"
		System.out.println("Call StoreArrivalFormsubmit...");
		return true;
	}

	public boolean StoreArrivalFormwithdraw(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call StoreArrivalFormwithdraw...");
		return false;
	}

}
