package presentation.financeui.CheckCostPayChartBoard;

import javax.swing.JFrame;

public class CheckCostPayChartFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public CheckCostPayChartFrame(){
		CheckCostPayChartPanel panel = new CheckCostPayChartPanel();
		frame = new JFrame();
		frame.setTitle("\u67E5\u770B\u6210\u672C\u6536\u76CA\u8868");
		frame.setBounds(100, 100, 386, 290);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(panel);
		frame.setVisible(true);
		frame.setResizable(false);
		
	}
	
	public static void main(String args[]){
		new CheckCostPayChartFrame();
	}

}
