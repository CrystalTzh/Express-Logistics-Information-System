package businesslogic.transitbl;

import java.rmi.RemoteException;

import businesslogicservice.transitblservice.TransferFormTransitblService;
import clienthelper.transitclienthelper.TransferFormClientHelper;
import dataservice.transitdataservice.TransferFormTransitdataService;
import impl.transitImpl.TransferFormImpl;
import po.TransferFormPO;
import state.FormState;
import vo.TransferFormVO;

public class TransferForm implements TransferFormTransitblService{
	
	TransferFormClientHelper transferFormClientHelper = new TransferFormClientHelper();

	public TransferFormVO setVO(TransferFormPO po){
		TransferFormVO vo = new TransferFormVO();
		
		vo.setAllIDs(po.getAllIDs());
		vo.setDestination(po.getDestination());
		vo.setLine(po.getLine());
		vo.setLoadingMember(po.getLoadingMember());
		vo.setPutOnCarDate(po.getPutOnCarDate());
		vo.setRelayFormNumber(po.getRelayFormNumber());
		vo.setShelf(po.getShelf());
		vo.setStartingpoint(po.getStartingpoint());
		vo.setTag(po.getTag());
		vo.setTransCharge(po.getTransCharge());
		vo.setTransport(po.getTransport());
		vo.setZone(po.getZone());
		
		return vo;
	}
	
	public TransferFormPO setPO(TransferFormVO vo){
		TransferFormPO po = new TransferFormPO();
		
		po.setAllIDs(vo.getAllIDs());
		po.setDestination(vo.getDestination());
		po.setLine(vo.getLine());
		po.setLoadingMember(vo.getLoadingMember());
		po.setPutOnCarDate(vo.getPutOnCarDate());
		po.setRelayFormNumber(vo.getRelayFormNumber());
		po.setShelf(vo.getShelf());
		po.setStartingpoint(vo.getStartingpoint());
		po.setTag(vo.getTag());
		po.setTransCharge(vo.getTransCharge());
		po.setTransport(vo.getTransport());
		po.setZone(vo.getZone());
		
		return po;
	}
	
	public TransferFormVO TransferFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入TransferFormbl...findTransferForm...");
		TransferFormTransitdataService transferFormTransitdataService = new TransferFormImpl();
		TransferFormPO po1 = transferFormClientHelper.goFind(number);
		TransferFormPO po2 = transferFormTransitdataService.find(number);
		if(po1!=null){
			TransferFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			TransferFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public TransferFormVO TransferFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void TransferFormcancel(TransferFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean TransferFormsave(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入TransferFormbl...saveTransferForm...");
		TransferFormPO po = new TransferFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		TransferFormTransitdataService transferFormTransitdataService = null;
		try {
			transferFormTransitdataService = new TransferFormImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			transferFormTransitdataService.insert(po);
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

	public boolean TransferFormsubmit(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入TransferFormbl...submitTransferForm...");
		TransferFormPO po = new TransferFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(transferFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean TransferFormwithdraw(TransferFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入TransferFormbl...withdrawTransferForm...");
		TransferFormPO po = new TransferFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(transferFormClientHelper.goFind(po.getRelayFormNumber()) != null){
			if(transferFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

}
