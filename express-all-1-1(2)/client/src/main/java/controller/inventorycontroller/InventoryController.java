/**
 * @author 谭琼
 * 2015年12月9日
 */
package controller.inventorycontroller;

import java.math.BigDecimal;
import java.util.Hashtable;
import java.util.Iterator;

import businesslogic.inventorybl.InventoryInfobl;
import po.PositionPO;
import state.NodeState;
import state.Zone;
import vo.InventoryInfoVO;

/**
 * 库存警戒值控制器
 */
public class InventoryController {
	/**
	 * 设置某一仓库的库存警戒值
	 * 
	 * @param inventoryID
	 * @param limit
	 * @return
	 */
	public boolean setLimit(String inventoryID, double limit) {
		System.out.println("进入LimitSetController...setLimit...");
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		vo.setLimit(limit);// 修改库存警戒值
		if (inventoryInfobl.updateInventoryInfo(vo)) { // 更新库存信息
			return true;
		}
		return false;
	}

	/**
	 * 根据仓库标识查找库存警戒值
	 * 
	 * @param inventoryID
	 * @return
	 */
	public double getLimit(String inventoryID) {
		System.out.println("进入LimitSetController...getLimit...");
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		return vo.getLimit();
	}

	/**
	 * 根据仓库标识查找机动仓库的状态
	 * 
	 * @param inventoryID
	 * @return
	 */
	public Zone getEmptyZoneState(String inventoryID) {
		System.out.println("进入LimitSetController...getEmptyZoneState...");
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		return vo.getEmptyZone();
	}

	/**
	 * 调整某仓库的库存分区(即设置机动仓库的状态: 航空区、火车区、汽车区)
	 * 
	 * @param inventoryID
	 * @param zone
	 * @return
	 */
	public boolean adjustZone(String inventoryID, Zone zone) {
		System.out.println("进入LimitSetController...adjustZone...");
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		vo.setEmptyZone(zone);// 调整库存分区
		if (inventoryInfobl.updateInventoryInfo(vo)) {// 更新库存信息
			return true;
		}
		return false;
	}

	/**
	 * 库存报警
	 * 
	 * @param inventoryID
	 * @param zone
	 * @return 若仓库的某一区现有货物超过了库存警戒值，返回true；否则返回false
	 */
	public boolean inventoryAlarm(String inventoryID, Zone zone) {
		System.out.println("进入LimitSetController...inventoryAlarm...");
		// 获取库存信息
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		BigDecimal inventoryPercentage = this.getInventoryPercentage(inventoryID, zone);
		BigDecimal limit = BigDecimal.valueOf(vo.getLimit());
		if(inventoryPercentage.compareTo(limit) >= 0) {//zone区的库存占据率大于等于库存警戒值
			return true;//报警
		}
		return false;
	}

	/**
	 * 获取某仓库某一区的现在已有货物总量占总容量的大小
	 * 
	 * @param inventoryID
	 * @param zone
	 * @return
	 */
	public BigDecimal getInventoryPercentage(String inventoryID, Zone zone) {
		BigDecimal persentage, takenNum;
		InventoryInfobl inventoryInfobl = new InventoryInfobl();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		Hashtable<PositionPO, NodeState> planeZoneInfo = vo.getPlaneZoneInfo();
		Hashtable<PositionPO, NodeState> carZoneInfo = vo.getCarZoneInfo();
		Hashtable<PositionPO, NodeState> trainZoneInfo = vo.getTrainZoneInfo();
		Hashtable<PositionPO, NodeState> emptyZoneInfo = vo.getEmptyZoneInfo();
		switch(zone) {
		case PLANE://飞机区
			takenNum = BigDecimal.valueOf(this.takenPositionNum(planeZoneInfo));
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
		case CAR://汽车区
			takenNum= BigDecimal.valueOf(this.takenPositionNum(carZoneInfo));
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
		case TRAIN://火车区
			takenNum= BigDecimal.valueOf(this.takenPositionNum(trainZoneInfo));
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
		default://机动区
			takenNum= BigDecimal.valueOf(this.takenPositionNum(emptyZoneInfo));
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
		}
		return persentage;
	}
	
	/**
	 * 遍历zone区的位置信息，找出已经被占据的位置总数
	 * @param planeZoneInfo
	 * @return
	 */
	public int takenPositionNum(Hashtable<PositionPO, NodeState> planeZoneInfo) {
		int num = 0;
		for(Iterator<PositionPO> itr = planeZoneInfo.keySet().iterator(); itr.hasNext();) {
			if(planeZoneInfo.get(itr) == NodeState.TAKEN) {
				++num;
			}
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println("在controller测试");
		InventoryController inventoryController = new InventoryController();
		double limit = inventoryController.getLimit("01");
		// if(inventoryController.setLimit("01", 0.85)) {
		// System.out.println("Limit 即将更新为0.85！");
		// }
		System.out.println("controller找到limit: " + limit);
	}
}
