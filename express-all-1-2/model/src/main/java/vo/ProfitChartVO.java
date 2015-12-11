package vo;

import java.io.Serializable;
import java.util.ArrayList;

import po.PaymentFormPO;
import po.ReceiptFormPO;
import state.FormState;

public class ProfitChartVO implements Serializable {

	ArrayList<PaymentFormPO> paymentformpo;
	ArrayList<ReceiptFormPO> receiptformpo;
	String NO;
	FormState formstate;//单据的状态

	public ArrayList<PaymentFormPO> getPaymentformpo() {
		return paymentformpo;
	}

	public ArrayList<ReceiptFormPO> getReceiptformpo() {
		return receiptformpo;
	}

//	public void setPaymentformpo(ArrayList<PaymentFormVO> paymentformvo) {
//		this.paymentformvo = paymentformvo;
//	}
//
//	public void setReceiptformpo(ArrayList<ReceiptFormVO> receiptformvo) {
//		this.receiptformvo = receiptformvo;
//	}

	public String getNO() {
		return NO;
	}

	public void setNO(String NO) {
		this.NO = NO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setPaymentformpo(ArrayList<PaymentFormPO> paymentformpo) {
		this.paymentformpo = paymentformpo;
	}

	public void setReceiptformpo(ArrayList<ReceiptFormPO> receiptformpo) {
		this.receiptformpo = receiptformpo;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}	
	
	
}
