/**
 * @author 谭琼
 * 2015年12月14日
 */
package businesslogicservice.corporationblservice;

import java.util.ArrayList;

import state.City;
import vo.TransferOfficeVO;

/**
 * 中转中心业务逻辑接口
 */
public interface TransferOfficeInfocoporationblService {
	
	/**
	 * 查找某一城市的所有中转中心
	 * @param city
	 * @return
	 */
	public ArrayList<TransferOfficeVO> findAll(City city);
	
	/**
	 * 获取下一个中转中心编号
	 * @param city
	 * @return
	 */
	public String getNextOffceID(City city);
	
	/**
	 * 添加中转中心信息
	 * @param vo
	 * @return
	 */
	public boolean add(TransferOfficeVO vo);
	
	/**
	 * 删除中转中心信息
	 * @param vo
	 * @return
	 */
	public boolean delete(TransferOfficeVO vo);
	
	/**
	 * 查找中转中心信息
	 * @param transferOfficeID
	 * @return
	 */
	public TransferOfficeVO find(String transferOfficeID);
	
	/**
	 * 更新中转中心信息
	 * @param vo
	 * @return
	 */
	public boolean update(TransferOfficeVO vo);
}
