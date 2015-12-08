/**
 * @author 谭琼
 * 2015年12月2日
 */
package controller.corporationController;

import businesslogic.corporationbl.CarInfobl;
import vo.CarInfoVO;

public class CarInfoController {
	public CarInfoVO findCar(String carNumber) {
		System.out.println("进入CarInfoController...findCar...");
		CarInfobl carInfobl = new CarInfobl();
		CarInfoVO vo = carInfobl.find(carNumber);
		return vo;
	}
	
	public boolean addCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...addCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.add(vo)) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...deleteCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	public boolean modifyCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...modifyCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.update(vo)) {
			return true;
		}
		return false;
	}
}
