package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.StoreArrivalForm;
import po.StoreArrivalFormPO;
import vo.StoreArrivalFormVO;

public class StoreArrivalFormController {
	
	public ArrayList<StoreArrivalFormPO> findAll(){
		System.out.println("进入PaymentFormController...findAll...");
		StoreArrivalForm storeArrivalForm = new StoreArrivalForm();
		return 	storeArrivalForm.findAll();
	}
	
	public boolean saveDriver(StoreArrivalFormVO vo){
		System.out.println("进入StoreArrivalFormController...saveDriver...");
		StoreArrivalForm storeArrivalForm = new StoreArrivalForm();
		if(storeArrivalForm.StoreArrivalFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(StoreArrivalFormVO vo){
		System.out.println("进StoreArrivalFormController...submitDriver...");
		StoreArrivalForm storeArrivalForm = new StoreArrivalForm();
		if(storeArrivalForm.StoreArrivalFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(StoreArrivalFormVO vo){
		System.out.println("进入StoreArrivalFormController...whitdrawDriver...");
		StoreArrivalForm storeArrivalForm = new StoreArrivalForm();
		if(storeArrivalForm.StoreArrivalFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public StoreArrivalFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入StoreArrivalFormController...findDriver...");
		StoreArrivalForm storeArrivalForm = new StoreArrivalForm();
		StoreArrivalFormVO vo = storeArrivalForm.StoreArrivalFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
	
}
