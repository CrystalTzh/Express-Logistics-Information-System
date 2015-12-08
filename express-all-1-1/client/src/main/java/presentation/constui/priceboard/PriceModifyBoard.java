/**
 * 公司常量相关面板
 * @author 谭琼
 * 2015年12月4日
 */
package presentation.constui.priceboard;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 更新价格常量面板
 */
public class PriceModifyBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField pricejtf;// 价格常量
	JButton modifybt, confirmModifybt;// 修改、确认修改

	public PriceModifyBoard() {
		pricejtf = new JTextField(5);
		pricejtf.setEditable(false);//初始为不可编辑
		modifybt = new JButton("修改");
		confirmModifybt = new JButton("确认修改");//初始为不可点按
		confirmModifybt.setEnabled(false);
		modifybt.addActionListener(this);
		confirmModifybt.addActionListener(this);

		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("城市距离价格常量:", JLabel.CENTER));
		box1.add(pricejtf);
		box1.add(new JLabel("元/公里"));

		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(140));
		boxH.add(box1);

		JPanel pCenter = new JPanel();
		pCenter.add(boxH);

		setLayout(new BorderLayout());
		add(pCenter, BorderLayout.CENTER);

		JPanel pSouth = new JPanel();
		pSouth.add(modifybt);
		pSouth.add(confirmModifybt);
		add(pSouth, BorderLayout.SOUTH);

		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		setVisible(true);
		setBounds(560, 250, 420, 380);
		validate();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
//	public static void main(String[] args) {
//		new PriceModifyBoard();
//	}

}
