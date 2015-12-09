package businesslogicservice.corporationblservice;

import vo.DriverInfoVO;

public interface DriverInfocorporationblService {
	public DriverInfoVO create();
	public boolean add(DriverInfoVO vo);
	public boolean delete(DriverInfoVO vo);
	public DriverInfoVO find(String driverNumber);
	public boolean update(DriverInfoVO vo);
}
