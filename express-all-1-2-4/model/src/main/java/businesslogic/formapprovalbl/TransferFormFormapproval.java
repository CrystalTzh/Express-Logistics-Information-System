package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.TransferFormFormapprovalblService;
import clienthelper.transitclienthelper.TransferFormClientHelper;
import po.TransferFormPO;
import state.FormState;
import vo.TransferFormVO;

public class TransferFormFormapproval implements TransferFormFormapprovalblService{

	TransferFormClientHelper transferFormClientHelper = new TransferFormClientHelper();

	public TransferFormPO setPO(TransferFormVO vo){
		TransferFormPO po = new TransferFormPO();
		
		po.setAllIDs(vo.getAllIDs());
		po.setDestination(vo.getDestination());
		po.setLine(vo.getLine());
		po.setLoadingMember(vo.getLoadingMember());
		po.setPutOnCarDate(vo.getPutOnCarDate());
		po.setRelayFormNumber(vo.getRelayFormNumber());
		po.setShelf(vo.getShelf());
		po.setStartingpoint(vo.getStartingpoint());
		po.setTag(vo.getTag());
		po.setTransCharge(vo.getTransCharge());
		po.setTransport(vo.getTransport());
		po.setZone(vo.getZone());
		
		return po;
	}
	
	public boolean TransferFormjudge(TransferFormVO vo) {
		// TODO Auto-generated method stub
		TransferFormPO po = new TransferFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(transferFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
