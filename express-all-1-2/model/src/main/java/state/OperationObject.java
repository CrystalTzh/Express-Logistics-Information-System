/**
 * @author 谭琼
 * 2015年12月16日
 */
package state;

/**
 * 操作对象的常量
 */
public enum OperationObject {
	//快递员：寄件单(OrderForm)、派件单(DeliveryForm)
	OrderForm("寄件单"), DeliveryForm("派件单"),
	//营业厅业务员：营业厅到达单(OfficeArrivalForm)、营业厅装车单(CarOfficeForm)、收款单(ReceiptForm)、司机信息(DriverInfo)、车辆信息(CarInfo)
	OfficeArrivalForm("营业厅到达单"), CarOfficeForm("营业厅装车单"), ReceiptForm("收款单"), DriverInfo("司机信息"), CarInfo("车辆信息"),
	//中转中心业务员：中转中心到达单(StoreArrivalForm)、中转单(TransferForm)、中转中心装车单(CarInputForm)
	StoreArrivalForm("中转中心到达单"), TransferForm("中转单"), CarInputForm("中转中心装车单"), 
	//仓库管理人员：入库单(StorageInForm)、出库单(StorageOutForm)
	StorageInForm("入库单"), StorageOutForm("出库单"),
	//财务人员：付款单(PaymentForm)、银行账户(BankAccountInfo)
	PaymentForm("付款单"), BankAccountInfo("银行账户信息"),
	//管理员：用户账户(UserAccount)
	UserAccount("用户账户信息"),
	//总经理：营业厅(Office)、中转中心(TransferOffice)、薪资标准(Salary)、价格常量(Price)
	Office("营业厅"), TransferOffice("中转中心"), Salary("薪资标准"), Price("价格常量");
	
	private String object;
	
	private OperationObject(String operationObject) {
		this.object = operationObject;
	}
	
	public String toString() {
		return object;
	}
}
