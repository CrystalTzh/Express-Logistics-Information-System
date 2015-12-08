package datadriver.financedatadriver;

import java.rmi.RemoteException;

import po.CostpayChartPO;
import dataservice.financedataservice.CostPayChartdataService;

public class CostPayChartdataDriver {
	public void driver(CostPayChartdataService costPayChartdataStub) throws RemoteException{
		CostpayChartPO po = new CostpayChartPO(0, 0, 0, null);
		costPayChartdataStub.delete(po);
		costPayChartdataStub.find(0);
		costPayChartdataStub.insert(po);
		costPayChartdataStub.update(po);
	}
}