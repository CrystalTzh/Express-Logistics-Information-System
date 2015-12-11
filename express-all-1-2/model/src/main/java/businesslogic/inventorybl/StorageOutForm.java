package businesslogic.inventorybl;

import businesslogicservice.inventoryblservice.StorageOutFormInventoryblService;
import state.Transport;
import vo.StorageOutFormVO;

public class StorageOutForm implements StorageOutFormInventoryblService {

	public boolean storageOutFormAddInfo(String date, String destination, Transport transport, String relayNumber,
			String motorNumber) {
		// TODO Auto-generated method stub
		return false;
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
		return false;
	}

	public boolean StorageOutFormsubmit(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		
		return false;
	}

	public boolean StorageOutFormwithdraw(StorageOutFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	

}
