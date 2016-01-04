package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.ReceiptFormFormapprovalblService;
import clienthelper.financeclienthelper.ReceiptFormClientHelper;
import po.ReceiptFormPO;
import state.FormState;
import vo.ReceiptFormVO;

public class ReceiptFormFormapproval implements ReceiptFormFormapprovalblService{

	ReceiptFormClientHelper receiptFormClientHelper = new ReceiptFormClientHelper();

	public ReceiptFormPO setPO(ReceiptFormVO vo){
		ReceiptFormPO po = new ReceiptFormPO();
		po.setDate(vo.getDate());
		po.setExpressname(vo.getExpressManNumber());
		po.setId(vo.getID());
		po.setMoney(vo.getMoney());
		po.setNO(vo.getNO());
		
		return po;
	}
	
	public boolean ReceiptFormjudge(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		ReceiptFormPO po = new ReceiptFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(receiptFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
