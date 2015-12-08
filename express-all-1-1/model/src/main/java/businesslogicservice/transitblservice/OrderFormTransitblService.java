package businesslogicservice.transitblservice;




import vo.OrderFormVO;

public interface OrderFormTransitblService {

	public OrderFormVO OrderFormcreate ();
	public void OrderFormcancel (OrderFormVO vo);
	public boolean OrderFormsave (OrderFormVO vo);
	public boolean OrderFormsubmit (OrderFormVO vo);
	public boolean OrderFormwithdraw (OrderFormVO vo);
}
