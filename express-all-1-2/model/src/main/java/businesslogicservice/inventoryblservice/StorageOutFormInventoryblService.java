package businesslogicservice.inventoryblservice;

import vo.StorageOutFormVO;

public interface StorageOutFormInventoryblService {
	public StorageOutFormVO StorageOutFormcreate ();
	public void StorageOutFormcancel (StorageOutFormVO vo);
	public boolean StorageOutFormsave (StorageOutFormVO vo);
	public boolean StorageOutFormsubmit (StorageOutFormVO vo);
	public boolean StorageOutFormwithdraw (StorageOutFormVO vo);
}
