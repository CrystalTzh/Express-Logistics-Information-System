package presentation.inventoryui.StorageOutBoard;

import javax.swing.JFrame;


public class StorageOutFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	
	public StorageOutFrame(){
		StorageOutPanel panel = new StorageOutPanel();
		frame = new JFrame();
		frame.setTitle("\u51FA\u5E93\u5355");
		frame.setBounds(100, 100, 490, 545);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().add(panel);
	}

	public static void main(String args[]){
		new StorageOutFrame();
	}

}
