package controller.inventorycontroller;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.inventorybl.StorageInForm;
import po.InventoryInfoPO;
import po.StorageInFormPO;
import vo.StorageInFormVO;


public class StorageInFormController {
	
	public ArrayList<StorageInFormPO> findAll(){
		System.out.println("进入PaymentFormController...findAll...");
		StorageInForm storageInForm = new StorageInForm();
		return 	storageInForm.findAll();
	}
	
	public boolean saveDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...saveDriver...");
		StorageInForm storageInForm = new StorageInForm();
		if(storageInForm.StorageInFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...submitDriver...");
		StorageInForm storageInForm = new StorageInForm();
		if(storageInForm.StorageInFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(StorageInFormVO vo){
		System.out.println("进入StorageInFormController...whitdrawDriver...");
		StorageInForm storageInForm = new StorageInForm();
		if(storageInForm.StorageInFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public InventoryInfoPO findInventoryInfo(String inventoryID){
		System.out.println("进入StorageInFormController...findEmptyposition...");
		StorageInForm storageInForm = new StorageInForm();
		return storageInForm.findInventoryInfo(inventoryID);
	}
	
	public StorageInFormVO findDriver(String number) throws IllegalArgumentException, RemoteException {
		// TODO Auto-generated method stub
		System.out.println("进入StorageInFormController...findDriver...");
		StorageInForm receiptForm = new StorageInForm();
		StorageInFormVO vo = receiptForm.StorageInFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
