package businesslogic.inventorybl;

import junit.framework.TestCase;
import state.NodeState;
import state.Zone;

public class InventoryInfoTest extends TestCase {

	public void test() {
		//fail("Not yet implemented");
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		assertEquals(NodeState.VACANT, inventoryInfo.getNodeState(Zone.CAR, 1, 1, 1));
		assertEquals(Zone.EMPTY, inventoryInfo.getEmptyZone());
		assertEquals(0.8, inventoryInfo.getLimit());
	}

}
