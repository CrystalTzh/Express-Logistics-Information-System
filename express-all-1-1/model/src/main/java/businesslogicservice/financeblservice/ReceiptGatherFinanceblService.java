package businesslogicservice.financeblservice;

import java.util.ArrayList;

import vo.ReceiptFormVO;
import vo.ReceiptGatherVO;

public interface ReceiptGatherFinanceblService {

	public ReceiptGatherVO ReceiptGathercreate();
	public void ReceiptGathercancel (ReceiptFormVO vo);
	public boolean ReceiptGathersave (ReceiptGatherVO vo);
	public boolean ReceiptGathersubmit (ReceiptGatherVO vo);
	public boolean ReceiptGatherwithdraw (ReceiptGatherVO vo);
	public boolean ReceiptGatherAddInfo (ArrayList<ReceiptFormVO> receiptFormgathervo);
}
