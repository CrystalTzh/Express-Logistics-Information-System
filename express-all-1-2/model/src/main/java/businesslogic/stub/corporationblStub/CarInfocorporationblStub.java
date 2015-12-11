package businesslogic.stub.corporationblStub;

import businesslogicservice.corporationblservice.CarInfocorporationblService;
import vo.CarInfoVO;

public class CarInfocorporationblStub implements CarInfocorporationblService{

	public CarInfoVO create() {
		// TODO Auto-generated method stub
		System.out.println("Call CarInfoVO create...");
		return null;
	}

	public boolean add(CarInfoVO vo) {
		// TODO to print "add carInfo successfully!"
//		System.out.println("add carInfo successfully!");
		System.out.println("Call CarInfoVO add...");
		return true;
	}

	public boolean delete(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInfoVO delete...");
		return true;
	}

	public CarInfoVO find(String carNumber) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInfoVO find...");
		return null;
	}

	public boolean update(CarInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call CarInfoVO update...");
		return true;
	}

}
