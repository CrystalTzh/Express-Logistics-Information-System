package presentation.financeui.CheckCostPayChartBoard;

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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.financeController.CostPayChartController;
import vo.CostpayChartVO;

public class CheckCostPayChartFrame extends JFrame implements ActionListener{

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
	private JLabel Ltotalin;
	private JLabel Ltotalout;
	private JLabel Lprofit;
	
	public CheckCostPayChartFrame() throws RemoteException, IllegalArgumentException{
		initialize();
//		CheckCostPayChartPanel panel = new CheckCostPayChartPanel();
//		frame = new JFrame();
//		frame.setTitle("\u67E5\u770B\u6210\u672C\u6536\u76CA\u8868");
//		frame.setBounds(100, 100, 386, 290);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.getContentPane().setLayout(null);
//		frame.getContentPane().add(panel);
//		frame.setVisible(true);
//		frame.setResizable(false);
		
	}
	
	private void initialize() throws RemoteException, IllegalArgumentException{
		frame = new JFrame();
		frame.setTitle("查看成本收益表");
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
		totalout.setEditable(false);
		totalout.setColumns(10);
		totalout.setBounds(140, 90, 166, 28);
		
		if(find()!=null){
			String cost = Double.toString(find().getCost());
			totalout.setText(cost);
		}else{
			totalout.setText("无信息！");
		}
		
		panel.add(totalout);
		
		profit = new JTextField();
		profit.setBackground(Color.WHITE);
		profit.setEditable(false);
		profit.setColumns(10);
		profit.setBounds(140, 150, 166, 28);
		
		if(find()!=null){
			String profits = Double.toString(find().getProfit());
			profit.setText(profits);
		}
		else{
			profit.setText("无信息！");
		}
		panel.add(profit);
		
		Ltotalin = new JLabel("\u603B\u6536\u5165\uFF1A");
		Ltotalin.setForeground(Color.BLACK);
		Ltotalin.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltotalin.setBackground(Color.GRAY);
		Ltotalin.setBounds(45, 30, 85, 28);
		panel.add(Ltotalin);
		
		totalin = new JTextField();
		totalin.setBackground(Color.WHITE);
		totalin.setEditable(false);
		totalin.setColumns(10);
		totalin.setBounds(140, 30, 166, 28);
		
		if(find()!=null){
			String income = Double.toString(find().getIncome());
			totalin.setText(income);
		}else{
			totalin.setText("无信息！");
		}
		
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
		
		close = new JButton("关闭");
		close.setBounds(242, 201, 93, 36);
		close.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(close);
		close.setContentAreaFilled(false);
		close.addActionListener(this);
	}
	
	public CostpayChartVO find() throws RemoteException, IllegalArgumentException{
		CostPayChartController costPayChartController = new CostPayChartController();
		return costPayChartController.findDriver("001");
	}
	
	public static void main(String args[]) throws RemoteException, IllegalArgumentException{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckCostPayChartFrame window = new CheckCostPayChartFrame();
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
		if(e.getActionCommand()=="关闭"){
			frame.dispose();
		}
	}

}
