package vo;

import java.io.Serializable;
import java.util.ArrayList;

import state.FormState;

public class ProfitChartVO implements Serializable {

	ArrayList<PaymentFormVO> paymentformvo;
	ArrayList<ReceiptFormVO> receiptformvo;
	long NO;
	FormState formstate;//单据的状态
	
	public ProfitChartVO() {}
	
	public ProfitChartVO(ArrayList<PaymentFormVO> paymentformvo, 
			ArrayList<ReceiptFormVO> receiptformvo, long NO, FormState formstate) {
		super();
		// TODO Auto-generated constructor stub
		this.paymentformvo = paymentformvo;
		this.receiptformvo = receiptformvo;
		this.NO = NO;
		this.formstate = formstate;
	}

	public ArrayList<PaymentFormVO> getPaymentformvo() {
		return paymentformvo;
	}

	public ArrayList<ReceiptFormVO> getReceiptformvo() {
		return receiptformvo;
	}

	public void setPaymentformpo(ArrayList<PaymentFormVO> paymentformvo) {
		this.paymentformvo = paymentformvo;
	}

	public void setReceiptformpo(ArrayList<ReceiptFormVO> receiptformvo) {
		this.receiptformvo = receiptformvo;
	}

	public long getNO() {
		return NO;
	}

	public void setNO(long nO) {
		NO = nO;
	}

	public FormState getFormstate() {
		return formstate;
	}

	public void setPaymentformvo(ArrayList<PaymentFormVO> paymentformvo) {
		this.paymentformvo = paymentformvo;
	}

	public void setReceiptformvo(ArrayList<ReceiptFormVO> receiptformvo) {
		this.receiptformvo = receiptformvo;
	}

	public void setFormstate(FormState formstate) {
		this.formstate = formstate;
	}	
	
	
}
