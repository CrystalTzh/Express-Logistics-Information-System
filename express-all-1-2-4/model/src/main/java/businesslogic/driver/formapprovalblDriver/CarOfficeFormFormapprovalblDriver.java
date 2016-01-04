package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.CarOfficeFormFormapprovalblService;
import vo.CarOfficeFormVO;

public class CarOfficeFormFormapprovalblDriver {
	@SuppressWarnings("unused")
	public void drive(CarOfficeFormFormapprovalblService carOfficeFormFormapprovalblStub) {
		ArrayList<Long> allIDs = new ArrayList<Long>();
		CarOfficeFormVO carOfficeFormVO = new CarOfficeFormVO();
		if(carOfficeFormFormapprovalblStub.CarOfficeFormjudge(carOfficeFormVO))
			System.out.println("Judge CarOfficeForm successfully!");
	}
}
