package presentation.transitui.CarOfficeBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class CarOfficeFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	CarOfficePanel carOfficePanel;
	public CarOfficeFrame(){
		JFrame frame = new JFrame("营业厅装车单");
		CarOfficePanel board = new CarOfficePanel();
		frame.add(board);
		frame.setSize(700, 350);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]){
		new CarOfficeFrame();
	}
	

}
