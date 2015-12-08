package businesslogicservice.financeblservice;

import po.PaymentFormPO;
import po.ReceiptFormPO;
import vo.CostpayChartVO;

public interface CostPayChartFinanceblService {

	public CostpayChartVO costPayChartCreate();
	public boolean costPayChartAdd(CostpayChartVO vo);
	public CostpayChartVO costPayChartCheck(long NO);
	public boolean costPayChartAddInfo (ReceiptFormPO rpo,PaymentFormPO ppo);
	
}
