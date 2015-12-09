package RMIHelper;

public class URL {
	private static int port = 33000; 

	private static String ConstInfoService = "CONSTINFOSERVICE";
	private static String CarInfoService = "CARINFOSERVICE";
	private static String DriverInfoService = "DRIVERINFOSERVICE";
	private static String InventoryInfoService = "INVENTORYINFOSERVICE";
	private static String StorageInFormService = "STORAGEINFORMSERVICE";
	private static String StorageOutFormService = "STORAGEOUTFORMSERVICE";
	private static String UserInfoService = "USERINFOSERVICE";
	private static String CarInputFormService = "CARINPUTFORMSERVICE";
	
	private static String AccountInfoPO = "ACCOUNTINFOPO";
	private static String BeginningAccountPO = "BEGINNINGACCOUNTPO";
	private static String CostPayChartPO= "COSTPAYCHARTPO";
	private static String PaymentFormPO = "PAYMENTFORMPO";
	private static String ReceiptFormPO = "RECEIPTFORMPO";
	private static String ProfitChartPO = "PROFITCHARTPO";
	
	public int getPort(){
		return port;
	}
	public String getConstInfoService(){
		return ConstInfoService;
	}
	public String getCarInfoService(){
		return CarInfoService;
	}
	public String getDriverInfoService(){
		return DriverInfoService;
	}
	public String getInventoryInfoService(){
		return InventoryInfoService;
	}
	public String getStorageInFormService(){
		return StorageInFormService;
	}
	public String getStorageOutFormService(){
		return StorageOutFormService;
	}
	public String getUserInfoService(){
		return UserInfoService;
	}
	public String getCarInputFormService(){
		return CarInputFormService;
	}
	
	public String getAccountInfoService() {
		// TODO Auto-generated method stub
		return AccountInfoPO;
	}

	public String getBeginningAccountService() {
		// TODO Auto-generated method stub
		return BeginningAccountPO;
	}

	public String getCostPayChartService() {
		// TODO Auto-generated method stub
		return CostPayChartPO;
	}



	public String getPaymentFormService() {
		// TODO Auto-generated method stub
		return PaymentFormPO;
	}

	public String getReceiptFormService() {
		// TODO Auto-generated method stub
		return ReceiptFormPO;
	}

	public String getProfitChartService() {
		// TODO Auto-generated method stub
		return ProfitChartPO;
	}
}
