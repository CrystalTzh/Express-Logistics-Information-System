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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.constcontroller.PriceInfoController;
import vo.PriceVO;

/**
 * 更新价格常量面板
 */
public class PriceModifyBoard extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JTextField pricejtf;// 价格常量文本框
	JButton savebt, cancelbt;// 保存、取消按钮
	PriceInfoController priceInfoController;

	public PriceModifyBoard() {
		priceInfoController = new PriceInfoController();
		
		pricejtf = new JTextField(5);
		savebt = new JButton("保存");
		savebt.setContentAreaFilled(false);
		cancelbt = new JButton("取消");
		cancelbt.setContentAreaFilled(false);
		savebt.addActionListener(this);
		cancelbt.addActionListener(this);

		Box box1 = Box.createHorizontalBox();
		box1.add(new JLabel("城市距离价格常量:", JLabel.CENTER));
		box1.add(pricejtf);
		box1.add(new JLabel("元/公里"));
		
		showBasicInfo();

		Box boxH = Box.createVerticalBox();
		boxH.add(Box.createVerticalStrut(140));
		boxH.add(box1);

		JPanel pCenter = new JPanel();
		pCenter.add(boxH);

		setLayout(new BorderLayout());
		add(pCenter, BorderLayout.CENTER);

		JPanel pSouth = new JPanel();
		pSouth.add(savebt);
		pSouth.add(cancelbt);
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
		if(e.getSource() == savebt) {//1 点击了保存按钮
			//判断是否填写了全部信息
			boolean isValid = this.allInfoValid();
			if(isValid) {//填写全部信息
				//TO DO 填写的信息是否合理？？
				PriceVO voToModify = this.wrappVO();
				priceInfoController.modifySalaryInfo(voToModify);//修改价格常量
				String m = "修改成功!";
				JOptionPane.showMessageDialog(this, m, "提示", JOptionPane.INFORMATION_MESSAGE);
				System.exit(0);
			} else {//警告有信息未填写
				String warning = "有信息未填写!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getSource() == cancelbt) {//2 点击了取消按钮
			System.exit(0);
		}
	}
	
	/**
	 * 在面板上显示价格常量的基本信息
	 */
	public void showBasicInfo() {
		PriceVO vo = priceInfoController.findSalayInfo();
		pricejtf.setText(String.valueOf(vo.getPrice()));
	}
	
	/**
	 * 将面板基本信息包装为VO
	 * @return
	 */
	public PriceVO wrappVO() {
		double price = Double.parseDouble(pricejtf.getText());
		
		PriceVO vo = new PriceVO();
		vo.setPrice(price);
		
		return vo;
	}
	
	/**
	 * 判断是否填写了全部信息
	 * @return
	 */
	public boolean allInfoValid() {
		String price = "";
		price = pricejtf.getText();
		return price.length() > 0;
	}
	
	public static void main(String[] args) {
		new PriceModifyBoard();
	}

}
