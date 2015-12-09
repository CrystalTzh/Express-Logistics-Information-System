package businesslogic.financebl;

import java.util.ArrayList;


public class MockProfitChart extends ProfitChart{
	ArrayList<MockPaymentForm> mockPaymentForm = new ArrayList<MockPaymentForm>();
	ArrayList<MockReceiptForm> mockReceiptForm = new ArrayList<MockReceiptForm>();
	long NO = 0;
	
	public MockProfitChart(long NO)
	{
		this.NO = NO;
		mockPaymentForm.add(new MockPaymentForm(13456));
		mockReceiptForm.add(new MockReceiptForm(12345));
//		System.out.println("MockPayment name: " + mockPaymentForm.get(0).name);
	}
	
	public ArrayList<MockPaymentForm> getMockPaymentForm()
	{
		return mockPaymentForm;
	}
	
	public ArrayList<MockReceiptForm> getMockReceiptForm()
	{
		return mockReceiptForm;
	}
	
}
