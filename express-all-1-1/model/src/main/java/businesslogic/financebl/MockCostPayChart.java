package businesslogic.financebl;

import state.FormState;

public class MockCostPayChart extends CostPayChart{
	int income = 0;
	int cost = 0;
	int profit = 0;
	long NO = 0;
	FormState formstate = null;
	
	public MockCostPayChart(long NO)
	{
		MockReceiptForm mockReceiptForm = new MockReceiptForm(2345688);
		income = mockReceiptForm.getMoney();
		MockPaymentForm mockPaymentForm = new MockPaymentForm(23456899);
		cost = mockPaymentForm.getMoney();
		profit = income - cost;
	}
	public int getProfit()
	{
		return profit;
	}
}
