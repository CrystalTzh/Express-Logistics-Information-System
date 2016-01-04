package presentation.transitui.StoreArrivalBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;





public class StoreArrivalFrame extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	StoreArrivalPanel storeArrivalPanel;
	
	public StoreArrivalFrame(){
		JFrame frame = new JFrame("中转中心到达单01");
		StoreArrivalPanel board=new StoreArrivalPanel();
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
		new StoreArrivalFrame();
	}
}
