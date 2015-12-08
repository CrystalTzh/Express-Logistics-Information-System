package businesslogic.stub.formapprovalblStub;

import businesslogicservice.formapprovalblservice.CarOfficeFormFormapprovalblService;
import vo.CarOfficeFormVO;

public class CarOfficeFormFormapprovalblStub implements CarOfficeFormFormapprovalblService{

	public boolean CarOfficeFormjudge(CarOfficeFormVO vo) {
		// TODO print "Judge CarOfficeForm successfully!"
		System.out.println("Call CarInputFormjudge...");
		return true;
		
	}

}
