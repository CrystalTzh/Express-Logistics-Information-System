package controller.financeController;

import java.rmi.RemoteException;

import businesslogic.financebl.ReceiptForm;
import vo.ReceiptFormVO;

public class ReceiptFormController {
	
	public boolean saveDriver(ReceiptFormVO vo){
		System.out.println("进入ReceiptFormController...saveDriver...");
		ReceiptForm receiptForm = new ReceiptForm();
		if(receiptForm.ReceiptFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(ReceiptFormVO vo){
		System.out.println("进入ReceiptFormController...submitDriver...");
		ReceiptForm receiptForm = new ReceiptForm();
		if(receiptForm.ReceiptFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(ReceiptFormVO vo){
		System.out.println("进入ReceiptFormController...whitdrawDriver...");
		ReceiptForm receiptForm = new ReceiptForm();
		if(receiptForm.ReceiptFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public ReceiptFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入ReceiptFormController...findDriver...");
		ReceiptForm receiptForm = new ReceiptForm();
		ReceiptFormVO vo = receiptForm.ReceiptFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
	
}
