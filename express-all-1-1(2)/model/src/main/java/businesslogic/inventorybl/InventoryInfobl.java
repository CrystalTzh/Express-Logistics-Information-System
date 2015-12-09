package businesslogic.inventorybl;

import businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice;
import clienthelper.inventoryinfoclienthelper.InventoryInfoClientHelper;
import po.InventoryInfoPO;
import vo.InventoryInfoVO;

public class InventoryInfobl implements InventoryInfoInventoryblSercice{

	InventoryInfoClientHelper inventoryInfoClientHelper = new InventoryInfoClientHelper();

	/* (non-Javadoc)
	 * @see businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice#findInventoryInfo(java.lang.String)
	 */
	public InventoryInfoVO findInventoryInfo(String inventoryID) {
		// TODO Auto-generated method stub
		System.out.println("进入findInventoryInfo...findInventoryInfo...");
		InventoryInfoPO po = inventoryInfoClientHelper.goFindInventoryInfo(inventoryID);
		return this.wrappPOtoVO(po);
	}
	
	/* (non-Javadoc)
	 * @see businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice#addInventoryInfo(vo.InventoryInfoVO)
	 */
	public boolean addInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入addInventoryInfo...addInventoryInfo...");
		InventoryInfoPO po = this.wrappVOtoPO(vo);
		if(inventoryInfoClientHelper.goAddInventoryInfo(po)) {
			return true;
		}
		return false;
	}

	/* (non-Javadoc)
	 * @see businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice#updateInventoryInfo(vo.InventoryInfoVO)
	 */
	public boolean updateInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入updateInventoryInfo...updateInventoryInfo...");
		InventoryInfoPO po = this.wrappVOtoPO(vo);
		if(inventoryInfoClientHelper.goUpdateInventoryInfo(po)) {
			return true;
		}
		return false;
	}



	/* (non-Javadoc)
	 * @see businesslogicservice.inventoryblservice.InventoryInfoInventoryblSercice#deleteInventoryInfo(vo.InventoryInfoVO)
	 */
	public boolean deleteInventoryInfo(InventoryInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入deleteInventoryInfo...deleteInventoryInfo...");
		InventoryInfoPO po = this.wrappVOtoPO(vo);
		if(inventoryInfoClientHelper.goDeleteInventoryInfo(po)) {
			return true;
		}
		return false;
	}
	

	/**
	 * 将库存信息的PO包装为VO
	 * @param po
	 * @return
	 */
	public InventoryInfoVO wrappPOtoVO(InventoryInfoPO po) {
		InventoryInfoVO vo = new InventoryInfoVO();
		vo.setCarZoneInfo(po.getCarZoneInfo());
		vo.setEmptyZone(po.getEmptyZone());
		vo.setInventoryID(po.getInventoryID());
		vo.setLimit(po.getLimit());
		vo.setPlaneZoneInfo(po.getPlaneZoneInfo());
		vo.setTrainZoneInfo(po.getTrainZoneInfo());
		vo.setEmptyZoneInfo(po.getEmptyZoneInfo());
		return vo;
	}
	
	/**
	 * 将库存信息的VO包装为PO
	 * @param vo
	 * @return
	 */
	public InventoryInfoPO wrappVOtoPO(InventoryInfoVO vo) {
		InventoryInfoPO po = new InventoryInfoPO();
		po.setCarZoneInfo(vo.getCarZoneInfo());
		po.setEmptyZone(vo.getEmptyZone());
		po.setEmptyZoneInfo(vo.getEmptyZoneInfo());
		po.setInventoryID(vo.getInventoryID());
		po.setLimit(vo.getLimit());
		po.setPlaneZoneInfo(vo.getPlaneZoneInfo());
		po.setTrainZoneInfo(vo.getTrainZoneInfo());
		return po;
	}

}
