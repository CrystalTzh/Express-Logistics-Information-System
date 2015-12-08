package businesslogicservice.transitblservice;

import vo.DeliveryFormVO;

public interface DeliveryFormTransitblService {
	public DeliveryFormVO DeliveryFormcreate ();
	public void DeliveryFormcancel (DeliveryFormVO vo);
	public boolean DeliveryFormsave (DeliveryFormVO vo);
	public boolean DeliveryFormsubmit (DeliveryFormVO vo);
	public boolean DeliveryFormwithdraw (DeliveryFormVO vo);
}
