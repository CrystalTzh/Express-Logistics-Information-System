package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.CarInputForm;
import po.CarInputFormPO;
import vo.CarInputFormVO;

public class CarInputFormController {
	
	
	public ArrayList<CarInputFormPO> findAll(){
		System.out.println("进入CarInputFormController...findAll...");
		CarInputForm carInputForm = new CarInputForm();
		return 	carInputForm.findAll();
	}
	
	public boolean saveDriver(CarInputFormVO vo){
		System.out.println("进入CarInputFormController...saveDriver...");
		CarInputForm carInputform = new CarInputForm();
		if(carInputform.CarInputFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(CarInputFormVO vo){
		System.out.println("进入CarInputFormController...submitDriver...");
		CarInputForm carInputForm = new CarInputForm();
		if(carInputForm.CarInputFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(CarInputFormVO vo){
		System.out.println("进入CarInputFormController...whitdrawDriver...");
		CarInputForm carInputForm = new CarInputForm();
		if(carInputForm.CarInputFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public CarInputFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入CarInputFormController...findDriver...");
		CarInputForm carInputForm = new CarInputForm();
		CarInputFormVO vo = carInputForm.CarInputFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
