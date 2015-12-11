package businesslogic.inventorybl;

import java.rmi.RemoteException;

import businesslogicservice.inventoryblservice.StorageInFormInventoryblService;
import clienthelper.inventoryinfoclienthelper.StorageInFormClientHelper;
import dataservice.inventorydataservice.StorageInFormInventorydataService;
import impl.inventoryImpl.StorageInFormServiceImpl;
import impl.inventoryImpl.StorageOutFormServiceImpl;
import po.InventoryInfoPO;
import po.StorageInFormPO;
import po.StorageOutFormPO;
import state.FormState;
import state.Zone;
import vo.StorageInFormVO;

public class StorageInForm implements StorageInFormInventoryblService {
	
	StorageInFormClientHelper storageInFormClientHelper = new StorageInFormClientHelper();
	
	public InventoryInfoPO findInventoryInfo(String inventoryID){
		System.out.println("进入StorageInFormbl...findEmptyposition...");
		return storageInFormClientHelper.goFindinventory(inventoryID);
	}

	public StorageInFormVO StorageInFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入StorageInFormbl...findStorageInForm...");
		StorageInFormInventorydataService storageInFormInventorydataService = new StorageInFormServiceImpl();
		StorageInFormPO po1 = storageInFormClientHelper.goFind(number);
		StorageInFormPO po2 = storageInFormInventorydataService.find(number);
		if(po1!=null){
			StorageInFormVO vo = setVO(po1);
			return vo;
		}
		if(po2!=null){
			StorageInFormVO vo = setVO(po2);
			return vo;
		}
		else{
			return null;
		}
	}
	
	public StorageInFormVO setVO(StorageInFormPO po){
		
		StorageInFormVO vo = new StorageInFormVO();
		vo.setDate(po.getDate());
		vo.setDestination(po.getDestination());
		vo.setExpressNumber(po.getExpressNumber());
		vo.setLine(po.getLine());
		vo.setNO(po.getNO());
		vo.setShelf(po.getShelf());
		vo.setTag(po.getTag());
		vo.setZone(po.getZone());
		
		return vo;
	}
	
	public StorageInFormPO setPO(StorageInFormVO vo){
		
		StorageInFormPO po = new StorageInFormPO();
		po.setDate(vo.getDate());
		po.setDestination(vo.getDestination());
		po.setExpressNumber(vo.getExpressNumber());
		po.setLine(vo.getLine());
		po.setNO(vo.getNO());
		po.setShelf(vo.getShelf());
		po.setTag(vo.getTag());
		po.setZone(vo.getZone());
		
		return po;
	}

	public StorageInFormVO StorageInFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void StorageInFormcancel(StorageInFormVO vo) {
		// TODO Auto-generated method stub

	}

	public boolean StorageInFormsave(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageInFormbl...saveStorageInForm...");
		StorageInFormPO po = new StorageInFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.DRAFT);
		StorageInFormInventorydataService storageInFormInventorydataService = null;
		try {
			storageInFormInventorydataService = new StorageInFormServiceImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			storageInFormInventorydataService.insert(po);
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

	public boolean StorageInFormsubmit(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageInFormbl...submitStorageInForm...");
		StorageInFormPO po = new StorageInFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.SUBMITTED);
		if(storageInFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	public boolean StorageInFormwithdraw(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入StorageInFormbl...withdrawStorageInForm...");
		StorageInFormPO po = new StorageInFormPO();
		po = setPO(vo);
		po.setFormstate(FormState.EDITABLE);
		if(storageInFormClientHelper.goFind(po.getNO()) != null){
			if(storageInFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

	@Override
	public boolean StorageInFormAddInfo(String date, String destination, Zone zone, int line, int shelf, int tag,
			long ID) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
