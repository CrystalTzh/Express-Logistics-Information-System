/**
 * @author 谭琼
 * 2015年12月17日
 */
package RMIHelper;

/**
 * RMI服务常量
 */
public enum ServiceName {
	//const模块
	PRICEINFO("priceInfo-ConstdataService"), SALARYINFO("salaryInfo-ConstdataService"),
	//corporation模块
	BANKACCOUNT("bankAccount-CorporationdataService"), CARINFO("carInfo-CorporationdataService"), 
	DRIVERINFO("driverInfo-CorporationdataService"), LOG("log-CorporationdataService"), 
	OFFICE("office-CorporationdataService"), TRANSFEROFFICE("transferOffice-CorporationdataService"),
	//finance模块
	BEGINNINGACCOUNT("beginningAccount-FinancedataService"), COSTPAYCHART("costPayChart-FinancedataService"), 
	PAYMENTFORM("paymentForm-FinancedataService"), PROFITCHART("profitChart-FinancedataService"),
	RECEIPTFORM("receiptForm-FinancedataService"),
	//inventory模块
	INVENTORYINFO("inventoryInfo-InventorydataService"), STORAGEINFORM("storageInForm-InventorydataService"), 
	STORAGEOUTFORM("storageOutFrom-InventorydataService"), 
	//transit模块
	CARINPURFORM("carInputForm-TransitdataService"), CAROFFICEFORM("carOffice-TransitdataService"), 
	DELIVERYFORM("deliveryForm-TransitdataService"), OFFICEARRIVALFORM("officeArrivalForm-TransitdataService"),
	ORDERFORM("orderForm-TransitdataService"), STOREARRIVALFORM("storeArrivalForm-TransitdataService"), 
	TRANSFERFORM("transferForm-TransitdataService"),
	//user模块
	USERACCOUNT("uerAccount-UserdataService");
	
	private String name;
	
	private ServiceName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
}
