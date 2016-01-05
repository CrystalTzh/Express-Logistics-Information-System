package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.OfficeArrivalFormFormapprovalblService;
import clienthelper.transitclienthelper.OfficeArrivalFormClientHelper;
import po.OfficeArrivalFormPO;
import state.FormState;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalFormFormapproval implements OfficeArrivalFormFormapprovalblService{

	OfficeArrivalFormClientHelper officeArrivalFormClientHelper = new OfficeArrivalFormClientHelper();

	public OfficeArrivalFormPO setPO(OfficeArrivalFormVO vo){
		
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po.setArriveDate(vo.getArriveDate());
		po.setDestination(vo.getDestination());
		po.setNO(vo.getNO());
		po.setRelayformnumber(vo.getRelayformnumber());

		po.setState(vo.getState());
		
		return po;
	}
	
	public boolean OfficeArrivalFormjudge(OfficeArrivalFormVO vo) {
		// TODO Auto-generated method stub
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(officeArrivalFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
