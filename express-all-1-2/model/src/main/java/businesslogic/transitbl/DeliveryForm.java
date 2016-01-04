package businesslogic.transitbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import clienthelper.transitclienthelper.DeliveryFormClientHelper;
import businesslogicservice.transitblservice.DeliveryFormTransitblService;
import dataservice.transitdataservice.DeliveryFormTransitdataService;
import impl.transitImpl.DeliveryFormImpl;
import po.DeliveryFormPO;
import state.FormState;
import vo.DeliveryFormVO;

public class DeliveryForm implements DeliveryFormTransitblService{

	DeliveryFormClientHelper deliveryFormClientHelper = new DeliveryFormClientHelper();
	
	public DeliveryFormVO DeliveryFormfind(String number) throws RemoteException, IllegalArgumentException{
		System.out.println("进入DeliveryFormbl...findDeliveryForm...");
		DeliveryFormTransitdataService deliveryFormTransitdataService = new DeliveryFormImpl();
		DeliveryFormPO po1 = deliveryFormClientHelper.goFind(number);
		DeliveryFormPO po2 = deliveryFormTransitdataService.find(number);
		if(po1!=null){
			DeliveryFormVO vo = new DeliveryFormVO();
			vo.setArrivaeDate(po1.getArrivaeDate());
			vo.setDeliveryMan(po1.getDeliveryMan());
			vo.setID(po1.getID());
			return vo;
		}
		if(po2!=null){
			DeliveryFormVO vo = new DeliveryFormVO();
			vo.setArrivaeDate(po2.getArrivaeDate());
			vo.setDeliveryMan(po2.getDeliveryMan());
			vo.setID(po2.getID());
			return vo;
		}
		else{
			return null;
		}
	}
	
	public DeliveryFormVO DeliveryFormcreate() {
		// TODO Auto-generated method stub
		return null;
	}

	public void DeliveryFormcancel(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		
	}

	public boolean DeliveryFormsave(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DeliveryFormbl...saveDeliveryForm...");
		DeliveryFormPO po = new DeliveryFormPO();
		po.setArrivaeDate(vo.getArrivaeDate());
		po.setDeliveryMan(vo.getDeliveryMan());
		po.setID(vo.getID());
		po.setFormstate(FormState.DRAFT);
		DeliveryFormTransitdataService deliveryFormTransitdataService = null;
		try {
			deliveryFormTransitdataService = new DeliveryFormImpl();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			deliveryFormTransitdataService.insert(po);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("save done!");
		return false;
	}

	@SuppressWarnings("null")
	public boolean DeliveryFormsubmit(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DeliveryFormbl...submitDeliveryForm...");
		DeliveryFormPO po = null;
		po.setArrivaeDate(vo.getArrivaeDate());
		po.setDeliveryMan(vo.getDeliveryMan());
		po.setID(vo.getID());
		po.setFormstate(FormState.SUBMITTED);
		if(deliveryFormClientHelper.goInsert(po)){
			return true;
		}
		return false;
	}

	@SuppressWarnings("null")
	public boolean DeliveryFormwithdraw(DeliveryFormVO vo) {
		// TODO Auto-generated method stub
		System.out.println("进入DeliveryFormbl...withdrawDeliveryForm...");
		DeliveryFormPO po = null;
		po.setArrivaeDate(vo.getArrivaeDate());
		po.setDeliveryMan(vo.getDeliveryMan());
		po.setID(vo.getID());
		po.setFormstate(FormState.EDITABLE);
		if(deliveryFormClientHelper.goFind(po.getID()) != null){
			if(deliveryFormClientHelper.goDelete(po)){
			return true;
			}
		}
		else
			System.out.println("po not found!");
		
		return false;
	}

	public ArrayList<DeliveryFormPO> findAll() {
		// TODO Auto-generated method stub
		System.out.println("进入PaymentFormbl...findAll...");
		return deliveryFormClientHelper.goFindAll();
	}

}
