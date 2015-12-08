package businesslogic.stub.transitblStub;

import businesslogicservice.transitblservice.CarInputFormTransitblService;
import vo.CarInputFormVO;

public class CarInputFormTransitblStub implements CarInputFormTransitblService{

	public CarInputFormVO CarInputFormcreate() {
		// TODO Auto-generated method stub
		System.out.println("Call CatInputFormcreat...");
		return null;
	}

	public void CarInputFormcancel(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInputFormcancel...");
	}

	public boolean CarInputFormsave(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInputFormsave...");
		return false;
	}

	public boolean CarInputFormsubmit(CarInputFormVO vo) {
		// TODO print "Submit successfully!"
		System.out.println("Call CarInputFormsubmit...");
		return true;
	}

	public boolean CarInputFormwithdraw(CarInputFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInputFormwithdraw...");
		return false;
	}
	
}
