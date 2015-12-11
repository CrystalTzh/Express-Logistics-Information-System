package presentation.financeui.ReceiptBoard;


import javax.swing.JFrame;

public class ReceiptFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public ReceiptFrame(){
		ReceiptPanel panel = new ReceiptPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("\u6536\u6B3E\u5355");
		frame.setBounds(100, 100, 490, 613);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(panel);
	}

	public static void main(String args[]){
		new ReceiptFrame();
	}
	
}
