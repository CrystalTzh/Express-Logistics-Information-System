package presentation.financeui.ReceiptGatherBoard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import dataservice.financedataservice.ReceiptFormdataService;
import impl.financeImpl.ReceiptFormServiceImpl;
import po.ReceiptFormPO;
import vo.ReceiptFormVO;

public class ReceiptGatherPanel extends JPanel implements ActionListener, ListSelectionListener{
	
	private JPanel panel_2;
	private JLabel Lmoney;
	private JLabel LexpressManNumber;
	private JLabel LID;
	private JTextArea ID;
	private JScrollPane p;
	private JLabel Ldate;
	private JButton settle;
	private JButton cancel;
	private JList receiptlist;
	private JScrollPane pl;
	private JLabel Lreceiptlist;
	private JLabel receiptInfo;
	private JTextField date;
	private JTextField money;
	private JTextField expressManNumber;
	
	public ReceiptGatherPanel() {
		// TODO Auto-generated constructor stub
		this.setForeground(Color.WHITE);
		this.setBackground(Color.WHITE);
		this.setBounds(0, 0, 484, 634);
		this.setLayout(null);
		
		panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(35, 252, 414, 303);
		this.add(panel_2);
		
		Lmoney = new JLabel("\u6536\u6B3E\u91D1\u989D \uFF1A");
		Lmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lmoney.setBackground(Color.GRAY);
		Lmoney.setBounds(10, 67, 85, 28);
		panel_2.add(Lmoney);
		
		money = new JTextField();
		money.setColumns(10);
		money.setBounds(122, 67, 166, 28);
		panel_2.add(money);
		
		LexpressManNumber = new JLabel("\u5FEB\u9012\u5458\u7F16\u53F7 \uFF1A");
		LexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LexpressManNumber.setBackground(Color.GRAY);
		LexpressManNumber.setBounds(10, 117, 98, 27);
		panel_2.add(LexpressManNumber);
		
		expressManNumber = new JTextField();
		expressManNumber.setColumns(10);
		expressManNumber.setBounds(122, 117, 166, 28);
		panel_2.add(expressManNumber);
		
		LID = new JLabel("\u8BA2\u5355\u7F16\u53F7 \uFF1A");
		LID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LID.setBackground(Color.GRAY);
		LID.setBounds(10, 167, 85, 28);
		panel_2.add(LID);
		
		ID = new JTextArea();
		ID.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		ID.setColumns(1);
		ID.setBorder(new EtchedBorder());
		ID.setBackground(Color.WHITE);
		ID.setBounds(135, 184, 166, 96);
		
		p = new JScrollPane(ID);
		p.setBounds(122, 167, 166, 96);
		panel_2.add(p);
		
		Ldate = new JLabel("\u6536\u6B3E\u65E5\u671F \uFF1A");
		Ldate.setBounds(10, 17, 85, 28);
		panel_2.add(Ldate);
		Ldate.setForeground(Color.BLACK);
		Ldate.setBackground(Color.GRAY);
		Ldate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		date = new JTextField();
		date.setBounds(122, 17, 166, 28);
		panel_2.add(date);
		date.setColumns(10);
		
		settle = new JButton("\u7ED3\u7B97");
		settle.setBounds(205, 575, 93, 36);
		this.add(settle);
		settle.addActionListener(this);
		
		cancel = new JButton("\u53D6\u6D88");
		cancel.setBounds(328, 575, 93, 36);
		this.add(cancel);
		cancel.addActionListener(this);
		
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
		pl = new JScrollPane(receiptlist);
		pl.setBounds(35, 45, 414, 151);
		this.add(pl);
		receiptlist.addListSelectionListener(this);
		
		
		receiptlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		receiptlist.setBounds(35, 25, 414, 151);
		
		Lreceiptlist = new JLabel("\u6536\u6B3E\u5355\u5217\u8868");
		Lreceiptlist.setForeground(Color.BLACK);
		Lreceiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lreceiptlist.setBackground(Color.GRAY);
		Lreceiptlist.setBounds(35, 10, 85, 28);
		this.add(Lreceiptlist);
		
		receiptInfo = new JLabel("\u6536\u6B3E\u5355\u4FE1\u606F");
		receiptInfo.setForeground(Color.BLACK);
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		receiptInfo.setBackground(Color.GRAY);
		receiptInfo.setBounds(35, 210, 85, 28);
		this.add(receiptInfo);
	}
	
//	public String getreceipt(){
//		
//	}
	
//	public ReceiptFormVO ReceiptFormfind(String number) throws RemoteException, IllegalArgumentException{
//		System.out.println("进入ReceiptFormbl...findReceiptForm...");
//		ReceiptFormdataService receiptFormdataService = new ReceiptFormServiceImpl();
//		ReceiptFormPO po1 = receiptFormClientHelper.goFind(number);
//		ReceiptFormPO po2 = receiptFormdataService.find(number);
//		if(po1!=null){
//			ReceiptFormVO vo = setVO(po1);
//			return vo;
//		}
//		if(po2!=null){
//			ReceiptFormVO vo = setVO(po2);
//			return vo;
//		}
//		else{
//			return null;
//		}
//	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
