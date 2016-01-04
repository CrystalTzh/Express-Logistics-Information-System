package businesslogicservice.inventoryblservice;

import vo.StorageInFormVO;

public interface StorageInFormInventoryblService {
	public StorageInFormVO StorageInFormcreate ();
	public void StorageInFormcancel (StorageInFormVO vo);
	public boolean StorageInFormsave (StorageInFormVO vo);
	public boolean StorageInFormsubmit (StorageInFormVO vo);
	public boolean StorageInFormwithdraw (StorageInFormVO vo);
	
	
}
