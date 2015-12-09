package businesslogic.transitbl;

import java.rmi.RemoteException;

import clienthelper.transitclienthelper.CarOfficeFormClientHelper;
import businesslogicservice.transitblservice.CarOfficeFormTransitblService;
import dataservice.transitdataservice.CarOfficeTransitdataService;
import impl.transitImpl.CarOfficeFormImpl;
import po.CarOfficeFormPO;
import state.FormState;
import vo.CarOfficeFormVO;

public class CarOfficeForm implements CarOfficeFormTransitblService{
	
	CarOfficeFormClientHelper carOfficeFormClientHelper = new CarOfficeFormClientHelper();

	public CarOfficeFormVO setVO(CarOfficeFormPO po){
		
		CarOfficeFormVO vo = new CarOfficeFormVO();
		vo.setAllIDs(po.getAllIDs());
		vo.setCarNumber(po.getCarNumber());
		vo.setDestination(po.getDestiantion());
		vo.setLoadingMember(po.getLoadingMember());
		vo.setMotorNumber(po.getMotorNumber());
		vo.setNO(po.getNO());
		vo.setCarNumber(po.getOfficeNumber());
		vo.setPutOnCarDate(po.getPutOnCarDate());
		vo.setSupercargo(po.getSupercargo());
		vo.setTransitCharge(po.getTransitChange());
		
		return vo;
	}
	
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
	
	public CarOfficeFormVO CarOfficeFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入CarOfficeFormbl...findCarOfficeForm...");
		CarOfficeTransitdataService carOfficeTransitdataService = new CarOfficeFormImpl();
		CarOfficeFormPO po1 = carOfficeFormClientHelper.goFind(number);
		CarOfficeFormPO po2 = carOfficeTransitdataService.find(number);
		if(po1!=null){
			CarOfficeFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			CarOfficeFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public CarOfficeFormVO CarOfficeFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void CarOfficeFormcancel(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean CarOfficeFormsave(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarOfficeFormbl...saveCarOfficeForm...");
		CarOfficeFormPO po = new CarOfficeFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		CarOfficeTransitdataService carOfficeTransitdataService = null;
		try {
			carOfficeTransitdataService = new CarOfficeFormImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			carOfficeTransitdataService.insert(po);
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

	public boolean CarOfficeFormsubmit(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarOfficeFormbl...submitCarOfficeForm...");
		CarOfficeFormPO po = new CarOfficeFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(carOfficeFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean CarOfficeFormwithdraw(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

}
