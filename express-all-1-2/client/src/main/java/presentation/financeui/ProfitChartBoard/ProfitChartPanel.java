package presentation.financeui.ProfitChartBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ProfitChartPanel extends JPanel implements ActionListener{
	
	private JPanel panel_2;
	private JLabel Lrmoney;
	private JLabel LrexpressManNumber;
	private JLabel LrID;
	private JLabel Lrdate;
	private JTextArea rID;
	private JScrollPane p;
	private JButton save;
	private JButton cancel;
	private JList receiptlist;
	private JScrollPane plr;
	private JLabel Lreceiptlist;
	private JLabel receiptInfo;
	private JLabel Lpaymentlist;
	private JList paymentlist;
	private JScrollPane plp;
	private JLabel payInfo;
	private JPanel panel_1;
	private JLabel Lpmoney;
	private JLabel Lpname;
	private JLabel Lpdate;
	private JLabel Lpaccount;
	private JLabel Lprent;
	private JLabel Lpfreight;
	private JLabel Lpsalary;
	private JLabel Lpyear;
	private JLabel LpID;
	private JLabel Lpmonth;
	private JPanel panel_3;
	private JLabel Ltotalin;
	private JLabel Ltotalout;
	private JLabel Lprofit;
	private JTextField rdate;
	private JTextField rmoney;
	private JTextField rexpressManNumber;
	private JTextField pmoney;
	private JTextField pname;
	private JTextField pdate;
	private JTextField paccount;
	private JTextField prent;
	private JTextField pfreight;
	private JTextField psalary;
	private JTextField pyear;
	private JTextField pID;
	private JTextField pmonth;
	private JTextField totalout;
	private JTextField profit;
	private JTextField totalin;
	
	public ProfitChartPanel(){
		
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 684, 814);
		this.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setBounds(35, 202, 614, 135);
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_2.setBackground(Color.WHITE);
		this.add(panel_2);
		
		Lrmoney = new JLabel("\u6536\u6B3E\u91D1\u989D \uFF1A");
		Lrmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lrmoney.setBackground(Color.GRAY);
		Lrmoney.setBounds(10, 50, 85, 28);
		panel_2.add(Lrmoney);
		
		rmoney = new JTextField();
		rmoney.setColumns(10);
		rmoney.setBounds(122, 50, 150, 28);
		panel_2.add(rmoney);
		
		LrexpressManNumber = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7 \uFF1A");
		LrexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LrexpressManNumber.setBackground(Color.GRAY);
		LrexpressManNumber.setBounds(10, 90, 98, 27);
		panel_2.add(LrexpressManNumber);
		
		rexpressManNumber = new JTextField();
		rexpressManNumber.setColumns(10);
		rexpressManNumber.setBounds(122, 90, 150, 28);
		panel_2.add(rexpressManNumber);
		
		LrID = new JLabel("\u8BA2\u5355\u7F16\u53F7 \uFF1A");
		LrID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LrID.setBackground(Color.GRAY);
		LrID.setBounds(312, 10, 85, 28);
		panel_2.add(LrID);
		
		
		
		Lrdate = new JLabel("\u6536\u6B3E\u65E5\u671F \uFF1A");
		Lrdate.setBounds(10, 10, 85, 28);
		panel_2.add(Lrdate);
		Lrdate.setForeground(Color.BLACK);
		Lrdate.setBackground(Color.GRAY);
		Lrdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		rdate = new JTextField();
		rdate.setBounds(122, 10, 150, 28);
		panel_2.add(rdate);
		rdate.setColumns(10);
		
		rID = new JTextArea();
		rID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		rID.setColumns(1);
		rID.setBorder(new EtchedBorder());
		rID.setBackground(Color.WHITE);
		rID.setBounds(312, 50, 164, 94);
		
		p = new JScrollPane(rID);
		p.setBounds(312, 40, 166, 80);
		panel_2.add(p);
		
		save = new JButton("\u4FDD\u5B58");
		save.setBounds(358, 750, 93, 36);
		this.add(save);
		
		cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(498, 750, 93, 36);
		this.add(cancel);
		
		receiptlist = new JList();
		receiptlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		receiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		receiptlist.setModel(new AbstractListModel() {
			String[] values = new String[] {};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		plr = new JScrollPane(receiptlist);
		plr.setBounds(35, 45, 614, 120);
		this.add(plr);
		
		
		receiptlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		receiptlist.setBounds(35, 25, 414, 151);
		
		Lreceiptlist = new JLabel("\u6536\u6B3E\u5355\u5217\u8868");
		Lreceiptlist.setBounds(35, 10, 85, 28);
		Lreceiptlist.setForeground(Color.BLACK);
		Lreceiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lreceiptlist.setBackground(Color.GRAY);
		this.add(Lreceiptlist);
		
		receiptInfo = new JLabel("\u6536\u6B3E\u5355\u4FE1\u606F");
		receiptInfo.setBounds(35, 170, 85, 28);
		receiptInfo.setForeground(Color.BLACK);
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		receiptInfo.setBackground(Color.GRAY);
		this.add(receiptInfo);
		
		Lpaymentlist = new JLabel("\u4ED8\u6B3E\u5355\u5217\u8868");
		Lpaymentlist.setBounds(35, 349, 85, 28);
		Lpaymentlist.setForeground(Color.BLACK);
		Lpaymentlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpaymentlist.setBackground(Color.GRAY);
		this.add(Lpaymentlist);
		
		paymentlist = new JList();
		paymentlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paymentlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		paymentlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		paymentlist.setBounds(35, 444, 512, 149);
		JScrollPane plp = new JScrollPane(paymentlist);
		plp.setBounds(35, 384, 614, 120);
		this.add(plp);
		
		payInfo = new JLabel("\u4ED8\u6B3E\u5355\u4FE1\u606F");
		payInfo.setForeground(Color.BLACK);
		payInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		payInfo.setBackground(Color.GRAY);
		payInfo.setBounds(35, 513, 85, 28);
		this.add(payInfo);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(35, 545, 614, 174);
		this.add(panel_1);
		
		Lpmoney = new JLabel("\u4ED8\u6B3E\u91D1\u989D \uFF1A");
		Lpmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpmoney.setBackground(Color.GRAY);
		Lpmoney.setBounds(10, 50, 85, 28);
		panel_1.add(Lpmoney);
		
		pmoney = new JTextField();
		pmoney.setColumns(10);
		pmoney.setBounds(100, 50, 130, 28);
		panel_1.add(pmoney);
		
		Lpname = new JLabel("\u4ED8\u6B3E\u4EBA \uFF1A");
		Lpname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpname.setBackground(Color.GRAY);
		Lpname.setBounds(20, 90, 73, 27);
		panel_1.add(Lpname);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(100, 90, 130, 28);
		panel_1.add(pname);
		
		Lpdate = new JLabel("\u4ED8\u6B3E\u65E5\u671F \uFF1A");
		Lpdate.setForeground(Color.BLACK);
		Lpdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpdate.setBackground(Color.GRAY);
		Lpdate.setBounds(10, 10, 85, 28);
		panel_1.add(Lpdate);
		
		pdate = new JTextField();
		pdate.setColumns(10);
		pdate.setBounds(100, 10, 130, 28);
		panel_1.add(pdate);
		
		Lpaccount = new JLabel("\u4ED8\u6B3E\u8D26\u53F7 \uFF1A");
		Lpaccount.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpaccount.setBackground(Color.GRAY);
		Lpaccount.setBounds(10, 130, 85, 28);
		panel_1.add(Lpaccount);
		
		paccount = new JTextField();
		paccount.setColumns(10);
		paccount.setBounds(100, 130, 130, 28);
		panel_1.add(paccount);
		
		Lprent = new JLabel("\u79DF\u91D1 \uFF1A");
		Lprent.setForeground(Color.BLACK);
		Lprent.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lprent.setBackground(Color.GRAY);
		Lprent.setBounds(240, 10, 55, 28);
		panel_1.add(Lprent);
		
		prent = new JTextField();
		prent.setColumns(10);
		prent.setBounds(294, 10, 78, 28);
		panel_1.add(prent);
		
		Lpfreight = new JLabel("\u8FD0\u8D39 \uFF1A");
		Lpfreight.setForeground(Color.BLACK);
		Lpfreight.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpfreight.setBackground(Color.GRAY);
		Lpfreight.setBounds(240, 50, 55, 28);
		panel_1.add(Lpfreight);
		
		Lpsalary = new JLabel("\u5DE5\u8D44 \uFF1A");
		Lpsalary.setForeground(Color.BLACK);
		Lpsalary.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpsalary.setBackground(Color.GRAY);
		Lpsalary.setBounds(240, 90, 55, 28);
		panel_1.add(Lpsalary);
		
		pfreight = new JTextField();
		pfreight.setColumns(10);
		pfreight.setBounds(294, 50, 78, 28);
		panel_1.add(pfreight);
		
		psalary = new JTextField();
		psalary.setColumns(10);
		psalary.setBounds(294, 90, 78, 28);
		panel_1.add(psalary);
		
		Lpyear = new JLabel("\u79DF\u91D1\u5E74\u4EFD \uFF1A");
		Lpyear.setForeground(Color.BLACK);
		Lpyear.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpyear.setBackground(Color.GRAY);
		Lpyear.setBounds(380, 10, 85, 28);
		panel_1.add(Lpyear);
		
		LpID = new JLabel("\u8FD0\u5355\u53F7\uFF1A");
		LpID.setForeground(Color.BLACK);
		LpID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LpID.setBackground(Color.GRAY);
		LpID.setBounds(390, 50, 66, 28);
		panel_1.add(LpID);
		
		Lpmonth = new JLabel("\u5DE5\u8D44\u6708\u4EFD \uFF1A");
		Lpmonth.setForeground(Color.BLACK);
		Lpmonth.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpmonth.setBackground(Color.GRAY);
		Lpmonth.setBounds(382, 90, 85, 28);
		panel_1.add(Lpmonth);
		
		pyear = new JTextField();
		pyear.setColumns(10);
		pyear.setBounds(465, 10, 130, 28);
		panel_1.add(pyear);
		
		pID = new JTextField();
		pID.setColumns(10);
		pID.setBounds(465, 50, 130, 28);
		panel_1.add(pID);
		
		pmonth = new JTextField();
		pmonth.setColumns(10);
		pmonth.setBounds(465, 90, 130, 28);
		panel_1.add(pmonth);
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	


}
