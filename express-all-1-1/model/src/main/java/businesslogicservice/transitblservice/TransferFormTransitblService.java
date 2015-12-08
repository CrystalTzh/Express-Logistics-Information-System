package businesslogicservice.transitblservice;

import vo.TransferFormVO;

public interface TransferFormTransitblService {
	public TransferFormVO TransferFormcreate ();
	public void TransferFormcancel (TransferFormVO vo);
	public boolean TransferFormsave (TransferFormVO vo);
	public boolean TransferFormsubmit (TransferFormVO vo);
	public boolean TransferFormwithdraw (TransferFormVO vo);
}
