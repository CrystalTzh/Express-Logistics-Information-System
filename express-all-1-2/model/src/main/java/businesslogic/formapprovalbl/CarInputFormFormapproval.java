package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.CarInputFormFormapprovalblService;
import clienthelper.transitclienthelper.CarInputFormClientHelper;
import po.CarInputFormPO;
import state.FormState;
import vo.CarInputFormVO;

public class CarInputFormFormapproval implements CarInputFormFormapprovalblService{

	CarInputFormClientHelper carInputFormClientHelper = new CarInputFormClientHelper();
	
	public CarInputFormPO setPO(CarInputFormVO vo){
		CarInputFormPO po = new CarInputFormPO();
		po.setAllIDs(vo.getAllIDs());
		po.setCarNumber(vo.getCarNumber());
		po.setDestination(vo.getDestination());
		po.setLoadingMember(vo.getLoadingMember());
		po.setMotorNumber(vo.getMotorNumber());
		po.setNO(vo.getNO());
		po.setPutOnCarDate(vo.getPutOnCarDate());
		po.setSupercargo(vo.getSupercargo());
		po.setTransCharge(vo.getTransCharge());
		return po;
	}
	
	public boolean CarInputFormjudge(CarInputFormVO vo) {
		
		CarInputFormPO po = new CarInputFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(carInputFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
