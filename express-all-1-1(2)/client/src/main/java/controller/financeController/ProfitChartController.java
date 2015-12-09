package controller.financeController;

import java.rmi.RemoteException;

import businesslogic.financebl.ProfitChart;
import vo.ProfitChartVO;

public class ProfitChartController {
	public boolean saveDriver(ProfitChartVO vo){
		System.out.println("进入ProfitChartController...saveDriver...");
		ProfitChart paymentForm = new ProfitChart();
		if(paymentForm.ProfitChartsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(ProfitChartVO vo){
		System.out.println("进入PaymentFormController...submitDriver...");
		ProfitChart paymentForm = new ProfitChart();
		if(paymentForm.ProfitChartsubmit(vo)){
			return true;
		}
		return false;
	}
	
	public boolean withdrawDriver(ProfitChartVO vo){
		System.out.println("进入PaymentFormController...whitdrawDriver...");
		ProfitChart paymentForm = new ProfitChart();
		if(paymentForm.ProfitChartwithdraw(vo)){
			return true;
		}
		return false;
	}

	public ProfitChartVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormController...findDriver...");
		ProfitChart paymentForm = new ProfitChart();
		ProfitChartVO vo = paymentForm.ProfitChartfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
