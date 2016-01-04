package businesslogic.formapprovalbl;

import businesslogicservice.formapprovalblservice.CarOfficeFormFormapprovalblService;
import clienthelper.transitclienthelper.CarOfficeFormClientHelper;
import po.CarOfficeFormPO;
import state.FormState;
import vo.CarOfficeFormVO;

public class CarOfficeFormFormapproval implements CarOfficeFormFormapprovalblService{

	CarOfficeFormClientHelper carOfficeFormClientHelper = new CarOfficeFormClientHelper();

	public CarOfficeFormPO setPO(CarOfficeFormVO vo){
		
		CarOfficeFormPO po = new CarOfficeFormPO();
		po.setAllIDs(vo.getAllIDs());
		po.setCarNumber(vo.getCarNumber());
		po.setDestiantion(vo.getDestination());
		po.setLoadingMember(vo.getLoadingMember());
		po.setMotorNumber(vo.getMotorNumber());
		po.setNO(vo.getNO());
		po.setOfficeNumber(vo.getCarNumber());
		po.setPutOnCarDate(vo.getPutOnCarDate());
		po.setSupercargo(vo.getSupercargo());
		po.setTransitChange(vo.getTransitCharge());
		
		return po;
	}
	
	public boolean CarOfficeFormjudge(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		CarOfficeFormPO po = new CarOfficeFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.APPROVED);
		if(carOfficeFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

}
