package presentation.transitui.CarInputBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class CarInputFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	CarInputPanel carInputPanel;
	public CarInputFrame(){
		JFrame frame = new JFrame("中转中心装车单");
		CarInputPanel board = new CarInputPanel();
		frame.add(board);
		frame.setSize(700, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]){
		new CarInputFrame();
	}
}
