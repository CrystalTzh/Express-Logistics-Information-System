package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.OfficeArrivalForm;
import po.OfficeArrivalFormPO;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalFormController {
	
	public ArrayList<OfficeArrivalFormPO> findAll(){
		System.out.println("进入PaymentFormController...findAll...");
		OfficeArrivalForm officeArrivalForm = new OfficeArrivalForm();
		return 	officeArrivalForm.findAll();
	}
	
	public boolean saveDriver(OfficeArrivalFormVO vo){
		System.out.println("进入OfficeArrivalFormController...saveDriver...");
		OfficeArrivalForm officeArrivalForm = new OfficeArrivalForm();
		if(officeArrivalForm.OfficeArrivalFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(OfficeArrivalFormVO vo){
		System.out.println("进OfficeArrivalFormController...submitDriver...");
		OfficeArrivalForm officeArrivalForm = new OfficeArrivalForm();
		if(officeArrivalForm.OfficeArrivalFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(OfficeArrivalFormVO vo){
		System.out.println("进入OfficeArrivalFormController...whitdrawDriver...");
		OfficeArrivalForm officeArrivalForm = new OfficeArrivalForm();
		if(officeArrivalForm.OfficeArrivalFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public OfficeArrivalFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入OfficeArrivalFormController...findDriver...");
		OfficeArrivalForm officeArrivalForm = new OfficeArrivalForm();
		OfficeArrivalFormVO vo = officeArrivalForm.OfficeArrivalFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
	
}
