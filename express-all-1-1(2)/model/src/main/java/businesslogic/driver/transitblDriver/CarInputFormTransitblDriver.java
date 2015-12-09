package businesslogic.driver.transitblDriver;

import businesslogicservice.transitblservice.CarInputFormTransitblService;
import vo.CarInputFormVO;

public class CarInputFormTransitblDriver {
	public void drive(CarInputFormTransitblService carInputFormTransitblStub) {
		CarInputFormVO carInputFormVO = new CarInputFormVO();
		if(carInputFormTransitblStub.CarInputFormsubmit(carInputFormVO))
			System.out.println("Submit CarInputForm  successfully!");
	}
}
