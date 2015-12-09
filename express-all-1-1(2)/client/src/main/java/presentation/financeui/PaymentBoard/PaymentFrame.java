package presentation.financeui.PaymentBoard;

import javax.swing.JFrame;

import presentation.financeui.ReceiptBoard.ReceiptFrame;

public class PaymentFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public PaymentFrame(){
		PaymentPanel panel = new PaymentPanel();
		frame = new JFrame();
		frame.setTitle("\u4ED8\u6B3E\u5355");
		frame.setBounds(100, 100, 490, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}

	public static void main(String args[]){
		new PaymentFrame();
	}
	
}
