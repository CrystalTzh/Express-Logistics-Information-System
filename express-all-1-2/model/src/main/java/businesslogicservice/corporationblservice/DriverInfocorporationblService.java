package businesslogicservice.corporationblservice;

import java.util.ArrayList;

import vo.DriverInfoVO;

/**
 * 司机信息业务逻辑层接口
 */
public interface DriverInfocorporationblService {
	
	/**
	 * 查找所有司机信息
	 * @return
	 */
	public ArrayList<DriverInfoVO> findAll();
	
	/**
	 * 添加司机信息
	 * @param vo
	 * @return
	 */
	public boolean add(DriverInfoVO vo);
	
	/**
	 * 删除司机信息
	 * @param vo
	 * @return
	 */
	public boolean delete(DriverInfoVO vo);
	
	/**
	 * 查找司机信息
	 * @param driverNumber
	 * @return
	 */
	public DriverInfoVO find(String driverNumber);
	
	/**
	 * 更新司机信息
	 * @param vo
	 * @return
	 */
	public boolean update(DriverInfoVO vo);
}
