/**
 * @author 谭琼
 * 2015年12月2日
 */
package controller.corporationcontroller;

import java.util.ArrayList;

import businesslogic.corporationbl.CarInfobl;
import vo.CarInfoVO;

/**
 * 车辆信息控制器
 */
public class CarInfoController {
	
	/**
	 * 查找所有车辆信息
	 * @return
	 */
	public ArrayList<CarInfoVO> findAll() {
		System.out.println("进入CarInfoController...findAll car...");
		CarInfobl carInfobl = new CarInfobl();
		return carInfobl.findAll();
	}
	
	/**
	 * 根据车辆代号查找车辆信息
	 * @param carNumber 车辆代号
	 * @return
	 */
	public CarInfoVO findCar(String carNumber) {
		System.out.println("进入CarInfoController...findCar...");
		CarInfobl carInfobl = new CarInfobl();
		CarInfoVO vo = carInfobl.find(carNumber);
		return vo;
	}
	
	/**
	 * 添加车辆信息
	 * @param vo 待添加的车辆信息
	 * @return
	 */
	public boolean addCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...addCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 删除车辆信息
	 * @param vo
	 * @return
	 */
	public boolean deleteCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...deleteCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.delete(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 修改车辆信息
	 * @param vo 待修改的车辆信息
	 * @return
	 */
	public boolean modifyCar(CarInfoVO vo) {
		System.out.println("进入CarInfoController...modifyCar...");
		CarInfobl carInfobl = new CarInfobl();
		if(carInfobl.update(vo)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		CarInfoController carInfoController = new CarInfoController();
		carInfoController.findAll();
	}
}
