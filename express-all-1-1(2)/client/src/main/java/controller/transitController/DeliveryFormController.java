package controller.transitController;

import java.rmi.RemoteException;

import businesslogic.transitbl.DeliveryForm;
import vo.DeliveryFormVO;

public class DeliveryFormController {

	public boolean saveDriver(DeliveryFormVO vo){
		System.out.println("进入DeliveryFormController...saveDriver...");
		DeliveryForm deliveryform = new DeliveryForm();
		if(deliveryform.DeliveryFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(DeliveryFormVO vo){
		System.out.println("进入DeliveryFormController...submitDriver...");
		DeliveryForm deliveryform = new DeliveryForm();
		if(deliveryform.DeliveryFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(DeliveryFormVO vo){
		System.out.println("进入DeliveryFormController...whitdrawDriver...");
		DeliveryForm deliveryform = new DeliveryForm();
		if(deliveryform.DeliveryFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public DeliveryFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入DeliveryFormController...findDriver...");
		DeliveryForm deliveryform = new DeliveryForm();
		DeliveryFormVO vo = deliveryform.DeliveryFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
