package presentation.inventoryui.boards;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.inventorycontroller.InventoryController;
import state.Zone;

public class AdjustZoneBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	private JLabel jlMessage;

	private JComboBox<String> jcbZone;
	private JButton jbSure,jbCancel;//确认修改按钮、取消修改按钮
	InventoryController inventoryController;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AdjustZoneBoard(){
		
		 inventoryController = new InventoryController();
		
		this.setLayout(null);
		this.setTitle("调整库存分区");
		this.setBounds(560, 250, 420, 300);
		
		jlMessage = new JLabel("把机动仓库调整为：");
		jlMessage.setFont(new Font("把机动仓库调整为：",Font.PLAIN,16));
		jlMessage.setBounds(60, 75, 150, 20);
		this.add(jlMessage);
		
		jcbZone = new JComboBox();
		jcbZone.addItem(Zone.CAR.toString());
		jcbZone.addItem(Zone.PLANE.toString());
		jcbZone.addItem(Zone.TRAIN.toString());
		jcbZone.addItem(Zone.EMPTY.toString());
//		jcbZone.setSelectedItem(Zone.EMPTY.toString());
		Zone zone = inventoryController.getEmptyZoneState("01");
		jcbZone.setSelectedItem(zone.toString());
		jcbZone.setBounds(210, 77, 150, 25);
		
		this.add(jcbZone);
		
		
		jbSure = new JButton();
		jbSure.setText("确认修改");
		jbSure.setBounds(110, 222, 90, 25);
		this.add(jbSure);
		jbSure.addActionListener(this);
		
		jbCancel = new JButton();
		jbCancel.setText("取消修改");
		jbCancel.setBounds(215, 222, 90, 25);
		this.add(jbCancel);
		jbCancel.addActionListener(this);
		
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == jbCancel){//1 点击了取消修改按钮
			this.setVisible(false);
		}
		
		jbSure.setEnabled(true);
		if(e.getSource() == jbSure){//2 点击了确认修改按钮
			String question = "确认此分区调整吗？";
			JOptionPane.showMessageDialog(this, question, "提示", JOptionPane.QUESTION_MESSAGE);
			String m = "机动仓库将被修改!";	
			int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if(ok == JOptionPane.YES_OPTION){
				//确认修改机动仓库，当前窗口关闭，更改navigation界面上输入框中的值；
				//读取库存分区
				String zoneStr = jcbZone.getSelectedItem().toString();
				Zone zone = null;
				zone = Zone.getbyStr(zoneStr);
				inventoryController.adjustZone("01", zone);
				this.setVisible(false);
			}
		}
		if(e.getSource() == jbCancel){
			this.setVisible(false);
		}
			
//		}else {//输入框中没有输入
//			if(e.getSource() == jbSure){//选择确认按钮提示警告
//				
//				String warning = "请输入更改后的警戒值!";
//				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
//				jbSure.setEnabled(false);
//			}else if(e.getSource() == jbCancel){//选择取消按钮返回上一界面，输入值不保存
//				
//				this.setVisible(false);
//			}
//			
//		}
		
	}

	public static void main(String[] args) {
		new AdjustZoneBoard();
	}
}
