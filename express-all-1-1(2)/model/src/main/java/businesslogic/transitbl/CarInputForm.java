package businesslogic.transitbl;

import java.rmi.RemoteException;

import businesslogicservice.transitblservice.CarInputFormTransitblService;
import clienthelper.transitclienthelper.CarInputFormClientHelper;
import dataservice.transitdataservice.CarInputFormTransitdataService;
import impl.transitImpl.CarInputFormIml;
import po.CarInputFormPO;
import state.FormState;
import vo.CarInputFormVO;

public class CarInputForm implements CarInputFormTransitblService{
	
	CarInputFormClientHelper carInputFormClientHelper = new CarInputFormClientHelper();

	public CarInputFormVO setVO(CarInputFormPO po){
		CarInputFormVO vo = new CarInputFormVO();
		vo.setAllIDs(po.getAllIDs());
		vo.setCarNumber(po.getCarNumber());
		vo.setDestination(po.getDestination());
		vo.setLoadingMember(po.getLoadingMember());
		vo.setMotorNumber(po.getMotorNumber());
		vo.setNO(po.getNO());
		vo.setPutOnCarDate(po.getPutOnCarDate());
		vo.setSupercargo(po.getSupercargo());
		vo.setTransCharge(po.getTransCharge());
		return vo;
	}
	
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

	public CarInputFormVO CarInputFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入CarInputFormbl...findCarInputForm...");
		CarInputFormTransitdataService carInputFormTransitdataService = new CarInputFormIml();
		CarInputFormPO po1 = carInputFormClientHelper.goFind(number);
		CarInputFormPO po2 = carInputFormTransitdataService.find(number);
		if(po1!=null){
			CarInputFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			CarInputFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public CarInputFormVO CarInputFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void CarInputFormcancel(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean CarInputFormsave(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInputFormbl...saveCarInputForm...");
		CarInputFormPO po = new CarInputFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		CarInputFormTransitdataService carInputFormTransitdataService = null;
		try {
			carInputFormTransitdataService = new CarInputFormIml();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			carInputFormTransitdataService.insert(po);
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

	public boolean CarInputFormsubmit(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInputFormbl...submitCarInputForm...");
		CarInputFormPO po = new CarInputFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(carInputFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean CarInputFormwithdraw(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入CarInputFormbl...withdrawCarInputForm...");
		CarInputFormPO po = new CarInputFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(carInputFormClientHelper.goFind(po.getNO()) != null){
			if(carInputFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

}
