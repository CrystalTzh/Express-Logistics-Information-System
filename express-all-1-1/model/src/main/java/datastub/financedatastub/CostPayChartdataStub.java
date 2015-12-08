package datastub.financedatastub;

import java.rmi.RemoteException;

import dataservice.financedataservice.CostPayChartdataService;
import po.CostpayChartPO;

public class CostPayChartdataStub implements CostPayChartdataService{
	public CostpayChartPO find(long NO) throws RemoteException {
		System.out.println("Find Succeed!\n");
		CostpayChartPO po = new CostpayChartPO(0, 0, 0, null);
		return po;
	}
	public void insert(CostpayChartPO po) throws RemoteException {
		System.out.println("Insert Succeed!\n");
	}
	public void delete(CostpayChartPO po) throws RemoteException {
		System.out.println("Delete Succeed!\n");
	}
	public void update(CostpayChartPO po) throws RemoteException {
		System.out.println("Update Succeed!\n");
	}
}
