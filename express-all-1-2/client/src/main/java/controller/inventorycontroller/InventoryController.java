///**
// * @author 谭琼
// * 2015年12月9日
// */
//package controller.inventorycontroller;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.Hashtable;
//
//import businesslogic.inventorybl.InventoryInfo;
//import po.Position;
//import state.NodeState;
//import state.Zone;
//import vo.InventoryInfoVO;
//
///**InventoryController
// * 库存警戒值控制器
// */
//public class InventoryController {
//	
//	/**
//	 * 删除一个仓库
//	 * @param vo
//	 * @return
//	 */
//	public boolean deleteInventory(InventoryInfoVO vo) {
//		System.out.println("进入LimitSetController...deleteInventory...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		if(inventoryInfobl.deleteInventoryInfo(vo)) {
//			return true;
//		}
//		return false;
//	}
//	
//	/**
//	 * 添加一个仓库
//	 * @param vo
//	 * @return
//	 */
//	public boolean addInventory(InventoryInfoVO vo) {
//		System.out.println("进入LimitSetController...addInventory...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		if(inventoryInfobl.addInventoryInfo(vo)) {
//			return true;
//		}
//		return false;
//	}
//	/**
//	 * 设置某一仓库的库存警戒值
//	 * 
//	 * @param inventoryID
//	 * @param limit
//	 * @return
//	 */
//	public boolean setLimit(String inventoryID, double limit) {
//		System.out.println("进入LimitSetController...setLimit...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		vo.setLimit(limit);// 修改库存警戒值
//		if (inventoryInfobl.updateInventoryInfo(vo)) { // 更新库存信息
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 根据仓库标识查找库存警戒值
//	 * 
//	 * @param inventoryID
//	 * @return
//	 */
//	public double getLimit(String inventoryID) {
//		System.out.println("进入LimitSetController...getLimit...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		return vo.getLimit();
//	}
//
//	/**
//	 * 根据仓库标识查找机动仓库的状态
//	 * 
//	 * @param inventoryID
//	 * @return
//	 */
//	public Zone getEmptyZoneState(String inventoryID) {
//		System.out.println("进入LimitSetController...getEmptyZoneState...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		return vo.getEmptyZone();
//	}
//
//	/**
//	 * 调整某仓库的库存分区(即设置机动仓库的状态: 航空区、火车区、汽车区)
//	 * 
//	 * @param inventoryID
//	 * @param zone
//	 * @return
//	 */
//	public boolean adjustZone(String inventoryID, Zone zone) {
//		System.out.println("进入LimitSetController...adjustZone...");
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		vo.setEmptyZone(zone);// 调整库存分区
//		if (inventoryInfobl.updateInventoryInfo(vo)) {// 更新库存信息
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * 库存报警
//	 * 
//	 * @param inventoryID
//	 * @param zone
//	 * @return 若仓库的某一区现有货物超过了库存警戒值，返回true；否则返回false
//	 */
//	public boolean inventoryAlarm(String inventoryID, Zone zone) {
//		System.out.println("进入LimitSetController...inventoryAlarm...");
//		// 获取库存信息
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		BigDecimal inventoryPercentage = this.getInventoryPercentage(inventoryID, zone);
//		BigDecimal limit = BigDecimal.valueOf(vo.getLimit());
//		if (inventoryPercentage.compareTo(limit) >= 0) {// zone区的库存占据率大于等于库存警戒值
//			return true;// 报警
//		}
//		return false;
//	}
//
//	/**
//	 * 获取某仓库某一区的现在已有货物总量占总容量的大小
//	 * 
//	 * @param inventoryID
//	 * @param zone
//	 * @return
//	 */
//	public BigDecimal getInventoryPercentage(String inventoryID, Zone zone) {
//		BigDecimal persentage, takenNum;
////		InventoryInfobl inventoryInfobl = new InventoryInfobl();
////		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
////		Hashtable<NodeState, ArrayList<Position>> planeZoneInfo = vo.getPlaneZoneInfo();
////		Hashtable<NodeState, ArrayList<Position>> carZoneInfo = vo.getCarZoneInfo();
////		Hashtable<NodeState, ArrayList<Position>> trainZoneInfo = vo.getTrainZoneInfo();
////		Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo = vo.getEmptyZoneInfo();
//		switch (zone) {
//		case PLANE:// 飞机区
//			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.PLANE, NodeState.TAKEN).size());
//			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
//			break;
//		case CAR:// 汽车区
//			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.CAR, NodeState.TAKEN).size());
//			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
//			break;
//		case TRAIN:// 火车区
//			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.TRAIN, NodeState.TAKEN).size());
//			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
//			break;
//		default:// 机动区
//			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.EMPTY, NodeState.TAKEN).size());
//			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
//			break;
//		}
//		return persentage;
//	}
//	
//	/**
//	 * 找出zone区被占据或空闲的位置集合
//	 * @param inventoryID
//	 * @param zone
//	 * @param nodeState
//	 * @return
//	 */
//	public ArrayList<Position> takenOrVacantPosition(String inventoryID, Zone zone, NodeState nodeState) {
//		
//		InventoryInfo inventoryInfobl = new InventoryInfo();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		
//		ArrayList<Position> positions = new ArrayList<Position>();
//		
//		switch(zone) {
//		case PLANE://获取航空区被占据或空闲的位置集合
//			Hashtable<NodeState, ArrayList<Position>> planeZoneInfo = vo.getPlaneZoneInfo();
//			positions = planeZoneInfo.get(nodeState);
//			break;
//		case CAR://获取汽车区被占据或空闲的位置集合
//			Hashtable<NodeState, ArrayList<Position>> carZoneInfo = vo.getCarZoneInfo();
//			positions = carZoneInfo.get(nodeState);
//			break;
//		case TRAIN://获取火车区被占据或空闲的位置集合
//			Hashtable<NodeState, ArrayList<Position>> trainZoneInfo = vo.getTrainZoneInfo();
//			positions = trainZoneInfo.get(nodeState);
//			break;
//		case EMPTY://获取机动区被占据或空闲的位置集合
//			Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo = vo.getEmptyZoneInfo();
//			positions = emptyZoneInfo.get(nodeState);
//			break;
//		}
//		
//		return positions;
//	}
//	
//
////	public static void main(String[] args) {
////		System.out.println("在controller测试");
////		InventoryController inventoryController = new InventoryController();
//////		double limit = inventoryController.getLimit("01");
////		// if(inventoryController.setLimit("01", 0.85)) {
////		// System.out.println("Limit 即将更新为0.85！");
////		// }
//////		System.out.println("controller找到limit: " + limit);
////	}
//}


/**
 * @author 谭琼
 * 2015年12月9日
 */
package controller.inventorycontroller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Vector;

import businesslogic.inventorybl.InventoryInfo;
import po.Position;
import state.Line;
import state.NodeState;
import state.Shelf;
import state.Tag;
import state.Zone;
import vo.InventoryInfoVO;

/**InventoryController
 * 库存警戒值控制器
 */
public class InventoryController {
	
	public Vector<String> getvacantline(String inventoryID,Zone zone){
		Vector<String> Lines = new Vector<String>();
		int i = 0;
		boolean oneline = false;
		boolean twoline = false;
		boolean threeline = false;
		boolean fourline = false;
		InventoryController inventoryController= new InventoryController();
		ArrayList<Position> positions = inventoryController.takenOrVacantPosition(inventoryID,zone, NodeState.VACANT);
		while(i<positions.size()){
			switch (positions.get(i).getLine()) {
			case OneLine:
				oneline = true;
				break;
			case TwoLine:
				twoline = true;
				break;
			case ThreeLine:
				threeline = true;
				break;
			case FourLine:
				fourline = true;
				break;
			default:
				break;
			}
			i++;
		}
		if(oneline){
			Lines.add(Line.OneLine.toString());
		}
		if(twoline){
			Lines.add(Line.TwoLine.toString());
		}
		if(threeline){
			Lines.add(Line.ThreeLine.toString());
		}
		if(fourline){
			Lines.add(Line.FourLine.toString());
		}
		return Lines;
	}
	
	public Vector<String> getvacantshelf(String inventoryID,Zone zone,Line line){
		Vector<String> Shelfs = new Vector<String>();
		int i = 0;
		boolean ashelf = false;
		boolean bshelf = false;
		boolean cshelf = false;
		boolean dshelf = false;
		InventoryController inventoryController= new InventoryController();
		ArrayList<Position> positions = inventoryController.takenOrVacantPosition(inventoryID,zone, NodeState.VACANT);
		Position position;
		while(i<positions.size()){
			position = positions.get(i);
			if(position.getLine()==line){
				switch (position.getShelf()) {
				case AShelf:
					ashelf = true;
					break;
				case BShelf:
					bshelf = true;
					break;
				case CShelf:
					cshelf = true;
					break;
				case DShelf:
					dshelf = true;
					break;
				default:
					break;
				}
			}
			i++;
		}
		if(ashelf){
			Shelfs.add(Shelf.AShelf.toString());
		}
		if(bshelf){
			Shelfs.add(Shelf.BShelf.toString());
		}
		if(cshelf){
			Shelfs.add(Shelf.CShelf.toString());
		}
		if(dshelf){
			Shelfs.add(Shelf.DShelf.toString());
		}
		return Shelfs;
	}
	
	public Vector<String> getvacanttag(String inventoryID,Zone zone,Line line,Shelf shelf){
		Vector<String> Tags = new Vector<String>();
		int i = 0;
		boolean onetag = false;
		boolean twotag = false;
		boolean threetag = false;
		boolean fourtag = false;
		boolean fivetag = false;
		InventoryController inventoryController= new InventoryController();
		ArrayList<Position> positions = inventoryController.takenOrVacantPosition(inventoryID,zone, NodeState.VACANT);
		Position position;
		System.out.println("get vacanttag!");
		while(i<positions.size()){
			
			position = positions.get(i);
			System.out.println("Zone: "+position.getZone()+"Line: "+position.getLine()+"Shelf: "+position.getShelf()+"Tag: "+position.getTag());
			if(position.getLine()==line){
				System.out.println(" "+line);
				if(position.getShelf()==shelf){
					System.out.println(" "+shelf);
					switch (position.getTag()) {
					case OneTag:
						onetag = true;
						break;
					case TwoTag:
						twotag = true;
						break;
					case ThreeTag:
						threetag = true;
						break;
					case FourTag:
						fourtag = true;
						break;
					case FiveTag:
						fivetag = true;
						break;
					default:
						break;
					}
				}
			}
			i++;
		}
		System.out.println("onetag: "+onetag+" twotag: "+twotag+" threetag: "+threetag+" fourtag: "+fourtag+" fivetag: "+fivetag);
		if(onetag){
			Tags.add(Tag.OneTag.toString());
		}
		if(twotag){
			Tags.add(Tag.TwoTag.toString());
		}
		if(threetag){
			Tags.add(Tag.ThreeTag.toString());
		}
		if(fourtag){
			Tags.add(Tag.FourTag.toString());
		}
		if(fivetag){
			Tags.add(Tag.FiveTag.toString());
		}
		for(int j=0;j<Tags.size();j++){
			System.out.println(Tags.get(j));
		}
		return Tags;
	}
	
	/**
	 * 删除一个仓库
	 * @param vo
	 * @return
	 */
	public boolean deleteInventory(InventoryInfoVO vo) {
		System.out.println("进入LimitSetController...deleteInventory...");
		InventoryInfo inventoryInfobl = new InventoryInfo();
		if(inventoryInfobl.deleteInventoryInfo(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 添加一个仓库
	 * @param vo
	 * @return
	 */
	public boolean addInventory(InventoryInfoVO vo) {
		System.out.println("进入LimitSetController...addInventory...");
		InventoryInfo inventoryInfobl = new InventoryInfo();
		if(inventoryInfobl.addInventoryInfo(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 更新一个仓库
	 * @param vo
	 * @return
	 */
	public boolean updateInventory(InventoryInfoVO vo) {
		System.out.println("进入LimitSetController...addInventory...");
		InventoryInfo inventoryInfobl = new InventoryInfo();
		if(inventoryInfobl.updateInventoryInfo(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 查找一个仓库
	 * @param vo
	 * @return
	 */
	public InventoryInfoVO findInventory(String inventoryID) {
		System.out.println("进入LimitSetController...findInventory...");
		InventoryInfo inventoryInfobl = new InventoryInfo();
		return inventoryInfobl.findInventoryInfo(inventoryID);
	}

	/**
	 * 设置某一仓库的库存警戒值
	 * 
	 * @param inventoryID
	 * @param limit
	 * @return
	 */
	public boolean setLimit(String inventoryID, double limit) {
		System.out.println("进入LimitSetController...setLimit...");
		InventoryInfo inventoryInfobl = new InventoryInfo();
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
		InventoryInfo inventoryInfobl = new InventoryInfo();
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
		InventoryInfo inventoryInfobl = new InventoryInfo();
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
		InventoryInfo inventoryInfobl = new InventoryInfo();
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
		InventoryInfo inventoryInfobl = new InventoryInfo();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		BigDecimal inventoryPercentage = this.getInventoryPercentage(inventoryID, zone);
		BigDecimal limit = BigDecimal.valueOf(vo.getLimit());
		if (inventoryPercentage.compareTo(limit) >= 0) {// zone区的库存占据率大于等于库存警戒值
			return true;// 报警
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
//		InventoryInfobl inventoryInfobl = new InventoryInfobl();
//		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
//		Hashtable<NodeState, ArrayList<Position>> planeZoneInfo = vo.getPlaneZoneInfo();
//		Hashtable<NodeState, ArrayList<Position>> carZoneInfo = vo.getCarZoneInfo();
//		Hashtable<NodeState, ArrayList<Position>> trainZoneInfo = vo.getTrainZoneInfo();
//		Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo = vo.getEmptyZoneInfo();
		switch (zone) {
		case PLANE:// 飞机区
			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.PLANE, NodeState.TAKEN).size());
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
			break;
		case CAR:// 汽车区
			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.CAR, NodeState.TAKEN).size());
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
			break;
		case TRAIN:// 火车区
			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.TRAIN, NodeState.TAKEN).size());
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
			break;
		default:// 机动区
			takenNum = BigDecimal.valueOf(this.takenOrVacantPosition(inventoryID, Zone.EMPTY, NodeState.TAKEN).size());
			persentage = takenNum.divide(BigDecimal.valueOf(InventoryInfoVO.capacity));
			break;
		}
		return persentage;
	}
	
	/**
	 * 找出zone区被占据或空闲的位置集合
	 * @param inventoryID
	 * @param zone
	 * @param nodeState
	 * @return
	 */
	public ArrayList<Position> takenOrVacantPosition(String inventoryID, Zone zone, NodeState nodeState) {
		
		InventoryInfo inventoryInfobl = new InventoryInfo();
		InventoryInfoVO vo = inventoryInfobl.findInventoryInfo(inventoryID);
		int i=0;
		ArrayList<Position> positions = new ArrayList<Position>();
		System.out.println("Zone: "+zone);
		switch(zone) {
		case PLANE://获取航空区被占据或空闲的位置集合
			Hashtable<NodeState, ArrayList<Position>> planeZoneInfo = vo.getPlaneZoneInfo();
			positions = planeZoneInfo.get(nodeState);
			System.out.println("didplane");
			break;
		case CAR://获取汽车区被占据或空闲的位置集合
			Hashtable<NodeState, ArrayList<Position>> carZoneInfo = vo.getCarZoneInfo();
			positions = carZoneInfo.get(nodeState);
			System.out.println("didcar");
			break;
		case TRAIN://获取火车区被占据或空闲的位置集合
			Hashtable<NodeState, ArrayList<Position>> trainZoneInfo = vo.getTrainZoneInfo();
			positions = trainZoneInfo.get(nodeState);
			System.out.println("didtrain");
			break;
		case EMPTY://获取机动区被占据或空闲的位置集合
			Hashtable<NodeState, ArrayList<Position>> emptyZoneInfo = vo.getEmptyZoneInfo();
			positions = emptyZoneInfo.get(nodeState);
			System.out.println("didempty");
			break;
		}
		while(i<positions.size()){
			Position position = positions.get(i);
			System.out.println("Zone: "+position.getZone()+" Line: "+position.getLine()+" Shelf: "+position.getShelf()+" Tag: "+position.getTag()+" NodeState: "+position.getState());
			i++;
		}
		System.out.println("-----------------------------------------");
		return positions;
	}
	

//	public static void main(String[] args) {
//		int i=0;
//		System.out.println("在controller测试");
//		InventoryController inventoryController = new InventoryController();
//		System.out.println("寻找0210仓库的航空区所有空闲的位置！");
//		ArrayList<Position> positions = inventoryController.takenOrVacantPosition("0210", Zone.PLANE, NodeState.VACANT);
//		while(i<positions.size()){
//			Position position = positions.get(i);
//			System.out.println("Zone: "+position.getZone()+" Line: "+position.getLine()+" Shelf: "+position.getShelf()+" Tag: "+position.getTag()+" NodeState: "+position.getState());
//			i++;
//		}
////		double limit = inventoryController.getLimit("01");
////		 if(inventoryController.setLimit("01", 0.85)) {
////		 System.out.println("Limit 即将更新为0.85！");
////		 }
////		System.out.println("controller找到limit: " + limit);
//	}
}
