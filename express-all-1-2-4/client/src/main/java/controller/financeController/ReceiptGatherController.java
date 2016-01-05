package controller.financeController;

import businesslogic.financebl.ReceiptGather;
import vo.ReceiptGatherVO;


public class ReceiptGatherController {
	public boolean settleDriver(ReceiptGatherVO vo){
		System.out.println("进入StorageInFormController...saveDriver...");
		ReceiptGather receiptForm = new ReceiptGather();
		receiptForm.ReceiptGathersettle(vo);
		return true;
		
	
	}
}
