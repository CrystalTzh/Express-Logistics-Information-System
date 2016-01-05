/**
 * @author 谭琼
 * 2015年11月26日
 */
package businesslogic.corporationbl;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.DriverInfocorporationblService;
import clienthelper.corporatioclienthelper.DriverInfoClientHelper;
import po.DriverInfoPO;
import vo.DriverInfoVO;
/**
 * 司机信息业务逻辑层实现
 */
public class DriverInfobl implements DriverInfocorporationblService {
	
	DriverInfoClientHelper driverInfoClientHelper = new DriverInfoClientHelper();


	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.DriverInfocorporationblService#findAll()
	 */
	public ArrayList<DriverInfoVO> findAll() {
		ArrayList<DriverInfoPO> allPO = driverInfoClientHelper.findAll();
		if(allPO.size() == 0) {return null;}
		ArrayList<DriverInfoVO> allVO = new ArrayList<DriverInfoVO>();
		for(int i = 0; i < allPO.size(); i++) {
			DriverInfoVO vo = this.wrappPOtoVO(allPO.get(i));
			allVO.add(vo);
		}
		return allVO;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.DriverInfocorporationblService#
	 * add(vo.DriverInfoVO)
	 */
	public boolean add(DriverInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...addDriver...");
		DriverInfoPO po = this.wrappVOtoPO(vo);
		if(driverInfoClientHelper.goInsert(po)){//建立RMI连接
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.DriverInfocorporationblService#
	 * delete(vo.DriverInfoVO)
	 */
	public boolean delete(DriverInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...deleteDriver...");
		DriverInfoPO po = this.wrappVOtoPO(vo);
		if(driverInfoClientHelper.goDelete(po)) {//建立RMI连接
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.DriverInfocorporationblService#
	 * find(long)
	 */
	public DriverInfoVO find(String driverNumber) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...findDriver...");
		DriverInfoPO po = driverInfoClientHelper.goFind(driverNumber);
		//将PO包装为VO
		if(po != null) {
			return this.wrappPOtoVO(po);
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.DriverInfocorporationblService#
	 * update()
	 */
	public boolean update(DriverInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DriverInfobl...updateDriver...");
		DriverInfoPO po = this.wrappVOtoPO(vo);
		if(driverInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}

	/**
	 * 将司机信息的PO转换为VO
	 * @param driverInfoPO
	 * @return
	 */
	public DriverInfoVO wrappPOtoVO(DriverInfoPO po) {
		DriverInfoVO vo = new DriverInfoVO();
		vo.setBirthday(po.getBirthday());
		vo.setCellphone(po.getCellphone());
		vo.setDriverNumber(po.getDriverNumber());
		vo.setIdcard(po.getIdcard());
		vo.setLicensedate(po.getLicensedate());
		vo.setName(po.getName());
		vo.setSex(po.getSex());
		return vo;
	}
	
	/**
	 * 将司机信息的VO转换为PO
	 * @param vo
	 * @return
	 */
	public DriverInfoPO wrappVOtoPO(DriverInfoVO vo) {
		DriverInfoPO po = new DriverInfoPO();
		po.setBirthday(vo.getBirthday());
		po.setCellphone(vo.getCellphone());
		po.setDriverNumber(vo.getDriverNumber());
		po.setIdcard(vo.getIdcard());
		po.setLicensedate(vo.getLicensedate());
		po.setName(vo.getName());
		po.setSex(vo.getSex());
		return po;
	}
}
