package presentation.financeui.ProfitChartBoard;

import javax.swing.JFrame;

import presentation.financeui.CostPayChartBoard.CostPayChartFrame;

public class ProfitChartFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public ProfitChartFrame(){
		ProfitChartPanel panel = new ProfitChartPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("\u7ECF\u8425\u60C5\u51B5\u8868");
		frame.setBounds(100, 100, 690, 843);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}

	public static void main(String args[]){
		new ProfitChartFrame();
	}
	
}
