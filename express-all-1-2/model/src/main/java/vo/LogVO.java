/**
 * @author 谭琼
 * 2015年12月16日
 */
package vo;

import java.io.Serializable;
import java.util.Calendar;

import state.Operation;
import state.OperationObject;
import state.UserRole;

/**
 * 日志持久化对象
 */
public class LogVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	UserRole operatorRole;//操作人员职位
	String operatorID;//操作人员账号
	Calendar operationTime;//操作时间
	Operation operation;//操作类型
	OperationObject operationObject;//操作对象
	
	public String timeToString() {
		int year = operationTime.get(Calendar.YEAR);
		int month = operationTime.get(Calendar.MONTH) + 1;
		int date = operationTime.get(Calendar.DATE);
		int hourOfDay = operationTime.get(Calendar.HOUR_OF_DAY);
		int minute = operationTime.get(Calendar.MINUTE);
		int second = operationTime.get(Calendar.SECOND);
		String time = year + "-" + toTwoDigit(String.valueOf(month)) + "-" + toTwoDigit(String.valueOf(date)) 
				+ " " + toTwoDigit(String.valueOf(hourOfDay)) + ":" + toTwoDigit(String.valueOf(minute)) 
				+ ":" + toTwoDigit(String.valueOf(second));
		return time;
	}
	
	public String toString() {
		//时间、职位、操作人员ID、操作类型、操作对象
		String time = this.timeToString();
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
}
