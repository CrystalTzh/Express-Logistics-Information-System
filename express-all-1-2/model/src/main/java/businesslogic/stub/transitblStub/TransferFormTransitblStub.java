package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.TransferFormTransitblService;
import vo.TransferFormVO;

public class TransferFormTransitblStub implements TransferFormTransitblService{

	public TransferFormVO TransferFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call TransferFormcreate...");
		return null;
	}

	public void TransferFormcancel(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call TransferFormcancel...");
	}

	public boolean TransferFormsave(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call TransferFormsave...");
		return false;
	}

	public boolean TransferFormsubmit(TransferFormVO vo) {
		// TODO print "Submit TransferForm successfully!"
		System.out.println("Call TransferFormsubmit...");
		return true;
	}

	public boolean TransferFormwithdraw(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call TransferFormwithdraw...");
		return false;
	}

}
