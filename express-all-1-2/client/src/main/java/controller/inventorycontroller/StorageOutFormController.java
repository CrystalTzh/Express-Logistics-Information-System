package controller.inventorycontroller;

import java.rmi.RemoteException;

import businesslogic.inventorybl.StorageOutForm;
import vo.StorageOutFormVO;




public class StorageOutFormController {
	public boolean saveDriver(StorageOutFormVO vo){
		System.out.println("进入StorageInFormController...saveDriver...");
		StorageOutForm receiptForm = new StorageOutForm();
		if(receiptForm.StorageOutFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(StorageOutFormVO vo){
		System.out.println("进入StorageOutFormController...submitDriver...");
		StorageOutForm receiptForm = new StorageOutForm();
		if(receiptForm.StorageOutFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(StorageOutFormVO vo){
		System.out.println("进入StorageOutFormController...whitdrawDriver...");
		StorageOutForm receiptForm = new StorageOutForm();
		if(receiptForm.StorageOutFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public StorageOutFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入StorageOutFormController...findDriver...");
		StorageOutForm receiptForm = new StorageOutForm();
		StorageOutFormVO vo = receiptForm.StorageOutFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
