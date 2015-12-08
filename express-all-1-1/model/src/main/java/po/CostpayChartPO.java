package po;

import java.io.Serializable;

public class CostpayChartPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	double income;
	double cost;
	double profit;
	String NO;
	
	public CostpayChartPO(double i,double c,double p,String N){
		income = i;
		cost = c;
		profit = p;
		NO = N;
	}

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
}
