package presentation.financeui.ReceiptGatherBoard;

import javax.swing.JFrame;

import presentation.financeui.ReceiptBoard.ReceiptFrame;

public class ReceiptGatherFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public ReceiptGatherFrame(){
		ReceiptGatherPanel panel = new ReceiptGatherPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("\u6536\u6B3E\u5355\u6C47\u603B");
		frame.setBounds(100, 100, 490, 663);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.getContentPane().add(panel);

	}
	
	public static void main(String args[]){
		new ReceiptGatherFrame();
	}

}
