package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.StorageOutFormFormapprovalblService;
import clienthelper.inventoryinfoclienthelper.StorageOutFormClientHelper;
import po.StorageOutFormPO;
import state.FormState;
import vo.StorageOutFormVO;

public class StorageOutFormFormapproval implements StorageOutFormFormapprovalblService{

	StorageOutFormClientHelper clienthelper = new StorageOutFormClientHelper();

	public StorageOutFormPO setPO(StorageOutFormVO vo){
		
		StorageOutFormPO po = new StorageOutFormPO();
		po.setDate(vo.getDate());
		po.setDestination(vo.getDestination());
		po.setExpressNumber(vo.getExpressNumber());
		po.setNO(vo.getNO());
		po.setSportNO(vo.getSportNO());
		po.setTransferNO(vo.getTransferNO());
		po.setTransport(vo.getTransport());
		
		return po;
	}
	
	public boolean StorageOutFormjudge(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		StorageOutFormPO po = new StorageOutFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(clienthelper.goUpdate(po)){
			return true;
		}
		return false;
	}

}
