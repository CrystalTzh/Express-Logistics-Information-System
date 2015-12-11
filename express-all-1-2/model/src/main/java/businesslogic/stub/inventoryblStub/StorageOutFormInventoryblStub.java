package businesslogic.stub.inventoryblStub;

import state.Transport;
import vo.StorageOutFormVO;
import businesslogicservice.inventoryblservice.StorageOutFormInventoryblService;

public class StorageOutFormInventoryblStub implements
		StorageOutFormInventoryblService {

	public StorageOutFormVO StorageOutFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("call StorageOutFormcreate...");
		return null;
	}

	public void StorageOutFormcancel(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageOutFormcancel...");

	}

	public boolean StorageOutFormsave(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageOutFormsave...");
		return false;
	}

	public boolean StorageOutFormsubmit(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageOutFormsubmit...");
		return false;
	}

	public boolean StorageOutFormwithdraw(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("call StorageOutFormwithdraw...");
		return false;
	}

	public boolean storageOutFormAddInfo(String date, String destination,
			Transport transport, String relayNumber, String motorNumber) {
		// TODO Auto-generated method stub
		System.out.println("call storageOutFormAddInfo...");
		return true;
	}

}
