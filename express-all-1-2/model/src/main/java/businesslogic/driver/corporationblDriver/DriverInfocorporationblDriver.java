package businesslogic.driver.corporationblDriver;

import businesslogicservice.corporationblservice.DriverInfocorporationblService;
import state.SexList;
import vo.DriverInfoVO;

public class DriverInfocorporationblDriver {
	public void drive(DriverInfocorporationblService driverInfocorporationblStub) {
		DriverInfoVO driverInfoVO = new DriverInfoVO();
		driverInfocorporationblStub.add(driverInfoVO);
	}
}
