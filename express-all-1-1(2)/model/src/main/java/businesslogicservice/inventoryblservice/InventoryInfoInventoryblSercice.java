package businesslogicservice.inventoryblservice;

import vo.InventoryInfoVO;

/**
 * 仓库信息业务逻辑接口
 */
public interface InventoryInfoInventoryblSercice {
	
	/**
	 * 根据仓库信息查找库存信息
	 * @param inventoryID
	 * @return
	 */
	public InventoryInfoVO findInventoryInfo(String inventoryID);
	
	/**
	 * 增加一个仓库的库存信息
	 * @param vo
	 * @return
	 */
	public boolean addInventoryInfo(InventoryInfoVO vo);
	
	/**
	 * 更新某仓库的库存信息
	 * @param vo
	 * @return
	 */
	public boolean updateInventoryInfo(InventoryInfoVO vo);
	
	/**
	 * 删除某仓库的库存信息
	 * @param vo
	 * @return
	 */
	public boolean deleteInventoryInfo(InventoryInfoVO vo);
}
