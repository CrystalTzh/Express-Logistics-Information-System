package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.CarOfficeForm;
import po.CarOfficeFormPO;
import vo.CarOfficeFormVO;

public class CarOfficeFormController {
	
	
	public ArrayList<CarOfficeFormPO> findAll(){
		System.out.println("进入CarOfficeFormController...findAll...");
		CarOfficeForm carOfficeForm = new CarOfficeForm();
		return 	carOfficeForm.findAll();
	}
	
	public boolean saveDriver(CarOfficeFormVO vo){
		System.out.println("进入CarOfficeFormController...saveDriver...");
		CarOfficeForm carOfficeForm = new CarOfficeForm();
		if(carOfficeForm.CarOfficeFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(CarOfficeFormVO vo){
		System.out.println("进入CarOfficeFormController...submitDriver...");
		CarOfficeForm carOfficeForm = new CarOfficeForm();
		if(carOfficeForm.CarOfficeFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(CarOfficeFormVO vo){
		System.out.println("进入CarOfficeFormController...whitdrawDriver...");
		CarOfficeForm carOfficeForm = new CarOfficeForm();
		if(carOfficeForm.CarOfficeFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public CarOfficeFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入CarOfficeFormController...findDriver...");
		CarOfficeForm carOfficeForm = new CarOfficeForm();
		CarOfficeFormVO vo = carOfficeForm.CarOfficeFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
