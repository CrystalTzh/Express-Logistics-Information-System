package presentation.transitui.TransferBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class TransferFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	TransferPanel tansferPanel=new TransferPanel();
	public TransferFrame(){
		JFrame frame = new JFrame("中转单");
		TransferPanel board = new TransferPanel();
		frame.add(board);
		frame.setSize(700, 400);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]) {
		new TransferFrame();
	}
}
