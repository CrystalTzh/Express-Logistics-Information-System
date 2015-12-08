package businesslogicservice.transitblservice;

import vo.CarInputFormVO;

public interface CarInputFormTransitblService {
	public CarInputFormVO CarInputFormcreate ();
	public void CarInputFormcancel (CarInputFormVO vo);
	public boolean CarInputFormsave (CarInputFormVO vo);
	public boolean CarInputFormsubmit (CarInputFormVO vo);
	public boolean CarInputFormwithdraw (CarInputFormVO vo);
}
