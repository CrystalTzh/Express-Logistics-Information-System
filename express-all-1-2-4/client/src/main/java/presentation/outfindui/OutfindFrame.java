package presentation.outfindui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class OutfindFrame  extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	OutfindPanel outputPanel;
	public OutfindFrame(){
//		JFrame frame = new JFrame("订单信息查询");
		this.setTitle("订单信息查询");
		OutfindPanel board = new OutfindPanel();
		this.add(board);
		this.setSize(700, 300);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	public static void main(String args[]){
		new OutfindFrame();
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
