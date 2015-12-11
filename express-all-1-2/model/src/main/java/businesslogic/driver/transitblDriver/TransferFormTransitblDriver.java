package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.TransferFormTransitblService;
import vo.TransferFormVO;

public class TransferFormTransitblDriver {
	public void drive(TransferFormTransitblService transferFormTransitblStub) {
		TransferFormVO transferFormVO = new TransferFormVO();
		if(transferFormTransitblStub.TransferFormsubmit(transferFormVO))
			System.out.println("Submit TransferForm  successfully!");
	}
}
