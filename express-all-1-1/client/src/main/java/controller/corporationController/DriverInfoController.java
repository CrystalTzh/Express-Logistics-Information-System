/**
 * @author 谭琼
 * 2015年11月26日
 */
package controller.corporationController;

import businesslogic.corporationbl.DriverInfobl;
import vo.DriverInfoVO;

public class DriverInfoController {
	public DriverInfoVO findDriver(String driverNumber) {
		System.out.println("进入DriverInfoController...findDriver...");
		DriverInfobl driverInfobl = new DriverInfobl();
		DriverInfoVO vo = driverInfobl.find(driverNumber);
		return vo;
	}
	public boolean addDriver(DriverInfoVO vo) {
		DriverInfobl driverInfobl = new DriverInfobl();
		System.out.println("进入DriverInfoController...addDriver...");
		if(driverInfobl.add(vo)) {
			return true;
		}
		return false;
	}
	public boolean deleteDriver(DriverInfoVO vo) {
		DriverInfobl driverInfobl = new DriverInfobl();
		System.out.println("进入DriverInfoController...deleteDriver...");
		if(driverInfobl.delete(vo)) {
			return true;
		}
		return false;
	}
	public boolean modifyDriver(DriverInfoVO vo) {
		DriverInfobl driverInfobl = new DriverInfobl();
		System.out.println("进入DriverInfoController...modifyDriver...");
		if(driverInfobl.update(vo)) {
			return true;
		}
		return false;
	}
}
