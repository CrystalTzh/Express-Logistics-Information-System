package controller.financeController;

import java.rmi.RemoteException;

import businesslogic.financebl.PaymentForm;
import vo.PaymentFormVO;



public class PaymentFormController {
	public boolean saveDriver(PaymentFormVO vo){
		System.out.println("进入PaymentFormController...saveDriver...");
		PaymentForm paymentForm = new PaymentForm();
		if(paymentForm.PaymentFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(PaymentFormVO vo){
		System.out.println("进入PaymentFormController...submitDriver...");
		PaymentForm paymentForm = new PaymentForm();
		if(paymentForm.PaymentFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(PaymentFormVO vo){
		System.out.println("进入PaymentFormController...whitdrawDriver...");
		PaymentForm paymentForm = new PaymentForm();
		if(paymentForm.PaymentFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public PaymentFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormController...findDriver...");
		PaymentForm paymentForm = new PaymentForm();
		PaymentFormVO vo = paymentForm.PaymentFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
