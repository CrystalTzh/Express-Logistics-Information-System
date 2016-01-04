package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.financeblservice.PaymentFormFinanceblService;
import clienthelper.financeclienthelper.PaymentFormClientHelper;
import dataservice.financedataservice.PaymentFormdataService;
import impl.financeImpl.PaymentFormServiceImpl;
import po.PaymentFormPO;
import state.FormState;
import vo.PaymentFormVO;


public class PaymentForm implements PaymentFormFinanceblService{

	PaymentFormClientHelper paymentFormClientHelper = new PaymentFormClientHelper();
	
	public PaymentFormVO setVO(PaymentFormPO po){
		PaymentFormVO vo = new PaymentFormVO();
		vo.setDate(po.getDate());
		vo.setMoney(po.getMoney());
		vo.setName(po.getName());
		vo.setAccount(po.getAccount());
		vo.setRent(po.getRent());
		vo.setYear(po.getYear());
		vo.setFreight(po.getFreight());
		vo.setFormNO(po.getFormNO());
		vo.setSalary(po.getSalary());
		vo.setMonth(po.getMonth());
		vo.setNO(po.getNO());
	
		return vo;
	}
	
	
	
	public PaymentFormPO setPO(PaymentFormVO vo){
		PaymentFormPO po = new PaymentFormPO();
		po.setDate(vo.getDate());
		po.setMoney(vo.getMoney());
		po.setName(vo.getName());
		po.setAccount(vo.getAccount());
		po.setRent(vo.getRent());
		po.setYear(vo.getYear());
		po.setFreight(vo.getFreight());
		po.setFormNO(vo.getFormNO());
		po.setSalary(vo.getSalary());
		po.setMonth(vo.getMonth());
		po.setNO(vo.getNO());
		
		return po;
	}
	
	public PaymentFormVO PaymentFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入PaymentFormbl...findPaymentForm...");
		PaymentFormdataService paymentFormdataService = new PaymentFormServiceImpl();
		PaymentFormPO po1 = paymentFormClientHelper.goFind(number);
		PaymentFormPO po2 = paymentFormdataService.find(number);
		if(po1!=null){
			PaymentFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			PaymentFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public PaymentFormVO PaymentFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void PaymentFormcancel(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean PaymentFormsave(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...savePaymentForm...");
		PaymentFormPO po = new PaymentFormPO();
		po = setPO(vo);
		po.setFormState(FormState.DRAFT);
		PaymentFormdataService paymentFormdataService = null;
		try {
			paymentFormdataService = new PaymentFormServiceImpl();
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

	public boolean PaymentFormsubmit(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入ReceiptFormbl...submitReceiptForm...");
		PaymentFormPO po = new PaymentFormPO();
		po = setPO(vo);
		po.setFormState(FormState.SUBMITTED);
		if(paymentFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean PaymentFormwithdraw(PaymentFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...withdrawReceiptForm...");
		PaymentFormPO po = new PaymentFormPO();
		po = setPO(vo);
		po.setFormState(FormState.EDITABLE);
		if(paymentFormClientHelper.goFind(po.getNO()) != null){
			if(paymentFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}



	public ArrayList<PaymentFormPO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...findAll...");
		return paymentFormClientHelper.goFindAll();

	}





}
