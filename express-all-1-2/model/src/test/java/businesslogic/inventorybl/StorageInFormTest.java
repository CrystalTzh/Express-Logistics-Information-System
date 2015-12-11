package businesslogic.inventorybl;

import junit.framework.TestCase;
import state.Zone;

public class StorageInFormTest extends TestCase {

	
	public void test(){
		
		StorageInForm storageInForm = new StorageInForm();
		assertEquals(false, storageInForm.StorageInFormAddInfo("20151116", "南京", Zone.CAR, 1, 1, 1, 10000));
		
	}

}
