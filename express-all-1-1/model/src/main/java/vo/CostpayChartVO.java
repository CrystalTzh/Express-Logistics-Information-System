package vo;

import java.io.Serializable;

import state.FormState;

public class CostpayChartVO implements Serializable{
	int income;
	int cost;
	int profit;
	long NO;
	FormState formstate;//单据的状态
	
	public CostpayChartVO() {}
	
	public CostpayChartVO(int i,int c,int p, long N, FormState formstate){
		income = i;
		cost = c;
		profit = p;
		NO = N;
		this.formstate = formstate;
	}

	public int getIncome() {
		return income;
	}

	public int getCost() {
		return cost;
	}

	public int getProfit() {
		return profit;
	}
	
	public long getNO(){
		return NO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setIncome(int income) {
		this.income = income;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public void setProfit(int profit) {
		this.profit = profit;
	}

	public void setNO(long nO) {
		NO = nO;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}
	
}
