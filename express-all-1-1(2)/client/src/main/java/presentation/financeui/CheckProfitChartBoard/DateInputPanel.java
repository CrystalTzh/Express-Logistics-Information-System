package presentation.financeui.CheckProfitChartBoard;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class DateInputPanel extends JPanel{
	
	private JTextField startdate;
	private JTextField enddate;
	private JButton close;
	private JLabel Lstartdate;
	private JLabel Lenddate;
	
	public DateInputPanel(){
		
		this.setLayout(null);
		this.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 380, 212);

		startdate = new JTextField();
		startdate.setBackground(Color.WHITE);
		startdate.setColumns(10);
		startdate.setBounds(140, 100, 166, 28);
		this.add(startdate);
		
		Lstartdate = new JLabel("\u5F00\u59CB\u65E5\u671F\uFF1A");
		Lstartdate.setForeground(Color.BLACK);
		Lstartdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lstartdate.setBackground(Color.GRAY);
		Lstartdate.setBounds(45, 40, 85, 28);
		this.add(Lstartdate);
		
		enddate = new JTextField();
		enddate.setBackground(Color.WHITE);
		enddate.setColumns(10);
		enddate.setBounds(140, 40, 166, 28);
		this.add(enddate);
		
		Lenddate = new JLabel("\u7ED3\u675F\u65E5\u671F\uFF1A");
		Lenddate.setForeground(Color.BLACK);
		Lenddate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lenddate.setBackground(Color.GRAY);
		Lenddate.setBounds(45, 100, 85, 28);
		this.add(Lenddate);
		
		close = new JButton("\u786E\u8BA4");
		close.setBounds(242, 150, 93, 36);
		this.add(close);
	}

}
