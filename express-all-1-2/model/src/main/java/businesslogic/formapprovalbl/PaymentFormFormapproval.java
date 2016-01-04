package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.PaymentFormFormapprovalblService;
import clienthelper.financeclienthelper.PaymentFormClientHelper;
import po.PaymentFormPO;
import state.FormState;
import vo.PaymentFormVO;

public class PaymentFormFormapproval implements PaymentFormFormapprovalblService{

	PaymentFormClientHelper paymentFormClientHelper = new PaymentFormClientHelper();
	
	public PaymentFormPO setPO(PaymentFormVO vo){
		PaymentFormPO po = new PaymentFormPO();
		po.setDate(vo.getDate());
		po.setMoney(vo.getMoney());
		po.setName(vo.getName());
		po.setAccount(vo.getAccount());
		po.setRent(vo.getRent());
		po.setYear(vo.getYear());
		po.setFreight(vo.getFreight());
		po.setFormNO(vo.getFormNO());
		po.setSalary(vo.getSalary());
		po.setMonth(vo.getMonth());
		po.setNO(vo.getNO());
		
		return po;
	}
	
	public boolean PaymentFormjudge(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		PaymentFormPO po = new PaymentFormPO();
		po = setPO(vo);
		po.setFormState(FormState.APPROVED);
		if(paymentFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
