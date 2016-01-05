package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.DeliveryFormFormapprovalblService;
import clienthelper.transitclienthelper.DeliveryFormClientHelper;
import po.DeliveryFormPO;
import state.FormState;
import vo.DeliveryFormVO;

public class DeliveryFormFormapproval implements DeliveryFormFormapprovalblService{

	DeliveryFormClientHelper deliveryFormClientHelper = new DeliveryFormClientHelper();
	
	public boolean DeliveryFormjudge(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		DeliveryFormPO po = new DeliveryFormPO();
		po.setArrivaeDate(vo.getArrivaeDate());
		po.setDeliveryMan(vo.getDeliveryMan());
		po.setID(vo.getID());
		po.setFormstate(FormState.APPROVED);
		if(deliveryFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
