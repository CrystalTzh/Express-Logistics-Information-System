package businesslogic.financebl;


import java.rmi.RemoteException;

import businesslogicservice.financeblservice.ReceiptFormFinanceblService;
import clienthelper.financeclienthelper.ReceiptFormClientHelper;
import dataservice.financedataservice.ReceiptFormdataService;
import impl.financeImpl.ReceiptFormServiceImpl;
import po.ReceiptFormPO;
import state.FormState;
import vo.ReceiptFormVO;

public class ReceiptForm implements ReceiptFormFinanceblService{

	ReceiptFormClientHelper receiptFormClientHelper = new ReceiptFormClientHelper();
	
	public ReceiptFormVO setVO(ReceiptFormPO po){
		ReceiptFormVO vo = new ReceiptFormVO();
		vo.setDate(po.getDate());
		vo.setExpressManNumber(po.getExpressname());
		vo.setID(po.getId());
		vo.setMoney(po.getMoney());
		vo.setNO(po.getNO());
		
		return vo;
	}
	
	public ReceiptFormPO setPO(ReceiptFormVO vo){
		ReceiptFormPO po = new ReceiptFormPO();
		po.setDate(vo.getDate());
		po.setExpressname(vo.getExpressManNumber());
		po.setId(vo.getID());
		po.setMoney(vo.getMoney());
		po.setNO(vo.getNO());
		
		return po;
	}
	
	public ReceiptFormVO ReceiptFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入ReceiptFormbl...findReceiptForm...");
		ReceiptFormdataService receiptFormdataService = new ReceiptFormServiceImpl();
		ReceiptFormPO po1 = receiptFormClientHelper.goFind(number);
		ReceiptFormPO po2 = receiptFormdataService.find(number);
		if(po1!=null){
			ReceiptFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			ReceiptFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public ReceiptFormVO ReceiptFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void ReceiptFormcancel(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean ReceiptFormsave(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入ReceiptFormbl...saveReceiptForm...");
		ReceiptFormPO po = new ReceiptFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		ReceiptFormdataService receiptFormdataService = null;
		try {
			receiptFormdataService = new ReceiptFormServiceImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			receiptFormdataService.insert(po);
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

	public boolean ReceiptFormsubmit(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入ReceiptFormbl...submitReceiptForm...");
		ReceiptFormPO po = new ReceiptFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(receiptFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean ReceiptFormwithdraw(ReceiptFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入ReceiptFormbl...withdrawReceiptForm...");
		ReceiptFormPO po = new ReceiptFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(receiptFormClientHelper.goFind(po.getNO()) != null){
			if(receiptFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

}
