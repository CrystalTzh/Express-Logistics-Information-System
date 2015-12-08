package businesslogic.corporationbl;

import ClientHelper.CorporationClientHelper.CarInfoClientHelper;
import businesslogicservice.corporationblservice.CarInfocorporationblService;
import po.CarInfoPO;
import vo.CarInfoVO;
import vo.DriverInfoVO;

public class CarInfobl implements CarInfocorporationblService {
	CarInfoClientHelper carInfoClientHelper = new CarInfoClientHelper();

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#create()
	 */
	public CarInfoVO create() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#add(vo.CarInfoVO)
	 */
	public boolean add(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfobl...addCar...");
		CarInfoPO po = new CarInfoPO();
		po.setActiveTime(vo.getActiveTime());
		po.setBuyTime(vo.getBuyTime());
		po.setCarNumber(vo.getCarNumber());
		po.setChassisNumber(vo.getChassisNumber());
		po.setEngineNumber(vo.getEngineNumber());
		po.setPlateNumber(vo.getPlateNumber());
		if(carInfoClientHelper.goInsert(po)) {//建立RMI连接
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#delete(vo.CarInfoVO)
	 */
	public boolean delete(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfobl...deleteCar...");
		CarInfoPO po = new CarInfoPO();
		po.setActiveTime(vo.getActiveTime());
		po.setBuyTime(vo.getBuyTime());
		po.setCarNumber(vo.getCarNumber());
		po.setChassisNumber(vo.getChassisNumber());
		po.setEngineNumber(vo.getEngineNumber());
		po.setPlateNumber(vo.getPlateNumber());
		if(carInfoClientHelper.goDelete(po)) {//建立RMI连接
			return false;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#find(java.lang.String)
	 */
	public CarInfoVO find(String carNumber) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfobl...findCar...");
		CarInfoPO po = carInfoClientHelper.goFind(carNumber);
		//将PO包装为VO
		if(po != null) {
			CarInfoVO vo = new CarInfoVO();
			vo.setActiveTime(po.getActiveTime());
			vo.setBuyTime(po.getBuyTime());
			vo.setCarNumber(po.getCarNumber());
			vo.setChassisNumber(po.getChassisNumber());
			vo.setEngineNumber(po.getEngineNumber());
			vo.setPlateNumber(po.getPlateNumber());
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#update(vo.CarInfoVO)
	 */
	public boolean update(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...updateCar...");
		CarInfoPO po = new CarInfoPO();
		po.setActiveTime(vo.getActiveTime());
		po.setBuyTime(vo.getBuyTime());
		po.setCarNumber(vo.getCarNumber());
		po.setChassisNumber(vo.getChassisNumber());
		po.setEngineNumber(vo.getEngineNumber());
		po.setPlateNumber(vo.getPlateNumber());
		if(carInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}
	
	

}
