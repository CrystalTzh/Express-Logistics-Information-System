package businesslogic.stub.financeblStub;

import java.util.ArrayList;

import vo.ReceiptFormVO;
import vo.ReceiptGatherVO;
import businesslogicservice.financeblservice.ReceiptGatherFinanceblService;

public class ReceiptGatherFinanceblStub implements
		ReceiptGatherFinanceblService {

	public ReceiptGatherVO ReceiptGathercreate() {
		// TODO Auto-generated method stub
		System.out.println("call ReceiptGathercreate...");
		return null;
	}

	public void ReceiptGathercancel(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call ReceiptGathercancel...");
	}

	public boolean ReceiptGathersave(ReceiptGatherVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call ReceiptGathersave...");
		return false;
	}

	public boolean ReceiptGathersubmit(ReceiptGatherVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call ReceiptGathersubmit...");
		return false;
	}

	public boolean ReceiptGatherwithdraw(ReceiptGatherVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call ReceiptGatherwithdraw...");
		return false;
	}

	public boolean ReceiptGatherAddInfo(
			ArrayList<ReceiptFormVO> receiptFormgathervo) {
		// TODO Auto-generated method stub
		System.out.println("call receiptGatherAddInfo...");
		return false;
	}

//	@Override
//	public boolean ReceiptGatherAddInfo(ArrayList<ReceiptFormVO> receiptFormgathervo) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
