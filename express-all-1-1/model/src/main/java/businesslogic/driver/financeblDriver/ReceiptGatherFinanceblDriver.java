package businesslogic.driver.financeblDriver;

import java.util.ArrayList;

import vo.ReceiptFormVO;
import vo.ReceiptGatherVO;
import businesslogicservice.financeblservice.ReceiptGatherFinanceblService;

public class ReceiptGatherFinanceblDriver {
	public void driver(ReceiptGatherFinanceblService receiptGatherFinanceblStub){
		
		ReceiptGatherVO receiptGatherVO = new ReceiptGatherVO();
		ReceiptFormVO receiptFormVO = new ReceiptFormVO();
		receiptGatherFinanceblStub.ReceiptGathercreate();
		receiptGatherFinanceblStub.ReceiptGathercancel(receiptFormVO);
		receiptGatherFinanceblStub.ReceiptGathersave(receiptGatherVO);
		receiptGatherFinanceblStub.ReceiptGathersubmit(receiptGatherVO);
		receiptGatherFinanceblStub.ReceiptGatherwithdraw(receiptGatherVO);
		ArrayList<ReceiptFormVO> receiptFormgathervo = null;
		receiptGatherFinanceblStub.ReceiptGatherAddInfo(receiptFormgathervo);
	}
}
