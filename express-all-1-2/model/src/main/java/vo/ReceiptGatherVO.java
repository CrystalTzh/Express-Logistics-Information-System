package vo;

import java.io.Serializable;
import java.util.ArrayList;

import po.ReceiptFormPO;

public class ReceiptGatherVO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String startdate;//开始日期
	String enddate;//结束日期
	ArrayList<ReceiptFormPO> receiptgather;
	ArrayList<String> officeNumbers;
	
	public String getStartdate() {
		return startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public ArrayList<ReceiptFormPO> getReceiptgather() {
		return receiptgather;
	}
	public ArrayList<String> getOfficeNumbers() {
		return officeNumbers;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public void setReceiptgather(ArrayList<ReceiptFormPO> receiptgather) {
		this.receiptgather = receiptgather;
	}
	public void setOfficeNumbers(ArrayList<String> officeNumbers) {
		this.officeNumbers = officeNumbers;
	}
	
	
}
