package businesslogicservice.inventoryblservice;

import state.Transport;
import vo.StorageOutFormVO;

public interface StorageOutFormInventoryblService {
	public StorageOutFormVO StorageOutFormcreate ();
	public void StorageOutFormcancel (StorageOutFormVO vo);
	public boolean StorageOutFormsave (StorageOutFormVO vo);
	public boolean StorageOutFormsubmit (StorageOutFormVO vo);
	public boolean StorageOutFormwithdraw (StorageOutFormVO vo);
	
	public boolean storageOutFormAddInfo (String date, String destination, 
			Transport transport, String relayNumber,String motorNumber);
}
