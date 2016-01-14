package presentation.inventoryui.boards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controller.inventorycontroller.InventoryController;

public class SetLimitBoard extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel jlMessage;
	private JTextField jtLimitation;
	private JButton jbSure, jbCancel;
	private String id;
	
	InventoryController inventoryController;

	public SetLimitBoard(String id) {

//		id = JOptionPane.showInputDialog("请输入仓库编号");
		this.id = id;
		inventoryController = new InventoryController();

		this.setLayout(null);
		this.setTitle("设置库存警戒值");
		this.setBounds(560, 250, 420, 300);

		jlMessage = new JLabel("请输入新的库存警戒值：");
		jlMessage.setFont(new Font("请输入新的库存警戒值：", Font.PLAIN, 16));
		jlMessage.setBounds(120, 75, 300, 20);
		this.add(jlMessage);

		jtLimitation = new JTextField();
		jtLimitation.setSize(215, 25);

		jtLimitation.setBounds(100, 120, jtLimitation.getWidth(), jtLimitation.getHeight());
		this.add(jtLimitation);
		jtLimitation.addActionListener(this);

		if(inventoryController.findInventory(id) != null){
			double limit = inventoryController.getLimit(id);
			jtLimitation.setText(String.valueOf(limit));
		}else {
			JOptionPane.showMessageDialog(this, "请重新输入仓库编号！");
			id = JOptionPane.showInputDialog("请输入仓库编号");
			double limit = inventoryController.getLimit(id);
			jtLimitation.setText(String.valueOf(limit));
		}
		
		
		

		jbSure = new JButton();
		jbSure.setText("确认修改");
		jbSure.setBounds(110, 222, 90, 25);
		this.add(jbSure);
		jbSure.addActionListener(this);
		jbSure.setContentAreaFilled(false);

		jbCancel = new JButton();
		jbCancel.setText("取消修改");
		jbCancel.setBounds(215, 222, 90, 25);
		this.add(jbCancel);
		jbCancel.addActionListener(this);
		jbCancel.setContentAreaFilled(false);

		this.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		if (e.getSource() == jbCancel) {
			this.setVisible(false);
		}

		String number = jtLimitation.getText();// 获取输入的库存警戒值

		if (number.length() > 0) {// 1 输入框中有输入
			jbSure.setEnabled(true);
			if (e.getSource() == jbSure || e.getSource() == jtLimitation) {// 1.1
																			// 点击了确认修改按钮或者按Enter键确认结束输入库存警戒值
				String question = "确认修改库存警戒值吗？";
				JOptionPane.showMessageDialog(this, question, "警告", JOptionPane.QUESTION_MESSAGE);
				String m = "库存警戒值将被修改!";
				int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (ok == JOptionPane.YES_OPTION) {
					// 确认修改库存警戒值，当前窗口关闭，更改navigation界面上输入框中的值；
					inventoryController.setLimit(id, Double.parseDouble(number));
					this.setVisible(false);
				}
			}
			if (e.getSource() == jbCancel) {
				this.setVisible(false);
			}

		} else {// 2 输入框中没有输入
			if (e.getSource() == jbSure) {// 选择确认按钮提示警告

				String warning = "请输入更改后的警戒值!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
				jbSure.setEnabled(false);
			} else if (e.getSource() == jbCancel) {// 选择取消按钮返回上一界面，输入值不保存

				this.setVisible(false);
			}

		}

	}

//	public static void main(String[] args) {
//		
//		new SetLimitBoard("0210").setVisible(true);
//	}
}
