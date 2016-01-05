package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.StorageInFormFormapprovalblService;
import clienthelper.inventoryinfoclienthelper.StorageInFormClientHelper;
import po.StorageInFormPO;
import state.FormState;
import vo.StorageInFormVO;

public class StorageInFormFormapproval implements StorageInFormFormapprovalblService{

	StorageInFormClientHelper storageInFormClientHelper = new StorageInFormClientHelper();

	public StorageInFormPO setPO(StorageInFormVO vo){
		
		StorageInFormPO po = new StorageInFormPO();
		po.setDate(vo.getDate());
		po.setDestination(vo.getDestination());
		po.setExpressNumber(vo.getExpressNumber());
		po.setLine(vo.getLine());
		po.setNO(vo.getNO());
		po.setShelf(vo.getShelf());
		po.setTag(vo.getTag());
		po.setZone(vo.getZone());
		
		return po;
	}
	
	public boolean StorageInFormjudge(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		StorageInFormPO po = new StorageInFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(storageInFormClientHelper.goUpdate(po)){
			return true;
		}
		return false;
	}

}
