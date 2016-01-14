package presentation.financeui.ProfitChartBoard;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.financeController.PaymentFormController;
import controller.financeController.ProfitChartController;
import controller.financeController.ReceiptFormController;
import po.PaymentFormPO;
import po.ReceiptFormPO;
import presentation.inventoryui.boards.DateChooser;
import vo.PaymentFormVO;
import vo.ProfitChartVO;
import vo.ReceiptFormVO;

public class ProfitChartFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_2;
	private JLabel Lrmoney;
	private JLabel LrexpressManNumber;
	private JLabel LrID;
	private JLabel Lrdate;
	private JTextArea rID;
	private JScrollPane p;
	private JButton save;
	private JButton cancel;
	@SuppressWarnings("rawtypes")
	private JList receiptlist;
	private JScrollPane plr;
	private JLabel Lreceiptlist;
	private JLabel receiptInfo;
	private JLabel Lpaymentlist;
	@SuppressWarnings("rawtypes")
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
	private ArrayList<PaymentFormPO> all1 = new ArrayList<PaymentFormPO>();
	private	ArrayList<ReceiptFormPO> all = new ArrayList<ReceiptFormPO>();
	private JPanel panel;
	private JLabel Lstartdate;
	private JLabel Lenddate;
	private DateChooser startdate;
	private DateChooser enddate;
	public JFrame frame;
	
	public ProfitChartFrame(){
		initialize();
//		ProfitChartPanel panel = new ProfitChartPanel();
//		frame = new JFrame();
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame.setTitle("\u7ECF\u8425\u60C5\u51B5\u8868");
//		frame.setBounds(100, 100, 690, 843);
//		frame.getContentPane().setLayout(null);
//		frame.setResizable(false);
//		frame.getContentPane().add(panel);
//		frame.setVisible(true);

	}
	
	private void initialize(){
		frame = new JFrame();
		frame.setTitle("经营情况表");
		frame.setSize(690, 763);
		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screen = tk.getScreenSize();
		int x = (screen.width - frame.getWidth())/2;
		int y = (screen.height - frame.getHeight())/2;
		frame.setLocation(x, y);
		frame.setResizable(false);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		
		panel = new JPanel();
		panel.setBounds(0, 0, 684, 734);
		panel.setLayout(null);
		
		JScrollPane spanel = new JScrollPane(panel);
		frame.getContentPane().add(panel);
		spanel.setBounds(0, 0, 684, 814);

		panel_2 = new JPanel();
		panel_2.setBounds(35, 142, 614, 135);
		panel_2.setLayout(null);
		panel_2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel.add(panel_2);
		
		Lrmoney = new JLabel("收款金额 ：");
		Lrmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lrmoney.setBackground(Color.GRAY);
		Lrmoney.setBounds(10, 50, 85, 28);
		panel_2.add(Lrmoney);
		
		rmoney = new JTextField();
		rmoney.setColumns(10);
		rmoney.setBounds(122, 50, 150, 28);
		panel_2.add(rmoney);
		
		LrexpressManNumber = new JLabel("快递员编号 ：");
		LrexpressManNumber.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LrexpressManNumber.setBackground(Color.GRAY);
		LrexpressManNumber.setBounds(10, 90, 98, 27);
		panel_2.add(LrexpressManNumber);
		
		rexpressManNumber = new JTextField();
		rexpressManNumber.setColumns(10);
		rexpressManNumber.setBounds(122, 90, 150, 28);
		panel_2.add(rexpressManNumber);
		
		LrID = new JLabel("订单编号 ：");
		LrID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LrID.setBackground(Color.GRAY);
		LrID.setBounds(312, 10, 85, 28);
		panel_2.add(LrID);
		
		
		
		Lrdate = new JLabel("收款日期 ：");
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
		
		save = new JButton("开始");
		save.setBounds(358, 665, 93, 36);
		save.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(save);
		save.setContentAreaFilled(false);
		save.addActionListener(this);
		
		cancel = new JButton("关闭");
		cancel.setBounds(498, 665, 93, 36);
		cancel.setFont(new Font("微软雅黑", Font.PLAIN, 14));
		panel.add(cancel);
		cancel.setContentAreaFilled(false);
		cancel.addActionListener(this);
		
		Lstartdate = new JLabel("开始日期 :");
		Lstartdate.setBounds(35,610,85,28);
		panel.add(Lstartdate);
		Lstartdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		startdate = new DateChooser(panel,"yyyy/mm/dd",100);
		startdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		startdate.setBounds(80, 600, startdate.getdatechooserwidth(), startdate.getdatechooserheight());
		startdate.setOpaque(false);
		panel.add(startdate);
		
		Lenddate = new JLabel("结束日期 ：");
		Lenddate.setBounds(342,610,85,28);
		panel.add(Lenddate);
		Lenddate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		enddate = new DateChooser(panel,"yyyy/mm/dd",100);
		enddate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		enddate.setBounds(387, 600, enddate.getdatechooserwidth(), enddate.getdatechooserheight());
		enddate.setOpaque(false);
		panel.add(enddate);
		
		receiptlist = new JList();
		receiptlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		receiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		
		DefaultListModel dlm = new DefaultListModel();
//		System.out.println(all.get(0).getNO());
		if(all!=null){
			for(int i=all.size()-1;i>=0;i--){
				dlm.addElement(("收款单"+all.get(i).getNO()));
			}
		}else{
//			if(all.size()!=0){
//				for(int i=all.size()-1;i>=0;i--){
//					dlm.addElement(("收款单"+all.get(i).getNO()));
//				}
//			}else{
				dlm.addElement("无收款单信息！");
//			}
			
//			receiptlist.setSelectedIndex(receiptlist.getSelectedIndex());
		}
		
		receiptlist.setModel(dlm);
		receiptlist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String str = (String)receiptlist.getSelectedValue();
				if(str!="无收款单信息！"){
					String  NO = str.substring(3);
					System.out.println(NO+" bianhao");
					ReceiptFormController receiptFormController = new ReceiptFormController();
					ReceiptFormVO vo = new ReceiptFormVO();
					try {
						vo = receiptFormController.findDriver(NO);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ArrayList<String> id = new ArrayList<String>();
					id = vo.getID();
					rdate.setText(vo.getDate());
					rmoney.setText(Double.toString(vo.getMoney()));
					rexpressManNumber.setText(vo.getExpressManNumber());
					rID.setText("");
					for(int i= 0;i<id.size();i++){
						rID.append(id.get(i)+"\r\n");	
					}
				}
				
			}
		});
		
		plr = new JScrollPane(receiptlist);
		plr.setBounds(35, 45, 614, 60);
		panel.add(plr);
		
		
		receiptlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		receiptlist.setBounds(35, 25, 414, 151);
		
		Lreceiptlist = new JLabel("收款单列表");
		Lreceiptlist.setBounds(35, 10, 85, 28);
		Lreceiptlist.setForeground(Color.BLACK);
		Lreceiptlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lreceiptlist.setBackground(Color.GRAY);
		panel.add(Lreceiptlist);
		
		receiptInfo = new JLabel("收款单信息");
		receiptInfo.setBounds(35, 110, 85, 28);
		receiptInfo.setForeground(Color.BLACK);
		receiptInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		receiptInfo.setBackground(Color.GRAY);
		panel.add(receiptInfo);
		
		Lpaymentlist = new JLabel("付款单列表");
		Lpaymentlist.setBounds(35, 280, 85, 28);
		Lpaymentlist.setForeground(Color.BLACK);
		Lpaymentlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpaymentlist.setBackground(Color.GRAY);
		panel.add(Lpaymentlist);
		
		paymentlist = new JList();
		paymentlist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paymentlist.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		paymentlist.setBorder(new BevelBorder(BevelBorder.RAISED, Color.GRAY, null, null, null));
		paymentlist.setBounds(35, 444, 512, 149);
		
		DefaultListModel dlm1 = new DefaultListModel();
		if(all1!=null){
			for(int i=all1.size()-1;i>=0;i--){
				dlm1.addElement((String)("付款单"+all1.get(i).getNO()));
			}
		}else{
//			if(all1.size()!=0){
//				for(int i=all1.size()-1;i>=0;i--){
//					dlm1.addElement((String)("付款单"+all1.get(i).getNO()));
//				}
//			}else{
				dlm1.addElement("无付款单信息！");
//			}
//			paymentlist.setSelectedIndex(paymentlist.getSelectedIndex());
		}
		
		paymentlist.setModel(dlm1);
		paymentlist.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				String str1 = (String)paymentlist.getSelectedValue();
				if(str1!="无付款单信息！"){
					String  NO1 = str1.substring(3);
					PaymentFormController paymentFormController = new PaymentFormController();
					PaymentFormVO vo1 = new PaymentFormVO();
					try {
						vo1 = paymentFormController.findDriver(NO1);
					} catch (RemoteException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					if(vo1.getFormNO()==null){
						vo1.setFormNO("0");
					}
					pmoney.setText(Double.toString(vo1.getMoney()));
					pdate.setText(vo1.getDate());
					pname.setText(vo1.getName());
					paccount.setText(vo1.getAccount());
					prent.setText(Double.toString(vo1.getRent()));
					pfreight.setText(Double.toString(vo1.getFreight()));
					psalary.setText(Double.toString(vo1.getSalary()));
					pyear.setText(Integer.toString(vo1.getYear()));
					pID.setText(vo1.getFormNO());
					pmonth.setText(Integer.toString(vo1.getMonth()));
				}
				
			}
		});
		
		plp = new JScrollPane(paymentlist);
		plp.setBounds(35, 315, 614, 60);
		panel.add(plp);
		
		payInfo = new JLabel("付款单信息");
		payInfo.setForeground(Color.BLACK);
		payInfo.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		payInfo.setBackground(Color.GRAY);
		payInfo.setBounds(35, 380, 85, 28);
		panel.add(payInfo);
		
		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(128, 128, 128), null, null, null));
		panel_1.setBounds(35, 410, 614, 174);
		panel.add(panel_1);
		
		Lpmoney = new JLabel("付款金额 ：");
		Lpmoney.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpmoney.setBackground(Color.GRAY);
		Lpmoney.setBounds(10, 50, 85, 28);
		panel_1.add(Lpmoney);
		
		pmoney = new JTextField();
		pmoney.setColumns(10);
		pmoney.setBounds(100, 50, 130, 28);
		panel_1.add(pmoney);
		
		Lpname = new JLabel("付款人 ：");
		Lpname.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpname.setBackground(Color.GRAY);
		Lpname.setBounds(20, 90, 73, 27);
		panel_1.add(Lpname);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(100, 90, 130, 28);
		panel_1.add(pname);
		
		Lpdate = new JLabel("付款日期 ：");
		Lpdate.setForeground(Color.BLACK);
		Lpdate.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpdate.setBackground(Color.GRAY);
		Lpdate.setBounds(10, 10, 85, 28);
		panel_1.add(Lpdate);
		
		pdate = new JTextField();
		pdate.setColumns(10);
		pdate.setBounds(100, 10, 130, 28);
		panel_1.add(pdate);
		
		Lpaccount = new JLabel("付款账号 ：");
		Lpaccount.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpaccount.setBackground(Color.GRAY);
		Lpaccount.setBounds(10, 130, 85, 28);
		panel_1.add(Lpaccount);
		
		paccount = new JTextField();
		paccount.setColumns(10);
		paccount.setBounds(100, 130, 130, 28);
		panel_1.add(paccount);
		
		Lprent = new JLabel("租金 ：");
		Lprent.setForeground(Color.BLACK);
		Lprent.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lprent.setBackground(Color.GRAY);
		Lprent.setBounds(240, 10, 55, 28);
		panel_1.add(Lprent);
		
		prent = new JTextField();
		prent.setColumns(10);
		prent.setBounds(294, 10, 78, 28);
		panel_1.add(prent);
		
		Lpfreight = new JLabel("运费 ：");
		Lpfreight.setForeground(Color.BLACK);
		Lpfreight.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpfreight.setBackground(Color.GRAY);
		Lpfreight.setBounds(240, 50, 55, 28);
		panel_1.add(Lpfreight);
		
		Lpsalary = new JLabel("工资 ：");
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
		
		Lpyear = new JLabel("租金年份 ：");
		Lpyear.setForeground(Color.BLACK);
		Lpyear.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		Lpyear.setBackground(Color.GRAY);
		Lpyear.setBounds(380, 10, 85, 28);
		panel_1.add(Lpyear);
		
		LpID = new JLabel("运单号：");
		LpID.setForeground(Color.BLACK);
		LpID.setFont(new Font("微软雅黑", Font.PLAIN, 15));
		LpID.setBackground(Color.GRAY);
		LpID.setBounds(390, 50, 66, 28);
		panel_1.add(LpID);
		
		Lpmonth = new JLabel("工资月份 ：");
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
		
		rdate.setEditable(false);
		rmoney.setEditable(false);
		rexpressManNumber.setEditable(false);
		pmoney.setEditable(false);
		pname.setEditable(false);
		pdate.setEditable(false);
		paccount.setEditable(false);
		prent.setEditable(false);
		pfreight.setEditable(false);
		psalary.setEditable(false);
		pyear.setEditable(false);
		pID.setEditable(false);
		pmonth.setEditable(false);
		rID.setEditable(false);
		
		rdate.setBackground(Color.WHITE);
		rmoney.setBackground(Color.WHITE);
		rexpressManNumber.setBackground(Color.WHITE);
		pmoney.setBackground(Color.WHITE);
		pname.setBackground(Color.WHITE);
		pdate.setBackground(Color.WHITE);
		paccount.setBackground(Color.WHITE);
		prent.setBackground(Color.WHITE);
		pfreight.setBackground(Color.WHITE);
		psalary.setBackground(Color.WHITE);
		pyear.setBackground(Color.WHITE);
		pID.setBackground(Color.WHITE);
		pmonth.setBackground(Color.WHITE);
		
	}

	public ArrayList<PaymentFormPO> findPaymentFormPO(){
		PaymentFormController paymentFormController = new PaymentFormController();
		return paymentFormController.findAll();
	}
	
	public ArrayList<ReceiptFormPO> findReceiptFormPO(){
		ReceiptFormController receiptFormController = new ReceiptFormController();
		return receiptFormController.findAll();
	}
	
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==cancel){
			frame.dispose();
		}
			
		if(e.getActionCommand()=="开始"){
			String startdates = startdate.getDateField().getText();
			String enddates = enddate.getDateField().getText();
			String[] ss =startdates.split("/");
			String[] es = enddates.split("/");
			int syear = Integer.valueOf(ss[0]);
			int smonth = Integer.valueOf(ss[1]);
			int sday = Integer.valueOf(ss[2]);
			int eyear = Integer.valueOf(es[0]);
			int emonth = Integer.valueOf(es[1]);
			int eday = Integer.valueOf(es[2]);
			Calendar start = new GregorianCalendar(syear, smonth, sday);
			Calendar end = new GregorianCalendar(eyear, emonth, eday);
			int comp = this.compare(start, end);
			if(comp > 0) {//开始日期晚于结束日期
				String error = "开始日期不能晚于结束日期";
				JOptionPane.showMessageDialog(this, error, "错误", JOptionPane.ERROR_MESSAGE);
			}
			else{
				ArrayList<ReceiptFormPO> sall = findReceiptFormPO();
				ArrayList<PaymentFormPO> sall1 = findPaymentFormPO();
				
				if(sall!=null){
					for(int i=0;i<sall.size();i++){
						String[] tempdate = sall.get(i).getDate().split("-");
						int tempyear = Integer.valueOf(tempdate[0]);
						int tempmonth = Integer.valueOf(tempdate[1]);
						int tempday = Integer.valueOf(tempdate[2]);
						Calendar tdate = new  GregorianCalendar(tempyear,tempmonth,tempday);
						if(this.compare(start, tdate)<=0&&this.compare(tdate, end)<=0){
							all.add(sall.get(i));
						}
					}
				}
				
				if(sall1!=null){
					for(int i=0;i<sall1.size();i++){
						String[] tempdate = sall1.get(i).getDate().split("-");
						int tempyear = Integer.valueOf(tempdate[0]);
						int tempmonth = Integer.valueOf(tempdate[1]);
						int tempday = Integer.valueOf(tempdate[2]);
						Calendar tdate = new  GregorianCalendar(tempyear,tempmonth,tempday);
						if(this.compare(start, tdate)<=0&&this.compare(tdate, end)<=0){
							all1.add(sall1.get(i));
						}
					}
				}	
				frame.dispose();
				initialize();
				save.setEnabled(false);
			}		
		}
	}
	
	public int compare(Calendar day1, Calendar day2) {
		int year1 = day1.get(Calendar.YEAR);
		int month1 = day1.get(Calendar.MONTH);
		int date1 = day1.get(Calendar.DATE);
		int year2 = day2.get(Calendar.YEAR);
		int month2 = day2.get(Calendar.MONTH);
		int date2 = day2.get(Calendar.DATE);

		if (year1 < year2) {
			return -1;
		}
		if (year1 == year2 && month1 < month2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 < date2) {
			return -1;
		}
		if (year1 == year2 && month1 == month2 && date1 == date2) {
			return 0;
		}
		return 1;
	}
	
	public static void main(String args[]){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitChartFrame window = new ProfitChartFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
