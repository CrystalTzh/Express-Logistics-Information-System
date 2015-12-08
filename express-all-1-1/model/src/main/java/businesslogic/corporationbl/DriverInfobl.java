/**
 * @author 谭琼
 * 2015年11月26日
 */
package businesslogic.corporationbl;

import ClientHelper.CorporationClientHelper.DriverInfoClientHelper;
import businesslogicservice.corporationblservice.DriverInfocorporationblService;
import po.DriverInfoPO;
import vo.DriverInfoVO;

public class DriverInfobl implements DriverInfocorporationblService {
	DriverInfoClientHelper driverInfoClientHelper = new DriverInfoClientHelper();
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.DriverInfocorporationblService#
	 * create()
	 */
	public DriverInfoVO create() {
		// TODO Auto-generated method stub
		return null;
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
		DriverInfoPO po = new DriverInfoPO();
		po.setBirthday(vo.getBirthday());
		po.setCellphone(vo.getCellphone());
		po.setDriverNumber(vo.getDriverNumber());
		po.setIdcard(vo.getIdcard());
		po.setLicensedate(vo.getLicensedate());
		po.setName(vo.getName());
		po.setSex(vo.getSex());
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
		DriverInfoPO po = new DriverInfoPO();
		po.setBirthday(vo.getBirthday());
		po.setCellphone(vo.getCellphone());
		po.setDriverNumber(vo.getDriverNumber());
		po.setIdcard(vo.getIdcard());
		po.setLicensedate(vo.getLicensedate());
		po.setName(vo.getName());
		po.setSex(vo.getSex());
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
		DriverInfoPO po = new DriverInfoPO();
		po.setBirthday(vo.getBirthday());
		po.setCellphone(vo.getCellphone());
		po.setDriverNumber(vo.getDriverNumber());
		po.setIdcard(vo.getIdcard());
		po.setLicensedate(vo.getLicensedate());
		po.setName(vo.getName());
		po.setSex(vo.getSex());
		if(driverInfoClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}

}
