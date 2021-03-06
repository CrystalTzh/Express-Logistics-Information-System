/**
 * @author 谭琼
 * 2015年12月16日
 */
package po;

import java.io.Serializable;
import java.util.Calendar;

import state.Operation;
import state.OperationObject;
import state.UserRole;

/**
 * 日志持久化对象
 */
public class LogPO implements Serializable{

	private static final long serialVersionUID = 1L;
	UserRole operatorRole;//操作人员职位
	String operatorID;//操作人员账号
	Calendar operationTime;//操作时间
	Operation operation;//操作类型
	OperationObject operationObject;//操作对象
	
	public String timeToString(Calendar opTime) {
		int year = opTime.get(Calendar.YEAR);
		int month = opTime.get(Calendar.MONTH) + 1;
		int date = opTime.get(Calendar.DATE);
		int hourOfDay = opTime.get(Calendar.HOUR_OF_DAY);
		int minute = opTime.get(Calendar.MINUTE);
		int second = opTime.get(Calendar.SECOND);
		String time = year + "-" + toTwoDigit(String.valueOf(month)) + "-" + toTwoDigit(String.valueOf(date)) 
				+ " " + toTwoDigit(String.valueOf(hourOfDay)) + ":" + toTwoDigit(String.valueOf(minute)) 
				+ ":" + toTwoDigit(String.valueOf(second));
		return time;
	}
	
	public String toString() {
		//时间、职位、操作人员ID、操作类型、操作对象
		String time = this.timeToString(this.operationTime);
		String logStr = time + "    " +  operatorRole.toString() + " " 
				+ operatorID + "  " + operation.toString() + operationObject.toString();
		return logStr;
	}
	
	public String toTwoDigit(String num) {
		if(num.length() < 2) {
			num = '0' + num;
		}
		return num;
	}
	
	public Operation getOperation() {
		return operation;
	}

	public OperationObject getOperationObject() {
		return operationObject;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}

	public void setOperationObject(OperationObject operationObject) {
		this.operationObject = operationObject;
	}

	public UserRole getOperatorRole() {
		return operatorRole;
	}


	public String getOperatorID() {
		return operatorID;
	}


	public void setOperatorRole(UserRole operatorRole) {
		this.operatorRole = operatorRole;
	}


	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}


	public Calendar getOperationTime() {
		return operationTime;
	}


	public void setOperationTime(Calendar operationTime) {
		this.operationTime = operationTime;
	}


//	public static void main(String[] args) {
//		Calendar calendar = new GregorianCalendar();
//		LogPO log = new LogPO();
//		log.setOperatorID("141250122");
////		log.setOperationTime(new GregorianCalendar(2015, 1, 1, 8, 1, 1));
//		log.setOperationTime(calendar);
//		log.setOperation(Operation.DELETE);
//		log.setOperatorRole(UserRole.EXPRESSMAN);
//		log.setOperationObject(OperationObject.DeliveryForm);
//		System.out.println(log.toString());
//	}
}
