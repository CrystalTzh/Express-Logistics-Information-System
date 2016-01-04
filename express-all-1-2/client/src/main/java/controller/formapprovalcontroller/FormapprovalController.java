package controller.formapprovalcontroller;

import businesslogic.formapprovalbl.CarInputFormFormapproval;
import businesslogic.formapprovalbl.CarOfficeFormFormapproval;
import businesslogic.formapprovalbl.DeliveryFormFormapproval;
import businesslogic.formapprovalbl.OfficeArrivalFormFormapproval;
import businesslogic.formapprovalbl.OrderFormFormapproval;
import businesslogic.formapprovalbl.PaymentFormFormapproval;
import businesslogic.formapprovalbl.ReceiptFormFormapproval;
import businesslogic.formapprovalbl.StorageInFormFormapproval;
import businesslogic.formapprovalbl.StorageOutFormFormapproval;
import businesslogic.formapprovalbl.StoreArrivalFormFormapproval;
import businesslogic.formapprovalbl.TransferFormFormapproval;
import vo.CarInputFormVO;
import vo.CarOfficeFormVO;
import vo.DeliveryFormVO;
import vo.OfficeArrivalFormVO;
import vo.OrderFormVO;
import vo.PaymentFormVO;
import vo.ReceiptFormVO;
import vo.StorageInFormVO;
import vo.StorageOutFormVO;
import vo.StoreArrivalFormVO;
import vo.TransferFormVO;

public class FormapprovalController {

	
	
	public boolean judgeCarInputForm(CarInputFormVO vo){
		CarInputFormFormapproval formapproval = new CarInputFormFormapproval();
		if(formapproval.CarInputFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeDeliveryForm(DeliveryFormVO vo){
		DeliveryFormFormapproval formapproval = new DeliveryFormFormapproval();
		if(formapproval.DeliveryFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeOfficeArrivalForm(OfficeArrivalFormVO vo){
		OfficeArrivalFormFormapproval formapproval = new OfficeArrivalFormFormapproval();
		if(formapproval.OfficeArrivalFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeOrderForm(OrderFormVO vo){
		OrderFormFormapproval formapproval = new OrderFormFormapproval();
		if(formapproval.OrderFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgePaymentForm(PaymentFormVO vo){
		PaymentFormFormapproval formapproval = new PaymentFormFormapproval();
		if(formapproval.PaymentFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeReceiptForm(ReceiptFormVO vo){
		ReceiptFormFormapproval formapproval = new ReceiptFormFormapproval();
		if(formapproval.ReceiptFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeStorageInForm(StorageInFormVO vo){
		StorageInFormFormapproval formapproval = new StorageInFormFormapproval();
		if(formapproval.StorageInFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeStorageOutForm(StorageOutFormVO vo){
		StorageOutFormFormapproval formapproval = new StorageOutFormFormapproval();
		if(formapproval.StorageOutFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeStoreArrivalForm(StoreArrivalFormVO vo){
		StoreArrivalFormFormapproval formapproval = new StoreArrivalFormFormapproval();
		if(formapproval.StoreArrivalFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeTransferForm(TransferFormVO vo){
		TransferFormFormapproval formapproval = new TransferFormFormapproval();
		if(formapproval.TransferFormjudge(vo)){
			return true;
		}
		return false;
	}
	
	public boolean judgeCarOfficeForm(CarOfficeFormVO vo){
		CarOfficeFormFormapproval formapproval = new CarOfficeFormFormapproval();
		if(formapproval.CarOfficeFormjudge(vo)){
			return true;
		}
		return false;
	}
}
