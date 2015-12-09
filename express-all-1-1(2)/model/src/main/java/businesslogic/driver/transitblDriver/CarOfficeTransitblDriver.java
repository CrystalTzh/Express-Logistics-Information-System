package businesslogic.driver.transitblDriver;

import businesslogic.stub.transitblStub.CarOfficeTransitblStub;
import businesslogicservice.transitblservice.CarOfficeFormTransitblService;
import vo.CarOfficeFormVO;

public class CarOfficeTransitblDriver {
	public void drive(CarOfficeFormTransitblService carOfficeTransitblStub) {
		CarOfficeFormVO carOfficeFormVO = new CarOfficeFormVO();
		if(carOfficeTransitblStub.CarOfficeFormsubmit(carOfficeFormVO))
			System.out.println("Submit CarOfficeForm  successfully!");
	}
}
