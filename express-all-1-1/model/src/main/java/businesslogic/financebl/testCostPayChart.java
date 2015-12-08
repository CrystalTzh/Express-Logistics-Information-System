package businesslogic.financebl;

import junit.framework.TestCase;
import vo.CostpayChartVO;

public class testCostPayChart extends TestCase{

	public void test() {
		CostPayChart contpay = new CostPayChart();
//		System.out.println(mockCostPayChart.getProfit());
		CostpayChartVO costpayChartVO = contpay.costPayChartCheck(66666666);
		assertEquals(10000, costpayChartVO.getProfit());
	}

}
