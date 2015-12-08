package businesslogic.driver.constblDriver;

import po.ConstPO;
import vo.ConstInfoVO;

import java.rmi.RemoteException;

import businesslogicservice.constblservice.ConstInfoConstblService;

public class ConstInfoConstblDriver {
	public void driver(ConstInfoConstblService constInfoConstblStub) throws RemoteException, IllegalArgumentException{
		ConstInfoVO constInfoVO1 = constInfoConstblStub.find();
		double baseSalary = constInfoVO1.getBaseSalary();
		System.out.println("The baseSalary is "+baseSalary);
		ConstInfoVO constInfoVO2 = constInfoConstblStub.update(constInfoVO1);
	
	}
}
