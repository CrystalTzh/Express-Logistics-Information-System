package po;

import java.io.Serializable;
import java.util.ArrayList;
/**
 * 经营情况表持久化对象
 */

public class ProfitChartPO implements Serializable {

	private static final long serialVersionUID = 1L;
	ArrayList<PaymentFormPO> paymentformpo;
	ArrayList<ReceiptFormPO> receiptformpo;
	String NO;
	
	

	public ArrayList<PaymentFormPO> getPaymentformpo() {
		return paymentformpo;
	}

	public ArrayList<ReceiptFormPO> getReceiptformpo() {
		return receiptformpo;
	}

	public void setPaymentformpo(ArrayList<PaymentFormPO> paymentformpo) {
		this.paymentformpo = paymentformpo;
	}

	public void setReceiptformpo(ArrayList<ReceiptFormPO> receiptformpo) {
		this.receiptformpo = receiptformpo;
	}

	public String getNO() {
		return NO;
	}

	public void setNO(String NO) {
		this.NO = NO;
	}	
	
	
}
