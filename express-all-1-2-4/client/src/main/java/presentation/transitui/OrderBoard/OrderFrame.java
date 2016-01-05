package presentation.transitui.OrderBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class OrderFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	OrderPanel orderPanel;
	
	public OrderFrame(){

		JFrame frame = new JFrame("寄件单01");
		OrderPanel board=new OrderPanel();
		frame.add(board);
		frame.setSize(731, 519);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]){
		new OrderFrame();
	}
}
