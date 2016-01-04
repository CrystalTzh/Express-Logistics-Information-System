package vo;

import java.io.Serializable;

import state.FormState;
/**
 * 成本收益表持久化对象
 */
public class CostpayChartVO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double income;//总收入
	double cost;//总支出
	double profit;//总利润
	String NO;//单号
	FormState formstate;//单据的状态

	public double getIncome() {
		return income;
	}

	public double getCost() {
		return cost;
	}

	public double getProfit() {
		return profit;
	}
	
	public String getNO(){
		return NO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setIncome(double income) {
		this.income = income;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}

	public void setNO(String NO) {
		this.NO = NO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
