package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.CarOfficeFormTransitblService;
import vo.CarInfoVO;
import vo.CarOfficeFormVO;

public class CarOfficeTransitblStub implements CarOfficeFormTransitblService{

	public CarOfficeFormVO CarOfficeFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call CarOfficeFormcreate...");
		return null;
	}

	public void CarOfficeFormcancel(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarOfficeFormcancel...");
	}

	public boolean CarOfficeFormsave(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarOfficeFormsave...");
		return false;
	}

	public boolean CarOfficeFormsubmit(CarOfficeFormVO vo) {
		// TODO print "Submit CarOfficeForm Successfully!"
		System.out.println("Call CarOfficeFormsubmit...");
		return true;
	}

	public boolean CarOfficeFormwithdraw(CarOfficeFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarOfficeFormwithdraw...");
		return false;
	}
}
