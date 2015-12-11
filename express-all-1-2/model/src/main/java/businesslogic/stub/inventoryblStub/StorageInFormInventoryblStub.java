package businesslogic.stub.inventoryblStub;

import state.Zone;
import vo.StorageInFormVO;
import businesslogicservice.inventoryblservice.StorageInFormInventoryblService;

public class StorageInFormInventoryblStub implements
		StorageInFormInventoryblService {

	public StorageInFormVO StorageInFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("call StorageInFormcreate...");
		return null;
	}

	public void StorageInFormcancel(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageInFormcancel...");
	}

	public boolean StorageInFormsave(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageInFormsave...");
		return false;
	}

	public boolean StorageInFormsubmit(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageInFormsubmit...");
		return false;
	}

	public boolean StorageInFormwithdraw(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageInFormwithdraw...");
		return false;
	}

	public boolean StorageInFormAddInfo(String date, String destination,
			Zone zone, int line, int shelf, int tag, long ID) {
		// TODO Auto-generated method stub
		
		return true;
	}

}
