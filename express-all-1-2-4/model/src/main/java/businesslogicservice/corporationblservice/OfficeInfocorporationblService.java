/**
 * @author 谭琼
 * 2015年12月14日
 */
package businesslogicservice.corporationblservice;

import java.util.ArrayList;

import state.City;
import vo.OfficeVO;

/**
 * 营业厅信息业务逻辑层接口
 */
public interface OfficeInfocorporationblService {
	
	/**
	 * 查找某一城市的所有营业厅
	 * @param city
	 * @return
	 */
	public ArrayList<OfficeVO> findAll(City city);
	
	/**
	 * 获取下一个营业厅编号
	 * @param city
	 * @return
	 */
	public String getNextOfficeID(City city);
	
	/**
	 * 添加营业厅信息
	 * @param vo
	 * @return
	 */
	public boolean add(OfficeVO vo);
	
	/**
	 * 删除营业厅信息
	 * @param vo
	 * @return
	 */
	public boolean delete(OfficeVO vo);
	
	/**
	 * 查找营业厅信息
	 * @param officeID
	 * @return
	 */
	public OfficeVO find(String officeID);
	
	/**
	 * 更新营业厅信息
	 * @param vo
	 * @return
	 */
	public boolean update(OfficeVO vo);
}
