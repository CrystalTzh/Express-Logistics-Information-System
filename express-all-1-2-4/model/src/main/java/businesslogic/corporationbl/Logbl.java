/**
 * @author 谭琼
 * 2015年12月17日
 */
package businesslogic.corporationbl;

import java.util.ArrayList;
import java.util.Calendar;

import businesslogicservice.corporationblservice.LogcorporationblService;
import clienthelper.corporatioclienthelper.LogClientHelper;
import po.LogPO;
import vo.LogVO;

/**
 * 日志信息逻辑层实现
 */
public class Logbl implements LogcorporationblService {

	LogClientHelper logClientHelper = new LogClientHelper();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.LogcorporationblService#add(vo.
	 * LogVO)
	 */
	public boolean add(LogVO vo){
		System.out.println("进入Logbl...AddLog...");
		LogPO po = this.wrappVOtoPO(vo);
		if (logClientHelper.goInsert(po)) {
			return true;
		}
		return false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * businesslogicservice.corporationblservice.LogcorporationblService#find(
	 * java.util.Calendar, java.util.Calendar)
	 */
	public ArrayList<LogVO> find(Calendar startDate, Calendar endDate){
		System.out.println("进入Logbl...FindLog...");
		ArrayList<LogVO> logvo = new ArrayList<LogVO>();
		ArrayList<LogPO> logpo = logClientHelper.goFind(startDate, endDate);

		if (logpo != null) {//查找到的日志信息非空
			System.out.println("日志信息非空");
			for (int i = 0; i < logpo.size(); i++) {
				logvo.add(this.wrappPOtoVO(logpo.get(i)));
			}
			return logvo;
		}
		System.out.println("日志信息为空");
		return null;
	}

	/**
	 * 将日志信息的PO包装为VO
	 * 
	 * @param po
	 * @return
	 */
	public LogVO wrappPOtoVO(LogPO po) {
		LogVO vo = new LogVO();
		vo.setOperation(po.getOperation());
		vo.setOperationObject(po.getOperationObject());
		vo.setOperationTime(po.getOperationTime());
		vo.setOperatorID(po.getOperatorID());
		vo.setOperatorRole(po.getOperatorRole());
		return vo;
	}

	/**
	 * 将日志信息的VO包装为PO
	 * 
	 * @param vo
	 * @return
	 */
	public LogPO wrappVOtoPO(LogVO vo) {
		LogPO po = new LogPO();
		po.setOperation(vo.getOperation());
		po.setOperationObject(vo.getOperationObject());
		po.setOperationTime(vo.getOperationTime());
		po.setOperatorID(vo.getOperatorID());
		po.setOperatorRole(vo.getOperatorRole());
		return po;
	}

}
