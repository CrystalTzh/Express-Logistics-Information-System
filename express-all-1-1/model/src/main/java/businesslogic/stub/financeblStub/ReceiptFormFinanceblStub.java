package businesslogic.stub.financeblStub;

import java.util.ArrayList;

import state.FormState;
import vo.ReceiptFormVO;
import businesslogicservice.financeblservice.ReceiptFormFinanceblService;

public class ReceiptFormFinanceblStub implements ReceiptFormFinanceblService {

	public ReceiptFormVO RecieptFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("call RecieptFormcreate...");
		return null;
	}

	public void RecieptFormcancel(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call RecieptFormcancel...");
	}

	public boolean RecieptFormsave(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call RecieptFormsave...");
		return false;
	}

	public boolean RecieptFormsubmit(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call RecieptFormsubmit...");
		return false;
	}

	public boolean RecieptFormwithdraw(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call RecieptFormwithdraw...");
		return false;
	}

	public ReceiptFormVO RecieptFormcreate(String date, double money, String e,
			ArrayList<Long> i, long NO) {
		// TODO Auto-generated method stub
		ReceiptFormVO r = null;
		r = new ReceiptFormVO(date,money,e,i,NO,FormState.EDITABLE);
		return r;
	}

}
