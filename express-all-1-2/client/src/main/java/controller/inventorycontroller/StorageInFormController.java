package controller.inventorycontroller;

import businesslogic.inventorybl.StorageInForm;
import vo.StorageInFormVO;


public class StorageInFormController {
	public boolean saveDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...saveDriver...");
		StorageInForm receiptForm = new StorageInForm();
		if(receiptForm.StorageInFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...submitDriver...");
		StorageInForm receiptForm = new StorageInForm();
		if(receiptForm.StorageInFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...whitdrawDriver...");
		StorageInForm receiptForm = new StorageInForm();
		if(receiptForm.StorageInFormwithdraw(vo)){
			return true;
		}
		return false;
	}

//	public StorageInFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
//		// TODO Auto-generated method stub
//		System.out.println("进入StorageInFormController...findDriver...");
//		StorageInForm receiptForm = new StorageInForm();
//		StorageInFormVO vo = receiptForm.StorageInFormfind(number);
//		if(vo != null){
//			return vo;
//		}else{
//			return null;
//		}
//	}
}
