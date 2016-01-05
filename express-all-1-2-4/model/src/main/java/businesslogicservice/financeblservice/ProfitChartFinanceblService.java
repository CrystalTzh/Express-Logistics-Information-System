package businesslogicservice.financeblservice;

import vo.ProfitChartVO;

public interface ProfitChartFinanceblService {

	public boolean profitChartAdd (ProfitChartVO vo);
	public ProfitChartVO profitChartCheck (long NO);
}
