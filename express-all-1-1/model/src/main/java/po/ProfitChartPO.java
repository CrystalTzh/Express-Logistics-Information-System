package po;

import java.io.Serializable;
import java.util.ArrayList;

public class ProfitChartPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<PaymentFormPO> paymentformpo;
	ArrayList<ReceiptFormPO> receiptformpo;
	long NO;
	
	public ProfitChartPO(ArrayList<PaymentFormPO> paymentformpo, 
			ArrayList<ReceiptFormPO> receiptformpo, long NO) {
		super();
		// TODO Auto-generated constructor stub
		this.paymentformpo = paymentformpo;
		this.receiptformpo = receiptformpo;
		this.NO = NO;
	}

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

	public long getNO() {
		return NO;
	}

	public void setNO(long nO) {
		NO = nO;
	}	
	
	
}
