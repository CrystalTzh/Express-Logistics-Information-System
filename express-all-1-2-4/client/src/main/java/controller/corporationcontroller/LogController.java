/**
 * @author 谭琼
 * 2015年12月17日
 */
package controller.corporationcontroller;

import java.util.ArrayList;
import java.util.Calendar;

import businesslogic.corporationbl.Logbl;
import vo.LogVO;

/**
 * 日志信息控制器
 */
public class LogController {
	
	/**
	 * 添加一条日志记录
	 * @param vo
	 * @return
	 */
	public boolean addLog(LogVO vo) {
		System.out.println("进入LogController...addLog...");
		Logbl logbl = new Logbl();
		if(logbl.add(vo)) {
			return true;
		}
		return false;
	}
	
	/**
	 * 根据开始日期和结束日期查找日志记录
	 * 保证endDate >= startDate
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public ArrayList<LogVO> findLog(Calendar startDate, Calendar endDate) {
		System.out.println("进入LogController...findLog...");
		Logbl logbl = new Logbl();
		return logbl.find(startDate, endDate);
	}
	
//	public static void main(String[] args) {
//		LogController logController = new LogController();
//		LogVO vo = new LogVO();
//		vo.setOperation(Operation.ADD);
//		vo.setOperationObject(OperationObject.BankAccountInfo);
//		vo.setOperationTime(new GregorianCalendar());
//		vo.setOperatorID("141250122");
//		vo.setOperatorRole(UserRole.ADFINANCEMAN);
//		
//		logController.addLog(vo);
		
//		Calendar startDate = new GregorianCalendar(2015, 11, 22);
//		Calendar endDate = new GregorianCalendar(2015, 11, 23);
//		ArrayList<LogVO> findLogs = logController.findLog(startDate, endDate);
//		if(findLogs == null) {
//			System.out.println("日志记录为空");
//		} else {
//			System.out.println();
//			for(int i = 0; i < findLogs.size(); i++) {
//				System.out.println(findLogs.get(i).toString());
//			}
//		}
//	}
}
