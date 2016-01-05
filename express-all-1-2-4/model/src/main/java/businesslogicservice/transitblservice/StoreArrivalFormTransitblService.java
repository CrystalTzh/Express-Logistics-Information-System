package businesslogicservice.transitblservice;

import vo.StoreArrivalFormVO;

public interface StoreArrivalFormTransitblService {

	public StoreArrivalFormVO StoreArrivalFormcreate ();
	public void StoreArrivalFormcancel (StoreArrivalFormVO vo);
	public boolean StoreArrivalFormsave (StoreArrivalFormVO vo);
	public boolean StoreArrivalFormsubmit (StoreArrivalFormVO vo);
	public boolean StoreArrivalFormwithdraw (StoreArrivalFormVO vo);
	
}
