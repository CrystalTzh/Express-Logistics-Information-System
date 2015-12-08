package vo;

import java.io.Serializable;
import java.util.ArrayList;

import po.ReceiptFormPO;

public class ReceiptGatherVO implements Serializable {

	String startdate;//开始日期
	String enddate;//结束日期
	ArrayList<ReceiptFormPO> receiptgather;
	ArrayList<String> officeNumbers;
	
	public ReceiptGatherVO() {
		// TODO Auto-generated constructor stub
		
	}
	public ReceiptGatherVO(String startdate,String enddate,
			ArrayList<ReceiptFormPO> receiptgather,ArrayList<String> officeNumbers) {
		// TODO Auto-generated constructor stub
		this.startdate = startdate;
		this.enddate =enddate;
		this.officeNumbers = officeNumbers;
		this.receiptgather = receiptgather;
	}
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
