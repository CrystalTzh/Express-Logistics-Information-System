package presentation.financeui.CostPayChartBoard;

import javax.swing.JFrame;


public class CostPayChartFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public CostPayChartFrame(){
		CostPayChartPanel panel = new CostPayChartPanel();
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("\u6210\u672C\u6536\u76CA\u8868");
		frame.setBounds(100, 100, 690, 993);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
	}
	
	public static void main(String args[]){
		new CostPayChartFrame();
	}
}
