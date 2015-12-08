package businesslogic.financebl;

import java.util.ArrayList;

import businesslogicservice.financeblservice.ProfitChartFinanceblService;
import state.FormState;
import vo.PaymentFormVO;
import vo.ProfitChartVO;
import vo.ReceiptFormVO;

public class ProfitChart implements ProfitChartFinanceblService{

	public boolean profitChartAdd(ProfitChartVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	public ProfitChartVO profitChartCheck(long NO) {
		// TODO Auto-generated method stub
		MockProfitChart mockProfitChart = new MockProfitChart(NO);
		ArrayList<PaymentFormVO> paymentformvo = new ArrayList<PaymentFormVO>();
		ArrayList<ReceiptFormVO> receiptformvo = new ArrayList<ReceiptFormVO>();
		MockPaymentForm mockPaymentForm = mockProfitChart.getMockPaymentForm().get(0);;
		MockReceiptForm mockReceiptForm = mockProfitChart.getMockReceiptForm().get(0);
		PaymentFormVO paymentFormVO = new PaymentFormVO(mockPaymentForm.date,
				mockPaymentForm.money, mockPaymentForm.name, mockPaymentForm.account,
				mockPaymentForm.rent, mockPaymentForm.year, mockPaymentForm.allNO, 
				mockPaymentForm.salary, mockPaymentForm.bonus, mockPaymentForm.payDate,
				mockPaymentForm.NO, mockPaymentForm.freight, mockPaymentForm.formstate);
		ReceiptFormVO receiptFormVO = new ReceiptFormVO(mockReceiptForm.date, 
				mockReceiptForm.money,mockReceiptForm.expressManNumber, mockReceiptForm.id,  mockReceiptForm.NO, 
				mockReceiptForm.formstate);
		paymentformvo.add(paymentFormVO);
		receiptformvo.add(receiptFormVO);
		
		ProfitChartVO profitChartVO = new ProfitChartVO(paymentformvo, receiptformvo,
				NO, FormState.DRAFT);
		
		return profitChartVO;
	}

}
