package businesslogic.stub.financeblStub;

import java.util.ArrayList;

import businesslogicservice.financeblservice.ReceiptFormFinanceblService;
import vo.ReceiptFormVO;

public class ReceiptFormFinanceblStub implements ReceiptFormFinanceblService {

	

	public ReceiptFormVO RecieptFormcreate(String date, double money, String e,
			ArrayList<Long> i, String NO) {
		// TODO Auto-generated method stub
		ReceiptFormVO r = null;
		r = new ReceiptFormVO();
		return r;
	}

	public ReceiptFormVO ReceiptFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ReceiptFormcancel(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean ReceiptFormsave(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ReceiptFormsubmit(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ReceiptFormwithdraw(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
