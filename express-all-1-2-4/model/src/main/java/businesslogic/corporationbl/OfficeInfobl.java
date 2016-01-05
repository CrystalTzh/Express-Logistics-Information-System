/**
 * @author 谭琼
 * 2015年12月14日
 */
package businesslogic.corporationbl;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.OfficeInfocorporationblService;
import clienthelper.corporatioclienthelper.OfficeClientHelper;
import po.OfficePO;
import state.City;
import vo.OfficeVO;

/**
 * 营业厅信息业务逻辑层实现
 */
public class OfficeInfobl implements OfficeInfocorporationblService{
	
	OfficeClientHelper officeClientHelper = new OfficeClientHelper();
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#findAll(state.City)
	 */
	public ArrayList<OfficeVO> findAll(City city) {
		ArrayList<OfficePO> allPOs = officeClientHelper.goFindAll(city);
		ArrayList<OfficeVO> allVOs = new ArrayList<OfficeVO>();
		for(int i = 0; i < allPOs.size(); i++) {
			OfficeVO vo = this.wrappPOtoVO(allPOs.get(i));
			allVOs.add(vo);
		}
		return allVOs;
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#getNextOfficeID(state.City)
	 */
	public String getNextOfficeID(City city) {
		System.out.println("进入OfficeInfobl...getNextOfficeID...");
		return officeClientHelper.goGetNextOfficeID(city);
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#add(vo.OfficeVO)
	 */
	public boolean add(OfficeVO vo) {
		System.out.println("进入OfficeInfobl...AddOffice...");
		OfficePO po = wrappVOtoPO(vo);
		if(officeClientHelper.goInsert(po)) {//建立RMI连接
//			OfficeVO.add();
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#delete(vo.OfficeVO)
	 */
	public boolean delete(OfficeVO vo) {
		System.out.println("进入OfficeInfobl...DeleteOffice...");
		OfficePO po = this.wrappVOtoPO(vo);
		if(officeClientHelper.goDelete(po)) {
//			OfficeVO.delete();
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#find(java.lang.String)
	 */
	public OfficeVO find(String officeID) {
		System.out.println("进入OfficeInfobl...FindOffice...");
		OfficePO po = officeClientHelper.goFind(officeID);
		//将PO包装成VO
		if(po != null) {
			OfficeVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.OfficeInfocorporationblService#update(vo.OfficeVO)
	 */
	public boolean update(OfficeVO vo) {
		System.out.println("进入OfficeInfobl...UpdateOffice...");
		if(officeClientHelper.goUpdate(wrappVOtoPO(vo))) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将营业厅信息的VO持久化对象包装为PO
	 * @param vo
	 * @return
	 */
	public OfficePO wrappVOtoPO(OfficeVO vo) {
		City city = vo.getCity();
		OfficePO po;
		switch(city) {
		case BEIJING:
			po = new OfficePO(city, vo.getBeiJingDistrict());
			break;
		case NANJING:
			po = new OfficePO(city, vo.getNanJingDistrict());
			break;
		case SHANGHAI:
			po = new OfficePO(city, vo.getShangHaiDistrict());
			break;
		default:
			po = new OfficePO(city, vo.getGuangZhouDistrict());
			break;
		}
		po.setOfficeID(vo.getOfficeID());
		return po;
	}
	
	/**
	 * 将营业厅信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public OfficeVO  wrappPOtoVO(OfficePO po) {
		OfficeVO vo;
		City city = po.getCity();
		switch(city) {
		case BEIJING:
			vo = new OfficeVO(city, po.getBeiJingDistrict());
			break;
		case NANJING:
			vo = new OfficeVO(city, po.getNanJingDistrict());
			break;
		case SHANGHAI:
			vo = new OfficeVO(city, po.getShangHaiDistrict());
			break;
		default:
			vo = new OfficeVO(city, po.getGuangZhouDistrict());
			break;
		}
		vo.setOfficeID(po.getOfficeID());
		return vo;
	}


}
