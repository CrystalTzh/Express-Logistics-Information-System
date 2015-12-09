package presentation.financeui.ProfitChartBoard;

import javax.swing.JFrame;

public class DateInputFrame extends JFrame{

	
private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public DateInputFrame(){
		
		DateInputPanel panel = new DateInputPanel();
		frame = new JFrame();
		frame.setTitle("\u67E5\u770B\u6210\u672C\u6536\u76CA\u8868");
		frame.setBounds(100, 100, 386, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
		
	}

	public static void main(String args[]){
		new DateInputFrame();
	}
	
}
