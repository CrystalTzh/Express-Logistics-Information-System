/**
 * @author 谭琼
 * 2015年12月14日
 */
package businesslogic.corporationbl;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService;
import clienthelper.corporatioclienthelper.TransferOfficeClientHelper;
import po.TransferOfficePO;
import state.City;
import vo.TransferOfficeVO;

public class TransferOfficeInfobl implements TransferOfficeInfocoporationblService{

	TransferOfficeClientHelper transferOfficeClientHelper = new TransferOfficeClientHelper();
	

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#findAll(state.City)
	 */
	public ArrayList<TransferOfficeVO> findAll(City city) {
		ArrayList<TransferOfficePO> allPOs = transferOfficeClientHelper.goFindAll(city);
		ArrayList<TransferOfficeVO> allVOs = new ArrayList<TransferOfficeVO>();
		for(int i = 0; i < allPOs.size(); i++) {
			TransferOfficeVO vo = this.wrappPOtoVO(allPOs.get(i));
			allVOs.add(vo);
		}
		return allVOs;
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#getNextOffceID(state.City)
	 */
	public String getNextOffceID(City city) {
		System.out.println("进入TransferOfficeInfobl...getNextOffceID...");
		return transferOfficeClientHelper.goGetNextTransferOfficeID(city);
	}

	
	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#add(vo.TransferOfficeVO)
	 */
	public boolean add(TransferOfficeVO vo) {
		System.out.println("进入TransferOfficeInfobl...AddTransferOffice...");
		TransferOfficePO po = wrappVOtoPO(vo);
		if(transferOfficeClientHelper.goInsert(po)) {//建立RMI连接
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#delete(vo.TransferOfficeVO)
	 */
	public boolean delete(TransferOfficeVO vo) {
		System.out.println("进入TransferOfficeInfobl...DeleteTransferOffice...");
		TransferOfficePO po = wrappVOtoPO(vo);
		if(transferOfficeClientHelper.goDelete(po)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#find(java.lang.String)
	 */
	public TransferOfficeVO find(String transferOfficeID) {
		System.out.println("进入TransferOfficeInfobl...FindTransferOffice...");
		TransferOfficePO po = transferOfficeClientHelper.goFind(transferOfficeID);
		//将PO包装成VO
		if(po != null) {
			TransferOfficeVO vo = this.wrappPOtoVO(po);
			return vo;
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.corporationblservice.TransferOfficeInfocoporationblService#update(vo.TransferOfficeVO)
	 */
	public boolean update(TransferOfficeVO vo) {
		System.out.println("进入TransferOfficeInfobl...UpdateTransferOffice...");
		TransferOfficePO po = wrappVOtoPO(vo);
		if(transferOfficeClientHelper.goUpdate(po)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 将中转中心信息的VO持久化对象包装为PO
	 * @param vo
	 * @return
	 */
	public TransferOfficePO wrappVOtoPO(TransferOfficeVO vo) {
		TransferOfficePO po = new TransferOfficePO(vo.getCity());
		po.setTransferOfficeID(vo.getTransferOfficeID());
		return po;
	}
	
	/**
	 * 将z中转中心信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public TransferOfficeVO  wrappPOtoVO(TransferOfficePO po) {
		TransferOfficeVO vo = new TransferOfficeVO(po.getCity());
		vo.setTransferOfficeID(po.getTransferOfficeID());
		return vo;
	}

}
