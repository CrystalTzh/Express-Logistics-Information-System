package businesslogic.financebl;

import java.rmi.RemoteException;

import businesslogicservice.financeblservice.CostPayChartFinanceblService;
import clienthelper.financeclienthelper.CostPayChartClientHelper;
import dataservice.financedataservice.CostPayChartdataService;
import impl.financeImpl.CostPayChartServiceClientImpl;
import po.CostpayChartPO;
import po.PaymentFormPO;
import po.ReceiptFormPO;
import vo.CostpayChartVO;

public class CostPayChart implements CostPayChartFinanceblService{
	CostPayChartClientHelper paymentFormClientHelper = new CostPayChartClientHelper();
	
	public CostpayChartVO setVO(CostpayChartPO po){
		CostpayChartVO vo = new CostpayChartVO();
		vo.setCost(po.getCost());
		vo.setNO(po.getNO());
		vo.setProfit(po.getProfit());
		vo.setIncome(po.getIncome());
		return vo;
	}
	
	
	
	public CostpayChartPO setPO(CostpayChartVO vo){
		CostpayChartPO po = new CostpayChartPO();
		po.setNO(vo.getNO());
		po.setCost(vo.getCost());
		po.setProfit(vo.getProfit());
		po.setIncome(vo.getIncome());
		return po;
	}
	
	
	
	public CostpayChartVO CostpayChartfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入CostpayChartFormbl...findCostpayChart...");
		CostPayChartdataService paymentFormdataService = new CostPayChartServiceClientImpl();
		CostpayChartPO po1 = paymentFormClientHelper.goFind(number);
		CostpayChartPO po2 = paymentFormdataService.find(number);
		if(po1!=null){
			CostpayChartVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			CostpayChartVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public boolean CostpayChartsave(CostpayChartVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CostpayChartbl...saveCostpayChart...");
		CostpayChartPO po = new CostpayChartPO();
		po = setPO(vo);
		
		CostPayChartdataService paymentFormdataService = null;
		try {
			paymentFormdataService = new CostPayChartServiceClientImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			paymentFormdataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("save done!");
		return false;
	}

	public boolean CostpayChartsubmit(CostpayChartVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CostpayChartbl...submitCostpayChart...");
		CostpayChartPO po = new CostpayChartPO();
		po = setPO(vo);
		
		if(paymentFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}


	
	public CostpayChartVO costPayChartCreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean costPayChartAdd(CostpayChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean costPayChartAddInfo(ReceiptFormPO rpo, PaymentFormPO ppo) {
		// TODO Auto-generated method stub
		return false;
	}

//这个就是find方法，接口不改了。
	public CostpayChartVO costPayChartCheck(String NO) {
		// TODO Auto-generated method stub
		CostPayChart c=new CostPayChart();
		try {
			c.CostpayChartfind(NO);
		} catch (RemoteException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}



	
	
}
