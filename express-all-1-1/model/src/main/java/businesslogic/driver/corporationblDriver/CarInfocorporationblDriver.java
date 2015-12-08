package businesslogic.driver.corporationblDriver;

import businesslogicservice.corporationblservice.CarInfocorporationblService;
import vo.CarInfoVO;

public class CarInfocorporationblDriver {
	public void drive(CarInfocorporationblService carInfocorporationblStub) {
		CarInfoVO carInfoVO = new CarInfoVO("c", "p", "e", "ch", "b","a");
		carInfocorporationblStub.add(carInfoVO);
	}
}
