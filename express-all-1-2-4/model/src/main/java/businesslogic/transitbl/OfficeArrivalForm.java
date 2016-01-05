package businesslogic.transitbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.transitblservice.OfficeArrivalFormTransitblService;
import clienthelper.transitclienthelper.OfficeArrivalFormClientHelper;
import dataservice.transitdataservice.OfficeArrivalFormTransitdataService;
import impl.transitImpl.OfficeArrivalFormImpl;
import po.OfficeArrivalFormPO;
import state.FormState;
import vo.OfficeArrivalFormVO;

public class OfficeArrivalForm implements OfficeArrivalFormTransitblService{

	OfficeArrivalFormClientHelper officeArrivalFormClientHelper = new OfficeArrivalFormClientHelper();
	
	public OfficeArrivalFormVO setVO(OfficeArrivalFormPO po){
		
		OfficeArrivalFormVO vo = new OfficeArrivalFormVO();
		vo.setArriveDate(po.getArriveDate());
		vo.setDestination(po.getDestination());
		vo.setNO(po.getNO());
		vo.setRelayformnumber(po.getRelayformnumber());
	
		vo.setState(po.getState());
		
		return vo;
	}
	
	public OfficeArrivalFormPO setPO(OfficeArrivalFormVO vo){
		
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po.setArriveDate(vo.getArriveDate());
		po.setDestination(vo.getDestination());
		po.setNO(vo.getNO());
		po.setRelayformnumber(vo.getRelayformnumber());

		po.setState(vo.getState());
		
		return po;
	}
	
	public OfficeArrivalFormVO OfficeArrivalFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入OfficeArrivalFormbl...findOfficeArrivalForm...");
		OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = new OfficeArrivalFormImpl();
		OfficeArrivalFormPO po1 = officeArrivalFormClientHelper.goFind(number);
		OfficeArrivalFormPO po2 = officeArrivalFormTransitdataService.find(number);
		if(po1!=null){
			OfficeArrivalFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			OfficeArrivalFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public OfficeArrivalFormVO OfficeArrivalFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void OfficeArrivalFormcancel(OfficeArrivalFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean OfficeArrivalFormsave(OfficeArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OfficeArrivalFormbl...saveOfficeArrivalForm...");
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		OfficeArrivalFormTransitdataService officeArrivalFormTransitdataService = null;
		try {
			officeArrivalFormTransitdataService = new OfficeArrivalFormImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			officeArrivalFormTransitdataService.insert(po);
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

	public boolean OfficeArrivalFormsubmit(OfficeArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OfficeArrivalFormbl...submitOfficeArrivalForm...");
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(officeArrivalFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean OfficeArrivalFormwithdraw(OfficeArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OfficeArrivalFormbl...withdrawOfficeArrivalForm...");
		OfficeArrivalFormPO po = new OfficeArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(officeArrivalFormClientHelper.goFind(po.getNO()) != null){
			if(officeArrivalFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

	public ArrayList<OfficeArrivalFormPO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...findAll...");
		return officeArrivalFormClientHelper.goFindAll();
	}

}
