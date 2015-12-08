package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.CarOfficeFormFormapprovalblService;
import state.FormState;
import vo.CarOfficeFormVO;

public class CarOfficeFormFormapprovalblDriver {
	public void drive(CarOfficeFormFormapprovalblService carOfficeFormFormapprovalblStub) {
		ArrayList<Long> allIDs = new ArrayList<Long>();
		CarOfficeFormVO carOfficeFormVO = new CarOfficeFormVO(1, "d", "m",
				"c", "l", "s", "p", "a", allIDs, 2, FormState.SUBMITTED);
		if(carOfficeFormFormapprovalblStub.CarOfficeFormjudge(carOfficeFormVO))
			System.out.println("Judge CarOfficeForm successfully!");
	}
}
