package businesslogicservice.corporationblservice;

import java.rmi.Remote;
import java.util.ArrayList;

import vo.CarInfoVO;

/**
 * 车辆信息业务逻辑
 */
public interface CarInfocorporationblService extends Remote{
	
	
	/**
	 * 找到所有车辆信息
	 * @return 可能为null，表示暂无车辆信息的记录
	 */
	public ArrayList<CarInfoVO> findAll();
	
	/**
	 * 添加车辆信息
	 * @param po 待添加的车辆信息VO对象
	 * @return
	 */
	public boolean add(CarInfoVO po);
	
	/**
	 * 删除车辆信息
	 * @param po 待删除的车辆信息VO对象
	 * @return
	 */
	public boolean delete(CarInfoVO po);
	
	/**
	 * 更具车辆代号查找车辆信息
	 * @param carNumber 车辆代号
	 * @return
	 */
	public CarInfoVO find(String carNumber);
	
	/**
	 * 更新车辆信息
	 * @param po 待更新的车辆信息VO对象
	 * @return
	 */
	public boolean update(CarInfoVO po);
	
}
