package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.CarInputFormFormapprovalblService;
import vo.CarInputFormVO;

public class CarInputFormFormapprovalblStub implements CarInputFormFormapprovalblService{

	public boolean CarInputFormjudge(CarInputFormVO vo) {
		// TODO print "Judge CarInputForm successfully!"
		System.out.println("Call CarInputFormjudge...");
		return true;
	}

}
