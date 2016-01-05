package presentation.financeui.CostPayChartBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.financeController.CostPayChartController;
import vo.CostpayChartVO;

public class CostPayChartFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public JFrame frame;
	private JPanel panel;
	private JTextField totalout;
	private JTextField profit;
	private JTextField totalin;
	private JButton close;
	private JButton save;
	private JLabel Ltotalin;
	private JLabel Ltotalout;
	private JLabel Lprofit;
	
	public CostPayChartFrame() throws RemoteException, IllegalArgumentException{
		initialize();
	}
	
	private void initialize() throws RemoteException, IllegalArgumentException{
		frame = new JFrame();
		frame.setTitle("创建成本收益表");
		frame.setSize(386, 290);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - frame.getWidth())/2;
		int y = (screen.height - frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 380, 262);
		frame.getContentPane().add(panel);
		
		totalout = new JTextField();
		totalout.setBackground(Color.WHITE);
		totalout.setColumns(10);
		totalout.setBounds(140, 90, 166, 28);
		
		panel.add(totalout);
		
		profit = new JTextField();
		profit.setBackground(Color.WHITE);
		profit.setColumns(10);
		profit.setBounds(140, 150, 166, 28);
	
		panel.add(profit);
		
		Ltotalin = new JLabel("\u603B\u6536\u5165\uFF1A");
		Ltotalin.setForeground(Color.BLACK);
		Ltotalin.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltotalin.setBackground(Color.GRAY);
		Ltotalin.setBounds(45, 30, 85, 28);
		panel.add(Ltotalin);
		
		totalin = new JTextField();
		totalin.setBackground(Color.WHITE);
		totalin.setColumns(10);
		totalin.setBounds(140, 30, 166, 28);
		
		panel.add(totalin);
		
		Ltotalout = new JLabel("\u603B\u652F\u51FA\uFF1A");
		Ltotalout.setForeground(Color.BLACK);
		Ltotalout.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltotalout.setBackground(Color.GRAY);
		Ltotalout.setBounds(45, 90, 85, 28);
		panel.add(Ltotalout);
		
		Lprofit = new JLabel("\u603B\u5229\u6DA6\uFF1A");
		Lprofit.setForeground(Color.BLACK);
		Lprofit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lprofit.setBackground(Color.GRAY);
		Lprofit.setBounds(43, 150, 85, 28);
		panel.add(Lprofit);
		
		close = new JButton("取消");
		close.setBounds(242, 201, 85, 33);
		close.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(close);
		close.setContentAreaFilled(false);
		close.addActionListener(this);
		
		save = new JButton("保存");
		save.setBounds(135, 201, 85, 33);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
	}
	
	public static void main(String args[]) throws RemoteException, IllegalArgumentException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CostPayChartFrame window = new CostPayChartFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand()=="保存"){
			CostPayChartController costPayChartController = new CostPayChartController();
			if(isTextFull()){
				String m = "基本信息将被录入!";
				int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
						JOptionPane.INFORMATION_MESSAGE);
				if (ok == JOptionPane.YES_OPTION) {
					
					double in = Double.parseDouble(totalin.getText());
					double out = Double.parseDouble(totalout.getText());
					double profits = Double.parseDouble(profit.getText());
					
					System.out.println("Income: "+in);
					
					CostpayChartVO vo = new CostpayChartVO();
					vo.setCost(out);
					vo.setIncome(in);
					vo.setProfit(profits);
					vo.setNO("001");
					
					costPayChartController.saveDriver(vo);
				}
				save.setText("提交");
			}
			else {
				String warning = "必须要输入信息!";
				JOptionPane.showMessageDialog(this, warning, "警告", JOptionPane.WARNING_MESSAGE);
			}
		}
		
		if(e.getActionCommand()=="提交"){
			CostPayChartController costPayChartController = new CostPayChartController();
			String m = "确认提交";
			int ok = JOptionPane.showConfirmDialog(this, m, "确认", JOptionPane.YES_NO_OPTION,
					JOptionPane.INFORMATION_MESSAGE);
			if (ok == JOptionPane.YES_OPTION) {
				double in = Double.parseDouble(totalin.getText());
				double out = Double.parseDouble(totalout.getText());
				double profits = Double.parseDouble(profit.getText());
				
//				System.out.println("Income: "+in);

				CostpayChartVO vo = new CostpayChartVO();
				vo.setCost(out);
				vo.setIncome(in);
				vo.setProfit(profits);
				vo.setNO("001");
				
				costPayChartController.submitDriver(vo);
				frame.dispose();
			}
			
		}
		
		if(e.getActionCommand()=="取消"){
			frame.dispose();
		}
	}
	
	private boolean isTextFull() {
		boolean flag = true;
		if(totalin.getText().length()==0){
			flag = false;
		}
		if(totalout.getText().length()==0){
			flag = false;
		}
		if(profit.getText().length()==0){
			flag = false;
		}
		return flag;
	}

}

