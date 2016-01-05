package presentation.transitui.ReceiveInfoBoard;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;



public class ReceiveInfoFrame extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	ReceiveInfoPanel receiveInfoPanel;
	
	public ReceiveInfoFrame(){

//		JFrame frame = new JFrame("收件信息录入");
		this.setTitle("收件信息录入");
		ReceiveInfoPanel board=new ReceiveInfoPanel();
		this.add(board);
		this.setSize(500, 500);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		this.setResizable(false);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String args[]){
		new ReceiveInfoFrame();
	}
}