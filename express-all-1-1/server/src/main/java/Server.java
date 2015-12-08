import java.rmi.RemoteException;

import serverhelper.constserverhelper.PriceInfoServerHelper;
import serverhelper.constserverhelper.SalaryInfoServerHelper;

public class Server {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub

//		URL url = new URL();
//		try{
//			Registry registry = LocateRegistry.createRegistry(url.getPort());
//			ConstdataService cs = new ConstInfoServiceImpl();
//			System.out.println("远程绑定ConstInfoConstdataService对象成功！");
//			registry.rebind(url.getConstInfoService(), cs);
//			
//			CarInfoCorporationdataService ccs = new CarInfoServiceImpl();
//			System.out.println("远程绑定CarInfoCorporationdataService对象成功！");
//			registry.rebind(url.getCarInfoService(), ccs);
//			
//			DriverInfoCorporationdataService dics = new DriverInfoServiceImpl();
//			System.out.println("远程绑定DriverInfoCorporationdataService对象成功！");
//			registry.rebind(url.getDriverInfoService(), dics);
//			
//			InventoryInfoInventorydataService iiis = new InventoryInfoServiceImpl();
//			System.out.println("远程绑定InventoryInfoInventorydataService成功！");
//			registry.rebind(url.getInventoryInfoService(), iiis);
//			
//			StorageInFormInventorydataService sifs = new StorageInFormServiceImpl();
//			System.out.println("远程绑定StorageInFormInventorydataService成功！");
//			registry.rebind(url.getStorageInFormService(), sifs);
//			
//			StorageOutFromInventorydataService sofs = new StorageOutFormServiceImpl();
//			System.out.println("远程绑定StorageOutFormInventorydataService成功！");
//			registry.rebind(url.getStorageOutFormService(), sofs);
//			
//			UserdataService us = new UserInfoServiceImpl();
//			System.out.println("远程绑定UserdataService成功！");
//			registry.rebind(url.getUserInfoService(), us);
//			
//			AccountInfodataService as = new AccountInfoServiceImpl();
//			System.out.println("远程绑定AccountInfodataService成功！");
//			registry.rebind(url.getAccountInfoService(), as);
//			
//			BeginningAccountdataService bs = new BeginningAccountServiceImpl();
//			System.out.println("远程绑定BeginningAccountdataService成功！");
//			registry.rebind(url.getBeginningAccountService(), bs);
//			
//			CostPayChartdataService cds = new CostPayChartServiceImpl();
//			System.out.println("远程绑定CostPayChartdataService成功！");
//			registry.rebind(url.getCostPayChartService(), cds);
//			
//			PaymentFormdataService pds = new PaymentFormServiceImpl();
//			System.out.println("远程绑定PaymentFormdataService成功！");
//			registry.rebind(url.getPaymentFormService(), pds);
//			
//			ProfitChartdataService pcds = new ProfitChartServiceImpl();
//			System.out.println("远程绑定ProfitChartdataService成功！");
//			registry.rebind(url.getProfitChartService(), pcds);
//			
//			ReceiptFormdataService rds = new ReceiptFormServiceImpl();
//			System.out.println("远程绑定ReceiptFormdataService成功！");
//			registry.rebind(url.getReceiptFormService(), rds);
//			
//			CarInputFormServerHelper carInputFormServerHelper = new CarInputFormServerHelper();
////			carInputFormServerHelper.goPrint();
//			carInputFormServerHelper.goInsert();
		
//			
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//		
//		DriverInfoServerHelper driverInfoServerHelper = new DriverInfoServerHelper();
//		driverInfoServerHelper.go();
		
//		CarInfoServerHelper carInfoServerHelper = new CarInfoServerHelper();
//		carInfoServerHelper.go();
		
//		BankAccountServerHelper ankAccountServerHelper = new BankAccountServerHelper();
//		ankAccountServerHelper.go();
		
//		UserAccountServerHelper userAccountServerHelper = new UserAccountServerHelper();
//		userAccountServerHelper.go();
		
//		SalaryInfoServerHelper salaryInfoServerHelper = new SalaryInfoServerHelper();
//		salaryInfoServerHelper.go();
		
		PriceInfoServerHelper priceInfoServerHelper = new PriceInfoServerHelper();
		priceInfoServerHelper.go();
	}
}
