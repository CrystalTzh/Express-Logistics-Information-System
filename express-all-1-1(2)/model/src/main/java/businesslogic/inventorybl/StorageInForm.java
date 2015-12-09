package businesslogic.inventorybl;

import businesslogicservice.inventoryblservice.StorageInFormInventoryblService;
import state.NodeState;
import state.Zone;
import vo.StorageInFormVO;

public class StorageInForm implements StorageInFormInventoryblService {
	
	
	public boolean StorageInFormAddInfo(String date, String destination, Zone zone,
			int line, int shelf, int tag,long ID) {
		// TODO Auto-generated method stub
		MockInventoryInfo inventoryInfo = new MockInventoryInfo();
		if(inventoryInfo.getNodeState(zone, line, shelf, tag)==NodeState.VACANT){
			//详细业务逻辑，增加入库单信息；
			return true;
		}
				
		return false;
	}


	public StorageInFormVO StorageInFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void StorageInFormcancel(StorageInFormVO vo) {
		// TODO Auto-generated method stub

	}

	public boolean StorageInForsmsave(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean StorageInFormsubmit(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean StorageInFormwithdraw(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean StorageInFormsave(StorageInFormVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
