package businesslogic.financebl;

import businesslogicservice.financeblservice.CostPayChartFinanceblService;
import po.PaymentFormPO;
import po.ReceiptFormPO;
import vo.CostpayChartVO;

public class CostPayChart implements CostPayChartFinanceblService{

	public CostpayChartVO costPayChartCreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean costPayChartAdd(CostpayChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public CostpayChartVO costPayChartCheck(long NO) {
		// TODO Auto-generated method stub
		MockCostPayChart mockCostPayChart = new MockCostPayChart(NO);
		CostpayChartVO costPayChartVO = new CostpayChartVO(mockCostPayChart.income,
				mockCostPayChart.cost, mockCostPayChart.profit, mockCostPayChart.NO, mockCostPayChart.formstate);
		return costPayChartVO;
	}

	public boolean costPayChartAddInfo(ReceiptFormPO rpo, PaymentFormPO ppo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
