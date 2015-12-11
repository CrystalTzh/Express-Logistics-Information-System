package presentation.inventoryui.StorageInBoard;

import javax.swing.JFrame;


public class StorageInFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	
	public StorageInFrame(){
		StorageInPanel panel = new StorageInPanel();
		frame = new JFrame();
		frame.setTitle("\u5165\u5E93\u5355");
		frame.setBounds(100, 100, 490, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		frame.getContentPane().add(panel);

	}

	public static void main(String args[]){
		new StorageInFrame();
	}
	
}
