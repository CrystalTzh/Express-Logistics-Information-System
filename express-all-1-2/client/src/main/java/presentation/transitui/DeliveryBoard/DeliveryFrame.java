package presentation.transitui.DeliveryBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class DeliveryFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	DeliveryPanel deliverpanel;
	
	
	public DeliveryFrame(){
	
			JFrame frame = new JFrame("派件单01");
			DeliveryPanel board = new DeliveryPanel();
			frame.add(board);
			frame.setSize(531, 219);
//			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
			frame.setResizable(false);
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	public static void main(String args[]) {
		new DeliveryFrame();
	}
}
