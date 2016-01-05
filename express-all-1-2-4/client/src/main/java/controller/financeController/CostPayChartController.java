package controller.financeController;

import java.rmi.RemoteException;

import businesslogic.financebl.CostPayChart;

import vo.CostpayChartVO;


public class CostPayChartController {
	public boolean saveDriver(CostpayChartVO vo){
		System.out.println("进入PaymentFormController...saveDriver...");
		CostPayChart paymentForm = new CostPayChart();
		if(paymentForm.CostpayChartsave(vo)){
			return true;
		}
		return false;
	}
	
	public boolean submitDriver(CostpayChartVO vo){
		System.out.println("进入PaymentFormController...submitDriver...");
		CostPayChart paymentForm = new CostPayChart();
		if(paymentForm.CostpayChartsubmit(vo)){
			return true;
		}
		return false;
	}
	
	

	public CostpayChartVO findDriver(String number) throws RemoteException, IllegalArgumentException {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormController...findDriver...");
		CostPayChart paymentForm = new CostPayChart();
		CostpayChartVO vo = paymentForm.CostpayChartfind(number);
		if(vo != null){
			return vo;
		}else{
			return null;
		}
	}
}
