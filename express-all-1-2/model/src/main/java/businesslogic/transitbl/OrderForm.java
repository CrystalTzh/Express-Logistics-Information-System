package businesslogic.transitbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.transitblservice.OrderFormTransitblService;
import clienthelper.transitclienthelper.OrderFormClientHelper;
import dataservice.transitdataservice.OrderFormTransitdataService;
import impl.transitImpl.OrderFormTransitImpl;
import po.OrderFormPO;
import state.FormState;
import vo.OrderFormVO;

public class OrderForm implements OrderFormTransitblService{

	OrderFormClientHelper orderFormClientHelper = new OrderFormClientHelper();
	
	public OrderFormPO setPO(OrderFormVO vo){
		OrderFormPO po = new OrderFormPO();
		
		po.setDate(vo.getDate());
		po.setExpressCharges(vo.getExpressCharges());
		po.setID(vo.getID());
		po.setName(vo.getName());
		po.setNumber(vo.getNumber());
		po.setPackingCharges(vo.getPackingCharges());
		po.setRealReceiveDate(vo.getRealReceiveDate());
		po.setRealReceiver(vo.getRealReceiver());
		po.setReceiveraddress(vo.getReceiveraddress());
		po.setReceivercompany(vo.getReceivercompany());
		po.setReceivermobiletel(vo.getReceivermobiletel());
		po.setReceivername(vo.getReceivername());
		po.setReceivertel(vo.getReceivertel());
		po.setSenderaddress(vo.getSenderaddress());
		po.setSendercompany(vo.getSendercompany());
		po.setSendermobiletel(vo.getSendermobiletel());
		po.setSendername(vo.getSendername());
		po.setSendertel(vo.getSendertel());
		po.setSize(vo.getSize());
		po.setTransCharges(vo.getTransCharges());
		po.setTransportation(vo.getTransportation());
		po.setType(vo.getType());
		po.setWeight(vo.getWeight());
		po.setAlldates(vo.getAlldates());
		return po;
	}
	
	public OrderFormVO setVO(OrderFormPO po){
		OrderFormVO vo = new OrderFormVO();
		
		vo.setDate(po.getDate());
		vo.setExpressCharges(po.getExpressCharges());
		vo.setID(po.getID());
		vo.setName(po.getName());
		vo.setNumber(po.getNumber());
		vo.setPackingCharges(po.getPackingCharges());
		vo.setRealReceiveDate(po.getRealReceiveDate());
		vo.setRealReceiver(po.getRealReceiver());
		vo.setReceiveraddress(po.getReceiveraddress());
		vo.setReceivercompany(po.getReceivercompany());
		vo.setReceivermobiletel(po.getReceivermobiletel());
		vo.setReceivername(po.getReceivername());
		vo.setReceivertel(po.getReceivertel());
		vo.setSenderaddress(po.getSenderaddress());
		vo.setSendercompany(po.getSendercompany());
		vo.setSendermobiletel(po.getSendermobiletel());
		vo.setSendername(po.getSendername());
		vo.setSendertel(po.getSendertel());
		vo.setSize(po.getSize());
		vo.setTransCharges(po.getTransCharges());
		vo.setTransportation(po.getTransportation());
		vo.setType(po.getType());
		vo.setWeight(po.getWeight());
		vo.setAlldates(po.getAlldates());
		return vo;
	}
	
	public OrderFormVO OrderFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入OrderFormbl...findOrderForm...");
		OrderFormTransitdataService orderFormTransitdataService = new OrderFormTransitImpl();
		OrderFormPO po1 = orderFormClientHelper.goFind(number);
		OrderFormPO po2 = orderFormTransitdataService.find(number);
		if(po1!=null){
			OrderFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			OrderFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public OrderFormVO OrderFormcreate() {
		// TODO Auto-generated method stub
		
		return null;
	}

	public void OrderFormcancel(OrderFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean OrderFormsave(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OrderFormbl...saveOrderForm...");
		OrderFormPO po = new OrderFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		OrderFormTransitdataService orderFormTransitdataService = null;
		try {
			orderFormTransitdataService = new OrderFormTransitImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			orderFormTransitdataService.insert(po);
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

	public boolean OrderFormsubmit(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OrderFormbl...submitOrderForm...");
		OrderFormPO po = new OrderFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(orderFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean OrderFormwithdraw(OrderFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OrderFormbl...withdrawOrderForm...");
		OrderFormPO po = new OrderFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(orderFormClientHelper.goFind(po.getID()) != null){
			if(orderFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

	public ArrayList<OrderFormPO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...findAll...");
		return orderFormClientHelper.goFindAll();
	}
}
