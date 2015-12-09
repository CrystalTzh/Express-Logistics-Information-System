package businesslogicservice.inventoryblservice;

import state.Zone;
import vo.StorageInFormVO;

public interface StorageInFormInventoryblService {
	public StorageInFormVO StorageInFormcreate ();
	public void StorageInFormcancel (StorageInFormVO vo);
	public boolean StorageInFormsave (StorageInFormVO vo);
	public boolean StorageInFormsubmit (StorageInFormVO vo);
	public boolean StorageInFormwithdraw (StorageInFormVO vo);
	
	public boolean StorageInFormAddInfo (String date, String destination, Zone zone,
			int line,int shelf,int tag,long ID);
}
