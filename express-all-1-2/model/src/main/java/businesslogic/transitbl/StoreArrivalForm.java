package businesslogic.transitbl;

import java.rmi.RemoteException;

import businesslogicservice.transitblservice.StoreArrivalFormTransitblService;
import clienthelper.transitclienthelper.StoreArrivalFormClientHelper;
import dataservice.transitdataservice.StoreArrivalFormTransitdataService;
import impl.transitImpl.StoreArrivalFormImpl;
import po.StoreArrivalFormPO;
import state.FormState;
import vo.StoreArrivalFormVO;

public class StoreArrivalForm implements StoreArrivalFormTransitblService{

	StoreArrivalFormClientHelper storeArrivalFormClientHelper = new StoreArrivalFormClientHelper();
	
	public StoreArrivalFormPO setPO(StoreArrivalFormVO vo){
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po.setArriveDate(vo.getArriveDate());
		po.setNO(vo.getNO());
		po.setRelayformnumber(vo.getRelayformnumber());
		po.setRelaynumber(vo.getRelaynumber());
		po.setStartingPoint(vo.getStartingPoint());
		po.setState(vo.getState());
		return po;
	}
	
	public StoreArrivalFormVO setVO(StoreArrivalFormPO po){
		StoreArrivalFormVO vo = new StoreArrivalFormVO();
		vo.setArriveDate(po.getArriveDate());
		vo.setNO(po.getNO());
		vo.setRelayformnumber(po.getRelayformnumber());
		
		vo.setRelaynumber(po.getRelaynumber());
		vo.setStartingPoint(po.getStartingPoint());
		vo.setState(po.getState());
		return vo;
	}
	
	public StoreArrivalFormVO StoreArrivalFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入StoreArrivalFormbl...findStoreArrivalForm...");
		StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = new StoreArrivalFormImpl();
		StoreArrivalFormPO po1 = storeArrivalFormClientHelper.goFind(number);
		StoreArrivalFormPO po2 = storeArrivalFormTransitdataService.find(number);
		if(po1!=null){
			StoreArrivalFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			StoreArrivalFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public StoreArrivalFormVO StoreArrivalFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void StoreArrivalFormcancel(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean StoreArrivalFormsave(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StoreArrivalFormbl...saveStoreArrivalForm...");
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		StoreArrivalFormTransitdataService storeArrivalFormTransitdataService = null;
		try {
			storeArrivalFormTransitdataService = new StoreArrivalFormImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			storeArrivalFormTransitdataService.insert(po);
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

	public boolean StoreArrivalFormsubmit(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StoreArrivalFormbl...submitStoreArrivalForm...");
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(storeArrivalFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean StoreArrivalFormwithdraw(StoreArrivalFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入OrderFormbl...withdrawOrderForm...");
		StoreArrivalFormPO po = new StoreArrivalFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(storeArrivalFormClientHelper.goFind(po.getNO()) != null){
			if(storeArrivalFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

}
