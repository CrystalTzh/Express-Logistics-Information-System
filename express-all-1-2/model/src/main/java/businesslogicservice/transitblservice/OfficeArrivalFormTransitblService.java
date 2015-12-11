package businesslogicservice.transitblservice;

import vo.OfficeArrivalFormVO;

public interface OfficeArrivalFormTransitblService {
	public OfficeArrivalFormVO OfficeArrivalFormcreate ();
	public void OfficeArrivalFormcancel (OfficeArrivalFormVO vo);
	public boolean OfficeArrivalFormsave (OfficeArrivalFormVO vo);
	public boolean OfficeArrivalFormsubmit (OfficeArrivalFormVO vo);
	public boolean OfficeArrivalFormwithdraw (OfficeArrivalFormVO vo);
}
