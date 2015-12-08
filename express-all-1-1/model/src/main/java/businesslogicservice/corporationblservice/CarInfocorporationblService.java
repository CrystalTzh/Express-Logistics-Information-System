package businesslogicservice.corporationblservice;

import java.rmi.Remote;

import po.CarInfoPO;
import vo.CarInfoVO;

public interface CarInfocorporationblService extends Remote{
	public CarInfoVO create();
	public boolean add(CarInfoVO po);
	public boolean delete(CarInfoVO po);
	public CarInfoVO find(String carNumber);
	public boolean update(CarInfoVO po);
	
}
