package businesslogic.driver.inventoryblDriver;

import state.Zone;
import businesslogicservice.inventoryblservice.StorageInFormInventoryblService;

public class StorageInFormInventoryblDriver {
	public void driver(StorageInFormInventoryblService StorageInFormInventoryblStub){
		boolean isSuccessful = StorageInFormInventoryblStub.StorageInFormAddInfo("20151025", "南京鼓楼营业厅", Zone.CAR, 1, 1, 1, 1);
		if(isSuccessful){
			System.out.println("StorageInFormInfo added successfully!");
		}
		StorageInFormInventoryblStub.StorageInFormcancel(null);
		StorageInFormInventoryblStub.StorageInFormcreate();
		StorageInFormInventoryblStub.StorageInFormsave(null);
		StorageInFormInventoryblStub.StorageInFormsubmit(null);
		StorageInFormInventoryblStub.StorageInFormwithdraw(null);
	}
}
