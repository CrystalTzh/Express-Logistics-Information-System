package presentation.financeui.CheckCostPayChartBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class CheckCostPayChartPanel extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	private JTextField totalout;
	private JTextField profit;
	private JTextField totalin;
	private JButton close;
	private JLabel Ltotalin;
	private JLabel Ltotalout;
	private JLabel Lprofit;
	
	public CheckCostPayChartPanel() {
		// TODO Auto-generated constructor stub
		
		this.setLayout(null);
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 380, 262);
		
		totalout = new JTextField();
		totalout.setBackground(Color.WHITE);
		totalout.setEditable(false);
		totalout.setColumns(10);
		totalout.setBounds(140, 90, 166, 28);
		this.add(totalout);
		
		profit = new JTextField();
		profit.setBackground(Color.WHITE);
		profit.setEditable(false);
		profit.setColumns(10);
		profit.setBounds(140, 150, 166, 28);
		this.add(profit);
		
		Ltotalin = new JLabel("\u603B\u6536\u5165\uFF1A");
		Ltotalin.setForeground(Color.BLACK);
		Ltotalin.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltotalin.setBackground(Color.GRAY);
		Ltotalin.setBounds(45, 30, 85, 28);
		this.add(Ltotalin);
		
		totalin = new JTextField();
		totalin.setBackground(Color.WHITE);
		totalin.setEditable(false);
		totalin.setColumns(10);
		totalin.setBounds(140, 30, 166, 28);
		this.add(totalin);
		
		Ltotalout = new JLabel("\u603B\u652F\u51FA\uFF1A");
		Ltotalout.setForeground(Color.BLACK);
		Ltotalout.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Ltotalout.setBackground(Color.GRAY);
		Ltotalout.setBounds(45, 90, 85, 28);
		this.add(Ltotalout);
		
		Lprofit = new JLabel("\u603B\u5229\u6DA6\uFF1A");
		Lprofit.setForeground(Color.BLACK);
		Lprofit.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lprofit.setBackground(Color.GRAY);
		Lprofit.setBounds(43, 150, 85, 28);
		this.add(Lprofit);
		
		close = new JButton("\u5173\u95ED");
		close.setBounds(242, 201, 93, 36);
		this.add(close);
		close.addActionListener(this);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==close){
			
		}
	}
	
}
