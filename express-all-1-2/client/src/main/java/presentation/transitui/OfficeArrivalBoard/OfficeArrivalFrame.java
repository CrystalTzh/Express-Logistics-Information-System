package presentation.transitui.OfficeArrivalBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class OfficeArrivalFrame extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	OfficeArrivalPanel storeArrivalPanel;
	
	public OfficeArrivalFrame(){
		JFrame frame = new JFrame("营业厅到达单");
		OfficeArrivalPanel board=new OfficeArrivalPanel();
		frame.add(board);
		frame.setSize(731, 319);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setResizable(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]){
		new OfficeArrivalFrame();
	}
}