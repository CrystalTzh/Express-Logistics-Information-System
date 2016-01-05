/**
 * @author 谭琼
 * 2015年12月17日
 */
package serverhelper;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import RMIHelper.ServiceName;
import exceptions.rmi.ServerInitException;
import impl.constImpl.PriceInfoServiceImpl;
import impl.constImpl.SalaryInfoServiceImpl;
import impl.corporationImpl.BankAccountImpl;
import impl.corporationImpl.CarInfoServiceImpl;
import impl.corporationImpl.DriverInfoServiceImpl;
import impl.corporationImpl.LogServiceImpl;
import impl.corporationImpl.OfficeInfoServiceImpl;
import impl.corporationImpl.TransferOfficeInfoServiceImpl;
import impl.financeImpl.BeginningAccountServiceImpl;
import impl.financeImpl.CostPayChartServiceImpl;
import impl.financeImpl.PaymentFormServiceImpl;
import impl.financeImpl.ProfitChartServiceImpl;
import impl.financeImpl.ReceiptFormServiceImpl;
import impl.inventoryImpl.InventoryInfoServiceImpl;
import impl.inventoryImpl.StorageInFormServiceImpl;
import impl.inventoryImpl.StorageOutFormServiceImpl;
import impl.transitImpl.CarInputFormIml;
import impl.transitImpl.CarOfficeFormImpl;
import impl.transitImpl.DeliveryFormImpl;
import impl.transitImpl.OfficeArrivalFormImpl;
import impl.transitImpl.OrderFormTransitImpl;
import impl.transitImpl.StoreArrivalFormImpl;
import impl.transitImpl.TransferFormImpl;
import impl.userImpl.UserAccountServiceImpl;

/**
 * 服务器为所有服务绑定RMI
 */
public class ServerInit {
	private static Map<String, Class<? extends UnicastRemoteObject>> NAMING_MAP = new HashMap<String, Class<? extends UnicastRemoteObject>>();

	static {
		// const模块
		NAMING_MAP.put(ServiceName.PRICEINFO.toString(), PriceInfoServiceImpl.class);
		NAMING_MAP.put(ServiceName.SALARYINFO.toString(), SalaryInfoServiceImpl.class);

		// coporation模块
		NAMING_MAP.put(ServiceName.BANKACCOUNT.toString(), BankAccountImpl.class);
		NAMING_MAP.put(ServiceName.CARINFO.toString(), CarInfoServiceImpl.class);
		NAMING_MAP.put(ServiceName.DRIVERINFO.toString(), DriverInfoServiceImpl.class);
		NAMING_MAP.put(ServiceName.LOG.toString(), LogServiceImpl.class);
		NAMING_MAP.put(ServiceName.OFFICE.toString(), OfficeInfoServiceImpl.class);
		NAMING_MAP.put(ServiceName.TRANSFEROFFICE.toString(), TransferOfficeInfoServiceImpl.class);

		// finance模块
		NAMING_MAP.put(ServiceName.BEGINNINGACCOUNT.toString(), BeginningAccountServiceImpl.class);
		NAMING_MAP.put(ServiceName.COSTPAYCHART.toString(), CostPayChartServiceImpl.class);
		NAMING_MAP.put(ServiceName.PAYMENTFORM.toString(), PaymentFormServiceImpl.class);
		NAMING_MAP.put(ServiceName.PROFITCHART.toString(), ProfitChartServiceImpl.class);// 有问题
		NAMING_MAP.put(ServiceName.RECEIPTFORM.toString(), ReceiptFormServiceImpl.class);

		// inventory模块
		NAMING_MAP.put(ServiceName.INVENTORYINFO.toString(), InventoryInfoServiceImpl.class);
		NAMING_MAP.put(ServiceName.STORAGEINFORM.toString(), StorageInFormServiceImpl.class);
		NAMING_MAP.put(ServiceName.STORAGEOUTFORM.toString(), StorageOutFormServiceImpl.class);

		// transit模块
		NAMING_MAP.put(ServiceName.CARINPURFORM.toString(), CarInputFormIml.class);
		NAMING_MAP.put(ServiceName.CAROFFICEFORM.toString(), CarOfficeFormImpl.class);
		NAMING_MAP.put(ServiceName.DELIVERYFORM.toString(), DeliveryFormImpl.class);
		NAMING_MAP.put(ServiceName.OFFICEARRIVALFORM.toString(), OfficeArrivalFormImpl.class);
		NAMING_MAP.put(ServiceName.ORDERFORM.toString(), OrderFormTransitImpl.class);
		NAMING_MAP.put(ServiceName.STOREARRIVALFORM.toString(), StoreArrivalFormImpl.class);
		NAMING_MAP.put(ServiceName.TRANSFERFORM.toString(), TransferFormImpl.class);

		// user模块
		NAMING_MAP.put(ServiceName.USERACCOUNT.toString(), UserAccountServiceImpl.class);

	}

	public synchronized static void init()
			throws ServerInitException, RemoteException, InstantiationException, IllegalAccessException {
		Registry registry = LocateRegistry.createRegistry(32004);

		for (Entry<String, Class<? extends UnicastRemoteObject>> entry : NAMING_MAP.entrySet()) {
			String name = entry.getKey();
			Class<? extends UnicastRemoteObject> clazz = entry.getValue();
			UnicastRemoteObject proxy = clazz.newInstance();
			registry.rebind(name, proxy);
			System.out.println(name + " RMI服务绑定成功...等待远程调用请求...");
		}
	}

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		ServerInit serverInit = new ServerInit();
		
		try {
			serverInit.init();
		} catch (ServerInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(new JFrame(), "服务器连接成功！");
	}
}
