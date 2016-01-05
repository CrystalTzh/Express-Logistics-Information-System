package businesslogic.financebl;

import java.rmi.RemoteException;

import businesslogicservice.financeblservice.ProfitChartFinanceblService;
import clienthelper.financeclienthelper.ProfitChartClientHelper;
import dataservice.financedataservice.ProfitChartdataService;
import impl.financeImpl.ProfitChartServiceClientImpl;
import po.ProfitChartPO;
import vo.ProfitChartVO;



public class ProfitChart implements ProfitChartFinanceblService{
	ProfitChartClientHelper profitChartClientHelper = new ProfitChartClientHelper();
	
	
	
	
	public ProfitChartVO setVO(ProfitChartPO po){
		ProfitChartVO vo = new ProfitChartVO();
		vo.setNO(po.getNO());
		vo.setPaymentformpo(po.getPaymentformpo());
		vo.setReceiptformpo(po.getReceiptformpo());
	
		return vo;
	}
	
	
	
	public ProfitChartPO setPO(ProfitChartVO vo){
		ProfitChartPO po = new ProfitChartPO();
		po.setNO(vo.getNO());
		po.setPaymentformpo(vo.getPaymentformpo());
		po.setReceiptformpo(vo.getReceiptformpo());
		
		return po;
	}
	
	public ProfitChartVO ProfitChartfind(String NO) throws RemoteException, IllegalArgumentException{
		System.out.println("进入ProfitChartFormbl...findProfitChart...");
		ProfitChartdataService profitChartdataService = new ProfitChartServiceClientImpl();
		ProfitChartPO po1 = profitChartClientHelper.goFind(NO);
		ProfitChartPO po2 = profitChartdataService.find(NO);
		if(po1!=null){
			ProfitChartVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			ProfitChartVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}



	public boolean profitChartAdd(ProfitChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}



	public ProfitChartVO profitChartCheck(long NO) {
		// TODO Auto-generated method stub
		return null;
	}



	public boolean ProfitChartwithdraw(ProfitChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean ProfitChartsubmit(ProfitChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}



	public boolean ProfitChartsave(ProfitChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}



}
