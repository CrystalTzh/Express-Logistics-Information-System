package po;

import java.io.Serializable;
/**
 * 成本收益表持久化对象
 */
public class CostpayChartPO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	double income;//总收入
	double cost;//总支出
	double profit;//总利润
	String NO;//单号
	
	public double getIncome() {
		return income;
	}
	public void setIncome(double income) {
		this.income = income;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public double getProfit() {
		return profit;
	}
	public void setProfit(double profit) {
		this.profit = profit;
	}
	public String getNO() {
		return NO;
	}
	public void setNO(String nO) {
		this.NO = nO;
	}
	
	
}
