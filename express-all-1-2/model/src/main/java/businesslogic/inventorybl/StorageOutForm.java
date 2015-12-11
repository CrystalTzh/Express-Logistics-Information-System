package businesslogic.inventorybl;

import java.rmi.RemoteException;

import businesslogicservice.inventoryblservice.StorageOutFormInventoryblService;
import clienthelper.inventoryinfoclienthelper.StorageOutFormClientHelper;
import dataservice.inventorydataservice.StorageOutFromInventorydataService;
import impl.inventoryImpl.StorageOutFormServiceImpl;
import po.StorageOutFormPO;
import state.FormState;
import state.Transport;
import vo.StorageOutFormVO;

public class StorageOutForm implements StorageOutFormInventoryblService {

	StorageOutFormClientHelper clienthelper = new StorageOutFormClientHelper();
	
	public StorageOutFormVO StorageOutFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入StorageOutFormbl...findStorageOutForm...");
		StorageOutFromInventorydataService storageOutFormInventorydataService = new StorageOutFormServiceImpl();
		StorageOutFormPO po1 = clienthelper.goFind(number);
		StorageOutFormPO po2 = storageOutFormInventorydataService.find(number);
		if(po1!=null){
			StorageOutFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			StorageOutFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public StorageOutFormVO setVO(StorageOutFormPO po){
		
		StorageOutFormVO vo = new StorageOutFormVO();
		vo.setDate(po.getDate());
		vo.setDestination(po.getDestination());
		vo.setExpressNumber(po.getExpressNumber());
		vo.setNO(po.getNO());
		vo.setSportNO(po.getSportNO());
		vo.setTransferNO(po.getTransferNO());
		vo.setTransport(po.getTransport());
		
		return vo;
	}
	
	public StorageOutFormPO setPO(StorageOutFormVO vo){
		
		StorageOutFormPO po = new StorageOutFormPO();
		po.setDate(vo.getDate());
		po.setDestination(vo.getDestination());
		po.setExpressNumber(vo.getExpressNumber());
		po.setNO(vo.getNO());
		po.setSportNO(vo.getSportNO());
		po.setTransferNO(vo.getTransferNO());
		po.setTransport(vo.getTransport());
		
		return po;
	}
	
	public StorageOutFormVO StorageOutFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void StorageOutFormcancel(StorageOutFormVO vo) {
		// TODO Auto-generated method stub

	}

	public boolean StorageOutFormsave(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageOutFormbl...saveStorageOutForm...");
		StorageOutFormPO po = new StorageOutFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		StorageOutFromInventorydataService storageOutFromInventorydataService = null;
		try {
			storageOutFromInventorydataService = new StorageOutFormServiceImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			storageOutFromInventorydataService.insert(po);
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

	public boolean StorageOutFormsubmit(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageOutFormbl...submitStorageOutForm...");
		StorageOutFormPO po = new StorageOutFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(clienthelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean StorageOutFormwithdraw(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageOutFormbl...withdrawStorageOutForm...");
		StorageOutFormPO po = new StorageOutFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(clienthelper.goFind(po.getNO()) != null){
			if(clienthelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

	@Override
	public boolean storageOutFormAddInfo(String date, String destination, Transport transport, String relayNumber,
			String motorNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
