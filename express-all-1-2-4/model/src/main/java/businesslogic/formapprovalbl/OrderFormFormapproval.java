package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.OrderFormFormapprovalblService;
import clienthelper.transitclienthelper.OrderFormClientHelper;
import po.OrderFormPO;
import state.FormState;
import vo.OrderFormVO;

public class OrderFormFormapproval implements OrderFormFormapprovalblService{

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
	
	public boolean OrderFormjudge(OrderFormVO vo) {
		// TODO Auto-generated method stub
		OrderFormPO po = new OrderFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(orderFormClientHelper.goUpdate(po)){
			return true;
		}
		return false;
	}

}
