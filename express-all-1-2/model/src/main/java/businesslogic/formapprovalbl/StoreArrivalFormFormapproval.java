package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.StoreArrivalFormFormapprovalblService;
import clienthelper.transitclienthelper.StoreArrivalFormClientHelper;
import po.StoreArrivalFormPO;
import state.FormState;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormFormapproval implements StoreArrivalFormFormapprovalblService{

	StoreArrivalFormClientHelper storeArrivalFormClientHelper = new StoreArrivalFormClientHelper();
	
	public StoreArrivalFormPO setPO(StoreArrivalFormVO vo){
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po.setArriveDate(vo.getArriveDate());
		po.setNO(vo.getNO());
		po.setRelayformnumber(vo.getRelayformnumber());
		po.setRelaynumber(vo.getRelaynumber());
		po.setStartingPoint(vo.getStartingPoint());
		po.setState(vo.getState());
		return po;
	}
	
	public boolean StoreArrivalFormjudge(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(storeArrivalFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
