package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.OrderForm;
import po.OrderFormPO;
import vo.OrderFormVO;

public class OrderFormController {
	
	public ArrayList<OrderFormPO> findAll(){
		System.out.println("进入PaymentFormController...findAll...");
		OrderForm orderForm = new OrderForm();
		return 	orderForm.findAll();
	}
	
	public boolean saveDriver(OrderFormVO vo){
		System.out.println("进入OrderFormController...saveDriver...");
		OrderForm orderform = new OrderForm();
		if(orderform.OrderFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(OrderFormVO vo){
		System.out.println("进OrderFormController...submitDriver...");
		OrderForm orderform = new OrderForm();
		if(orderform.OrderFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(OrderFormVO vo){
		System.out.println("进入OrderFormController...whitdrawDriver...");
		OrderForm orderform = new OrderForm();
		if(orderform.OrderFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public OrderFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入OrderFormController...findDriver...");
		OrderForm orderform = new OrderForm();
		OrderFormVO vo = orderform.OrderFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
