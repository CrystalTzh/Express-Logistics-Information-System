package businesslogic.driver.formapprovalblDriver;

import java.util.ArrayList;

import businesslogicservice.formapprovalblservice.CarInputFormFormapprovalblService;
import vo.CarInputFormVO;

public class CarInputFormFormapprovalblDriver {
	@SuppressWarnings("unused")
	public void drive(CarInputFormFormapprovalblService carInputFormFormapprovalblStub) {
		ArrayList<Long> allIDs = new ArrayList<Long>();
		CarInputFormVO carInputFormVO = new CarInputFormVO();
		if(carInputFormFormapprovalblStub.CarInputFormjudge(carInputFormVO))
			System.out.println("Judge CarInputForm successfully!");
	}
}
