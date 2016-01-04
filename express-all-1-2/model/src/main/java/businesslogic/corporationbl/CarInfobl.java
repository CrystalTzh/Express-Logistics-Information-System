package businesslogic.corporationbl;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.CarInfocorporationblService;
import clienthelper.corporatioclienthelper.CarInfoClientHelper;
import po.CarInfoPO;
import vo.CarInfoVO;

public class CarInfobl implements CarInfocorporationblService {
	
	CarInfoClientHelper carInfoClientHelper = new CarInfoClientHelper();

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#findAll()
	 */
	public ArrayList<CarInfoVO> findAll() {
		ArrayList<CarInfoPO> allPO = carInfoClientHelper.findAll();
		if(allPO.size() == 0) {return null;}
		ArrayList<CarInfoVO> allVO = new ArrayList<CarInfoVO>();
		for(int i = 0; i < allPO.size(); i++) {
			CarInfoVO vo = this.wrappPOtoVO(allPO.get(i));
			allVO.add(vo);
		}
		return allVO;
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#add(vo.CarInfoVO)
	 */
	public boolean add(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInfobl...addCar...");
		CarInfoPO po = this.wrappVOtoPO(vo);
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
		CarInfoPO po = this.wrappVOtoPO(vo);
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
			return this.wrappPOtoVO(po);
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.CarInfocorporationblService#update(vo.CarInfoVO)
	 */
	public boolean update(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...updateCar...");
		CarInfoPO po = this.wrappVOtoPO(vo);
		if(carInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将司机信息的PO对象包装为VO对象
	 * @param po
	 * @return
	 */
	public CarInfoVO wrappPOtoVO(CarInfoPO po) {
		CarInfoVO vo = new CarInfoVO();
		vo.setActiveTime(po.getActiveTime());
		vo.setBuyTime(po.getBuyTime());
		vo.setCarNumber(po.getCarNumber());
		vo.setChassisNumber(po.getChassisNumber());
		vo.setEngineNumber(po.getEngineNumber());
		vo.setPlateNumber(po.getPlateNumber());
		return vo;
	}
	
	/**
	 * 将司机信息的VO对象包装为PO对象
	 * @param vo
	 * @return
	 */
	public CarInfoPO wrappVOtoPO(CarInfoVO vo) {
		CarInfoPO po = new CarInfoPO();
		po.setActiveTime(vo.getActiveTime());
		po.setBuyTime(po.getBuyTime());
		po.setCarNumber(vo.getCarNumber());
		po.setChassisNumber(vo.getChassisNumber());
		po.setEngineNumber(vo.getEngineNumber());
		po.setPlateNumber(vo.getPlateNumber());
		return po;
	}

}
