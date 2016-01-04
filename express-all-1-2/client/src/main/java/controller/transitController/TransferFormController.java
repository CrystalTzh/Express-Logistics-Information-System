package controller.transitController;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogic.transitbl.TransferForm;
import po.TransferFormPO;
import vo.TransferFormVO;

public class TransferFormController {
	
	public ArrayList<TransferFormPO> findAll(){
		System.out.println("进入PaymentFormController...findAll...");
		TransferForm transferForm = new TransferForm();
		return 	transferForm.findAll();
	}
	
	public boolean saveDriver(TransferFormVO vo){
		System.out.println("进入TransferFormController...saveDriver...");
		TransferForm transferForm = new TransferForm();
		if(transferForm.TransferFormsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(TransferFormVO vo){
		System.out.println("进TransferFormController...submitDriver...");
		TransferForm transferForm = new TransferForm();
		if(transferForm.TransferFormsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(TransferFormVO vo){
		System.out.println("进入TransferFormController...whitdrawDriver...");
		TransferForm transferForm = new TransferForm();
		if(transferForm.TransferFormwithdraw(vo)){
			return true;
		}
		return false;
	}

	public TransferFormVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入TransferFormController...findDriver...");
		TransferForm transferForm = new TransferForm();
		TransferFormVO vo = transferForm.TransferFormfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
	
}
