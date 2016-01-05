package businesslogic.stub.corporationblStub;

import java.util.ArrayList;

import businesslogicservice.corporationblservice.DriverInfocorporationblService;
import vo.DriverInfoVO;

public class DriverInfocorporationblStub implements DriverInfocorporationblService{

	public DriverInfoVO create() {
		// TODO Auto-generated method stub
		System.out.println("Call DriverInfoVO create...");
		return null;
	}

	public boolean add(DriverInfoVO vo) {
		// TODO print add carInfo successfully!
		System.out.println("Call DriverInfoVO add...");
		return true;
	}

	public boolean delete(DriverInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call DriverInfoVO delete...");
		return true;
	}

	public DriverInfoVO find(String driverNumber) {
		// TODO Auto-generated method stub
		System.out.println("Call DriverInfoVO find...");
		return null;
	}

	public boolean update(DriverInfoVO vo) {
		// TODO Auto-generated method stub
		System.out.println("Call DriverInfoVO update...");
		return true;
	}

	@Override
	public ArrayList<DriverInfoVO> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
