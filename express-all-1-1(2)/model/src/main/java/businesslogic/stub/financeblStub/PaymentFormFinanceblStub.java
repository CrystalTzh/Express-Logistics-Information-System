package businesslogic.stub.financeblStub;

import java.util.ArrayList;

import state.FormState;
import vo.PaymentFormVO;
import businesslogicservice.financeblservice.PaymentFormFinanceblService;

public class PaymentFormFinanceblStub implements PaymentFormFinanceblService {

	public PaymentFormVO PaymentFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call PaymentFormcreate...");
		return null;
	}

	public void PaymentFormcancel(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call PaymentFormcancel...");
	}

	public boolean PaymentFormsave(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call PaymentFormsave...");
		return false;
	}

	public boolean PaymentFormsubmit(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call PaymentFormsubmit...");
		return false;
	}

	public boolean PaymentFormwithdraw(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call PaymentFormwithdraw...");
		return false;
	}

	public PaymentFormVO PaymentFormcreate(String date, double money,
			String name, long account,  double rent, int year,ArrayList<Long> allNO, double salary,
			double bonus, String payDate,long NO,double freight) {
		// TODO Auto-generated method stub
		PaymentFormVO p = null;
		p = new PaymentFormVO();
		return p;
	}

	

}
